package hotel.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.*;

public class AddDriver extends JFrame implements ActionListener {
    JButton add,cancel;
    JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
    JComboBox gendercombo,availablecombo;
    AddDriver(){
       
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel ("Add Drivers");
        heading .setFont(new Font ("tahoma",Font.BOLD,18));
        
        heading.setBounds(150,20,220,30);
        add(heading);
        
        JLabel lblroomno = new JLabel("Name");
        lblroomno.setFont(new Font("tahoma",Font.PLAIN,16));
        lblroomno.setBounds(60,80,120,30);
        add (lblroomno);
        
    tfname = new JTextField ();
        tfname.setBounds(200,80,180,30);
        add(tfname);
        
        JLabel lblage= new JLabel("Age");
        lblage .setFont(new Font("tahoma",Font.PLAIN,16));
        lblage .setBounds(60,130,120,30);
        add (lblage );
        
        tfage = new JTextField ();
        tfage.setBounds(200,130,180,30);
        add(tfage);
       
       
       JLabel lblclean = new JLabel("Gender");
        lblclean .setFont(new Font("tahoma",Font.PLAIN,16));
        lblclean.setBounds(60,180,120,30);
        add (lblclean );
        
        String cleanOptions [] = { "Male" , "Female"};
     gendercombo =  new JComboBox(cleanOptions);
      gendercombo.setBounds(200,180,180,30);
       gendercombo.setBackground(Color.white);
       add(gendercombo);
       
       
       
       JLabel lblprice = new JLabel("Car Company ");
        lblprice.setFont(new Font("tahoma",Font.PLAIN,16));
        lblprice.setBounds(60,230,120,30);
        add (lblprice);
        
         tfcompany = new JTextField ();
        tfcompany.setBounds(200,230,180,30);
        add(tfcompany);
        
        JLabel lbltype = new JLabel("Car Model");
        lbltype .setFont(new Font("tahoma",Font.PLAIN,16));
        lbltype .setBounds(60,280,180,30);
        add (lbltype );
        
        
         tfmodel = new JTextField ();
        tfmodel.setBounds(200,280,180,30);
        add(tfmodel);
        
        
        JLabel lbavailable= new JLabel("Available");
        lbavailable .setFont(new Font("tahoma",Font.PLAIN,16));
        lbavailable .setBounds(60,330,120,30);
        add (lbavailable );
        
        
         String driverOptions [] = { "Available" , "Busy"};
     availablecombo =  new JComboBox(driverOptions);
       availablecombo.setBounds(200,330,180,30);
       availablecombo.setBackground(Color.white);
       add(availablecombo);
       
        
        JLabel lblocation = new JLabel("Location ");
        lblocation.setFont(new Font("tahoma",Font.PLAIN,16));
        lblocation.setBounds(60,380,120,30);
        add (lblocation);
        
    tflocation = new JTextField ();
        tflocation.setBounds(200,380,180,30);
        add(tflocation);

        
             
      add = new JButton ("Add Driver");
       add.setForeground(Color.white);
       add.setBackground(Color.black);
       add.setBounds(60,440,130,30);
       add.addActionListener (this);
       add(add);
       
    cancel = new JButton ("Cancel");
       cancel.setForeground(Color.white);
       cancel.setBackground(Color.black);
       cancel.setBounds(220,440,130,30);
       cancel.addActionListener (this);
       add(cancel);
       
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
          
           Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
           ImageIcon i3 = new ImageIcon(i2); 
            
            JLabel image = new JLabel(i3);
            image.setBounds(430,80,500,300);
            add(image);
            
       setBounds(310,180,980,580);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource()== add ){
           //tring roomnumber = tfprice.getText();
           String name = tfname.getText();  // CORRECT
           String age = tfage.getText();
           String gender =(String)gendercombo.getSelectedItem();
           String company  = tfcompany.getText();
           String brand  = tfmodel.getText();
           String available =  (String)availablecombo.getSelectedItem();
           String location =  tflocation.getText();
          
          try{
//String str = "INSERT INTO room values( '"+room+"', '"+available+"', '"+status+"','"+price+"', '"+type+"')";
             Conn conn = new Conn();
             //String str = "INSERT INTO room VALUES ('" + roomnumber + "', '" + availability + "', '" + status + "', '" + price + "', '" + type + "')";//
             
//ring str = "INSERT INTO driver values( '" + name + " ' ,  ' " + age + " ' ,  ' " + gender + " ' , ' " + company + " ' ,  ' " + brand + " ' , ' " + available + " ' , ' " + location + " ' ) " ;
    //String str = "INSERT INTO driver (name, age, gender, company, model, availability, location) VALUES ('" + name + "', '" + age + "', '" + gender + "', '" + company + "', '" + brand + "', '" + available + "', '" + location + "')";
     String str = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+brand+"', '"+available+"','"+location+"')";
                conn.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null ,   "  New  Driver   Added Successfully " ) ;
                setVisible(false);
               
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
            
        }
    
else{
        setVisible(false);
}
    }
    public static void main(String [] args){
        new AddDriver();
    }
}
