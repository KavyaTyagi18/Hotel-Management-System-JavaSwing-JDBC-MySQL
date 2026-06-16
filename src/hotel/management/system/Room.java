
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class Room extends JFrame  implements ActionListener {
    JTable table;
    JButton back;
    Room(){
        
         getContentPane().setBackground(Color.WHITE);   
        setLayout(null);
        
        
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eight2.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(500,0,550,550);
                add(l1);
                
                JLabel  l3 = new JLabel ("Room Number");
                l3.setBounds(5,10,100,20);
                add(l3);
                
                JLabel  l2 = new JLabel ("Availability");
                l2.setBounds(110,10,100,20);
                add(l2);
                
                JLabel  l4 = new JLabel ("Status");
                l4.setBounds(210,10,100,20);
                add(l4);
                
                 JLabel  l5 = new JLabel ("Price ");
                l5.setBounds(310,10,100,20);
                add(l5);
                
                 JLabel  l6 = new JLabel ("Bed Type");
                l6.setBounds(410,10,100,20);
                add(l6);
                
                 //JLabel  l4 = new JLabel ("Status");
                //l4.setBounds(210,10,100,20);
                //add(l4);
                
                
                
                
                table = new JTable();
                table.setBounds(0,40,500,400);
                add(table);
                
                
                try{
                  Conn c = new Conn();
                  ResultSet rs  = c.s.executeQuery("select * from room");
                 // table.setModel(DbUtils.resultSetToTableModel(rs);
                 table.setModel(DbUtils.resultSetToTableModel(rs));
					
                }catch(Exception e){
                    e.printStackTrace();
                }
                
                back = new JButton("Back");
                back.setBackground(Color.BLACK);
                back.setForeground(Color.WHITE);
                back.addActionListener(this);
                back.setBounds(200,500,120,30);
                add(back);
                
        
                setBounds(300,200,1050,600);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae) {
      
            setVisible(false);
         new Reception ();
    }
    public static void main(String [] args){
        new Room();
    }
}
