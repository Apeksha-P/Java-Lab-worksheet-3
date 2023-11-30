import java.util.ArrayList;
import java.util.List;

abstract class BorrowableItems{
    abstract void displayInfo();
}
class Book extends BorrowableItems{
    private String title;
    private String author;
    private String ISBN;
    private boolean available;

    public Book(String title,String author,String ISBN){
        this.title=title;
        this.author=author;
        this.ISBN=ISBN;
        this.available=true;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public String getISBN(){
        return ISBN;
    }
    public void setISBN(String ISBN){
        this.ISBN=ISBN;
    }
    public boolean isAvailable(){
        return available;
    }
    public void setAvailable(boolean available){
        this.available=available;
    }
    void displayInfo(){
        System.out.println("Title : "+title);
        System.out.println("Author : "+author);
        System.out.println("ISBN : "+ISBN);
        System.out.println("Available : "+available);
    }
}
class Person{
    private String name;
    public Person(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}
class Student extends Person{
    public Student(String name){
        super(name);
    }
}
class Library{
    private List<BorrowableItems>borrowableItemsList = new ArrayList<>();
    public void addLibraryItem(BorrowableItems item){
        borrowableItemsList.add(item);
    }
    public void checkoutItem(String title){
        for (BorrowableItems item : borrowableItemsList){
            if(item instanceof Book){
                Book book = (Book) item;
                if (book.getTitle().equals(title)&& book.isAvailable()){
                    book.setAvailable(false);
                    System.out.println("Check out: "+title);
                    return;
                }
            }
        }
        System.out.println("Book not found or already checked out: "+title);
    }
    public void listAvailableItems(){
        System.out.println("Available items in the library: ");
        for (BorrowableItems item : borrowableItemsList){
            if(item instanceof Book){
                Book book = (Book) item;
                if (book.isAvailable()){
                    book.displayInfo();
                }
            }
        }
    }
    public void displayLibraryInfo(){
        System.out.println("Total number of items in the library: "+borrowableItemsList.size());
    }
}
public class Main {
    public static void main(String[] args) {

    }
}
