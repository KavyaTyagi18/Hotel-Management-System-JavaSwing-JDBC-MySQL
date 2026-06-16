package hotel.management.system;
import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
import java.awt.event.*;
//import java.sql.*;


public class AddEmployee  extends JFrame implements ActionListener{
    JTextField tfname,tfemail,tfphone,tfage,tfsalary,tfaadhar;
    JRadioButton rbmale,rbfemale,rbother;
    JButton submit;
    JComboBox cbjob;
    
    
    
    
    AddEmployee(){
        setLayout(null);
        JLabel lb1name = new JLabel("NAME");
        lb1name.setBounds(60,40,120,30);
        lb1name.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lb1name);
        
         tfname = new JTextField();
        tfname.setBounds(210,40,160,30);
        add(tfname);
        
        JLabel lb1age = new JLabel("AGE");
        lb1age.setBounds(60,90,120,30);
        lb1age.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lb1age);
        
        tfage = new JTextField();
        tfage.setBounds(210,90,160,30);
        add(tfage);
        
        
        
         JLabel lb1gender = new JLabel("GENDER");
        lb1gender.setBounds(60,140,120,30);
        lb1gender.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lb1gender);
        
         rbmale = new JRadioButton("Male");
        rbmale.setBounds(210,140,70,30);
        rbmale.setFont(new Font("tahoma",Font.BOLD,14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        
         rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(290,140,80,30);
        rbfemale.setFont(new Font("tahoma",Font.BOLD,14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        
     rbother = new JRadioButton("Other");
        rbother.setBounds(390,140,90,30);
        rbother.setFont(new Font("tahoma",Font.BOLD,14));
        rbother.setBackground(Color.WHITE);
        add(rbother);
        
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        bg.add(rbother);
        
        JLabel lb1job = new JLabel("JOB");
        lb1job.setBounds(60,190,120,30);
        lb1job.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lb1job);
        
        String str[] = {"Front Desk Clerks" , "Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Witress","Manager","Accountant"};
         cbjob = new JComboBox(str);
        cbjob.setBounds(210,180,150,30);
        cbjob.setFont(new Font("Tahoma",Font.BOLD,12));
        cbjob.setBackground(Color.white);
        add(cbjob);
        
        
        JLabel lb1salarly = new JLabel("SALARY");
        lb1salarly .setBounds(60,240,120,30);
        lb1salarly .setFont(new Font("Tahoma",Font.BOLD,20));
        add(lb1salarly );
        
    tfsalary = new JTextField();
        tfsalary.setBounds(210,240,160,30);
        add(tfsalary);
        
        JLabel lb1phone = new JLabel("PHONE");
        lb1phone .setBounds(60,290,120,30);
        lb1phone.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lb1phone);
        
       tfphone= new JTextField();
        tfphone.setBounds(210,290,160,30);
        add(tfphone);
        JLabel lb1email = new JLabel("EMAIL");
        lb1email .setBounds(60,340,120,30);
        lb1email .setFont(new Font("Tahoma",Font.BOLD,20));
        add(lb1email );
        
        tfemail = new JTextField();
        tfemail.setBounds(210,340,160,30);
        add(tfemail);
        
        
        JLabel lb1aadhar = new JLabel("AADHAR");
        lb1aadhar .setBounds(60,390,120,30);
        lb1aadhar .setFont(new Font("Tahoma",Font.BOLD,20));
        add(lb1aadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(210,390,160,30);
        
        
        
        add(tfaadhar);
        
        
        
      submit = new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(210,450,150,30);
        submit.addActionListener(this);
        add(submit);
        
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/tenth.jpg"));
        JLabel image = new JLabel (i1);
        image.setBounds(380,20,450,450);
        add(image);
        
     getContentPane().setBackground(Color.WHITE);   
    setBounds(360,200,800,550);
    setVisible(true);
}
    
  public void actionPerformed (ActionEvent ae){
        
        String name  =  tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;
        
        
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name should not be empty");
            return;
        }
        if(rbmale.isSelected()){
            gender = "Male";
        }else if (rbfemale.isSelected()){
            
        gender = "female";
    }
        
        String job = (String )cbjob.getSelectedItem();
        
        try{
            
            Conn conn = new Conn();
            //String query = "insert into employee values ('" + name + " '  , ' " + age + " ' , ' " +gender+  " ' , ' " +job+ " ' , ' " + salary+ " ' , ' " +phone+  " ' , ' " +email+  " ' , ' " +aadhar+  " ' )";
            String query = "insert into employee values ('" + name + "', '" + age + "', '" + gender + "', '" + job + "', '" + salary + "', '" + phone + "', '" + email + "', '" + aadhar + "')";
System.out.println("Query: " + query); 
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog( null , " Employee  added  successfully  " );
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
    }
    public static void main(String[]args){
        new AddEmployee();
    }
    
}
