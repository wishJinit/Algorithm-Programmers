
// https://programmers.co.kr/learn/courses/30/lessons/43162
// 네트워크

import java.util.*;

public class Q49189 {

    class Vertex {
        int id, deep;

        Vertex(int id, int deep) {
            this.id = id;
            this.deep = deep;
        }
    }

    public int solution(int n, int[][] edge) {
        Queue<Vertex> q = new LinkedList<>();
        boolean[][] map = new boolean[n + 1][n + 1];
        boolean[] isVisit = new boolean[n + 1];
        int answer = 0, maxDeep = 0;

        for (int[] e : edge) {
            int a = e[0], b = e[1];
            map[a][b] = map[b][a] = true;
        }

        isVisit[1] = true;
        q.add(new Vertex(1, 1));

        while (!q.isEmpty()) {
            Vertex v = q.poll();
            int id = v.id, deep = v.deep;

            if (maxDeep < deep) {
                answer = 1;
                maxDeep = deep;
            } else if (maxDeep == deep) {
                answer++;
            }

            for (int i = 1; i <= n; i++) {
                if (!isVisit[i] && map[id][i]) {
                    q.add(new Vertex(i, deep + 1));
                    isVisit[i] = true;
                }
            }
        }

        return answer;
    }
}
