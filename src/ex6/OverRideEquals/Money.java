package ex6.OverRideEquals;

public class Money {

  private int value;

  public Money(int value) {
    this.value = value;
  }

  private int getValue(Money money) {
    return money.value;
  }

  @Override
  public boolean equals(Object o) {
    if (getClass() != o.getClass()) {
      return false;
    }
    Money m = (Money) (o);
    if (this.value == m.getValue(m)) {
      return true;
    }
    return false;
  }
}