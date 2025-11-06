class Solution {
    public int findValidSplit(int[] a) {
        int n = a.length;
        if (a[0] == 1) return n == 1 ? -1 : 0; // if first is 1 and 1 is only element, no valid split, otherwise 0 is the best split
        Map<Integer, int[]> primeRanges = new HashMap<>();

        for (int i = 0; i < n; i++)
            updateMap(i, a[i], primeRanges); // update left and right nost of all prime factors

        List<int[]> l = new ArrayList(primeRanges.values());
        Collections.sort(l, (x, y) -> x[0] - y[0]); // sort by start of every range

        int end = l.get(0)[1];
        for (var r : l) {
            if (end < r[0]) return end; // a valid split, no primes overlap with each other
            end = Math.max(end, r[1]); // for all overlap ranges, we need the max end
        }

        return end == n-1 ? -1 : end;
    }

    private void updateMap(int idx, int x, Map<Integer, int[]> primeRanges) {
        if (x % 2 == 0)
            x = _updateMap(idx, x, 2, primeRanges); // first prime

        int end = (int) Math.sqrt(x);
        for (int p = 3; p <= end; p += 2) // check all odd numbers, improve efficiency
            if (x % p == 0)
                x = _updateMap(idx, x, p, primeRanges);

        if (x != 1) _updateMap(idx, x, x, primeRanges); // one last prime number left
    }

    private int _updateMap(int idx, int x, int p, Map<Integer, int[]> map) {
        var range = map.get(p);
        if (range == null)
            map.put(p, range = new int[]{10_000, -1});

        range[0] = Math.min(range[0], idx);
        range[1] = Math.max(range[1], idx);

        while (x % p == 0) x /= p;
        return x;
    }
}