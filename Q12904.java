
// https://programmers.co.kr/learn/courses/30/lessons/12904
// 가장 긴 팰린드롬

public class Q12904 {
    public int solution(String s) {
        final int len = s.length();
        int answer = 1;

        for (int i = len; i >= 2; i--) {
            for (int j = 0; j <= len - i; j++) {
                boolean isPalindrome = true;
                for (int z = 0, halfLen = i / 2; z <= halfLen; z++) {
                    if (s.charAt(j + z) != s.charAt(i + j - z - 1)) {
                        isPalindrome = false;
                        break;
                    }
                }

                if (isPalindrome) {
                    answer = i;
                    i = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
