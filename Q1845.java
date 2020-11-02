// https://programmers.co.kr/learn/courses/30/lessons/1845
// 폰켓몬

import java.util.*;

public class Q1845 {
    public int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for (int num : nums) {
            hs.add(num);
        }

        return Math.min(nums.length / 2, hs.size());
    }
}
