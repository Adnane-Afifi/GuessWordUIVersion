import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Instruction extends JPanel {



   BufferedImage hangMan ;
   private void drawString(Graphics g, String text, int x, int y) {

        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }


public void paintComponent(Graphics g) {
    try {

        hangMan = ImageIO.read(new File("/Users/adnaneafifi/Documents/Jeux du pendu/Images/131868.jpeg"));

    } catch (IOException ex) {

        System.out.println("ERROR!");

    }
   g.drawImage(hangMan,300,0,this);
    g.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
    drawString(g,"Instruction:",50,450);
    drawString(g,"You have 10 attempt to find the word !\nif you don't find it ...we will restart !\nMore you find words ,more you have a better rank \n" +
            "",10,500);
}

}

