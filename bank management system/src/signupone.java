import java.awt.Color;
import java.awt.Font;
import java.util.*
;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.*;
import java.awt.event.*;
import javax.swing.JOptionPane;


public class signupone extends JFrame implements ActionListener {
    
    long random;
        JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
        JButton next;
        JRadioButton male,female,married,unmarried,other;
        JDateChooser dateChooser;
    
    
    signupone(){
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong()%9000l)+1000L);
        JLabel formno = new JLabel("Application form no:" +random);
        formno.setFont(new Font("Raleway",Font.BOLD,30));
        formno.setBounds(140,15,600,35);
        add(formno);

        JLabel personDetails = new JLabel("page 1:personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,18));
        personDetails.setBounds(235,60,400,25);
        add(personDetails);

        getContentPane().setBackground(Color.WHITE);

        JLabel Name = new JLabel("Name :");
        Name.setFont(new Font("Raleway",Font.BOLD,15));
        Name.setBounds(100,100,100,20);
        add(Name);
        //texxt field
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(250,100,250,20);
        add(nameTextField);

        JLabel fatherName = new JLabel("Father Name:");
        fatherName.setFont(new Font("Raleway",Font.BOLD,15));
        fatherName.setBounds(100,130,200,20);
        add(fatherName);
        //texxt field
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(250,130,250,20);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,15));
        dob.setBounds(100,160,200,20);
        add(dob);//texxt field
        dateChooser = new JDateChooser();
        dateChooser.setBounds(250,160,250,20);
        add(dateChooser);
        
    
        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway",Font.BOLD,15));
        gender.setBounds(100,190,100,20);
        add(gender);

        //radio buttons
        male = new JRadioButton("Male");
        male.setBounds(250,190,80,20);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(350,190,100,20);
        female.setBackground(Color.WHITE);
        add(female);
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);


        JLabel email = new JLabel("Email address :");
        email.setFont(new Font("Raleway",Font.BOLD,15));
        email.setBounds(100,220,200,20);
        add(email);
        //texxt field
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(250,220,250,20);
        add(emailTextField);

        JLabel marital = new JLabel("Marital status:");
        marital.setFont(new Font("Raleway",Font.BOLD,15));
        marital.setBounds(100,250,200,20);
        add(marital);
       //radio buttons
       married = new JRadioButton("Married");
       married.setBounds(250,250,80,20);
       married.setBackground(Color.WHITE);
       add(married);
       unmarried = new JRadioButton("Unmarried");
       unmarried.setBounds(350,250,100,20);
       unmarried.setBackground(Color.WHITE);
       add(unmarried);
       other = new JRadioButton("Other");
       other.setBounds(450,250,80,20);
       other.setBackground(Color.WHITE);
       add(other);
       //grouping
       ButtonGroup maritalstatus = new ButtonGroup();
       maritalstatus.add(married);
       maritalstatus.add(unmarried);
       maritalstatus.add(other);


        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Raleway",Font.BOLD,15));
        address.setBounds(100,280,200,20);
        add(address);
        //texxt field
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(250,280,250,20);
        add(addressTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,15));
        city.setBounds(100,310,200,20);
        add(city);
        //texxt field
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(250,310,250,20);
        add(cityTextField);

        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,15));
        state.setBounds(100,340,100,20);
        add(state);
        //texxt field
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(250,340,250,20);
        add(stateTextField);

        JLabel pincode = new JLabel("PinCode :");
        pincode.setFont(new Font("Raleway",Font.BOLD,15));
        pincode.setBounds(100,370,100,20);
        add(pincode);
        //texxt field
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextField.setBounds(250,370,250,20);
        add(pincodeTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBounds(400,420,80,20);
        next.addActionListener(this);
        add(next);

        setTitle("New Account Application");
        setSize(700,500);
        setVisible(true);
        setLocation(300,150);
  
    }

    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "male";
        }else if(female.isSelected()){
            gender = "female";
        }
        
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "married";
        }else if(unmarried.isSelected()){
            marital = "Unmarried";
        }else if(other.isSelected()){
            marital = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();

        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }
            else {
                conn c = new conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new signuptwo(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new signupone().setVisible(true);;
    }
}
 