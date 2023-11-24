package gui.layout.login.create_id_window;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswChecker {

	public static boolean isEnglish(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public static boolean isDigit(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    public static boolean isSpecialCharacter(char ch) {
        String specialCharacters = "!@#$%^&*()-+=";
        return specialCharacters.indexOf(ch) != -1;
    }

    public static void main(String[] args) {
        char inputChar = '$'; // 여기에 확인하려는 문자를 넣으세요

        if (isEnglish(inputChar)) {
            System.out.println("입력된 문자는 영어");
        } else if (isDigit(inputChar)) {
            System.out.println("입력된 문자는 숫자");
        } else if (isSpecialCharacter(inputChar)) {
            System.out.println("입력된 문자는 특수문자");
        } else {
            System.out.println("입력된 문자는 영어, 숫자, 특수문자가 아님");
        }
    }
}