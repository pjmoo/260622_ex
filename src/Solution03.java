import java.util.*;

public class Solution03 {
    public long solution(int n) {
//        System.out.println("n = " + n);
        // 1칸 또는 2칸 -> n만큼 도달
        // dp
        // int[] memo = new int[n + 1]; // 0이 없음.
        int[] memo = new int[2001];
        // 연산을 줄이기 위해 dp에서는 메모.
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; i++) {
//            memo[i] = memo[i - 1] + memo[i - 2]; // 점화식
            memo[i] = (memo[i - 1] + memo[i - 2]) % 1234567;
        }
//        return jump(n);
        return memo[n];
    }

    // 재귀
//    public long jump(int n) {
//        // n = 1 => 1. 1칸 뛰기
//        // n = 2 => 2. 1칸 뛰기, 2칸 뛰기
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//        // 3칸째부터는 계산이 복잡함
//        // 1 -> (1,2)
//        // 2 -> (1)
//        // 1칸 뛴 결과와 2칸 뛴 결과의 조합
//        // 남은 칸수가 있으면, 1칸 남았을 때랑 2칸 남았을 때는 고정.
//        // 3칸부터는 일단 1칸 남았을 때의 2칸 남았을 때까지의 조합.
//        return ((jump(n - 1) + jump(n - 2))) % 1234567; // 나머지 연산은 어차피 ( ??? ) x + 나머지
//    }

    public static void main(String[] args) {
        Solution03 sol = new Solution03();
        System.out.println("=== 멀리 뛰기 디버깅 및 테스트 ===");

        // 테스트 케이스 1
        int n1 = 4;
        long expected1 = 5;
        long result1 = sol.solution(n1);
        System.out.printf("Test Case 1: %s (결과: %d, 기대값: %d)\n",
                (result1 == expected1 ? "PASS" : "FAIL"), result1, expected1);

        // 테스트 케이스 2
        int n2 = 3;
        long expected2 = 3;
        long result2 = sol.solution(n2);
        System.out.printf("Test Case 2: %s (결과: %d, 기대값: %d)\n",
                (result2 == expected2 ? "PASS" : "FAIL"), result2, expected2);

        // 테스트 케이스 3
        int n3 = 2000;
        long expected3 = 694725;
        long result3 = sol.solution(n3);
        System.out.printf("Test Case 3: %s (결과: %d, 기대값: %d)\n",
                (result3 == expected3 ? "PASS" : "FAIL"), result3, expected3);
    }

    public class Solution04 {
        public int solution2(int[][] triangle) {
            for (int i = 1; i < triangle.length; i++) {
                for (int j = 0; j < triangle[i].length; j++) {
                    if (j == 0) {
                        triangle[i][j] += triangle[i - 1][j];
                        continue;
                    }
                    if (j == i) {
                        triangle[i][j] += triangle[i - 1][j - 1];
                        continue;
                    }
                    triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
                }
            }
            int answer = 0;
            for (int v : triangle[triangle.length - 1]) {
                answer = Math.max(answer, v);
            }
            return answer;
        }
    }
}