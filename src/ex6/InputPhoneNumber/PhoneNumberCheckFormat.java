package ex6.InputPhoneNumber;

import java.util.Scanner;

public class PhoneNumberCheckFormat {

  private String insertDashToPhoneNumber(String ValidPhoneNumber) {
    String res = "";
    for (int i = 0; i < ValidPhoneNumber.length(); i++) {
      if (i == 3 || i == 7) {
        res += "-";
      }
      res += ValidPhoneNumber.charAt(i);
    }
    return res;
  }

  int checkFormat() throws Exception {
    System.out.println("휴대폰 번호를 입력해주세요.");
    Scanner sc = new Scanner(System.in);
    String phoneNumber = sc.nextLine();
    String frontPhoneNumber = "";
    int PhoneNumberLength = 0;

    // 입력 받은 문자열이 모두 숫자인지 확인
    for (int i = 0; i < phoneNumber.length(); i++) {
      try {
        char num = phoneNumber.charAt(i);
        Integer.parseInt(String.valueOf(num));
        PhoneNumberLength += 1;
        if (i == 0 || i == 1 || i == 2) {
          frontPhoneNumber += num;
        }
      } catch (NumberFormatException e) {
        System.out.println("숫자만 입력해주세요.");
        return checkFormat();
      }
    }

    // 입력 받은 문자열이 11자리인지 확인
    if (phoneNumber.length() != 11) {
      System.out.println("휴대폰 번호는 11글자여야 합니다.");
      return checkFormat();
    }

    // 입력 받은 문자열의 앞부분이 010인지 확인
    if (!frontPhoneNumber.equals("010")) {
      System.out.println("휴대폰 번호는 010으로 시작해야 합니다.");
      return checkFormat();
    }

    System.out.println(
        "휴대폰 번호를 정상적으로 입력하셨습니다. 입력하신 휴대폰 번호는 " + insertDashToPhoneNumber(phoneNumber) + "입니다.");
    return 0;
  }
}
