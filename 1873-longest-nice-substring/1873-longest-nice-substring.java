class Solution {
    public String longestNiceSubstring(String s) 
    {
        String longestNiceSubstring = "";
        for (int i = 0; i < s.length(); i++) 
        {
            for (int j = i + 1; j < s.length(); j++) 
            {
                String subString = s.substring(i, j + 1);
                if (isNice(subString) && subString.length() > longestNiceSubstring.length()) 
                {
                    longestNiceSubstring = subString;
                }
            }
        }
        return longestNiceSubstring;
    }
    
    private boolean isNice(String s) 
    {
        Set<Character> upperCase = new HashSet<>();
        Set<Character> lowerCase = new HashSet<>();
        for (char c : s.toCharArray()) 
        {
            if (Character.isUpperCase(c)) 
            {
                upperCase.add(c);
            } 
            else 
            {
                lowerCase.add(c);
            }
        }

        for (char c : upperCase) 
        {
            if (!lowerCase.contains(Character.toLowerCase(c))) 
            {
                return false;
            }
        }

        for (char c : lowerCase) 
        {
            if (!upperCase.contains(Character.toUpperCase(c))) 
            {
                return false;
            }
        }
        return true;
    }
}
