package LibrarySystem;

public class Main {

  public static void main(String[] args) {
    LibrarySystem.Book b1 = new LibrarySystem.Book("클린코드(Clean Code)", true);
    LibrarySystem.Book b2 = new LibrarySystem.Book("객체지향의 사실과 오해", true);
    LibrarySystem.Book b3 = new LibrarySystem.Book("테스트 주도 개발(TDD)", true);

    LibrarySystem.Library library = new LibrarySystem.Library();
    library.addBook(b1);
    library.addBook(b2);
    library.addBook(b3);

    library.powerOn();
  }
}