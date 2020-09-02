
// https://programmers.co.kr/learn/courses/30/lessons/12950
// 행렬의 덧셈

public class Q12950 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int h = arr1.length, w = arr1[0].length;
        int[][] answer = new int[h][w];

        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                answer[i][j] = arr1[i][j] + arr2[i][j];

        return answer;
    }
}
