import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class signupthree extends JFrame implements ActionListener{

    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JRadioButton r1,r2,r3,r4;
    JButton submit, cancel,next;
    String formno;

    public signupthree(String formno){
        this.formno = formno;

        setLayout(null);
        setTitle("New Account Application");

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(200,20,400,30);
        l1.setBackground(Color.WHITE);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,20));
        type.setBounds(80,80,200,20);
        add(type);

        //radio buttons
        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway",Font.BOLD,10));
        r1.setBounds(100,120,150,20);
        add(r1);
        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway",Font.BOLD,10));
        r2.setBounds(100,150,150,20);
        add(r2);
        r3 = new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Raleway",Font.BOLD,10));
        r3.setBounds(250,120,200,20);
        add(r3);
        r4 = new JRadioButton("Reccuring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,10));
        r4.setBounds(250,150,200,20);
        add(r4);
        //button grouping
        ButtonGroup groupingacc = new ButtonGroup();
        groupingacc.add(r1);
        groupingacc.add(r2);
        groupingacc.add(r3);
        groupingacc.add(r4);


        JLabel Cnum = new JLabel("Card Number");
        Cnum.setFont(new Font("Raleway",Font.BOLD,20));
        Cnum.setBounds(80,190,250,20);
        add(Cnum);
        JLabel sub = new JLabel("Your 16 digit card number");
        sub.setFont(new Font("Raleway",Font.BOLD,10));
        sub.setBounds(80,210,250,20);
        add(sub);
        //number 
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4190");
        number.setFont(new Font("Raleway",Font.BOLD,15));
        number.setBounds(250,195,300,20);
        add(number);

        //pin num
        JLabel pinnumber = new JLabel("PIN");
        pinnumber.setFont(new Font("Raleway",Font.BOLD,20));
        pinnumber.setBounds(80,250,250,20);
        add(pinnumber);
        JLabel Sub = new JLabel("Your 4 digit Password");
        Sub.setFont(new Font("Raleway",Font.BOLD,10));
        Sub.setBounds(80,270,250,20);
        add(Sub);
        //num
        JLabel num = new JLabel("XXXX");
        num.setFont(new Font("Raleway",Font.BOLD,20));
        num.setBounds(250,250,200,20);
        add(num);

        //services
        JLabel facility = new JLabel("Services Required:");
        facility.setFont(new Font("Raleway",Font.BOLD,20));
        facility.setBounds(80,310,250,20);
        add(facility);
        //checkboxes
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,10));
        c1.setBounds(100,350,150,20);
        add(c1);
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,10));
        c2.setBounds(250,350,200,20);
        add(c2);
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,10));
        c3.setBounds(100,370,150,20);
        add(c3);
        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,10));
        c4.setBounds(250,370,200,20);
        add(c4);
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,10));
        c5.setBounds(100,390,150,20);
        add(c5);
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,10));
        c6.setBounds(250,390,200,20);
        add(c6);
        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge ");
        c7.setFont(new Font("Raleway",Font.BOLD,10));
        c7.setBounds(100,440,450,15);
        add(c7);

        //buttons
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway",Font.BOLD,10));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(150,465,80,20);
        submit.addActionListener(this);
        add(submit);
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway",Font.BOLD,10));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(280,465,80,20);
        cancel.addActionListener(this);
        add(cancel);
        next = new JButton("Next");
        next.setFont(new Font("Ralewway",Font.BOLD,10));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(400,465,80,20);
        next.addActionListener(this);
        add(next);



        setSize(600,550);
        setVisible(true);
        setLocation(300,90);

    }

    public void actionPerformed(ActionEvent ae){
       
           String type = null;

           if(r1.isSelected()){
            type = "Saving account";
           }else if(r2.isSelected()){
            type = "Current account";
           }else if(r3.isSelected()){
            type = "Fixed deposit account";
           }else if(r4.isSelected()){
            type = "Reccuring deposit account";
           }

           Random random = new Random();
           String cardno = "" + Math.abs((random.nextLong() % 9000000L) + 504093600000000L);
           

           String pin = "" + Math.abs((random.nextLong() % 9000) + 1000);

           String facility = "";
           if(c1.isSelected()){
            facility = facility + "ATM Card";
           }else if(c2.isSelected()){
            facility = facility + "Internet Banking";
           }else if(c3.isSelected()){
            facility = facility + "Mobile Banking"; 
           }else if(c4.isSelected()){
            facility = facility + "EMAIL & SMS Alerts";
           }else if(c5.isSelected()){
            facility = facility + "Cheque Book";
           }else if(c6.isSelected()){
            facility = facility + "E-Statement";
           }  
           try{
            if(ae.getSource() == submit){  
              
             if(type.equals("")){
                JOptionPane.showMessageDialog(null, "Acount type is Required");

             }else{
                conn con = new conn();
                String query1 = "insert into signupthree values('"+formno+"','"+type+"','"+cardno+"','"+pin+"','"+facility+"')";
                String query2 = "insert into login values('"+formno+"','"+cardno+"','"+pin+"')";
                con.s.executeUpdate(query1); 
                con.s.executeUpdate(query2); 

                JOptionPane.showMessageDialog(null, "Card Number: " +cardno +"\n pinnumber: " +pin);

                
             }
            }else if (ae.getSource() == cancel) {
                System.exit(0);
            }
            else if(ae.getSource() == next){
                new login().setVisible(true);
                setVisible(false);
            }
               
         }catch(Exception e) {
            System.out.println(e);
           }
        
        


    }
    public static void main(String[] args) {
        new signupthree("").setVisible(true);;
    }
}
