class SavingAccount {
static float annualInterestRate; 
private float savingBalance;
public void CMI (float savingBalance)
{
	annualInterestRate = 0.04f; 
	float IR=(savingBalance*annualInterestRate)/12; 
	System.out.println("The Actual Balance of Account Holder is=>"+savingBalance); 
	savingBalance=savingBalance+IR;	 
	System.out.println("The Balance after adding Interest rate is=>"+savingBalance);
}

public static void mIR(float savingBalance)
{
	annualInterestRate = 0.05f; 
	float IR=(savingBalance*annualInterestRate)/12; 
	System.out.println("The Actual Balance of Account Holder is=>" +savingBalance); 
	savingBalance=savingBalance+IR; 
	System.out.println("The Balance after adding Modified Interestrate is=>"+savingBalance);
}
}
public class TestSA 
{
public static void main(String[] args) 
   {
SavingAccount s1 = new SavingAccount();
s1.CMI (2000); 
s1.CMI (3000);
System.out.println("******** ");
SavingAccount.mIR(2000); 
SavingAccount.mIR(3000);
   }
}