import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow  extends JFrame {
    private final int m_width = 700;
    private final int m_height =600;

    private ImageIcon m_killImage = new ImageIcon("/Users/adnaneafifi/Documents/Jeux du pendu/Images/hangmanKilled.png");


    private JLabel m_TitleGame = new JLabel("HANGMAN GAME");
    private JLabel m_Image_Title = new JLabel(m_killImage);


    private JButton m_B_StartTheGame = new JButton("START");
    private JButton m_B_QuitTheGame = new JButton("QUIT");

    MainWindow(){
        setLayout(null);
        getContentPane().add(m_TitleGame);
        getContentPane().add(m_B_StartTheGame);
        getContentPane().add(m_B_QuitTheGame);
        getContentPane().add(m_Image_Title);
        setMainTitle();
        setStartButton();
        startGame();
        setKillImage();
        setQuitButton();
        quitGame();
        setName("Jeux du pendu");
        setTitle("Jeux du pendu ");
        setSize(m_width,m_height);
        setResizable(false);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setVisible(true);


    }
    //IMT NOT

    public void setMainTitle(){
        m_TitleGame.setBounds(250,-50,200,200);
        m_TitleGame.setFont(new Font(Font.MONOSPACED,Font.ITALIC,25));
//        TitleGame.setOpaque(true);
//        TitleGame.setBackground(Color.);
        m_TitleGame.setForeground(ColorUIResource.blue);

    }
    public void setStartButton(){
        m_B_StartTheGame.setBounds(m_width/5+100,m_height/4,200,100);
        m_B_StartTheGame.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        m_B_StartTheGame.setForeground(Color.GREEN.darker());
    }

    public void setQuitButton(){
        m_B_QuitTheGame.setBounds(m_width/5+100,m_height/2,200,100);
        m_B_QuitTheGame.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        m_B_QuitTheGame.setForeground(Color.RED.darker());
    }
    public void setKillImage(){
        m_Image_Title.setBounds(-460,15,950,280);
    }

    public void startGame(){
        m_B_StartTheGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==m_B_StartTheGame){
                    Hangman hagman  = new Hangman();
                }
            }
        });
    }

    public void quitGame(){
        m_B_QuitTheGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==m_B_QuitTheGame){
                   dispose();
                }
            }
        });
    }






}
