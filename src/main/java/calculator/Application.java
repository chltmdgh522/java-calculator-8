package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String input = br.readLine();
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("입력 오류 발생", e);
        }
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String text = input;
        List<Integer> numbers = new ArrayList<>();

        // 커스텀 구분자 찾기 및 숫자 처리
        while (text.startsWith("//")) {
            int endDelimIndex = text.indexOf("\\n");
            if (endDelimIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다. (예: //;\\n1;2;3)");
            }

            // 구분자 추출
            String delimiter = text.substring(2, endDelimIndex);
            // 실제 숫자 부분으로 이동
            text = text.substring(endDelimIndex + 2);

            // 다음 커스텀 구분자 선언 부분까지 찾기
            int nextDelimDeclIndex = text.indexOf("//");
            String currentPart;

            if (nextDelimDeclIndex != -1) {
                currentPart = text.substring(0, nextDelimDeclIndex);
                text = text.substring(nextDelimDeclIndex);
            } else {
                currentPart = text;
                text = "";
            }

            // 정규표현식 특수문자 이스케이프 처리
            String escapedDelimiter = Pattern.quote(delimiter);

            // 구분자로 분리하고 숫자 추출
            String[] parts = currentPart.split(escapedDelimiter);
            for (String part : parts) {
                addNumberIfValid(part, numbers);
            }
        }

        // 기본 구분자로 남은 문자열 처리
        if (!text.isEmpty()) {
            // 콤마와 콜론을 구분자로 사용
            String[] parts = text.split("[,:]");
            for (String part : parts) {
                addNumberIfValid(part, numbers);
            }
        }

        // 합계 계산
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        return sum;
    }

    private static void addNumberIfValid(String token, List<Integer> numbers) {
        if (token == null || token.isEmpty()) {
            return;
        }

        try {
            int num = Integer.parseInt(token);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
            }
            numbers.add(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + token);
        }
    }
}