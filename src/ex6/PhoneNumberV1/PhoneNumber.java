package ex6.PhoneNumberV1;

public class PhoneNumber implements TypeCheck {

  private String value;

  public PhoneNumber() {
    Input input = new Input();
    String phoneNumber = input.inputPhoneNumber();
    this.validate(phoneNumber);
    this.value = phoneNumber;
  }

  private void validate(String phoneNumber) {
    checkIsAllDigits(phoneNumber);
    checkFirstThreeDigits(phoneNumber);
    checkTotalLength(phoneNumber);
    getPhoneNumberFormally(phoneNumber);
  }

  @Override
  public void checkIsAllDigits(String phoneNumber) {
    for (int i = 0; i < phoneNumber.length(); i++) {
      try {
        Integer.parseInt(String.valueOf(phoneNumber.charAt(i)));
      } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException("숫자를 입력해주세요.");
      }
    }
  }

  @Override
  public void checkFirstThreeDigits(String phoneNumber) {
    if (!phoneNumber.startsWith("010")) {
      throw new IllegalArgumentException("휴대폰 번호는 010으로 시작해야 합니다.");
    }
  }

  @Override
  public void checkTotalLength(String phoneNumber) {
    int totalLength = 0;
    for (int i = 0; i < phoneNumber.length(); i++) {
      totalLength += 1;
    }
    if (totalLength != 11) {
      throw new IllegalArgumentException("휴대폰 번호는 11글자여야 합니다.");
    }
  }

  private void getPhoneNumberFormally(String phoneNumber) {
    String res = "";
    for (int i = 0; i < phoneNumber.length(); i++) {
      if (i == 3 || i == 7) {
        res += "-";
      }
      res += phoneNumber.charAt(i);
    }
    System.out.println("휴대폰 번호를 정상적으로 입력하셨습니다. 입력하신 휴대폰 번호는 " + res + "입니다.");
  }
}