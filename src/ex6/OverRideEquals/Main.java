package ex6.OverRideEquals;

public class Main {

  public static void main(String[] args) {
    Money money1 = new Money(500);
    Money money2 = new Money(500);
    System.out.println(money1 == money2);
    System.out.println(money1.equals(money2));
  }
}