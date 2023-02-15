import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Book b1 = new Book("클린코드(Clean Code)", true);
    Book b2 = new Book("객체지향의 사실과 오해", true);
    Book b3 = new Book("테스트 주도 개발(TDD)", true);

    Library library = new Library();
    library.addBook(b1);
    library.addBook(b2);
    library.addBook(b3);

    library.powerOn();
  }
}