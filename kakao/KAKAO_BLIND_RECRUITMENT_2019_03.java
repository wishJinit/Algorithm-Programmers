package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/42891
// 무지의 먹방 라이브

import java.util.*;

public class KAKAO_BLIND_RECRUITMENT_2019_03 {
    private static class Food implements Comparable<Food> {
        int idx, time;

        Food(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Food o) {
            return time - o.time;
        }
    }

    public int solution(int[] food_times, long k) {
        long sum = 0;
        for (int time : food_times) {
            sum += time;
        }
        if (sum <= k) return -1;

        int len = food_times.length;
        Queue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            pq.add(new Food(i + 1, food_times[i]));
        }

        // len 앞에 (long) 안붙이면 오버플로우나서 에러남 => 효율성 2번
        int pre = 0;
        while ((pq.peek().time - pre) * (long) len <= k) {
            int time = pq.poll().time;
            k -= (time - pre) * len;
            len--;
            pre = time;
        }

        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll().idx);
        }
        Collections.sort(list);

        return list.get((int) (k % len));
    }
}
