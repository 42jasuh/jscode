package ex7.FitnessCenterMemberManagingProgram;

public class FitnessCenterMemberManagingProgram {

  public void start() {
    Input input = new Input();
    while (true) {
      input.printHeader();
      int chosenNumber = input.number();
      if (chosenNumber == 1) {
        input.menu1();
      } else if (chosenNumber == 2) {
        input.menu2();
      }
    }
  }
}
