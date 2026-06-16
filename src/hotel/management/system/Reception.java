package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Reception extends JFrame implements ActionListener{
    JButton newCustomer,rooms,  department,allemployee,managerinfo,customer,searchroom,update,roomStatus,pickup,checkout,Logout;
    Reception(){
        getContentPane().setBackground(Color.WHITE);   
        setLayout(null);
                                                           
        
          
        newCustomer = new JButton ("New Customer Formed");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);
        
         rooms = new JButton ("Rooms");
        rooms .setBounds(10,70,200,30);
        rooms .setBackground(Color.BLACK);
        rooms .setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms );
        
         department= new JButton ("Department");
        department .setBounds(10,110,200,30);
        department.setBackground(Color.BLACK);
        department .setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department );
        
          allemployee= new JButton ("All Employess");
        allemployee .setBounds(10,150,200,30);
        allemployee.setBackground(Color.BLACK);
        allemployee .setForeground(Color.WHITE);
        allemployee.addActionListener(this);
        // department.addActionListener(this);
        add(allemployee );
        
          customer= new JButton ("Customer Info");
        customer .setBounds(10,190,200,30);
        customer.setBackground(Color.BLACK);
        customer.setForeground(Color.WHITE);
         customer.addActionListener(this);
        add(customer );
        
         managerinfo= new JButton ("Manager Info");
        managerinfo .setBounds(10,230,200,30);
        managerinfo.setBackground(Color.BLACK);
        managerinfo.setForeground(Color.WHITE);
        managerinfo.addActionListener(this);
        add(managerinfo );
        
          checkout= new JButton ("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
       checkout.addActionListener(this);
        add(checkout );
        
          update= new JButton ("Update Status ");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.addActionListener(this);
        update.setForeground(Color.WHITE);
        add(update );
        
          roomStatus= new JButton ("Update Room Status ");
        roomStatus .setBounds(10,350,200,30);
         roomStatus.setBackground(Color.BLACK);
         roomStatus.setForeground(Color.WHITE);
           roomStatus.addActionListener(this);
        add( roomStatus );
        
         pickup= new JButton ("Pickup Service");
        pickup.setBounds(10,390,200,30);
         pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add( pickup );
        
           searchroom= new JButton ("Search Room ");
        searchroom.setBounds(10,430,200,30);
         searchroom.setBackground(Color.BLACK);
        searchroom.setForeground(Color.WHITE);
        searchroom.addActionListener(this);
        add( searchroom );
        
           Logout= new JButton ("Logout");
        Logout.setBounds(10,470,200,30);
         Logout.setBackground(Color.BLACK);
        Logout.setForeground(Color.WHITE);
          Logout.addActionListener(this);
        add( Logout );
        
        
        
          
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(250,30,500,470);
                add(l1);
        
        
        
        
        
        
        setBounds(350,200,800,570);
        setVisible(true);
        
    }
    
   public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == newCustomer) {
            setVisible(false);
            new AddCustomer();
        }else if (ae.getSource() == rooms ){
            setVisible(true);
            new Room();
        }else if (ae.getSource() == department){
             setVisible(true);
            new Department();
        }else if (ae.getSource()==allemployee){
            setVisible(true);
            new EmployeeInfo();
        }else if (ae.getSource()==allemployee){
            setVisible(true);
            new EmployeeInfo();
        }else if(ae.getSource()== managerinfo){
            setVisible(false);
            new ManagerInfo();
        }else if(ae.getSource()== customer){
            setVisible(false);
            new CustomerInfo();
        }else if(ae.getSource()== searchroom){
            setVisible(false);
            new SearchRoom();
        }else if(ae.getSource()== update){
             setVisible(false);
            new UpdateCheck();
        }else if(ae.getSource()== roomStatus){
             setVisible(false);
            new UpdateRoom();
        }else if(ae.getSource()== pickup){
             setVisible(false);
            new Pickup();
        }else if(ae.getSource()== checkout){
           setVisible(false);
            new Checkout();
        }else if(ae.getSource()== Logout){
               setVisible(false);
               System.exit(0);
        }
    }
    
    public static void main(String [] args){
        new Reception();
    }
}