import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;

public class withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw, back;
    String pin;


    public withdrawl(String pin){
        this.pin = pin;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,600,550);
        add(image);

        JLabel stat = new JLabel("Enter the amount you want to withdraw");
        stat.setFont(new Font("Raleway",Font.BOLD,10));
        stat.setBounds(135,180,200,25);
        stat.setBackground(Color.WHITE);
        stat.setForeground(Color.WHITE);
        image.add(stat);

        amount = new JTextField();
        amount.setBounds(140,220,170,20);
        amount.setFont(new Font("Raleway",Font.BOLD,15));
        image.add(amount);

        withdraw = new JButton("withdraw");
        withdraw.setFont(new Font("Raleway",Font.BOLD,10));
        withdraw.setBounds(260,285,80,20);
        withdraw.addActionListener(this);
        image.add(withdraw);

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
        try {
             String Amount = amount.getText();
            Date date = new Date();
       
        if(ae.getSource() == withdraw){
            
            if(Amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter the amount you want to withdraw");
            }
            else {
                
                conn con = new conn();

                ResultSet rs = con.s.executeQuery("select * from bank where pin = '"+pin+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("Amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("Amount"));
                       }
                    }
                    if(balance < Integer.parseInt(Amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }



                String query = "insert into bank values('"+pin+"', '"+date+"', 'withdrawl', '"+Amount+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs " +Amount+"withdrawled Successfully");
                setVisible(false);
                new Transactions(pin).setVisible(true);
                }
            } else if(ae.getSource() == back){
                  setVisible(false);
                new Transactions(pin).setVisible(true); 
                }
                
                }catch (Exception e){
                    System.out.println(e);
                }          
              }

        
    
    public static void main(String[] args) {
        new withdrawl("").setVisible(true);;
    }
}
