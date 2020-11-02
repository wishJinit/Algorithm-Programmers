// https://programmers.co.kr/learn/courses/30/lessons/12911
// 다음 큰 숫자

public class Q12911 {
    public int solution(int n) {
        int answer = n + 1;
        int binaryCnt = binaryOneCnt(n);
        while (true) {
            if (binaryOneCnt(answer) == binaryCnt) break;
            answer++;
        }
        return answer;
    }

    // Integer.bitCount 로 대체 가능
    private int binaryOneCnt(int n) {
        return Integer.toBinaryString(n).replace("0", "").length();
    }
}
