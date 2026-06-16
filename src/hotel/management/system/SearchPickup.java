package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class SearchPickup extends JFrame  implements ActionListener {
    JTable table;
    JButton back,submit;
    Choice typeofcar;
    JCheckBox available;
    SearchPickup (){
        
         getContentPane().setBackground(Color.WHITE);   
        setLayout(null);
        
        
                JLabel text = new JLabel ("Pickup Service");
                text.setFont(new Font ("Tahoma",Font.PLAIN,20));
                text.setBounds(400,30,200,30);
                add(text);
                
                JLabel lblCarType = new JLabel ("Type of car");
                lblCarType.setBounds(50,100,100,50);
                add(lblCarType);
                
                typeofcar = new Choice();
                typeofcar.setBounds( 150, 100, 200, 25);
                add(typeofcar);
                
                try{
                       Conn c= new Conn();
                       ResultSet rs = c.s.executeQuery("select * from driver");
                       while (rs.next()) {
                           typeofcar.add(rs.getString("brand"));
                       }
                } catch (Exception e){
                        e.printStackTrace();
                       }
                
             
                
                JLabel  l3 = new JLabel ("Room Number");
                l3.setBounds(50,160,100,20);
                add(l3);
                
                JLabel  l2 = new JLabel ("Availability");
                l2.setBounds(270,160,100,20);
                add(l2);
                
                JLabel  l4 = new JLabel ("Cleaning Status");
                l4.setBounds(450,160,100,20);
                add(l4);
                
                 JLabel  l5 = new JLabel ("Price ");
                l5.setBounds(670,160,100,20);
                add(l5);
                
                 JLabel  l6 = new JLabel ("Bed Type");
                l6.setBounds(870,160,100,20);
                add(l6);
                
                 //JLabel  l4 = new JLabel ("Status");
                //l4.setBounds(210,10,100,20);
                //add(l4);
                
                
                
                
                table = new JTable();
                table.setBounds(0,200,1000,300);
                add(table);
                
                
                try{
                  Conn c = new Conn();
                  ResultSet rs  = c.s.executeQuery("select * from driver");
                 // table.setModel(DbUtils.resultSetToTableModel(rs);
                 table.setModel(DbUtils.resultSetToTableModel(rs));
					
                }catch(Exception e){
                    e.printStackTrace();
                }
                 submit = new JButton("Submit");
                submit .setBackground(Color.BLACK);
                submit .setForeground(Color.WHITE);
                submit .addActionListener(this);
                submit .setBounds(300,520,120,30);
                add(submit );
                
                
                back = new JButton("Back");
                back.setBackground(Color.BLACK);
                back.setForeground(Color.WHITE);
                back.addActionListener(this);
                back.setBounds(500,520,120,30);
                add(back);
                
        
                setBounds(300,200,1050,600);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
            try{
                //String query1 = "select*from room where bed type = '"+bedType.getSelectedItem()+"'";
                //String query2 = "select*from Room where availability='Available'AND bed_type='"+bedType.getSelectedItem()+"'";
                
                /*---String query1 = "select * from room where bed_type = '" + bedType.getSelectedItem() + "'";
String query2 = "select * from room where availability='Available' AND bed_type='" + bedType.getSelectedItem() + "'";--- */
                
//String query1 = "select * from room where bed_type = '" + bedType.getSelectedItem() + "'";
        //String query2 = "select * from room where availability = 'Available' AND bed_type = '" + bedType.getSelectedItem() + "'";
         String bed = typeofcar.getSelectedItem().toString();
String query1, query2;

if (bed.equals("All")) {
    query1 = "SELECT * FROM room";
    query2 = "SELECT * FROM room WHERE availability = 'Available'";
} else {
    query1 = "SELECT * FROM room WHERE bed_type = '" + bed + "'";
    query2 = "SELECT * FROM room WHERE availability = 'Available' AND bed_type = '" + bed + "'";
}
        
        
        
        
                Conn conn = new Conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs = conn.s.executeQuery(query2);
                    
                }else{
                    rs = conn.s.executeQuery(query1 );
                    
                    
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
      
            setVisible(false);
         new Reception ();
        }
    }
    public static void main(String [] args){
        new SearchPickup ();
    }
}
