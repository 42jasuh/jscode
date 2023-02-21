package ex6.PhoneNumberV1;

import java.util.Scanner;

public class Input {

  Scanner sc = new Scanner(System.in);

  String inputPhoneNumber() {
    System.out.println("휴대폰 번호를 입력해주세요.");
    String phoneNumber = sc.nextLine();
    return phoneNumber;
  }
}
