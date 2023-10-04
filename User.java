import java.util.Scanner;

class BankAccount {

    String accountHolderName; // Changed from "name" to "accountHolderName"
    String username; // Changed from "userName" to "username"
    String password;
    String accountNumber; // Changed from "accountNo" to "accountNumber"
    float accountBalance = 100000f; // Changed from "balance" to "accountBalance"
    int transactionCount = 0; // Changed from "transactions" to "transactionCount"
    String transactionHistory = "";

    // BankAccount(String accountHolderName, String username, String password, String accountNumber) {
    // this.accountHolderName = accountHolderName;
    // this.username = username;
    // this.password = password;
    // this.accountNumber = accountNumber;
    // }

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Your Name - ");
        this.accountHolderName = sc.nextLine();
        System.out.print("\nEnter Your Username - ");
        this.username = sc.nextLine();
        System.out.print("\nEnter Your Password - ");
        this.password = sc.nextLine();
        System.out.print("\nEnter Your Account Number - ");
        this.accountNumber = sc.nextLine();
        System.out.println("\nRegistration completed..kindly login");
    }

    public boolean login() {
        boolean isLoggedIn = false; // Changed from "isLogin" to "isLoggedIn"
        Scanner sc = new Scanner(System.in);
        while (!isLoggedIn) {
            System.out.print("\nEnter Your Username - ");
            String enteredUsername = sc.nextLine();
            if (enteredUsername.equals(username)) {
                while (!isLoggedIn) {
                    System.out.print("\nEnter Your Password - ");
                    String enteredPassword = sc.nextLine();
                    if (enteredPassword.equals(password)) {
                        System.out.print("\nLogin successful!!");
                        isLoggedIn = true;
                    } else {
                        System.out.println("\nIncorrect Password");
                    }
                }
            } else {
                System.out.println("\nUsername not found");
            }
        }
        return isLoggedIn;
    }

    public void withdraw() {
        System.out.print("\nEnter amount to withdraw - ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if (accountBalance >= amount) {
                transactionCount++;
                accountBalance -= amount;
                System.out.println("\nWithdraw Successfully");
                String str = amount + " Rs Withdrawn\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nInsufficient Balance");
            }
        } catch (Exception e) {
        }
    }

    public void deposit() {
        System.out.print("\nEnter amount to deposit - ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if (amount <= 100000f) {
                transactionCount++;
                accountBalance += amount;
                System.out.println("\nSuccessfully Deposited");
                String str = amount + " Rs deposited\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("\nSorry...Limit is 100000.00");
            }
        } catch (Exception e) {
        }
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Recipient's Name - ");
        String recipient = sc.nextLine();
        System.out.print("\nEnter amount to transfer - ");
        float amount = sc.nextFloat();
        try {
            if (accountBalance >= amount) {
                if (amount <= 50000f) {
                    transactionCount++;
                    accountBalance -= amount;
                    System.out.println("\nSuccessfully Transferred to " + recipient);
                    String str = amount + " Rs transferred to " + recipient + "\n";
                    transactionHistory = transactionHistory.concat(str);
                } else {
                    System.out.println("\nSorry...Limit is 50000.00");
                }
            } else {
                System.out.println("\nInsufficient Balance");
            }
        } catch (Exception e) {
        }
    }

    public void checkBalance() {
        System.out.println("\n" + accountBalance + " Rs");
    }

    public void transactionHistory() {
        if (transactionCount == 0) {
            System.out.println("\nEmpty");
        } else {
            System.out.println("\n" + transactionHistory);
        }
    }
}

