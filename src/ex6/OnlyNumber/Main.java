package ex6.OnlyNumber;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean isContinued = true;
    while (isContinued) {
      System.out.println("숫자를 입력해주세요.");
      String input = scanner.nextLine();
      int number;
      try {
        number = Integer.parseInt(input);
        System.out.println("입력하신 숫자는 " + number + "입니다.");
      } catch (NumberFormatException e) {
        System.out.println("잘못된 값을 입력하셨습니다.");
      }
    }
  }
}