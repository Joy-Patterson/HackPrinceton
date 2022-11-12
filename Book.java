import java.util.Comparator;

public class Book implements Comparable<Book> {
    String name;
    String author;
    String rating;
    String pages;
    String review;
    String date;

    public Book(String name, String author, String rating,
                String pages, String review, String date) {
        this.name = name;
        this.author = author;
        this.rating = rating;
        this.pages = pages;
        this.review = review;
        this.date = date;
    }

    public static Comparator<Book> byDate() {
        return new DateCompare();
    }

    private static class DateCompare implements Comparator<Book> {
        public int compare(Book a, Book b) {
            return a.compareTo(b);
        }
    }

    public int compareTo(Book that) {
        String[] thisDate = this.date.split("/");
        String[] thatDate = that.date.split("/");
        int thisYear = Integer.parseInt(thisDate[2]);
        int thatYear = Integer.parseInt(thatDate[2]);
        if (thisYear > thatYear) return -1;
        else if (thisYear < thatYear) return 1;
        int thisMonth = Integer.parseInt(thisDate[0]);
        int thatMonth = Integer.parseInt(thatDate[0]);
        if (thisMonth > thatMonth) return -1;
        else if (thisMonth < thatMonth) return 1;
        int thisDay = Integer.parseInt(thisDate[1]);
        int thatDay = Integer.parseInt(thatDate[1]);
        if (thisDay > thatDay) return -1;
        else if (thisDay < thatDay) return 1;
        else return 0;
    }

    public static void main(String[] args) {

    }
}
