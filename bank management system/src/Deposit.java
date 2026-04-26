import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposit, back;
    String pin;


    public Deposit(String pin){
        this.pin = pin;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,600,550);
        add(image);

        JLabel stat = new JLabel("Enter the amount you want to deposit");
        stat.setFont(new Font("Raleway",Font.BOLD,10));
        stat.setBounds(135,180,200,25);
        stat.setBackground(Color.WHITE);
        stat.setForeground(Color.WHITE);
        image.add(stat);

        amount = new JTextField();
        amount.setBounds(140,220,170,20);
        amount.setFont(new Font("Raleway",Font.BOLD,15));
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway",Font.BOLD,10));
        deposit.setBounds(260,285,80,20);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,10));
        back.setBounds(260,310,80,20);
        back.addActionListener(this);
        image.add(back);

        setSize(600,600);
        setLocation(300,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        try{
              String Amount = amount.getText();
              Date date = new Date();
        if(ae.getSource() == deposit){
           if(Amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter the amount you want to deposit");
            }else {
               
                conn con = new conn();
                String query = "insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+Amount+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs " +Amount+" Deposited Successfully");
                setVisible(false);
                new Transactions(pin).setVisible(true);
              }
            }
              else if(ae.getSource() == back){
                    setVisible(false);
                    new Transactions(pin).setVisible(true); 
               }
           }catch(Exception e){
                    System.out.println(e);
                }        
    }

        
    
    public static void main(String[] args) {
        new Deposit("").setVisible(true);;
    }
}
