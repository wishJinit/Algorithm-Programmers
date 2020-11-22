// https://programmers.co.kr/learn/courses/30/lessons/68935
// 3진법 뒤집기

public class Q68935 {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }

        String value = sb.toString();
        int len = value.length(), num = 0, sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += (value.charAt(i) - '0') * Math.pow(3, num++);
        }

        return sum;
    }
}
