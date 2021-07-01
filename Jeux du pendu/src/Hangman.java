import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Hangman extends JFrame {
    private final int  width = 1200;
    private final int  height = 900;

    private Game game;
    File file = new File("/Users/adnaneafifi/Documents/Jeux du pendu/Words/words.txt");


    private GridBagConstraints GBC;
    private JButton m_B_next = new JButton("Next");
    private Instruction Jinstruction = new Instruction();
    private String charbutton[] ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N",
            "O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private JButton m_B_keyboard[] = new JButton[26];

    private  String generatedWord =GenerateWord();
    private JLabel wordToGuess = new JLabel();





    Hangman() throws FileNotFoundException {
        setLayout(null);
        Jinstruction.setLayout(null);
        setContentPane(Jinstruction);
        setM_B_next();
        next_scene();
        setSize(width,height);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }


    public void setM_B_next(){
        Jinstruction.add(m_B_next);
        Jinstruction.repaint();
        m_B_next.setBounds(400,650,100,50);
        m_B_next.setForeground(Color.green.darker());
        m_B_next.setVisible(true);
    }

    public void next_scene(){
        m_B_next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==m_B_next){
                    game =new Game();
                  getContentPane().removeAll();
                  setContentPane(game);
                  GBC = new GridBagConstraints();

                  game.setLayout(null);
                  manageVirtualKeyboard();
                    try {
                        GuessedWord(generatedWord);
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                    getContentPane().revalidate();
                  getContentPane().repaint();
                }
            }
        });
    }
    public void manageVirtualKeyboard(){
        int x =width/2-230;
        int y = height/2+100;
        int count =1;
        for(int i =0 ; i<m_B_keyboard.length;i++){
            x+=50;
            m_B_keyboard[i]= new JButton(charbutton[i]);
            m_B_keyboard[i].setBounds(x,y,50,40);
            if(count==6){
                x=width/2-230;
                y+=50;
                count=1;
            }
            game.add(m_B_keyboard[i]);
            count++;
        }
    }

    public void GuessedWord(String word) throws FileNotFoundException {
        wordToGuess.setText(HashWord(word).toString());
        wordToGuess.setBounds(width/2-130,height/2-50,100,100);
        wordToGuess.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        wordToGuess.setSize(200,200);
        game.add(wordToGuess);


    }
    public int NumberOfWords() throws FileNotFoundException {
        int count =0 ;

        Scanner read = new Scanner(file);
        while(read.hasNextLine()){
            read.nextLine();
            count++;
        }
        read.close();
        return count;

    }

    public int generateNumber() throws FileNotFoundException {
        Random random  = new Random();
        int randomNumber =  random.nextInt(NumberOfWords()+1);
        System.out.println(randomNumber);
        return randomNumber;
    }

    public String GenerateWord() throws FileNotFoundException {
        int random = generateNumber();
        int count =0;
        Scanner read  = new Scanner(file);
        String word ="";
        while(read.hasNextLine()){
            read.nextLine();
            if(count==random){
                word=read.nextLine();
            }
            count++;

        }
        read.close();
        return word;

    }

    public String HashWord(String word) throws FileNotFoundException {
        StringBuilder hashWord = new StringBuilder();
        for( int i =0; i<word.length();i++){
            hashWord.append("*");
        }
        return hashWord.toString();
    }

    

}
