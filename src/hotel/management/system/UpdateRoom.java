package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener  {
    Choice ccustomer;
    JTextField tfroom,tfavailable,tfstatus,tfpaid,tfpending;
    JButton check,update,back;
    UpdateRoom(){
        getContentPane().setBackground(Color.WHITE);   
        setLayout(null);
        
        JLabel text = new JLabel ("Update Room Status");
        text.setFont(new Font ("Tahoma",Font.BOLD,25));
        text.setBounds(30,20,280,30);
        text.setForeground(Color.BLACK);
                add(text);
                
                 
        JLabel lblid = new JLabel ("Customer ID");
        lblid .setBounds(30,80,100,20);
         add(lblid );
                
                ccustomer = new Choice();
                 ccustomer.setBounds(200,80,150,25);
                 add(ccustomer);
                 
                 try{
                     Conn c = new Conn();
                     ResultSet rs = c.s.executeQuery("select * from customer");
                     while(rs.next()){
                         ccustomer.add(rs.getString("number"));
                         
                     }
                 }catch(Exception e){
                     e.printStackTrace();
                 }
                 
                 JLabel lblroom = new JLabel ("Room Number");
        lblroom .setBounds(30,130,100,20);
         add(lblroom );
         
         tfroom = new JTextField();
         tfroom.setBounds(200,130,150,25);
         add(tfroom);
         
          JLabel lblname = new JLabel ("Availability");
         lblname .setBounds(30,180,100,20);
         add( lblname);
         
         tfavailable = new JTextField();
     tfavailable.setBounds(200,180,150,25);
         add( tfavailable);
         
          
          JLabel lblcheckin = new JLabel ("Cleaning Status");
          lblcheckin .setBounds(30,230,100,20);
         add( lblcheckin);
         
         tfstatus = new JTextField();
       tfstatus.setBounds(200,230,150,25);
         add(tfstatus);
         
          
         
         check = new JButton("Check");
                check.setBackground(Color.BLACK);
                check.setForeground(Color.WHITE);
                check.addActionListener(this);
                check.setBounds(30,300,100,30);
                add(check);
                
                update = new JButton("Update");
                update .setBackground(Color.BLACK);
                update .setForeground(Color.WHITE);
                update.addActionListener(this);
                update .setBounds(150,300,100,30);
                add(update );
                
                
                  back = new JButton("Back");
                back.setBackground(Color.BLACK);
                back.setForeground(Color.WHITE);
                back.addActionListener(this);
                back.setBounds(270,300,100,30);
                add(back);
                
                
                         
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/bed2.jpg"));
                JLabel l1 = new JLabel(i1);
                l1.setBounds(430,60,430,300);
                add(l1);
                 
        
        
          setBounds(300,200,980,500);
        setVisible(true);
        
    }
    
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == check){
          String id = ccustomer.getSelectedItem();
           String query = "select * from customer where number = '"+id+"'";
           try{
               Conn c = new Conn();
               ResultSet rs = c.s.executeQuery(query);
               while(rs.next()){
                   tfroom.setText(rs.getString("room"));
                     //tfname.setText(rs.getString("name"));
                     //tfcheckin.setText(rs.getString("checkintime"));
                     //tfpaid.setText(rs.getString("deposit"));
                   
                   
               }
               ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber= '"+tfroom.getText()+"'");
               while (rs2.next()){
                   tfavailable.setText(rs2.getString("availability"));
                    tfstatus.setText(rs2.getString("cleaning_status"));
                   
               }
           }catch(Exception e){
               e.printStackTrace();
           }
        }else if (ae.getSource() == update){
            String number = ccustomer.getSelectedItem();
            String room = tfroom.getText();
            String available = tfavailable.getText();
            String status = tfstatus.getText();
           // String deposit = tfpaid.getText();
            
            try{
              Conn c = new Conn();
              c.s.executeUpdate("update room set availability = '"+available+"',cleaning_status= '"+status+"' where roomnumber= '"+room+"'");
              JOptionPane.showMessageDialog(null, "Data Updated Successfully");
              setVisible(false);
              new Reception();
            }catch (Exception e){
                
            }
        }else{
            // JOptionPane.showMessageDialog(null, "Data Updated Siccessfully");
              setVisible(false);
              new Reception();
            
        }
                         
            
    }           
       
    
    
    public static void main(String []args){
        new UpdateRoom();
    }
    
}