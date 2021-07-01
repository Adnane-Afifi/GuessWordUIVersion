import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Game extends JPanel {

     private  int nombreDemotTrouver=0;
     private int currentScore = 0 ;
     BufferedImage hangManDraw ;

    public void paintComponent(Graphics g) {
        g.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        g.drawString("Nombre de mot trouver "+String.valueOf(nombreDemotTrouver),400,50);
        g.drawString("Votre score actuelle :"+String.valueOf(currentScore),400,100);
        g.drawImage(setImage(),400,120,this);
    }

    public BufferedImage setImage(){
        int i =0 ;
        try{
           hangManDraw= ImageIO.read(new File("/Users/adnaneafifi/Documents/Jeux du pendu/Images/13187"+i+".jpeg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return hangManDraw;
    }


}
