int cmp(const void *a, const void *b) {
    return (*(int *)b) - (*(int *)a);
}

int maxSatisfaction(int* satisfaction, int satisfactionSize){
    qsort(satisfaction, satisfactionSize, sizeof(int), cmp);

    int max_sum = 0;
    int sum = 0;
    for (int i = 0; i < satisfactionSize; i++) {
        sum += satisfaction[i];
        if (sum < 0) {
            break;
        }
        max_sum += sum;
    }

    return max_sum;
}
