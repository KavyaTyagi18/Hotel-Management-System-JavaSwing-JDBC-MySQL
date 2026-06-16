
package hotel.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.*;

public class AddRooms extends JFrame implements ActionListener {
    JButton add,cancel;
    JTextField tfroom,tfprice;
    JComboBox typecombo,cleancombo,availablecombo;
    AddRooms(){
       
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel ("Add Rooms");
        heading .setFont(new Font ("tahoma",Font.BOLD,18));
        
        heading.setBounds(150,20,220,30);
        add(heading);
        
        JLabel lblroomno = new JLabel("Room Number");
        lblroomno.setFont(new Font("tahoma",Font.PLAIN,16));
        lblroomno.setBounds(60,80,120,30);
        add (lblroomno);
        
    tfroom = new JTextField ();
        tfroom.setBounds(200,80,180,30);
        add(tfroom);
        
        JLabel lblavailable = new JLabel("Available");
        lblavailable .setFont(new Font("tahoma",Font.PLAIN,16));
        lblavailable .setBounds(60,130,120,30);
        add (lblavailable );
        
       /* JTextField tfavailable = new JTextField ();
        tfavailable.setBounds(200,130,180,30);
        add(tfavailable);*/
       
       String availableOptions [] = { "Available" , "Occupied"};
        availablecombo =  new JComboBox(availableOptions);
       availablecombo.setBounds(200,130,180,30);
       availablecombo.setBackground(Color.white);
       add(availablecombo);
       
       JLabel lblclean = new JLabel("Clean");
        lblclean .setFont(new Font("tahoma",Font.PLAIN,16));
        lblclean.setBounds(60,180,120,30);
        add (lblclean );
        
        String cleanOptions [] = { "Cleaned" , "Dirty"};
     cleancombo =  new JComboBox(cleanOptions);
       cleancombo.setBounds(200,180,180,30);
       cleancombo.setBackground(Color.white);
       add(cleancombo);
       
       
       
       JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("tahoma",Font.PLAIN,16));
        lblprice.setBounds(60,230,120,30);
        add (lblprice);
        
         tfprice = new JTextField ();
        tfprice.setBounds(200,230,180,30);
        add(tfprice);
        
        JLabel lbltype = new JLabel("Bed Type");
        lbltype .setFont(new Font("tahoma",Font.PLAIN,16));
        lbltype .setBounds(60,280,180,30);
        add (lbltype );
        
        String typeOptions [] = { "Single Bed " , "Double Bed "};
     typecombo =  new JComboBox(typeOptions);
       typecombo.setBounds(200,280,180,30);
       typecombo.setBackground(Color.white);
       add(typecombo);
       
       
      add = new JButton ("Add Room");
       add.setForeground(Color.white);
       add.setBackground(Color.black);
       add.setBounds(60,350,130,30);
       add.addActionListener (this);
       add(add);
       
    cancel = new JButton ("Cancel");
       cancel.setForeground(Color.white);
       cancel.setBackground(Color.black);
       cancel.setBounds(220,350,130,30);
       cancel.addActionListener (this);
       add(cancel);
       
       /*ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/room2.jpg"));
            
            Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2); 
            
            JLabel image = new JLabel(i3);
            image.setBounds(300,30,600,600);
            add(image);*/
       
       ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/room2.jpg"));
        JLabel image = new JLabel (i1);
        image.setBounds(420,5,500,450);
        add(image);
       
       setBounds(310,180,980,500);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource()== add ){
           //tring roomnumber = tfprice.getText();
           String roomnumber = tfroom.getText();  // CORRECT

            String availability =(String) availablecombo.getSelectedItem();
            String status  =(String) cleancombo.getSelectedItem();
          String price = tfprice.getText();
          String type =  (String)typecombo.getSelectedItem();
          
          try{
//String str = "INSERT INTO room values( '"+room+"', '"+available+"', '"+status+"','"+price+"', '"+type+"')";
             Conn conn = new Conn();
             String str = "INSERT INTO room VALUES ('" + roomnumber + "', '" + availability + "', '" + status + "', '" + price + "', '" + type + "')";

                conn.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null ,   "  New  Room  Successfully  Added " ) ;
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
        new AddRooms();
    }
}
