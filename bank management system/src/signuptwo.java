import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class signuptwo extends JFrame implements ActionListener {
    
    
        JTextField  panTextField,adhrTextField;
        JRadioButton SYes,SNo,eYes,eNo;
        JButton next;
        JComboBox Religion,Category,income,education,Occupation;
        String formno;
    
    
    signuptwo(String formno){
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,30));
        additionalDetails.setBounds(140,15,600,35);
        add(additionalDetails);
        

        getContentPane().setBackground(Color.WHITE);

        JLabel religion = new JLabel("Religion :");
        religion.setFont(new Font("Raleway",Font.BOLD,15));
        religion.setBounds(100,100,100,20);
        add(religion);
        //combobox
        String valReligion[] = {"Hindu","Sikh","Muslim","Christian","Other"};
        Religion  = new JComboBox(valReligion);
        Religion.setBounds(250,100,250,20);
        Religion.setBackground(Color.WHITE);
        add(Religion);

        JLabel category = new JLabel("Category :");
        category.setFont(new Font("Raleway",Font.BOLD,15));
        category.setBounds(100,130,200,20);
        add(category);
        //combo box
        String valCategory[] = {"General", "OBC", "SC", "Other"};
        Category = new JComboBox<>(valCategory);
        Category.setFont(new Font("Raleway",Font.BOLD,14));
        Category.setBounds(250,130,250,20);
        Category.setBackground(Color.WHITE);
        add(Category);

        JLabel inc = new JLabel("Income :");
        inc.setFont(new Font("Raleway",Font.BOLD,15));
        inc.setBounds(100,160,200,20);
        add(inc);
        //combo box
        String incomecategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000","Upto 10,00,000" };
        income = new JComboBox<>(incomecategory);
        income.setBounds(250,160,250,20);
        income.setBackground(Color.WHITE);
        add(income);
        
    
        JLabel educate = new JLabel("Educational");
        educate.setFont(new Font("Raleway",Font.BOLD,15));
        educate.setBounds(100,190,110,20);
        add(educate);
        //combo box
        String eduCategory[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        education = new JComboBox<>(eduCategory);
        education.setBounds(250,210,250,20);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel qual = new JLabel("Qualification :");
        qual.setFont(new Font("Raleway",Font.BOLD,15));
        qual.setBounds(100,210,200,20);
        add(qual);
       

        JLabel occupation = new JLabel("Occupation :");
        occupation.setFont(new Font("Raleway",Font.BOLD,15));
        occupation.setBounds(100,250,200,20);
        add(occupation);
       //combo box
       String occuCategory[] = {"Self-employed", "Bussiness", "Student", "Retired", "Other"};
       Occupation = new JComboBox<>(occuCategory);
       Occupation.setBounds(250,250,250,20);
       Occupation.setBackground(Color.WHITE);
       add(Occupation);



        JLabel pan = new JLabel("Pan Number :");
        pan.setFont(new Font("Raleway",Font.BOLD,15));
        pan.setBounds(100,280,200,20);
        add(pan);
        //text field
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(250,280,250,20);
        add(panTextField);

        JLabel adhr = new JLabel("Adhaar Number :");
        adhr.setFont(new Font("Raleway",Font.BOLD,15));
        adhr.setBounds(100,310,200,20);
        add(adhr);
        //texxt field
        adhrTextField = new JTextField();
        adhrTextField.setFont(new Font("Raleway",Font.BOLD,14));
        adhrTextField.setBounds(250,310,250,20);
        add(adhrTextField);

        JLabel scit = new JLabel("Senior Citizen :");
        scit.setFont(new Font("Raleway",Font.BOLD,15));
        scit.setBounds(100,340,200,20);
        add(scit);
        //Radio buttons
        SYes = new JRadioButton("Yes");
        SYes.setBounds(250,340,100,20);
        SYes.setBackground(Color.WHITE);
        add(SYes);
        SNo = new JRadioButton("No");
        SNo.setBounds(400,340,250,20);
        SNo.setBackground(Color.WHITE);
        add(SNo);
        ButtonGroup SCgroup = new ButtonGroup();
        SCgroup.add(SYes);
        SCgroup.add(SNo);



        JLabel eacc = new JLabel("Existing Account :");
        eacc.setFont(new Font("Raleway",Font.BOLD,15));
        eacc.setBounds(100,370,200,20);
        add(eacc);
        //Radio buttons
        eYes = new JRadioButton("Yes");
        eYes.setBounds(250,370,100,20);
        eYes.setBackground(Color.WHITE);
        add(eYes);
        eNo = new JRadioButton("No");
        eNo.setBounds(400,370,250,20);
        eNo.setBackground(Color.WHITE);
        add(eNo);
        ButtonGroup EAgroup = new ButtonGroup();
        EAgroup.add(eYes);
        EAgroup.add(eNo);


        
        

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
        String religion = (String) Religion.getSelectedItem();
        String category = (String) Category.getSelectedItem();
        String inc = (String) income.getSelectedItem();
        String educate = (String) education.getSelectedItem();
        String occupation = (String) Occupation.getSelectedItem();
        String scit = null;
        if(SYes.isSelected()){
            scit = "Yes";
        }else if(SNo.isSelected()){
           scit = "No";
        }
        
        String eacc = "";
        if(eYes.isSelected()){
            eacc = "Yes";
        }else if(eNo.isSelected()){
            eacc = "No";
        }

        String pan = panTextField.getText();
        String adhr = adhrTextField.getText();
        

        try {
            if(adhrTextField.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the required fields");
            } else{
                conn c = new conn();
                String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+inc+"','"+educate+"','"+occupation+"','"+pan+"','"+adhr+"','"+scit+"','"+eacc+"')";
                c.s.executeUpdate(query);

                //signup3 obj
                setVisible(false);
                new signupthree(formno).setVisible(true);
                }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        new signuptwo("").setVisible(true);
    }
}
 