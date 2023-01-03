import javax.swing.*;
import java.util.*;
class PersonInfo
{
	String name,address,phonenumber;
    PersonInfo(String n,String a,String p)
    {
    	name=n;
    	address=a;
    	phonenumber=p;
    }
    void display()
    {
    	JOptionPane.showMessageDialog(null,"\n Name : "+name+"\n Address : "+address+"\n Phonenumber : "+phonenumber); 
    }
}
class AddressBook
{
	ArrayList persons;

	AddressBook()
	{
		persons=new ArrayList();
	}

	void addPerson()
	{
		String name=JOptionPane.showInputDialog("Enter name:");
		String add=JOptionPane.showInputDialog("Enter Address:");
		String pnum=JOptionPane.showInputDialog("Enter phone:");

		PersonInfo p=new PersonInfo(name,add,pnum);
		persons.add(p);
	}

	void searchperson(String n)
	{
		for(int i=0;i<persons.size();i++)
		{
			PersonInfo p=(PersonInfo)persons.get(i);
			if(n.equals(p.name))
			{
				p.display();
			}
		}
	}

	void deletePerson(String n)
	{
		for(int i=0;i<persons.size();i++)
		{
			PersonInfo p=(PersonInfo) persons.get(i);
			if(n.equals(p.name))
			{
				persons.remove(i);
			}
		}
	}
}
public class Test
{
   public static void main(String[] args){
      AddressBook ab= new AddressBook();
   String input,s;
   int ch;

   while(true)
   {
   	input=JOptionPane.showInputDialog("Enter 1 t add \n Enter 2 to Search\n Enter 3 to delete\n Enter 4 t Exit ");
   	ch=Integer.parseInt(input);

   	switch(ch)
   	{
       case 1:
       		ab.addPerson();
       break;

       case 2:
       		s=JOptionPane.showInputDialog("Enter name to Search:");
       		ab.searchperson(s);
       break;

       case 3:
       		s=JOptionPane.showInputDialog("Enter name to Delete:");
       		ab.deletePerson(s);
       break;

       case 4:
       		System.exit(0);
   	}
   	
   }
}
}
