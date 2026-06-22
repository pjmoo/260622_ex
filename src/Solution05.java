import java.util.*;

public class Solution05 {
    public int solution(int n, int[] lost, int[] reserve) {
//        System.out.println("n = " + n);
        int[] students = new int[n+2]; // +1 : 1부터 시작해서. +1 : 조건문을 덜 쓰기 (index out of bound)
//        System.out.println("Arrays.toString(lost) = " + Arrays.toString(lost));
        for (int i : lost) {
            students[i]--; // -1
        }
//        System.out.println("Arrays.toString(reserve) = " + Arrays.toString(reserve));
        for (int i : reserve) {
            students[i]++; // 0, 1, -1
        }
//        System.out.println("Arrays.toString(students) = " + Arrays.toString(students));
        // 학생들 번호는 1부터 시작.
        int answer = 0; // 수업 들어갈 수 있는 학생. 합계해서 0 이상인 학생.
        for (int i = 1; i <= n; i++) {
            // 앞 뒤 친구에게 빌려오기 -> 여벌은 1벌이라는 조건. & 사이즈가 앞뒤만 맞다는 조건 -> 굳이 여러 배치 X.
            boolean imOk = students[i] >= 0;
            boolean prevOk = students[i - 1] == 1;
            boolean nextOk = students[i + 1] == 1;
            if (imOk || prevOk || nextOk) {
                answer++;
            }
            // 빌려야하는데, 앞에선 못 빌리는데, 뒤에서만 빌릴 수 있음 (이경우 차감)
            if (!imOk && !prevOk && nextOk) {
                students[i + 1]--;
            }
//            System.out.print("");
        }
        // int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("=== 체육복 디버깅 및 테스트 ===");

        Solution05 solution = new Solution05();

        // 테스트 케이스 1
        int n1 = 5;
        int[] lost1 = {2, 4};
        int[] reserve1 = {1, 3, 5};
        int expected1 = 5;
        int result1 = solution.solution(n1, lost1.clone(), reserve1.clone());
        System.out.printf("Test Case 1: %s (결과: %d, 기대값: %d)\n",
                (result1 == expected1 ? "PASS" : "FAIL"), result1, expected1);

        // 테스트 케이스 2
        int n2 = 5;
        int[] lost2 = {2, 4};
        int[] reserve2 = {3};
        int expected2 = 4;
        int result2 = solution.solution(n2, lost2.clone(), reserve2.clone());
        System.out.printf("Test Case 2: %s (결과: %d, 기대값: %d)\n",
                (result2 == expected2 ? "PASS" : "FAIL"), result2, expected2);

        // 테스트 케이스 3
        int n3 = 3;
        int[] lost3 = {3};
        int[] reserve3 = {1};
        int expected3 = 2;
        int result3 = solution.solution(n3, lost3.clone(), reserve3.clone());
        System.out.printf("Test Case 3: %s (결과: %d, 기대값: %d)\n",
                (result3 == expected3 ? "PASS" : "FAIL"), result3, expected3);

        // 테스트 케이스 4: 앞 학생에게 빌릴 수 없어 뒤 학생의 여벌을 사용하면 중복 대여할 수 없음
        int n4 = 4;
        int[] lost4 = {2, 4};
        int[] reserve4 = {3};
        int expected4 = 3;
        int result4 = solution.solution(n4, lost4.clone(), reserve4.clone());
        System.out.printf("Test Case 4: %s (결과: %d, 기대값: %d)\n",
                (result4 == expected4 ? "PASS" : "FAIL"), result4, expected4);
    }
}