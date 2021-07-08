package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/60058
// 괄호 변환

public class KAKAO_BLIND_RECRUITMENT_2020_02_2 {
    public String solution(String p) {
        return process(p);
    }

    private String process(String p) {
        if (p.isEmpty()) return "";

        int cnt = 0, idx = 0;
        for (int i = 0, len = p.length(); i < len; i++) {
            if (p.charAt(i) == '(') cnt++;
            else cnt--;
            if (cnt == 0) {
                idx = i;
                break;
            }
        }

        String u = p.substring(0, idx + 1), v = p.substring(idx + 1);
        if (isPerfect(u)) {
            return u + process(v);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(process(v));
            sb.append(')');

            for (int i = 1, len = u.length() - 1; i < len; i++) {
                sb.append(u.charAt(i) == '(' ? ')' : '(');
            }

            return sb.toString();
        }
    }

    private boolean isPerfect(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') cnt++;
            else cnt--;
            if (cnt < 0) return false;
        }
        return cnt == 0;
    }
}
