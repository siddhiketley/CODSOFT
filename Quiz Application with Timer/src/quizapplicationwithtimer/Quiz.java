
package quizapplicationwithtimer;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Quiz extends JFrame  implements ActionListener{
    
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers [][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit;
    
    public static int timer = 20;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
     String name;
     
    public Quiz( String name){
        this.name = name;
        setBounds(50,0,1100,600);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/quiz img3.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(10,350,1800,220);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(50,30,50,30);
        qno.setFont(new Font("Mongalian Baiti", Font.PLAIN,24));
        qno.setForeground(Color.MAGENTA);
        add(qno);
        
        question = new JLabel();
        question.setBounds(80,30,900,30);
        question.setFont(new Font("Mongalian Baiti", Font.PLAIN,24));
        question.setForeground(Color.MAGENTA);
        add(question);
        
        questions[0][0] = "What is runnable?";
        questions[0][1] = "Abstract class";
        questions[0][2] = "Interface";
        questions[0][3] = "Class";
        questions[0][4] = "Method";

        questions[1][0] = "Where is System class defined?";
        questions[1][1] = "java.lang.package";
        questions[1][2] = "java.util.package";
        questions[1][3] = "java.io.package";
        questions[1][4] = "None";

        questions[2][0] = "Identify the interface which is used to declare core methods in Java?";
        questions[2][1] = "Comparator";
        questions[2][2] = "EventListener";
        questions[2][3] = "Set";
        questions[2][4] = "Collection";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "When an array is passed to a method, what does the method receive?";
        questions[4][1] = "The reference of the array";
        questions[4][2] = "A copy of the array";
        questions[4][3] = "Length of the array";
        questions[4][4] = "Copy of first element";

        questions[5][0] = "Array in Java are- ";
        questions[5][1] = "Object reference";
        questions[5][2] = "objects";
        questions[5][3] = "Primitive data type";
        questions[5][4] = "None";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "When is the object created with new keyword?";
        questions[8][1] = "At run time";
        questions[8][2] = "At compile time";
        questions[8][3] = "Depends on the code";
        questions[8][4] = "None";

        questions[9][0] = "compareTo() returns?";
        questions[9][1] = "True";
        questions[9][2] = "False";
        questions[9][3] = "An int value";
        questions[9][4] = "None";
        
        answers[0][1] = "Interface";
        answers[1][1] = "java.lang.package";
        answers[2][1] = "Collection";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "The reference of the array";
        answers[5][1] = "objects";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "At run time";
        answers[9][1] = "An int value";
        
        
        opt1 = new JRadioButton();
        opt1 .setBounds(50,100,400,100);
        opt1.setBackground(Color.BLACK);
        opt1.setFont(new Font("Mongolain Baiti" , Font.PLAIN,20));
        opt1.setForeground(Color.PINK);  
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2 .setBounds(50,170,400,100);
        opt2.setBackground(Color.BLACK);
        opt2.setFont(new Font("Mongolain Baiti" , Font.PLAIN,20));            
        opt2.setForeground(Color.PINK);
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(50,240,400,100);
        opt3.setBackground(Color.BLACK);
        opt3.setFont(new Font("Mongolain Baiti" , Font.PLAIN,20));
        opt3.setForeground(Color.PINK);
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(50,310,400,100);
        opt4.setBackground(Color.BLACK);
        opt4.setFont(new Font("Mongolain Baiti" , Font.PLAIN,20));
        opt4.setForeground(Color.PINK);
        add(opt4);
        
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        
        next = new JButton("NEXT");
        next.setBounds(800,190,200,30);
        next.setFont(new Font("Mongolain Baiti", Font.PLAIN, 22));
        next.setBackground(Color.LIGHT_GRAY);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        add(next);
        
        submit = new JButton("SUBMIT");
        submit.setBounds(800,270,200,30);
        submit.setFont(new Font("Mongolain Baiti", Font.PLAIN, 22));
        submit.setBackground(Color.LIGHT_GRAY);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        
        start(count);
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == next){
            repaint();
            
            ans_given = 1;
            
            if (groupoptions.getSelection() == null){
                useranswers[count][0] = "";
            }else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
         
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
                
            
            count++;
            start(count);
        }else if(ae.getSource() == submit){
            ans_given = 1;
             if (groupoptions.getSelection() == null){
                useranswers[count][0] = "";
            }else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                 
                 
                 for(int i = 0; i < useranswers.length; i++){
                    if(useranswers[i][0].equals(answers[i][1])){
                        score += 10;
                    } else{
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
       }
   }
    
    public void paint(Graphics g){
        super.paint(g);
        
        String time = "Time Left : " + timer + " seconds";
        g.setColor(Color.red);
        g.setFont(new Font("Mongalion Baiti", Font.BOLD, 25));
        
        if(timer > 0){
            g.drawString(time,780,150);
        } else{
             g.drawString("Times Up!! ",780,150);
        }
        
        timer --;
        
        try{
            Thread.sleep(1000);
            repaint();
        } catch (Exception e){
          e.printStackTrace();
        }
        
        if(ans_given == 1){
            ans_given = 0;
            timer = 20;
        }else if(timer < 0)
        {
            timer = 20;
            
            if(count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count ==  9){
                 if (groupoptions.getSelection() == null){
                useranswers[count][0] = "";
            }else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                 }
                 
                 
                 for(int i = 0; i < useranswers.length; i++){
                     if(useranswers[i][0].equals(answers[i][1])){
                         score += 10;
                     } else{
                         score += 0;
                     }
                 }
                 setVisible(false);
                new Score(name, score);
            }else {
                
            if (groupoptions.getSelection() == null){
                useranswers[count][0] = "";
            }else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            count++;
            start(count);
        }
    }
    }
    
    public void start(int count){
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
        
    }
    
    public static void main(String[] args){
        new Quiz("User");
    }
    
}
