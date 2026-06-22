import java.util.*;

public class Solution07 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("=== 기능개발 디버깅 및 테스트 ===");
        Solution07 solution = new Solution07();

        // 테스트 케이스 1
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        int[] expected1 = {2, 1};
        int[] result1 = solution.solution(progresses1, speeds1);
        System.out.printf("Test Case 1: %s (결과: %s, 기대값: %s)\n",
                (Arrays.equals(result1, expected1) ? "PASS" : "FAIL"),
                Arrays.toString(result1), Arrays.toString(expected1));

        // 테스트 케이스 2
        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        int[] expected2 = {1, 3, 2};
        int[] result2 = solution.solution(progresses2, speeds2);
        System.out.printf("Test Case 2: %s (결과: %s, 기대값: %s)\n",
                (Arrays.equals(result2, expected2) ? "PASS" : "FAIL"),
                Arrays.toString(result2), Arrays.toString(expected2));
    }
}