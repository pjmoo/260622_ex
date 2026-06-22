import java.util.*;

public class Solution01 {
    public int solution(String s) {
        // 숫자를 판정하는 것
        Set<String> set = new HashSet();
        set.add("0");
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.add("5");
        set.add("6");
        set.add("7");
        set.add("8");
        set.add("9");
        // 글자 -> 숫자 변경
        Map<String, String> map = new HashMap();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        String answerStr = "";
        String tmp = "";
        for (String v : s.split("")) {
            if (set.contains(v)) {
                answerStr += v; // 그냥 숫자니까.
                continue;
            }
            tmp += v;
            if (map.containsKey(tmp)) {
                answerStr += map.get(tmp);
                tmp = ""; // 정확한 숫자가 한 번 감지되면 임시를 비워줌
            }
        }
        int answer = Integer.parseInt(answerStr);
        return answer;
    }
    public int solution02(String s) {
//        System.out.println("s = " + s);
//        System.out.print("");
//        for (String v : s.split("")) {
//        for (char c : s.toCharArray()) { // 위에보다 상대적으로 경량이면서 char -> 연산
//            System.out.println("v = " + v);
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        // 인덱스가 곧 숫자 이고, 그 인덱스에 대응하는 원소는 그 숫자의 문자열 표현.
//        for (int i = 0; i < s.length(); i++) {
        for (int i = 0; i < numbers.length; i++) { // numbers를 돌면서 0 - 9까지를 치환.
//            char c = s.charAt(i);
//            System.out.println("c = " + c);
            // 문자열.replace(바꾸자하는 문자열, 바꿀 문자열)
            s = s.replace(numbers[i], i + "");
//            System.out.print("");
        }

//        int answer = 0;
        int answer = Integer.parseInt(s); // 문자열을 정수로 바꿔주는...
        return answer;
    }

    public static void main(String[] args) {
        Solution01 sol = new Solution01();

        // [입력값, 기대하는 결과값]
        String[] inputs = {
                "one4seveneight", "23four5six7", "2three45sixseven", "123",
                "zero", "zerozero77", "oneoneoneone", "1",
                "sevensevensevensevensevensevensevensevensevenseven", "zerothreefour"
        };

        int[] expected = {
                1478, 234567, 234567, 123,
                0, 77, 1111, 1,
                777777777, 34 // 7이 10개인 케이스는 int 범위를 넘지 않음 (77억이 아니므로 주의, 7이 10개면 7777777777인데 int 최대는 2147483647임)
        };

        // *주의: 7이 10개면 7,777,777,777이라 int 범위를 초과합니다.
        // 문제 조건상 "정답이 1 이상 2,000,000,000 이하인 입력만 주어진다"고 했으므로
        // 실제 프로그래머스 테스트셋에서는 결과가 21억을 넘는 입력(예: seven 10개)은 들어오지 않습니다.

        System.out.println("--- 테스트 시작 ---");
        for (int i = 0; i < inputs.length; i++) {
            // int 범위를 넘지 않도록 안전한 테스트셋으로 조정해서 검증하세요.
            if (inputs[i].length() == 50) continue;

            int result = sol.solution(inputs[i]);
            if (result == expected[i]) {
                System.out.println("Pass: " + inputs[i] + " => " + result);
            } else {
                System.out.println("FAIL: " + inputs[i] + " => Expected: " + expected[i] + ", Got: " + result);
            }
        }
    }
}
