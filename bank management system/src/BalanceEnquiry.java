import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener{
    String pin;
    JButton back;

    public BalanceEnquiry(String pin) {
        this.pin  =  pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,600,550);
        add(image);

        back = new JButton("Back");
        back.setBounds(220,315,120,18);
        back.addActionListener(this);
        image.add(back);

        
        int balance = 0;
         try {
          conn c = new conn();
          ResultSet rs = c.s.executeQuery("select *from bank where pin = '"+pin+"'");
          while(rs.next()){
          if(rs.getString("type").equals("Deposit")){
            balance += Integer.parseInt(rs.getString("Amount"));
           } else {
            balance -= Integer.parseInt(rs.getString("Amount"));
           }
        }
        } catch(Exception e){
            System.out.println(e);
         }


         JLabel text = new JLabel("Your Current Account balance is Rs - " +balance);
         text.setForeground(Color.WHITE);
         text.setBounds(110,180,400,28);
         text.setFont(new Font("Raleway",Font.BOLD,10));
         image.add(text);


        setSize(600,600);
        setLocation(300,90);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }
    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
    
}
