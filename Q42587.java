import java.util.*;

public class Q42587 {
    private class Print {
        int idx, priority;

        Print(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Print> queue = new LinkedList<>();
        for (int i = 0, len = priorities.length; i < len; i++) {
            queue.add(new Print(i, priorities[i]));
        }

        Arrays.sort(priorities);
        int idx = priorities.length - 1;
        while (!queue.isEmpty()) {
            Print p = queue.poll();
            if (p.priority == priorities[idx]) {
                if (p.idx == location) {
                    break;
                }
                idx--;
                answer++;
            } else {
                queue.add(p);
            }
        }
        return answer;
    }
}
