package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/1829
// 카카오프렌즈 컬러링북

import java.util.*;

public class KAKAO_CODE_PRELIMINARY_2017_01 {

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public int[] solution(int m, int n, int[][] picture) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        boolean[][] map = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !map[i][j]) {
                    Queue<Point> queue = new LinkedList<>();
                    int color = picture[i][j], cnt = 1;
                    queue.add(new Point(j, i));
                    map[i][j] = true;
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int y = dy[k] + p.y, x = dx[k] + p.x;
                            if (y >= 0 && x >= 0 && y < m && x < n && !map[y][x] && picture[y][x] == color) {
                                map[y][x] = true;
                                cnt++;
                                queue.add(new Point(x, y));
                            }
                        }
                    }
                    int z = 1;
                    while (true) {
                        if (hashMap.containsKey(color + "-" + z)) z++;
                        else break;
                    }
                    hashMap.put(color + "-" + z, cnt);
                }
            }
        }
        return new int[]{hashMap.size(), (hashMap.values().stream().max(Integer::compareTo).orElse(0))};
    }
}
