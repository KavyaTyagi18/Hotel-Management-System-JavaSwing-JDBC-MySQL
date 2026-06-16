package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class Department extends JFrame  implements ActionListener {
    JTable table;
    JButton back;
    Department(){
        
         getContentPane().setBackground(Color.WHITE);   
        setLayout(null);
        
      
                JLabel  l3 = new JLabel ("Department ");
                l3.setBounds(130,10,100,20);
                add(l3);
                
                JLabel  l2 = new JLabel ("Budget");
                l2.setBounds(450,10,100,20);
                add(l2);
                
              
                
                 //JLabel  l4 = new JLabel ("Status");
                //l4.setBounds(210,10,100,20);
                //add(l4);
                
                
                
                
                table = new JTable();
                table.setBounds(0,50,700,350);
                add(table);
                
                
                try{
                  Conn c = new Conn();
                  ResultSet rs  = c.s.executeQuery("select * from department");
                 // table.setModel(DbUtils.resultSetToTableModel(rs);
                 table.setModel(DbUtils.resultSetToTableModel(rs));
					
                }catch(Exception e){
                    e.printStackTrace();
                }
                
                back = new JButton("Back");
                back.setBackground(Color.BLACK);
                back.setForeground(Color.WHITE);
                back.addActionListener(this);
                back.setBounds(280,400,120,30);
                add(back);
                
        
                setBounds(400,200,700,480);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae) {
      
            setVisible(false);
         new Reception ();
    }
    public static void main(String [] args){
        new Department();
    }
}
