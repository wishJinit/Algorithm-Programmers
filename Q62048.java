
// https://programmers.co.kr/learn/courses/30/lessons/62048
// 멀쩡한 사각형

public class Q62048 {
    public static long solution(int w, int h) {
        long answer = 0;
        float ratio = (float) h / w;

        for (long i = 0; i < w; i++) {
            answer += ratio * i;
        }

        return answer * 2;
    }
}
