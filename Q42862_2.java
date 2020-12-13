
// https://programmers.co.kr/learn/courses/30/lessons/42862
// 체육복

import java.util.Arrays;

public class Q42862_2 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n + 2];

        Arrays.fill(student, 1);
        for (int value : lost) student[value]--;
        for (int value : reserve) student[value]++;

        for (int i = 1; i <= n; i++) {
            if (student[i] == 0) {
                if (student[i - 1] > 1) {
                    student[i - 1]--;
                    student[i]++;
                } else if (student[i + 1] > 1) {
                    student[i + 1]--;
                    student[i]++;
                }
            }
        }

        for (int i = 1; i <= n; i++)
            if (student[i] > 0) answer++;

        return answer;
    }
}
