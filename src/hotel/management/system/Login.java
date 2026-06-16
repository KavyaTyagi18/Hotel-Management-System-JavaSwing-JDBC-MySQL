package hotel.management.system;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.sql.*;



public class Login extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton login,cancel;
    Login(){
        getContentPane().setBackground(Color.WHITE);
       setLayout(null);
        
       JLabel user = new JLabel("Username");
        user.setBounds(40,30,110,30);
         user.setFont(new Font ("default",Font.BOLD,14));
        add(user);
        
        username = new JTextField();
        username.setBounds(160,30,160,30);
        add(username);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(40,85,110,30);
         pass.setFont(new Font ("default",Font.BOLD,14));
        add(pass);
                           
             password = new JPasswordField();
            password.setBounds(160,85,160,30);
         
            add(password);
            
             login = new JButton("Login");
            login.setBounds(40,160,120,40);
            login.setBackground(Color.black);
            login.setForeground(Color.white);
           login.setFont(new Font ("dialog",Font.BOLD,13));
           login.addActionListener(this);
            add(login);
            
              cancel = new JButton(" Cancel");
             cancel.setBounds(205,160,120,40);
             cancel.setBackground(Color.BLACK);
             cancel.setForeground(Color.white);
             cancel.setFont(new Font ("dialog",Font.BOLD,13));
            cancel.addActionListener(this);
            add(cancel);
            
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/images3.jpg"));
            
            Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2); 
            
            JLabel image = new JLabel(i3);
            image.setBounds(350,10,200,200);
            add(image);
        
        setBounds(500,200,600,300);
        setVisible(true);
        
    }
   @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == login ){
           //String user = username.getText();
           //String pass = password.getText();
           String user = username.getText().trim();
        String pass = new String(password.getPassword()).trim(); 
           
           try{
              Conn c =  new Conn();
              
             String query = "select * from login where username = '"+ user+ "' AND password = '" +pass+ "'";

              ResultSet rs = c.s.executeQuery(query);
              
              if(rs.next()){
                 setVisible(false);
                 new Dashboard();
              }else{
                  JOptionPane.showMessageDialog(null, "Invalid username or password");
                  setVisible(false);
              }
               
           }catch(Exception e){
               e.printStackTrace();
           }
            
        }else if(ae.getSource() == cancel ){
             setVisible(false);
        }
        
     }
    public static void main(String [] args){
        new   Login();
    
} 
}
