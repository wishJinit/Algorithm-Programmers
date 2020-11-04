// https://programmers.co.kr/learn/courses/30/lessons/42862
// 체육복

public class Q42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] array = new int[n];

        for (int l : lost)
            array[l - 1]--;

        for (int r : reserve)
            array[r - 1]++;

        for (int i = 0; i < n; i++) {
            if (array[i] == -1) {
                // 배열을 n+2크기로 지정했으면 i범위 체크할 필요 없었음
                if (i - 1 >= 0 && array[i - 1] == 1) {
                    array[i]++;
                    array[i - 1]--;
                } else if (i + 1 < n && array[i + 1] == 1) {
                    array[i]++;
                    array[i + 1]--;
                } else {
                    answer--;
                }
            }
        }

        return answer;
    }
}
