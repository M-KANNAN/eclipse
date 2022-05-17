import java.util.*;
class BaseClass{
    String holderName;
    double depositeAmount;
    byte choice;
    int customerId=1;
    ArrayList<String> nameArray=new ArrayList<String>(); 
    ArrayList<Double> balanceArray=new ArrayList<Double>(); 
    Scanner scanner=new Scanner(System.in);

    protected void flowManager(){
        System.out.println("*********************************************************");
        System.out.println("$$$$$$$$$$$$ WELCOME TO NATIONAL BANK $$$$$$$$$$$$");
        System.out.println("Enter 1 to add customer :"+"\n"+"Enter 2 to check details :"+"\n"+"Enter 3 to Deposite Cash :"+"\n"+"Enter 4 to delete account :"
        +"\n"+"Enter 5 for savings Detail :"+"\n"+"Enter 6 for withdraw :"+"\n"+"Enter 7 to Exit :");
        choice=scanner.nextByte();
        switch(choice){
            case 1 :{
                this.createAccount(nameArray,balanceArray);
                break;
            }
            case 2:{
                this.checkDetails(nameArray,balanceArray,customerId);
                break;
            }
            case 3:{
                this.depositBalance(balanceArray,customerId);
                break;
            }
            case 4:{
            	this.deleteAccount(nameArray,balanceArray);
            	break;
            }
            case 5:{
            	this.savingDetails(nameArray,balanceArray,customerId);
            	break;
            }
            case 6:{
            	this.withdrawBalance(balanceArray,customerId);
            	break;
            }
            case 7 :{
            	break;
            }
            default :{
                System.out.println("Enter a choice from 1 to 7");
            }
        }

    }


    protected void createAccount(ArrayList<String> nameArray,ArrayList<Double> balanceArray){
        System.out.println("Enter the name :");
        holderName=scanner.next();
        nameArray.add(holderName);
        System.out.println("*********************************************************");
        System.out.println("Enter Deposite cash in double value : ");
        depositeAmount=scanner.nextDouble();
        balanceArray.add(depositeAmount);
        System.out.println("*********************************************************");
        System.out.println("Your customer ID is : "+customerId);
        System.out.println("*********************************************************");
        customerId++;
         System.out.println("Enter 1 to add customer"+"\n"+"Enter anything other than 1 to Mainpage");
        choice=scanner.nextByte();
        switch(choice){
            case 1 :{
                this.createAccount(nameArray,balanceArray);
                break;
            }
            default :{
                this.flowManager();
                break;
            }
        }
        
    }
    protected void checkDetails(ArrayList<String> nameArray,ArrayList<Double> balanceArray,int customerId){
        if(nameArray.size() == 0){//check the bank has account or not
            System.out.println("Create a customer there is no customer in bank ");
            this.flowManager();
        }
        else{
            System.out.println("Enter Your customer ID to check Details: ");
            int checkCustomer=scanner.nextInt();
            if(checkCustomer > customerId || nameArray.get(checkCustomer-1) == null){//check for customer Id present or not
                System.out.println("*********************************************************");
                System.out.println("Not such customer Found in ID : "+checkCustomer);
                this.flowManager();
            }
            else{
                System.out.println("*********************************************************");
                System.out.println("Customer Found for ID : "+checkCustomer);
                System.out.println("Customer Name : "+nameArray.get(checkCustomer-1));
                System.out.println("Customer Account Balance : "+balanceArray.get(checkCustomer-1));
                System.out.println("*********************************************************");
                this.flowManager();
            }
        }
    }

