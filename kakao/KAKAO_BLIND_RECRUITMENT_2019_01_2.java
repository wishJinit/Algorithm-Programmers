package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/42889
// 실패율

import java.util.*;

public class KAKAO_BLIND_RECRUITMENT_2019_01_2 {
    private static class Score implements Comparable<Score> {
        int idx;
        double fail;

        Score(int idx, double fail) {
            this.idx = idx;
            this.fail = fail;
        }

        @Override
        public int compareTo(Score o) {
            return Double.compare(o.fail, fail);
        }
    }

    public static int[] solution(int N, int[] stages) {
        ArrayList<Score> list = new ArrayList<>();
        int[] answer = new int[N];
        final int LEN = stages.length;
        int len = LEN;

        Arrays.sort(stages);
        for (int i = 1, idx = 0; i <= N; i++) {
            int cnt = 0;
            for (; idx < LEN; idx++) {
                if (i == stages[idx]) cnt++;
                else break;
            }
            list.add(new Score(i, (cnt == 0 ? 0 : (double) cnt / len)));
            len -= cnt;
        }

        Collections.sort(list);
        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i).idx;
        }

        return answer;
    }
}
