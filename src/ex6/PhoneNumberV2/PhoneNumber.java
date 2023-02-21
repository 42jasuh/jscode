package ex6.PhoneNumberV2;

import java.util.Scanner;

public class PhoneNumber {

  private String value;

  public PhoneNumber() {
    this.value = this.checkFormat();
  }

  private String getPhoneNumberFormally(String ValidPhoneNumber) {
    String res = "";
    for (int i = 0; i < ValidPhoneNumber.length(); i++) {
      if (i == 3 || i == 7) {
        res += "-";
      }
      res += ValidPhoneNumber.charAt(i);
    }
    return res;
  }

  String checkFormat() {
    System.out.println("휴대폰 번호를 입력해주세요.");
    Scanner sc = new Scanner(System.in);
    String phoneNumber = sc.nextLine();

    // 입력 받은 문자열이 모두 숫자인지 확인
    for (int i = 0; i < phoneNumber.length(); i++) {
      try {
        char num = phoneNumber.charAt(i);
        Integer.parseInt(String.valueOf(num));
      } catch (NumberFormatException e) {
        System.out.println("숫자만 입력해주세요.");
        return checkFormat();
      }
    }

    // 핸드폰 번호 자릿수 확인
    if (phoneNumber.length() != 11) {
      System.out.println(phoneNumber.length());
      System.out.println("휴대폰 번호는 11글자여야 합니다.");
      return checkFormat();
    }

    // 입력 받은 문자열의 앞부분이 010인지 확인
    if (!phoneNumber.startsWith("010")) {
      System.out.println("휴대폰 앞자리는 010 이어야 합니다.");
      return checkFormat();
    }
    System.out.println(
        "휴대폰 번호를 정상적으로 입력하셨습니다. 입력하신 휴대폰 번호는 " + getPhoneNumberFormally(phoneNumber) + "입니다.");
    return phoneNumber;
  }
}
