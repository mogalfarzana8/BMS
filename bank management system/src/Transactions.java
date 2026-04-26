import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawl, fastcash, minStat, pinchg, Blenq, exit;  

    String pin;
    public Transactions(String pin) {
      this.pin = pin;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,600,550);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(135,180,500,30);
        text.setForeground(Color.WHITE);
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Raleway",Font.BOLD,10));
        deposit.setBounds(110,255,90,18);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl =new JButton("Cash Withdrawl");
        withdrawl.setFont(new Font("Raleway",Font.BOLD,10));
        withdrawl.setBounds(220,255,120,18);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash =new JButton("Fast Cash");
        fastcash.setFont(new Font("Raleway",Font.BOLD,10));
        fastcash.setBounds(110,275,90,18);
        fastcash.addActionListener(this);
        image.add(fastcash);

        minStat =new JButton("Mini Statement");
        minStat.setFont(new Font("Raleway",Font.BOLD,10));
        minStat.setBounds(220,275,120,18);
        minStat.addActionListener(this);
        image.add(minStat);

        pinchg =new JButton("Pin Change");
        pinchg.setFont(new Font("Raleway",Font.BOLD,10));
        pinchg.setBounds(110,295,90,18);
        pinchg.addActionListener(this);
        image.add(pinchg);

        Blenq =new JButton("Balance Enquiry");
        Blenq.setFont(new Font("Raleway",Font.BOLD,10));
        Blenq.setBounds(220,295,120,18);
        Blenq.addActionListener(this);
        image.add(Blenq);

        
        exit =new JButton("Exit");
        exit.setFont(new Font("Raleway",Font.BOLD,10));
        exit.setBounds(220,315,120,18);
        exit.addActionListener(this);
        image.add(exit);

        setSize(600,600);
        setLocation(300,90);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == exit){
        System.exit(0);
    } else if(ae.getSource() == deposit){
        setVisible(false);
        new Deposit(pin).setVisible(true); 
    } else if(ae.getSource() == withdrawl){
      setVisible(false);
      new withdrawl(pin).setVisible(true);
    } else if(ae.getSource() == fastcash) {
      setVisible(false);
      new Fastcash(pin).setVisible(true);  
    } else if(ae.getSource() == pinchg){
      setVisible(false);
      new pinchange(pin).setVisible(true);
    }else if(ae.getSource() == Blenq){
      setVisible(false);
      new BalanceEnquiry(pin).setVisible(true);
    }else if(ae.getSource() == minStat){
      new Ministatement(pin).setVisible(true);
    }
    }

  
    
    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }

  }
