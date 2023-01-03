import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Info extends JFrame implements ActionListener {

  private JLabel lblEnrollNo, lblName, lblAge;
  private JTextField txtEnrollNo, txtName, txtAge;
  private JButton btnAdd, btnRetrieve, btnUpdate, btnDelete,btnClear;

  private Connection con;
  private Statement stmt;
  private ResultSet rs;

  public Info() {
    setTitle("Student Information");
    setLayout(new FlowLayout());
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c=getContentPane();
      c.setLayout(null);
      

    lblEnrollNo = new JLabel("Roll no:");
    lblEnrollNo.setBounds(20,50,100,20);
    add(lblEnrollNo);
    txtEnrollNo = new JTextField();
    txtEnrollNo.setBounds(130,50,100,20);
    add(txtEnrollNo);

    lblName = new JLabel("Name:");
    lblName.setBounds(20,100,100,20);
    add(lblName);
    txtName = new JTextField();
    txtName.setBounds(130,100,100,20);
    add(txtName);

    lblAge = new JLabel("Age:");
    lblAge.setBounds(20,150,100,20);
    add(lblAge);
    txtAge = new JTextField();
    txtAge.setBounds(130,140,100,20);
    add(txtAge);

    btnAdd = new JButton("Add");
    btnAdd.setBounds(40,200,70,20);
    btnAdd.addActionListener(this);
    add(btnAdd);

    btnRetrieve = new JButton("Retrieve");
     btnRetrieve.setBounds(120,200,70,20);
    btnRetrieve.addActionListener(this);
    add(btnRetrieve);

    btnUpdate = new JButton("Update");
    btnUpdate.setBounds(200,200,70,20);
    btnUpdate.addActionListener(this);
    add(btnUpdate);

    btnDelete = new JButton("Delete");
    btnDelete.setBounds(280,200,70,20);
    btnDelete.addActionListener(this);
    add(btnDelete);

    btnClear = new JButton("Clear");
    btnClear.setBounds(150,250,70,20);
    btnClear.addActionListener(this);
    add(btnClear);


    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost/students", "root", "");
      stmt = con.createStatement();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnAdd) {
          try {
                String sql = "INSERT INTO students (enroll_no, name, age) VALUES ('" + txtEnrollNo.getText() + "', '" + txtName.getText() + "', '" + txtAge.getText() + "')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Record added successfully!");
              } 
          catch (Exception ex)
              {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding record!");
              }
             } else if (e.getSource() == btnRetrieve) {


          try {
                String sql = "SELECT * FROM students WHERE enroll_no = '" + txtEnrollNo.getText() + "'";
                rs = stmt.executeQuery(sql);
                  if (rs.next()) {
                          txtName.setText(rs.getString("name"));
                          txtAge.setText(rs.getString("age"));
                  } else 
                  {
                     JOptionPane.showMessageDialog(this, "Record not found!");
                  }
             }  
             catch (Exception ex) 
             {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error retrieving record!");
              }
              } else if (e.getSource() == btnUpdate) {

              try {
String sql = "UPDATE students SET name = '" + txtName.getText() + "', age = '" + txtAge.getText() + "' WHERE enroll_no = '" + txtEnrollNo.getText() + "'";
stmt.executeUpdate(sql);
JOptionPane.showMessageDialog(this, "Record updated successfully!");
} catch (Exception ex) {
ex.printStackTrace();
JOptionPane.showMessageDialog(this, "Error updating record!");
}
} else if (e.getSource() == btnDelete) {

try {
String sql = "DELETE FROM students WHERE enroll_no = '" + txtEnrollNo.getText() + "'";
stmt.executeUpdate(sql);
JOptionPane.showMessageDialog(this, "Record deleted successfully!");
} catch (Exception ex) {
ex.printStackTrace();
JOptionPane.showMessageDialog(this, "Error deleting record!");
}
}
}

public static void main(String[] args) {
new Info().setVisible(true);
}
}
