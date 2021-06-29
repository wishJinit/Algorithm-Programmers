package kakao;

// https://programmers.co.kr/learn/courses/30/lessons/60059
// 자물쇠와 열쇠

public class KAKAO_BLIND_RECRUITMENT_2020_03 {

    private int[][] rotateKey(int M, int[][] key) {
        int[][] copyKey = new int[M][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                copyKey[j][M - 1 - i] = key[i][j];
            }
        }

        return copyKey;
    }

    private boolean check(int N, int[][] lock) {
        for (int i = N, len = N * 2; i < len; i++) {
            for (int j = N; j < len; j++) {
                if (lock[i][j] != 1) return false;
            }
        }
        return true;
    }

    public boolean solution(int[][] key, int[][] lock) {
        final int N = lock.length, M = key.length;

        int[][] checkLock = new int[N * 3][N * 3];
        for (int i = N, len = N * 2; i < len; i++) {
            for (int j = N; j < len; j++) {
                checkLock[i][j] = lock[i - N][j - N];
            }
        }

        for (int r = 0; r < 4; r++) {
            key = rotateKey(M, key);

            for (int i = 0, len = N * 2; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    for (int ii = 0; ii < M; ii++) {
                        for (int jj = 0; jj < M; jj++) {
                            checkLock[i + ii][j + jj] += key[ii][jj];
                        }
                    }

                    if (check(N, checkLock)) return true;

                    for (int ii = 0; ii < M; ii++) {
                        for (int jj = 0; jj < M; jj++) {
                            checkLock[i + ii][j + jj] -= key[ii][jj];
                        }
                    }
                }
            }
        }

        return false;
    }
}
