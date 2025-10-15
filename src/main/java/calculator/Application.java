package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IOException e) {
            throw new RuntimeException("입력 오류 발생", e);
        }
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int newlineIndex = input.indexOf("\\n");
            if (newlineIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다. (예: //;\\n1;2;3)");
            }

            delimiter = input.substring(2, newlineIndex);
            input = input.substring(newlineIndex + 2);
        }

        String[] tokens = input.split(delimiter);
        int sum = 0;

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            int num;
            try {
                num = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + token);
            }

            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }

            sum += num;
        }

        return sum;
    }
}


