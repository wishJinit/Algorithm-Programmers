package kakao;

// TODO : 다시 풀어보기
// https://programmers.co.kr/learn/courses/30/lessons/17679
// 프렌즈4블록

import java.util.ArrayList;
import java.util.List;

public class KAKAO_BLIND_RECRUITMENT_2018_1_05 {
    static class Point {
        int y, x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public int solution(int m, int n, String[] board) {
        List<Point> list = new ArrayList<>();
        int answer = 0;
        while (true) {
            list.clear();
            for (int i = 0, ii = m - 1; i < ii; i++) {
                for (int j = 0, jj = n - 1; j < jj; j++) {
                    char c1 = board[i].charAt(j);
                    char c2 = board[i].charAt(j + 1);
                    char c3 = board[i + 1].charAt(j);
                    char c4 = board[i + 1].charAt(j + 1);
                    if (isSameChar(c1, c2, c3, c4)) {
                        list.add(new Point(i, j));
                    }
                }
            }

            if (list.size() == 0) break;

            list.forEach(p -> {
                char[] c1 = board[p.y].toCharArray();
                char[] c2 = board[p.y + 1].toCharArray();
                c1[p.x] = c1[p.x + 1] = c2[p.x] = c2[p.x + 1] = '-';

                board[p.y] = String.valueOf(c1);
                board[p.y + 1] = String.valueOf(c2);
            });

            for (int i = 0; i < n; i++) {
                for (int j = m - 1; j > 0; j--) {
                    if (board[j].charAt(i) == '-') {
                        int gap = 0;
                        for (int z = j - 1; z >= 0; z--) {
                            if (board[z].charAt(i) != '-') {
                                gap = j - z;
                                break;
                            }
                        }
                        if (gap == 0) continue;

                        for (int z = j; z >= gap; z--) {
                            char[] boardStr = board[z].toCharArray();
                            boardStr[i] = board[z - gap].charAt(i);
                            board[z] = String.valueOf(boardStr);
                        }
                        for (int z = 0; z < gap; z++) {
                            if (board[z].charAt(i) == '-') continue;
                            char[] boardStr = board[z].toCharArray();
                            boardStr[i] = '-';
                            board[z] = String.valueOf(boardStr);
                        }
                    }
                }
            }
        }

        for (String b : board) {
            for (char c : b.toCharArray()) {
                if (c == '-') answer++;
            }
        }

        return answer;
    }

    private static boolean isSameChar(char c1, char c2, char c3, char c4) {
        return c1 != '-' && c1 == c2 && c2 == c3 && c3 == c4;
    }
}
