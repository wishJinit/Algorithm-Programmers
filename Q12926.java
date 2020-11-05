// https://programmers.co.kr/learn/courses/30/lessons/12926
// 시저 암호

public class Q12926 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
//               tip : Character.isUpperCase()로 대체 가능
                if (isUpper(c)) {
                    c += n;
                    if (c > 'Z') c = (char) (c - 'Z' + 'A' - 1);
                } else {
                    c += n;
                    if (c > 'z') c = (char) (c - 'z' + 'a' - 1);
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean isUpper(char c) {
        return 'A' <= c && c <= 'Z';
    }
}
