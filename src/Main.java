import java.util.ArrayList;
import java.util.Scanner;

class Library {
  private ArrayList<Book> books;
  public Library() {
    books = new ArrayList<Book>(100);
    for (int i = 0; i < 100; i++) {
      books.add(i, null);
    }
  }
  public void addBook(int index, Book book) {
    books.add(index, book);
  }

  public void lendBook(int index) {
    Book b = books.get(index);
    if (b.getStatus() == false) {
      System.out.println("대여 중인 책은 대여할 수 없습니다.");
    }
    else {
      System.out.println("정상적으로 대여가 완료되었습니다.");
      b.setStatus(false);
    }
  }

  public void returnBook(int index) {
    Book b = books.get(index);
    if (b.getStatus() == true) {
      System.out.println("대여하지 않은 책은 반납할 수 없습니다.");
    } else {
      System.out.println("정상적으로 반납되었습니다.");
      b.setStatus(true);
    }
  }

  public String printStatus(Book book) {
    if (book.getStatus() == true) {
      return "대여 가능";
    }
    return "대여 중";
  }

  public int powerOn() {
    Scanner sc = new Scanner(System.in);
    System.out.println("대여할 책의 번호를 입력하세요.");
    for (int i = 0; i < books.size(); i++) {
      Book b = books.get(i);
      if (b != null) {
        System.out.println(i + ". " + b.getTitle() + " - " + this.printStatus(b));
      }
    }
    String num = sc.nextLine();
    int n;
    try {
      n = Integer.parseInt(num);
      if (n < 0) {
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

class Book {
  private String title;
  private boolean available;
  public Book(String title, boolean available) {
    this.title = title;
    this.available = available;
  }
  public String getTitle() {
    return this.title;
  }

  public boolean getStatus() {
    return this.available;
  }

  public void setStatus(boolean b) {
    this.available = b;
  }
}

public class Main {
  public static void main(String[] args) {
    Book b1 = new Book("클린코드(Clean Code)", true);
    Book b2 = new Book("객체지향의 사실과 오해", true);
    Book b3 = new Book("테스트 주도 개발(TDD)", true);

    Library library = new Library();
    library.addBook(1, b1);
    library.addBook(2, b2);
    library.addBook(3, b3);

    library.powerOn();
  }
}