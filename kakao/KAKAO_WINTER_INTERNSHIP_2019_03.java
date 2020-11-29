package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/64064
// 불량 사용자

import java.util.*;

class KAKAO_WINTER_INTERNSHIP_2019_03 {
    private Set<Set<String>> result;

    public int solution(String[] user_id, String[] banned_id) {
        result = new HashSet<>();
        dfs(user_id, banned_id, new LinkedHashSet<>());
        return result.size();
    }

    private void dfs(String[] user_id, String[] faultyArr, Set<String> set) {
        if (set.size() == faultyArr.length) {
            if (isFaultyUser(set, faultyArr)) result.add(new HashSet<>(set));

            return;
        }

        for (String userId : user_id) {
            if (!set.contains(userId)) {
                set.add(userId);
                dfs(user_id, faultyArr, set);
                set.remove(userId);
            }
        }
    }

    private boolean isFaultyUser(Set<String> set, String[] banned_id) {
        int i = 0;
        for (String user : set) {
            if (!isSameName(user, banned_id[i++])) return false;
        }

        return true;
    }

    private boolean isSameName(String a, String b) {
        if (a.length() != b.length()) return false;

        for (int i = 0; i < a.length(); i++) {
            if (b.charAt(i) == '*') continue;
            if (a.charAt(i) != b.charAt(i)) return false;
        }

        return true;
    }
}