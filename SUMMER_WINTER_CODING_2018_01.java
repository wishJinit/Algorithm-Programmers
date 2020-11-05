// https://programmers.co.kr/learn/courses/30/lessons/12982
// 예산

import java.util.*;

public class SUMMER_WINTER_CODING_2018_01 {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        for (int money : d) {
            if (budget < money) break;
            answer++;
            budget -= money;
        }

        return answer;
    }
}
