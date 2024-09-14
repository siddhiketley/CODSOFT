
package quizapplicationwithtimer;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    
    
    JButton rules, back;
    JTextField tfname;
    Login(){
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/quiz img2.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,600,500);
        add(image);
        
        JLabel heading = new JLabel ("QUIZ  TIME");
        heading.setBounds(600,60,300,60);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD,52));
        heading.setForeground(Color.blue);
        add(heading);
        
        
        JLabel name = new JLabel ("Enter your name : ");
        name.setBounds(650,200,350,20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD,24));
        name.setForeground(Color.PINK);
        add(name);
        
        
        tfname = new JTextField();
        tfname.setBounds(600,250,300,25);
        tfname.setFont(new Font("Mongolian Baiti", Font.BOLD,18));
        tfname.setForeground(Color.BLACK);
        add(tfname);
        
        
        rules = new JButton("RULES");
        rules.setBounds(550,320,120,25);
        rules.setBackground(new Color(30,144,254));
        rules.setFont(new Font("Mongolian Baiti", Font.BOLD,16));
        rules.setForeground(Color.BLACK);
        rules.addActionListener(this);
        add(rules);
        
        
        back = new JButton("BACK");
        back.setBounds(850,320,120,25);
        back.setBackground(new Color(30,144,254));
        back.setFont(new Font("Mongolian Baiti", Font.BOLD,16));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
        setSize(1100,600);
        setLocation(200,150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == rules){
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
            
        }else if(ae.getSource() == back){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Login();
    }
}
