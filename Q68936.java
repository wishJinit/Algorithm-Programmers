// https://programmers.co.kr/learn/courses/30/lessons/68936
// 쿼드압축 후 개수 세기

public class Q68936 {
    int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (arr[i][j] == 0) answer[0]++;
                else answer[1]++;
            }
        }
        zip(arr, 0, 0, len);
        return answer;
    }

    private void zip(int[][] arr, int x, int y, int s) {
        if (s <= 1) return;
        boolean isZipAvail = true;
        int ele = arr[x][y];
        for (int i = x; i < x + s; i++) {
            for (int j = y; j < y + s; j++) {
                if (ele != arr[i][j]) {
                    isZipAvail = false;
                    i = x + s;
                    break;
                }
            }
        }
        if (isZipAvail) {
            answer[ele] -= (s * s) - 1;
        } else {
            int size = s / 2;
            zip(arr, x, y, size);
            zip(arr, x + size, y, size);
            zip(arr, x, y + size, size);
            zip(arr, x + size, y + size, size);
        }
    }
}
