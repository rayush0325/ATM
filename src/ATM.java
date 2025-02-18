import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

public class ATM {
    private int balance = 50000;
    private int PIN = 4567;
    public static void main(String[] args) {
        ATM atm = new ATM();
        Scanner scanner = new Scanner(System.in);
        int PIN;
        while(true){
            System.out.println("Enter your PIN");
            PIN = scanner.nextInt();
            if(atm.isValid(PIN)){
                break;
            }
        }
        atm.menu();
    }
    private void  menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("WELCOME");
        while (true){
            System.out.println(
                    "1. Check Balance\n" +
                    "2. Deposit Money\n" +
                    "3. Withdraw Money\n" +
                    "4. Exit\n"+
                    "choose option [1 ... 4]"
            );
            int option = scanner.nextInt();
            if(option == 4){
                //exit
                System.out.println("Thank you for visiting using our ATM");
                scanner.close();
                break;
            }
            switch (option){
                case 1 : // check balance
                    checkBalance(PIN);
                    break;
                case 2 : // deposit money
                    depositMoney(PIN);
                    break;
                case 3 : // withdraw money
                    withdrawMoney(PIN);
                    break;
            }
        }

    }
    private boolean isValid(int PIN){
        if(PIN < 1000 || PIN > 9999){
            System.out.println("Enter 4 digit PIN");
            return false;
        }
        if(this.PIN == PIN){
            return true;
        }
        System.out.println("incorrect PIN");
        return false;
    }
    private void checkBalance(int PIN){
        System.out.println("your balance is "+this.balance);
    }
    private void depositMoney(int PIN){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount");
        int amount = scanner.nextInt();
        this.balance += amount;
        System.out.println("Amount deposited successfully");
    }
    private void withdrawMoney(int PIN){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount");
        int amount = scanner.nextInt();
        if(amount > 2000){
            System.out.println("Amount > 2000 can't be withdrawn");
            return;
        }
        if(this.balance < amount){
            System.out.println("Insufficient balance");
            return;
        }
        this.balance -= amount;
        System.out.println("Amount withdrawn successfully");
    }
}
