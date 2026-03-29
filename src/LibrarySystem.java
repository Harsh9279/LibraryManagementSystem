import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n=== LIBRARY SYSTEM ===");
            System.out.println("1.Add Book");
            System.out.println("2.Add Member");
            System.out.println("3.Show Books");
            System.out.println("4.Search Books");
            System.out.println("5.Borrow Book");
            System.out.println("6.Return Book");
            System.out.println("7.Exit");

            int ch = sc.nextInt(); 
            sc.nextLine();

            switch(ch) {
                case 1:
                    System.out.print("ISBN: ");
                    String i=sc.nextLine();
                    System.out.print("Title: ");
                    String t=sc.nextLine();
                    System.out.print("Author: ");
                    String a=sc.nextLine();
                    System.out.print("Genre: ");
                    String g=sc.nextLine();
                    lib.addBook(new Book(i,t,a,g));
                    System.out.println("Book added!");
                    break;

                case 2:
                    System.out.print("ID: ");
                    String id=sc.nextLine();
                    System.out.print("Name: ");
                    String n=sc.nextLine();
                    System.out.print("Contact: ");
                    String c=sc.nextLine();
                    lib.addMember(new Member(id,n,c));
                    System.out.println("Member added!");
                    break;

                case 3:
                    lib.displayBooks();
                    break;

                case 4:
                    System.out.print("Keyword: ");
                    String k=sc.nextLine();
                    for(Book b: lib.search(k)) b.displayInfo();
                    break;

                case 5:
                    System.out.print("Member ID: ");
                    String mid=sc.nextLine();
                    System.out.print("ISBN: ");
                    String isbn=sc.nextLine();

                    Member m = lib.findMember(mid);
                    Book b = lib.findBook(isbn);

                    if(m!=null && b!=null && m.borrowBook(b))
                        System.out.println("Book borrowed!");
                    else
                        System.out.println("Failed!");
                    break;

                case 6:
                    System.out.print("Member ID: ");
                    mid=sc.nextLine();
                    System.out.print("ISBN: ");
                    isbn=sc.nextLine();

                    m = lib.findMember(mid);
                    b = lib.findBook(isbn);

                    if(m!=null && b!=null && m.returnBook(b))
                        System.out.println("Book returned!");
                    else
                        System.out.println("Failed!");
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }
}