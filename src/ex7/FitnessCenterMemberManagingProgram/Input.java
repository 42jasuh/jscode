package ex7.FitnessCenterMemberManagingProgram;

import java.util.Scanner;

public class Input {

  private int typeCheckNumber(String num) {
    try {
      int flag = Integer.parseInt(num);
      if (flag <= 0) {
        System.out.println("자연수를 입력해주세요.");
        return -1;
      }
      return flag;
    } catch (NumberFormatException e) {
      System.out.println("자연수를 입력해주세요.");
      return -1;
    }
  }

  public void printHeader() {
    System.out.println("\n원하시는 번호를 입력해주세요.");
    System.out.println("1. 회원등록");
    System.out.println("2. 특정 회원 조회");
    System.out.println();
  }

  public int number() {
    int[] numberArray = {1, 2};
    Scanner sc = new Scanner(System.in);
    String num = sc.nextLine();
    if (-1 == typeCheckNumber(num)) {
      return number();
    }
    int n = Integer.parseInt(num);
    boolean match = false;

    for (int elem : numberArray) {
      if (n == elem) {
        match = true;
        break;
      }
    }

    if (!match) {
      System.out.println("제시된 번호 안에서 입력해주세요.");
      return number();
    }
    return n;
  }

  public String email() {
    System.out.println("이메일을 입력해주세요.");
    Scanner sc = new Scanner(System.in);
    String email = sc.nextLine();
    String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    if (!(email.matches(regex))) {
      System.out.println("이메일 형식에 맞게 입력해주세요.");
      return email();
    }
    return email;
  }

  public String name() {
    System.out.println("이름을 입력해주세요.");
    Scanner sc = new Scanner(System.in);
    return sc.nextLine();
  }


  public int age() {
    System.out.println("나이를 입력해주세요.");
    Scanner sc = new Scanner(System.in);
    String age = sc.nextLine();
    int res = typeCheckNumber(age);
    if (res == -1) {
      return age();
    }
    return res;
  }

  public int menu1() {
    Input input = new Input();
    String email = input.email();
    String name = input.name();
    int age = input.age();
    MemberRepository member = new MemberRepository(email, name, age);

    if (member.isEmailExist(email)) {
      member.removeMember(email);
      System.out.println("이미 등록된 이메일이어서 회원 등록에 실패했습니다.");
      return menu1();
    } else {
      MemberRepository.emailArr.add(email);
    }
    return 0;
  }

  public void menu2() {
    boolean match = false;
    Scanner sc = new Scanner(System.in);
    System.out.println("조회하려는 회원의 이름을 입력해주세요.");
    String inputName = sc.nextLine();

    for (int i = 0; i < MemberRepository.memberArr.size(); i++) {
      Object[] memberInfo = (Object[]) MemberRepository.memberArr.get(i);
      String name = (String) memberInfo[1];
      if (inputName.equals(name)) {
        match = true;
        MemberRepository.print(i);
      }
    }
    if (!(match)) {
      System.out.println("등록되지 않은 회원입니다.");
    }
  }
}