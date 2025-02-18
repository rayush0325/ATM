import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

public class ATM {
    private static int[][] accounts = {
            {1234, 50000},
            {2345, 60000},
            {3456, 70000},
            {4567, 80000},
            {5678, 90000},
            {6789, 1000}
    };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int PIN;
        while(true){
            System.out.println("Enter your PIN");
            PIN = scanner.nextInt();
            if(isValid(PIN)){
                break;
            }
        }
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
    private static boolean isValid(int PIN){
        if(PIN < 1000 || PIN > 9999){
            System.out.println("Enter 4 digit PIN");
            return false;
        }
        if(!isPresent(PIN)){
            System.out.println("PIN incorrect");
            return false;
        }
        return true;
    }
    private static boolean isPresent(int PIN){
        for(int[] account : accounts){
            if(account[0] == PIN){
                return true;
            }
        }
        return false;
    }
    private static void checkBalance(int PIN){
        for(int[] account : accounts){
            if(account[0] == PIN){
                System.out.println("your balance is "+account[1]);
            }
        }
    }
    private static void depositMoney(int PIN){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount");
        int amount = scanner.nextInt();
        for(int[] account : accounts){
            if(account[0] == PIN){
                account[1] += amount;
                System.out.println("Amount deposited successfully");
                return;
            }
        }
        System.out.println("Some error occurred");
    }
    private static void withdrawMoney(int PIN){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount");
        int amount = scanner.nextInt();
        if(amount > 2000){
            System.out.println("Amount > 2000 can't be withdrawn");
            return;
        }
        for(int[] account : accounts){
            if(account[0] == PIN){
                if(account[1] < amount){
                    System.out.println("Insufficient balance");
                    return;
                }
                account[1] -= amount;
                System.out.println("Amount withdrawn successfully");
                return;
            }
        }
        System.out.println("Some error occurred");
    }
}
