#include <stdio.h>

int main() {
    // ????????????
    int numStudents = 20;
    int totalScore, individualScore;

    // ????????????????????????
    for (int i = 1; i <= numStudents; i++) {
        // ???????????????????
        printf("Enter scores for student %d:\n", i);

        // ?????????
        printf("   Enter exam scores (5 times, 10 points each): ");
        for (int j = 1; j <= 5; j++) {
            scanf("%d", &individualScore);
            totalScore += (individualScore > 10) ? 10 : individualScore;
        }

        // ???????????????
        printf("   Enter midterm exam score (out of 50): ");
        scanf("%d", &individualScore);
        totalScore += (individualScore > 50) ? 25 : individualScore / 2;

        // ???????????????
        printf("   Enter final exam score (out of 100): ");
        scanf("%d", &individualScore);
        totalScore += (individualScore > 100) ? 25 : individualScore / 4;

        // ????????????
        printf("   Total score for student %d: %d\n", i, totalScore);

        // ?????????????????????????????????
        totalScore = 0;
    }

    return 0;
}

