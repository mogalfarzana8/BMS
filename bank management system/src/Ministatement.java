
import java.awt.Color;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Ministatement extends JFrame implements ActionListener{
    

    public Ministatement(String pin) { 
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();
        
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(20,450,300,20);
        add(balance);

        JButton exit = new JButton("Exit");
        exit.setBounds(20,500,100,20);
        exit.addActionListener(this);
        add(exit);

        

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            
            while(rs.next()){
                System.out.println("login data table");
                card.setText("Card Number:    " +rs.getString("cardno").substring(0,4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
             
            }
        } catch (Exception e) {
           System.out.println(e);
        }

        try {
            conn c1 = new conn();
            int bal = 0;
            ResultSet rs = c1.s.executeQuery("Select * from bank where pin = '"+pin+"'");
            while(rs.next()){
                mini.setText(mini.getText() +"<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Amount") + "<br><br><html>");

                if(rs.getString("type").equals("Deposit")){
                     bal += Integer.parseInt(rs.getString("Amount"));
                 } else {
                     bal -= Integer.parseInt(rs.getString("Amount"));
                  } 
            }

            balance.setText("Your current balance is Rs " +bal);
            
        } catch(Exception e){
            System.out.println(e);
        }
        

     
        setSize(400,600);// to seee the page
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);

    }
    
    public static void main(String[] args) {
        new Ministatement("").setVisible(true);;
        
    }
}
