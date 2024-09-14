
package quizapplicationwithtimer;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener{
 
    public Score(String name, int score){
        setBounds(50,0,1100,600);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/quiz img4.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,600,650);
        add(image);
        
        JLabel heading = new JLabel("Thankyou " + name + " for playing Quiz Time!!");
        heading.setBounds(120,30,850,200);
        heading.setFont(new Font("Mongalian Baiti", Font.PLAIN,48));
        heading.setForeground(Color.MAGENTA);
        add(heading);
        
        JLabel lblscore = new JLabel("Your Score is : " + score);
        lblscore.setBounds(600,260,600,50);
        lblscore.setFont(new Font("Mongalian Baiti", Font.PLAIN,42));
        lblscore.setForeground(Color.CYAN);
        add(lblscore);
        
        
        JButton submit = new JButton("Play Aain");
        submit.setBounds(700,370,120,30);
        submit.setBackground(Color.LIGHT_GRAY);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        add(submit);
      
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args){
        new Score("User", 0);
    }
}
