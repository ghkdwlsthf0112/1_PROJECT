package gui.layout.paymentWindow;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ReservationCode {
   final private static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   final private static int CODE_LENGTH = 7;
   
   private static char generateRandomAlphabet() {
      Random random = new Random();
      int randomIndex = random.nextInt(ALPHABET.length());
      return ALPHABET.charAt(randomIndex);
   }
   private static int generateRandomNumber() {
      Random random = new Random();
      
      return random.nextInt(10); // 0부터 9까지
   }
   
   private static String generateCode() {
      StringBuilder codeBuilder = new StringBuilder();
      
      // 첫 글자는 랜덤 영어 대문자
      char firstChar = generateRandomAlphabet();
      codeBuilder.append(firstChar);
      
      // 중복 피하기 위해서 사용된 숫자를 기록할 SET 객체 생성
      Set<Integer> usedNumber = new HashSet<>();
      
      // 남은 자릿수
      int remainDigit = CODE_LENGTH - 1;
      
      // 남은 자릿수가 0이 될때까지 바놉ㄱ
      while (remainDigit > 0) {
         // 랜덤 숫자 생성
         int randomNumber = generateRandomNumber();
         
         // 사용된 숫자가 아니면 예약번호 추가
         if (!usedNumber.contains(randomNumber)) {
            usedNumber.add(randomNumber);
            codeBuilder.append(randomNumber);
            remainDigit--;
         }
      }
      return codeBuilder.toString();
   }
   
   public static void main(String[] args) {
      String reservationCode = generateCode();
      
      System.out.println(reservationCode);
   }
         
}