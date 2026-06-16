package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class CustomerInfo extends JFrame  implements ActionListener {
    JTable table;
    JButton back;
     CustomerInfo(){
        
         getContentPane().setBackground(Color.WHITE);   
        setLayout(null);
        
                
                JLabel  l3 = new JLabel ("Document Type");
                l3.setBounds(10,10,100,20);
                add(l3);
                
                JLabel  l2 = new JLabel ("Number");
                l2.setBounds(160,10,100,20);
                add(l2);
                
                JLabel  l4 = new JLabel ("Name");
                l4.setBounds(290,10,100,20);
                add(l4);
                
                 JLabel  l5 = new JLabel ("Gender ");
                l5.setBounds(410,10,100,20);
                add(l5);
                
                 JLabel  l6 = new JLabel ("Country");
                l6.setBounds(540,10,100,20);
                add(l6);
                
                 JLabel  l7 = new JLabel ("Room Number");
                l7.setBounds(640,10,100,20);
                add(l7);
                
                 JLabel  l8 = new JLabel ("Checkin Time");
                l8.setBounds(760,10,100,20);
                add(l8);
                
                 JLabel  l9 = new JLabel ("Deposit");
                l9.setBounds(910,10,100,20);
                add(l9);
                
                
                
                
                table = new JTable();
                table.setBounds(0,40,1000,400);
                add(table);
                
                
                try{
                  Conn c = new Conn();
                  ResultSet rs  = c.s.executeQuery("select * from customer");
                 // table.setModel(DbUtils.resultSetToTableModel(rs);
                 table.setModel(DbUtils.resultSetToTableModel(rs));
					
                }catch(Exception e){
                    e.printStackTrace();
                }
                
                back = new JButton("Back");
                back.setBackground(Color.BLACK);
                back.setForeground(Color.WHITE);
                back.addActionListener(this);
                back.setBounds(450,500,120,30);
                add(back);
                
        
                setBounds(300,200,1000,600);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae) {
      
            setVisible(false);
         new Reception ();
    }
    public static void main(String [] args){
        new  CustomerInfo();
    }
}
