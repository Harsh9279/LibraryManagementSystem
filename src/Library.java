import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }
    public void addMember(Member member) { members.add(member); }

    public Book findBook(String isbn) {
        for(Book b : books) if(b.getIsbn().equals(isbn)) return b;
        return null;
    }

    public Member findMember(String id) {
        for(Member m : members) if(m.getMemberId().equals(id)) return m;
        return null;
    }

    public ArrayList<Book> search(String keyword) {
        ArrayList<Book> result = new ArrayList<>();
        for(Book b : books) {
            if(b.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
               b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }

    public void displayBooks() {
        for(Book b : books) b.displayInfo();
    }
}
