package ex5.LibrarySystem;

public class Book {

  private final String title;
  private boolean available;

  public Book(String title, boolean available) {
    this.title = title;
    this.available = available;
  }

  public String getTitle() {
    return this.title;
  }

  public boolean isAvailable() {
    return this.available;
  }

  public void setStatus(boolean b) {
    this.available = b;
  }
}