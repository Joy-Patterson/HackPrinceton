import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainJavaFile {

    public static void main(String[] args) {

        ArrayList<Book> listOfBooks = new ArrayList<Book>(10);
        /*String review = " ";*/
        String highestRating = "0";
        BufferedReader file =
                new BufferedReader(new InputStreamReader(System.in));
        String thisLine = null;

        do {
            try {
                thisLine = file.readLine();
            } catch (IOException ex) {
                System.out.println(ex.toString());
                System.out.println("Could not find file");
            }

            if (thisLine != null) {
                String[] fields = thisLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                String name = fields[1];
                String author = fields[2];
                String rating = fields[8];
                String pages = fields[11];
                String date = fields[15];
                /*String currentReview = fields[19];*/
                String review = fields[19];
                /*if (rating.compareTo(highestRating) > 0) {
                    if (!currentReview.equals(" ")) review = currentReview;
                }*/
                Book newBook = new Book(name, author, rating, pages, review, date);
                listOfBooks.add(newBook);
            }

        } while (thisLine != null);

        listOfBooks.remove(0);

        Comparator<Book> comparator = Book.byDate();
        listOfBooks.sort(comparator);

        // int size = listOfBooks.size();

        List<Book> bookList = listOfBooks.subList(0, 10);
        bookList.sort(comparator);
/*
        for (int a = 0; a < 10; a++) {
            Book bookDebug = bookList.get(a);
            System.out.println(bookDebug.name);
            System.out.println(bookDebug.author);
            System.out.println(bookDebug.rating);
            System.out.println(bookDebug.pages);
            System.out.println(bookDebug.date);
            System.out.println(bookDebug.review);
        }
*/

        /* ******************************************************/

        TempVisualGeneration menu = new TempVisualGeneration(bookList);
    }


}