   protected void depositBalance(ArrayList<Double> balanceArray,int customerId){
        if(nameArray.size() == 0){//check the bank has account or not
            System.out.println("Create a customer there is no customer in bank ");
            this.flowManager();
        }
        else{
            System.out.println("Enter Your customer ID for Deposite cash : ");
            int checkCustomer=scanner.nextInt();
            if(checkCustomer > customerId || nameArray.get(checkCustomer-1) == null){//check for customer Id present or not
                System.out.println("*********************************************************");
                System.out.println("Not such costumer Found in ID : "+checkCustomer);
                this.flowManager();
            }
            else{
                System.out.println("Enter the deposite cash amount for customer ID : "+checkCustomer);
                depositeAmount=scanner.nextDouble();
                double newBalance=balanceArray.get(checkCustomer-1) + depositeAmount;
                balanceArray.set(checkCustomer-1,newBalance);
                System.out.println("*********************************************************");
                this.flowManager();

            }
        }
       
    }
    protected void deleteAccount(ArrayList<String> nameArray,ArrayList<Double> balanceArray){
    	if(nameArray.size() == 0){//check the bank has account or not
            System.out.println("Create a customer there is no costumer in bank ");
            this.flowManager();
        }
        else{
            System.out.println("Enter Your customer ID for Deletion : ");
            int checkCustomer=scanner.nextInt();
            if(checkCustomer > customerId || nameArray.get(checkCustomer-1) == null){//check for customer Id present or not
                System.out.println("*********************************************************");
                System.out.println("Not such customer Found in ID : "+checkCustomer);
                this.flowManager();
            }
            else{
            	nameArray.set(checkCustomer-1, null);
                balanceArray.set(checkCustomer-1,0.0);
                System.out.println("Customer :"+checkCustomer+" deleted successfully.");
                System.out.println("*********************************************************");
                this.flowManager();

            }
        }
       
    }
    
    protected void savingDetails(ArrayList<String> nameArray,ArrayList<Double> balanceArray,int customerId){
        if(nameArray.size() == 0){//check the bank has account or not
            System.out.println("Create a customer there is no costumer in bank ");
            this.flowManager();
        }
        else{
            System.out.println("Enter Your customer ID to check Details: ");
            int checkCustomer=scanner.nextInt();
            if(checkCustomer > customerId || nameArray.get(checkCustomer-1) == null){//check for customer Id present or not
                System.out.println("*********************************************************");
                System.out.println("Not such customer Found in ID : "+checkCustomer);
                this.flowManager();
            }
            else{
                System.out.println("*********************************************************");
                double rate=10.5;
                System.out.println("Enter nomber of years to check intrest : ");
                double years=scanner.nextByte();
                double principle=balanceArray.get(checkCustomer-1);
                double compoundIntrest = (principle * (Math.pow((1 + rate / 100),years)));
                System.out.println();
                System.out.println("Customer Found for ID : "+checkCustomer);
                System.out.println("Customer Name : "+nameArray.get(checkCustomer-1));
                System.out.println("Customer Account Balance after : "+years+" is"+compoundIntrest);
                System.out.println("*********************************************************");
                this.flowManager();
            }
        }
    }
    protected void withdrawBalance(ArrayList<Double> balanceArray,int customerId) {
    	 if(nameArray.size() == 0){//check the bank has account or not
             System.out.println("Create a customer there is no costomer in bank ");
             this.flowManager();
         }
         else{
             System.out.println("Enter Your customer ID to Withdraw Ammount: ");
             int checkCustomer=scanner.nextInt();
             if(checkCustomer > customerId || nameArray.get(checkCustomer-1) == null){//check for customer Id present or not
                 System.out.println("*********************************************************");
                 System.out.println("Not such customer Found in ID : "+checkCustomer);
                 this.flowManager();
             }
             else{
                 System.out.println("*********************************************************");
                 double fine=10;//fine for amount withdraw above 1000
                 System.out.println("Your balance : "+balanceArray.get(checkCustomer-1));
                 System.out.println("Enter the Withdraw ammount : ");
                 double withdrawAmount=scanner.nextDouble();
                 if(withdrawAmount > balanceArray.get(checkCustomer-1)) {//if withdraw amount > account balance
                	 System.out.println("Withdraw amount is greater than balance");
                	 this.flowManager();
                 }
                 else if(withdrawAmount < 0) {//if withdraw amount is ngative
                	 System.out.println("Withdraw amount can't be negative");
                	 this.flowManager();
                 }
                 else {
                	 if(withdrawAmount > 1000) {//Fine purpose
                		 System.out.println("Your withdraw amount : " +withdrawAmount);
                		 double remainingAmount=balanceArray.get(checkCustomer-1)-withdrawAmount-fine;
                		 balanceArray.set(checkCustomer-1, remainingAmount);
                		 this.flowManager();
                	 }
                	 else {// if no fine
                		 System.out.println("Your withdraw amount : " +withdrawAmount);
                		 double remainingAmount=balanceArray.get(checkCustomer-1)-withdrawAmount;
                		 balanceArray.set(checkCustomer-1, remainingAmount);
                		 this.flowManager();
                	 
                	 }
                 }   
             }
         }
    }
    
    
}
public class BankApplication{
    public static void main(String [] args){
        BaseClass base=new BaseClass();
        base.flowManager();
    }
}