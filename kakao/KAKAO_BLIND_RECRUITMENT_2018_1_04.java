package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/17680
// 캐시

import java.util.*;

public class KAKAO_BLIND_RECRUITMENT_2018_1_04 {
    final static int CACHE_HIT = 1;
    final static int CACHE_MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        List<String> cacheList = new ArrayList<>();
        int answer = 0;

        if (cacheSize == 0) return cities.length * CACHE_MISS;

        for (String city : cities) {
            city = city.toLowerCase();
            if (cacheList.contains(city)) {
                cacheList.remove(city);
                answer += CACHE_HIT;
            } else {
                if (cacheList.size() >= cacheSize) cacheList.remove(0);
                answer += CACHE_MISS;
            }
            cacheList.add(city);
        }

        return answer;
    }
}
