import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.net.*;
class Myframe extends JFrame implements ActionListener
  {
    JLabel l1,l2;
    JTextField t1,t2;
    JButton submit;
    JLabel msg;
    Statement stm; 
    Connection con;

    Myframe()
    {
      setTitle("RegistrationFrom");
      setSize(400,400);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      Container c=getContentPane();
      c.setLayout(null);
      c.setBackground(Color.yellow); 
          

      l1=new JLabel("Email");
      l1.setBounds(20,50,100,20);
      c.add(l1);

      t1=new JTextField();
      t1.setBounds(130,50,100,20);
      c.add(t1);

      l2=new JLabel("Password");
      l2.setBounds(20,100,100,20);
      c.add(l2);

      t2=new JTextField();
      t2.setBounds(130,100,100,20);
      c.add(t2);

      submit=new JButton("Submit");
      submit.setBounds(150,150,80,20);
      c.add(submit);
      submit.addActionListener(this);

      msg=new JLabel("");
      msg.setBounds(130,400,250,20);
      c.add(msg);

      setVisible(true);
      addWindowListener(new WindowAdapter()
      {
        public void windowClosing(WindowEvent w)
        {
           System.exit(0);
        }
           });
    try   
       {
                Class.forName("com.mysql.cj.jdbc.Driver");  
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info1","root","");
                stm=con.createStatement();
                System.out.print("Connected");
            }
    catch(Exception e)
     {  
      System.out.println("Database driver not found..."+e);  
     }
    }
    public void actionPerformed(ActionEvent e){
      
     if(e.getSource()==submit) 
              {
               try
                      {
                     String Email=t1.getText();
                     String Pass=t2.getText();
                  ResultSet rs=stm.executeQuery("SELECT * FROM stdin WHERE Email = '"+t1.getText()+"' AND Pass ='"+t2.getText()+"'");  
                  while(rs.next())
                    {   
                        JOptionPane.showMessageDialog(null," Welcome Back");                    } 
                      }
                    catch(Exception r)
                      {
                      JOptionPane.showMessageDialog(null," Please Check"); 
                       }
                  }  
  }
    
  }

  class Login
    {
      public static void main(String args[])
      {
        Myframe frame=new Myframe();
    }
  }
