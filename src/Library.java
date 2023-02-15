import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
  private final List<Book> books;
  public Library() {
    books = new ArrayList<>();
  }
  public void addBook(Book book) {
    books.add(book);
  }

  public void lendBook(int index) {
    if (index - 1 < 0) {
      System.out.println("책 번호는 1부터 시작합니다.");
    }
    Book b = books.get(index-1);
    if (!b.isAvailable()) {
      System.out.println("대여 중인 책은 대여할 수 없습니다.");
    }
    else {
      System.out.println("정상적으로 대여가 완료되었습니다.");
      b.setStatus(false);
    }
  }

  public void returnBook(int index) {
    Book b = books.get(index);
    if (b.isAvailable()) {
      System.out.println("대여하지 않은 책은 반납할 수 없습니다.");
    } else {
      System.out.println("정상적으로 반납되었습니다.");
      b.setStatus(true);
    }
  }

  public String printStatus(Book book) {
    if (book.isAvailable()) {
      return "대여 가능";
    }
    return "대여 중";
  }

  public int powerOn() {
    Scanner sc = new Scanner(System.in);
    System.out.println("대여할 책의 번호를 입력하세요.");
    for (int i = 0; i < books.size(); i++) {
      Book b = books.get(i);
      System.out.println(i+1 + ". " + b.getTitle() + " - " + this.printStatus(b));
    }
    String num = sc.nextLine();
    int n;
    try {
      n = Integer.parseInt(num);
      if (n <= 0) {
        Integer.parseInt("a");
      }
    } catch (NumberFormatException e) {
      System.out.println("양의 정수만 입력해주세요");
      return this.powerOn();
    }
    this.lendBook(n);
    return this.powerOn();
  }
}