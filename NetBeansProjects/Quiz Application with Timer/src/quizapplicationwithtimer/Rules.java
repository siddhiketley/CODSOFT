package quizapplicationwithtimer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Rules extends JFrame implements ActionListener{
    
    String name;
    JButton start, back;
    
    
    Rules(String name){
        this.name = name;
        
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        JLabel heading = new JLabel ("WELCOME " + name + " to QUIZ TIME!");
        heading.setBounds(220,30,900,60);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD,42));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel rules = new JLabel();
        rules.setBounds(220,100,1000,350);
        rules.setFont(new Font("Mongolian Baiti", Font.PLAIN,24));
        rules.setForeground(Color.LIGHT_GRAY);
        rules.setText(
                
           "<html>" +
            "1.  One Question at a Time : you can't go back to previous question." + "<br><br>" +
            "1.  Time Limit : 15 seconds per question." + "<br><br>" +          
            "2.  Select an Option : Choose your answer and click 'Next'." + "<br><br>" +
            "3.  Submit : Click 'Submit' after the last question." + "<br><br>" +
            "4.  Scoring : 10 points for each correct answer." + "<br><br>" +
            "5.  Result :  Your score and summary will be shown at the end." + "<br><br>" +
            "6.  Stay Focused : Try to answer all the questions within the time limit." + "<br><br>" +
           "<html>"
        );
        add(rules);
        
        
        back = new JButton("BACK");
        back.setBounds(100,500,100,30);
        back.setBackground(new Color(30,144,254));
        back.setFont(new Font("Mongolian Baiti", Font.BOLD,16));
        back.setForeground(Color.BLACK);
        back.addActionListener((ActionListener) this);
        add(back);
        
        
        start = new JButton("START");
        start.setBounds(900,500,100,30);
        start.setBackground(new Color(30,144,254));
        start.setFont(new Font("Mongolian Baiti", Font.BOLD,16));
        start.setForeground(Color.BLACK);
        start.addActionListener((ActionListener)this);
        add(start);
        
        
        setSize(1100,600);
        setLocation(200,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == start){
            setVisible(false);
            new Quiz(name);
        }else{
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args){
        new Rules("User");
    }
}
