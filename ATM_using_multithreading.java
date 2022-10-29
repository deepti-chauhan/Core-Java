package MultiThreading;

//shared class
class myATM {

    private int amount = 10000;

     synchronized void checkBalance(String name){
        System.out.println(name + " is checking the balance." );
        try{
            Thread.sleep(1000);
        }
        catch (Exception e){}

        System.out.println("balance checked !!");
    }

    synchronized void withDraw(int amt){
        System.out.println("amount withdrawn : "+ amt);
        try{
            Thread.sleep(1000);
        }
        catch (Exception e){}

        amount = amount - amt;
        System.out.println("amount left in the bank : " + amount);
    }
}

//Thread customer class
class customer extends Thread{
    private String name;
    private int amt;
    myATM atm;  //reference of atm class

    customer(String name, myATM atm, int amt){
        this.name = name;
        this.amt = amt;
        this.atm = atm;
    }

    public void useAtm(){
        atm.checkBalance(name);
        atm.withDraw(amt);
    }

    public void run(){
       useAtm();
    }
}


public class ATM {
    public static void main(String[] args){
        myATM A = new myATM();
        customer c1 = new customer("deepti", A, 1000);
        customer c2 = new customer("disha", A, 2000);

        c2.start();
        c1.start();
    }
}
