import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.net.*;
class Myframe extends JFrame implements ActionListener
	{
		JLabel l1,l2,l3,l4,l5,l0,l6,l7;
		JTextField t1,t2,t3,t4;
		JRadioButton male,female;
		JComboBox day,month,year;
		JTextArea ta1,tx1;
		JCheckBox terms;
		JButton submit;
		JLabel msg;
 Statement stm; 
    Connection con;

		Myframe()
		{
			setTitle("RegistrationFrom");
			setSize(400,500);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			Container c=getContentPane();
			c.setLayout(null);
			c.setBackground(Color.pink); 
					

			l0=new JLabel("Student Information");	
			l0.setBounds(150,10,100,10);
			c.add(l0);

			l1=new JLabel("Name");
			l1.setBounds(20,50,100,20);
			c.add(l1);

			t1=new JTextField();
			t1.setBounds(130,50,100,20);
			c.add(t1);

			l2=new JLabel("Mobile");
			l2.setBounds(20,100,100,20);
			c.add(l2);

			t2=new JTextField();
			t2.setBounds(130,100,100,20);
			c.add(t2);

			l3=new JLabel("Gender");
			l3.setBounds(20,150,100,20);
			c.add(l3);

			male=new JRadioButton("Male");
			female=new JRadioButton("Female");
			male.setBounds(130,150,80,20);
			female.setBounds(220,150,80,20);
			male.setSelected(true);
			c.add(male);
			c.add(female);

			ButtonGroup gen=new ButtonGroup();
			gen.add(male);
			gen.add(female);

			l4=new JLabel("DOB");
			l4.setBounds(20,200,100,20);
			c.add(l4);

			String days[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
			String months[]={"Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sep","Oct","Nov","Dec"};
			String years[]={"2021","2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997"};
			day=new JComboBox(days);
			month=new JComboBox(months);
			year=new JComboBox(years);

			day.setBounds(130,200,50,20);
			month.setBounds(190,200,50,20);
			year.setBounds(250,200,50,20);
			
			c.add(day);
			c.add(month);
			c.add(year);

			l5=new JLabel("Address");
			l5.setBounds(20,250,100,20);
			c.add(l5);
			
			ta1=new JTextArea();
			ta1.setBounds(130,240,200,50);
			c.add(ta1);


			l6=new JLabel("Email");
			l6.setBounds(20,300,100,20);
			c.add(l6);

			t3=new JTextField();
			t3.setBounds(130,300,100,20);
			c.add(t3);

			l7=new JLabel("Password");
			l7.setBounds(20,350,100,20);
			c.add(l7);

			t4=new JTextField();
			t4.setBounds(130,350,100,20);
			c.add(t4);

			submit=new JButton("Submit");
			submit.setBounds(150,400,80,20);
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
		try    // for database connection
		   {
                Class.forName("com.mysql.cj.jdbc.Driver");  // for mysql
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info1","root","");// for mysql
                stm=con.createStatement();
                System.out.print("Connected");
            }
		catch(Exception e)
		 {  
		 	System.out.println("Database driver not found..."+e);  
		 }
		}
		public void actionPerformed(ActionEvent e){
			
			if(e.getSource()==submit)    // To Save Record
		          {
		           try
		                 {  
		                   String gender="male";  
                       if(female.isSelected())
				                          {
					                             gender="female";
				                          }
				                 String dob=day.getSelectedItem()+"-"+month.getSelectedItem()+"-"+year.getSelectedItem();	
				                 String address=ta1.getText();
				                 String Email=t3.getText();
				                 String Pass=t4.getText();
		                     String msg="Insert into stdin(name,mob,gen,bod,address,Email,Pass) Values(' "+t1.getText()+" ','"+t2.getText()+"','"+gender+"','"+dob+"','"+ta1.getText()+"','"+Email+"','"+Pass+"')";
		                     stm.executeUpdate(msg);
                             JOptionPane.showMessageDialog(null," Data Saved Successfully");
		                 }	 
		              
		            catch(Exception r)
		              {
		              	System.out.println("Error in saving:"+r);
		              }
		          }  
	}
		
	}

  class RegistrationFrom
    {
      public static void main(String args[])
  		{
  			Myframe frame=new Myframe();
 		}
 	}