import java.io.*;
import java.util.Scanner;

public class Homework1 {
    public static void main (String [] args) throws IOException {
        File bankFile = new File("Banklog.txt");
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        FileWriter fInput = new FileWriter("Banklog.txt", true);
        PrintWriter printFile= new PrintWriter((fInput));
        Scanner fileScan = new Scanner(bankFile);

        float balance = 1000f;
        int choice = 0;
        float withdrawAmt;
        float depositAmt;
        //float newBalance;


        int lineNumber = 1;

        while(!quit) {//Options menu.
            System.out.println("Welcome to CIS-2348 Banking System!");
            System.out.println("Enter your option in a number: ");
            System.out.println("1. Display balance:  ");
            System.out.println("2. Withdraw money: ");
            System.out.println("3. Deposit money: ");
            System.out.println("Enter 0 to exit: ");
            for(int i = 0; i < 1; i++) {//Restricts numbers to 0-3 so people wont be able to enter numbers outside that range

                choice = scan.nextInt();
                if(choice < 0 || choice > 4){
                    System.out.println("Please enter number choice within range of 0-3: ");
                    i = i-1;

                }
            }

            switch(choice){

                //Scan file for content and display through following function.
                //While loop can only be used once in running the program, cannot display
                //file contents more than once.
                case 1: //1st case used to show balance.
                    while(fileScan.hasNextLine()){
                        String line = fileScan.nextLine();
                        System.out.println(lineNumber + ": " + line);
                        lineNumber++;
                    }
                    break;

                case 2://2nd Case used to withdraw money from account.
                    System.out.println("Enter amount of money to withdraw from bank account: ");
                    withdrawAmt = scan.nextInt();
                    if(0 > withdrawAmt || withdrawAmt > balance){
                        System.out.println("Cannot withdraw more than the current balance.");
                    }else{
                    balance = balance - withdrawAmt;
                    printFile.println("Withdrawal of $" + withdrawAmt + ". Current balance: $" + balance);
                    System.out.println(lineNumber + ": Withdrawal of $" + withdrawAmt + ". Current balance: $" + balance);
                    lineNumber++;
                    printFile.flush();
                    }
                    break;

                case 3://3rd Case used to deposit money into account.
                    System.out.println("Enter amount of money to deposit into bank account: ");
                    depositAmt = scan.nextInt();
                    if(depositAmt < 0){
                        System.out.println("Cannot deposit a negative amount.");
                    }else {
                        balance = balance + depositAmt;
                        printFile.println("Deposit of $" + depositAmt + ". Current balance: $" + balance);
                        System.out.println("Deposit of $" + depositAmt + ". Current balance: $" + balance);
                        lineNumber++;
                        printFile.flush();
                    }
                    break;

                case 0://Case 0 exits menu
                quit = true;
            }
        }
        System.out.println("Thanks for using your banking system!");
        printFile.close();
    }
}
