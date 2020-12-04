
// https://programmers.co.kr/learn/courses/30/lessons/43162
// 네트워크

import java.util.*;

public class Q43162 {
    public int solution(int n, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisit = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!isVisit[i]) {
                answer++;
                q.add(i);
                isVisit[i] = true;
                while (!q.isEmpty()) {
                    int computer = q.poll();
                    for (int j = 0; j < n; j++) {
                        if (computer == j) continue;
                        if (!isVisit[j] && computers[computer][j] == 1) {
                            q.add(j);
                            isVisit[j] = true;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
