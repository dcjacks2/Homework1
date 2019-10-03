import java.io.*;
import java.util.Scanner;

public class Homework1 {
    public static void main (String [] args) throws IOException {
        File text = new File("Banklog.txt");
        Scanner scan = new Scanner(System.in);
        int option;
        float balance = 1000f;
        boolean quit = false;
        FileWriter fwriter = new FileWriter("Banklog.txt", true);
        PrintWriter outfile= new PrintWriter((fwriter));



        while(!quit) {
            int choice = 0;

            System.out.println("1. Display balance summary:  ");
            System.out.println("2. Withdraw money: ");
            System.out.println("3. Deposit money: ");
            System.out.println("Enter 0 to exit: ");

            choice = scan.nextInt();

            switch(choice){
                case 1:

                case 2:

                case 3:

                case 0:
                quit = true;
            }
        }
    }
}
