import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class TempVisualGeneration extends Canvas {

    private List<Book> bookList;

    public TempVisualGeneration(List<Book> books) {
        bookList = books;
        JFrame f = new JFrame();
        f.add(this);
        f.setSize(429, 926);
        f.setVisible(true);
    }

    //Draw the menu
    public void paint(Graphics g) {
        setBackground(Color.WHITE);
        BufferedImage menuImg = null;
        try {
            menuImg = ImageIO.read(new File("menu.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(menuImg, 0, 0, null);

        addText(g);


    }

    //Add the text to the menu
    private void addText(Graphics g) {
        setForeground(Color.BLACK);

        //set up the font
        Font menuFontTitle = null;
        Font menuFontText = null;

        try {
            Font menuFontTemp = Font.createFont(Font.TRUETYPE_FONT, new File("menuFont.ttf"));
            menuFontTitle = menuFontTemp.deriveFont((float) 12.0);
            menuFontText = menuFontTemp.deriveFont((float) 10.0);
            g.setFont(menuFontTitle);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        //drawStringMulti(g, "THRONE OF GLASS", 15, 15, 5);

        //Drinks Section
        int start = 270;
        for (int i = 0; i < 2; i++) {
            g.setFont(menuFontTitle);
            drawStringMulti(g, bookList.get(i).name, 15, start + 20 + (i * 140), 15);
            g.setFont(menuFontText);
            g.drawString("$" + bookList.get(i).pages, 180, start + 20 + (i * 140));
            g.drawString("********************************************", 15, start + (i * 140));
            drawStringMulti(g, "By: " + bookList.get(i).author, 50, start + 60 + (i * 140), 20);
            drawStringMulti(g, "Read: " + bookList.get(i).date, 50, start + 70 + (i * 140), 20);
            drawStringMulti(g, "Rating: " + bookList.get(i).rating + " stars", 50, start + 80 + (i * 140), 20);
        }


        try {
            BufferedImage drawing = null;
            drawing = ImageIO.read(new File("food.png"));
            g.drawImage(drawing, 225, 440, null);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Specials Section
        start = 270;
        g.setFont(menuFontTitle);
        drawStringMulti(g, bookList.get(2).name, 15 + 220, start + 20, 12);
        g.setFont(menuFontText);

        if (!bookList.get(2).review.equals("")) {
            drawStringMulti(g, bookList.get(2).review, 15 + 220, start + 70, 19);
        } else {
            drawStringMulti(g, "By: " + bookList.get(2).author, 15 + 220, start + 70, 19);
            drawStringMulti(g, "Read: " + bookList.get(2).date, 15 + 220, start + 80, 19);
            drawStringMulti(g, "Rating: " + bookList.get(2).rating + " stars", 15 + 220, start + 90, 19);
        }

        //Dinner Section
        start = 605;
        for (int i = 0; i < 3; i++) {
            g.setFont(menuFontTitle);
            drawStringMulti(g, bookList.get(i + 3).name, 15, start + 10 + (i * 90), 40);
            g.setFont(menuFontText);
            g.drawString("$" + bookList.get(i + 3).pages, 390, start + 10 + (i * 90));
            g.drawString("*****************************************************************************************", 15, start + (i * 90));
            drawStringMulti(g, "By: " + bookList.get(i + 3).author, 50, start + 40 + (i * 90), 50);
            drawStringMulti(g, "Read: " + bookList.get(i + 3).date, 50, start + 50 + (i * 90), 50);
            drawStringMulti(g, "Rating: " + bookList.get(i + 3).rating + " stars", 50, start + 60 + (i * 90), 50);
        }

    }

    // Works like draw string but splits into new lines based on maxChars
    private void drawStringMulti(Graphics g, String toPrint, int x, int y, int maxChars) {
        int len = toPrint.length();
        int start = 0;
        int end = 0;
        String line = "";
        while (start < len) {

            do {
                end = toPrint.indexOf(" ", end + 1);
                if (end == -1)
                    end = len;
            } while (end < start + maxChars && end < len);
            line = toPrint.substring(start, end);
            g.drawString(line, x, y);
            y += 15;
            start = end;
        }

    }

    public static void main(String[] args) {
    }

}
