package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/60058
// 괄호 변환

public class KAKAO_BLIND_RECRUITMENT_2020_02 {
    public static String solution(String p) {
        return process(p);
    }

    private static String process(String p) {
        if (isPerfect(p)) return p;

        StringBuilder answer = new StringBuilder();
        int sc = 0, ec = 0, i = 0, len = p.length();
        for (; i < len; i++) {
            if (p.charAt(i) == '(') sc++;
            else ec++;
            if (sc == ec) break;
        }

        String u = p.substring(0, i + 1);
        String v = p.substring(i + 1, len);
        if (!isPerfect(u)) {
            if (!v.equals("")) answer.append("(").append(process(v)).append(")");
            else answer.append("(").append(")");
            for (int j = 1; j < u.length() - 1; j++)
                answer.append((u.charAt(j) == '(' ? ')' : '('));
        } else {
            answer.append(u);
            if (!v.equals("")) answer.append(process(v));
        }

        return answer.toString();
    }

    private static boolean isPerfect(String s) {
        String t;
        do {
            t = s;
            s = s.replace("()", "");
        } while (!t.equals(s));
        return s.equals("");
    }
}
