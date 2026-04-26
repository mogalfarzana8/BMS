import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class pinchange extends JFrame implements ActionListener{

    JPasswordField Pin,repintext;
    JButton change,back;
    String pin;


    public pinchange(String pin) {
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,600,550);
        add(image);

        JLabel text = new JLabel("Change your PIN ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        text.setBounds(170,170,500,25);
        image.add(text);

        JLabel pintext = new JLabel("New PIN: ");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 12));
        pintext.setBounds(110,200,100,15);
        image.add(pintext);

        Pin = new JPasswordField();
        Pin.setFont(new Font("System", Font.BOLD, 15));
        Pin.setBounds(220,200,120,15);
        image.add(Pin);
        

        JLabel repin = new JLabel("Re-Enter New PIN: ");
        repin.setForeground(Color.WHITE);
        repin.setFont(new Font("System", Font.BOLD, 12));
        repin.setBounds(105,230,150,12);
        image.add(repin);

        repintext = new JPasswordField();
        repintext.setFont(new Font("System", Font.BOLD, 15));
        repintext.setBounds(220,230,120,15);
        image.add(repintext);

        change = new JButton("CHANGE");
        change.setBounds(230,300,100,18);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(230,320,100,18);
        back.addActionListener(this);
        image.add(back);


        setSize(600,600);
        setLocation(300,90);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
       
        try {
            String npin = Pin.getText();
            String rpin = repintext.getText();

            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Enter pin does not match");
                return;
            }


             if(ae.getSource() == change){
                 if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter pin");
                return;
              }
             if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-enter new pin");
                return;
            }
            conn con = new conn();
            String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"'";
            String query2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"'";
            String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pin+"'";
 
            con.s.executeUpdate(query1);
            con.s.executeUpdate(query2);
            con.s.executeUpdate(query3);

            JOptionPane.showMessageDialog(null, "pin changed Successfully");

           setVisible(false);
           new Transactions(pin).setVisible(true);
        } else {
        setVisible(false);
        new Transactions(pin).setVisible(true);
         }
     } catch (Exception e) {
            System.out.println(e);
        }
    }
   

    public static void main(String[] args) {
        new pinchange("").setVisible(true);
    }
}
