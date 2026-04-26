import java.awt.Color;
import java.awt.Font;
import java.awt.Image; // for image class
import java.awt.event.*;
import java.sql.*;// for Jframe class
import javax.swing.*;

public class login extends JFrame implements ActionListener {
     JButton login,clear,signup;
     JTextField cardTextField;
     JPasswordField pinTextField;

    login() {
        
        setTitle("Automated Teller Machine"); // for title of page

        setLayout(null);//to implement customizes things
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); //to add image from a system to page
        Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT); //to adjust the size and position of the image
        ImageIcon i3 = new ImageIcon(i2); //we cannot add image in JLabel so we created new ImageIcon add insert i2
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100); //modified the position of image
        add(label);

        getContentPane().setBackground(Color.WHITE);// background color

        //to enter text
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("osward",Font.BOLD,30));
        text.setBounds(200,40,400,40);
        add(text);

        //to enter details
        JLabel cardno = new JLabel("cardNo:");
        cardno.setFont(new Font("Raleway",Font.BOLD,20));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        add(cardTextField);//to get text box

        JLabel PIN = new JLabel("PIN :");
        PIN.setFont(new Font("Raleway",Font.BOLD,20));
        PIN.setBounds(120,220,250,30);
        add(PIN);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);//to get text box
        
        // to add buttons
        login = new JButton("SIGN IN");
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.setBounds(300,300,100,30);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.setBounds(430,300,100,30);
        clear.addActionListener(this);
        add(clear);

        signup= new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.setBounds(300,350,230,30);
        signup.addActionListener(this);
        add(signup);

        setSize(700,500);
        setVisible(true);// to seee the page
        setLocation(300,150);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == login){
            conn con = new conn();
            String cardno = cardTextField.getText();
            String pin = pinTextField.getText();
            String query = "Select *from login where cardno ='"+cardno+"' and pin ='"+pin+"'";

            try {
                ResultSet rs = con.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(ae.getSource() == signup){
            setVisible(false);
           new signupone().setVisible(true);
            
        }
        
    }
    public static void main(String[] args) {
       new login().setVisible(true);;
    }
}   