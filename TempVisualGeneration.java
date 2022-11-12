import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class TempVisualGeneration extends Canvas {


    public TempVisualGeneration() {
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
            menuFontTitle = menuFontTemp.deriveFont((float) 15.0);
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
            drawStringMulti(g, "THRONE OF GLASS ", 15, start + 20 + (i * 140), 15);
            g.drawString("$$$", 180, start + 20 + (i * 140));
            g.setFont(menuFontText);
            g.drawString("********************************************", 15, start + (i * 140));
            drawStringMulti(g, "AUTHOR blah blah blah rating long name very long", 50, start + 60 + (i * 140), 20);
        }

        //Specials Section
        start = 270;
        g.setFont(menuFontTitle);
        drawStringMulti(g, "THRONE OF GLASS", 15 + 220, start + 20, 15);
        g.setFont(menuFontText);
        drawStringMulti(g, "Quote quote quote i freaking love this book! Also I love ur mom.", 15 + 220, start + 70, 19);

        //Dinner Section
        start = 605;
        for (int i = 0; i < 3; i++) {
            g.setFont(menuFontTitle);
            drawStringMulti(g, "THRONE OF GLASS", 15, start + 20 + (i * 90), 30);
            g.drawString("$$$", 390, start + 20 + (i * 90));
            g.setFont(menuFontText);
            g.drawString("*****************************************************************************************", 15, start + (i * 90));
            drawStringMulti(g, "AUTHOR", 50, start + 40 + (i * 90), 50);
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
        TempVisualGeneration menu = new TempVisualGeneration();
    }

}
