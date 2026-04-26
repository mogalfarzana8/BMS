import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Fastcash extends JFrame implements ActionListener {

    JButton deposit, withdrawl, fastcash, minStat, pinchg, Blenq, exit;  

    String pin;
    public Fastcash(String pin) {
      this.pin = pin;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,600,550);
        add(image);

        JLabel text = new JLabel("Select withdrawl Amout");
        text.setBounds(135,180,500,30);
        text.setForeground(Color.WHITE);
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setFont(new Font("Raleway",Font.BOLD,10));
        deposit.setBounds(110,255,90,18);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl =new JButton("Rs 500");
        withdrawl.setFont(new Font("Raleway",Font.BOLD,10));
        withdrawl.setBounds(220,255,120,18);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash =new JButton("Rs 1000");
        fastcash.setFont(new Font("Raleway",Font.BOLD,10));
        fastcash.setBounds(110,275,90,18);
        fastcash.addActionListener(this);
        image.add(fastcash);

        minStat =new JButton("Rs 2000");
        minStat.setFont(new Font("Raleway",Font.BOLD,10));
        minStat.setBounds(220,275,120,18);
        minStat.addActionListener(this);
        image.add(minStat);

        pinchg =new JButton("Rs 5000");
        pinchg.setFont(new Font("Raleway",Font.BOLD,10));
        pinchg.setBounds(110,295,90,18);
        pinchg.addActionListener(this);
        image.add(pinchg);

        Blenq =new JButton("Rs 10000");
        Blenq.setFont(new Font("Raleway",Font.BOLD,10));
        Blenq.setBounds(220,295,120,18);
        Blenq.addActionListener(this);
        image.add(Blenq);

        
        exit =new JButton("Back");
        exit.setFont(new Font("Raleway",Font.BOLD,10));
        exit.setBounds(220,315,120,18);
        exit.addActionListener(this);
        image.add(exit);

        setSize(600,600);
        setLocation(300,90);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
      try {
         String Amount = ((JButton)ae.getSource()).getText().substring(3);
         conn c = new conn();
      
         ResultSet rs = c.s.executeQuery("select *from bank where pin = '"+pin+"'");
         int balance = 0;
         while(rs.next()){
          if(rs.getString("type").equals("Deposit")){
            balance += Integer.parseInt(rs.getString("Amount"));
          } else {
            balance -= Integer.parseInt(rs.getString("Amount"));
          }
         }

         if(ae.getSource() != exit && balance < Integer.parseInt(Amount)){
          JOptionPane.showMessageDialog(null, "Insufficient balance");
          return;
         }
         
      if(ae.getSource() == exit){
        setVisible(false);
        new Transactions(pin).setVisible(true);
         }  else {
         Date date  = new Date();
         String query = "Insert into bank values('"+pin+"', '"+date+"', 'withdrawl', '"+Amount+"')";
         c.s.executeUpdate(query);
         JOptionPane.showMessageDialog(null, "Rs "+ Amount +" Debited successfully");
         
         setVisible(false);
         new Transactions(pin).setVisible(true);
         }
        } catch (Exception e) {
          System.out.println(e);
      }
    }

  
    
    public static void main(String[] args) {
        new Fastcash("").setVisible(true);;
    }

  }