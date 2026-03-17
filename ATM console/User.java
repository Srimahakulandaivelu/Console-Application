import java.util.*;
import java.time.LocalDateTime;

public class User extends Admin{
    public int userID;
    public int password;
    public int balance;
    public List<Transaction> transactions;

    public User(int userID, int password, int balance){
        this.userID = userID;
        this.password = password;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public User(){}

    public boolean validateUser(int userID, int password){
            User user = getUser(userID);

            if(user != null && user.password == password){
                return true;
            }

            return false;
    }

    public void deposit(int deposit_amount){
        if(deposit_amount % 100 == 0 || deposit_amount % 200 == 0 || deposit_amount % 500 == 0){
            this.balance += deposit_amount;
            adminBalance += deposit_amount;

            transactions.add(new Transaction(LocalDateTime.now(), TransactionType.deposit, deposit_amount));

            System.out.println("Amount deposited Successfully");
        }

        else {
            System.out.println("Invalid Amount");
        }
    }

    public void withdraw(int userID, int withdraw_amount){
        User user = getUser(userID);
        if(minWithdraw <= adminBalance && withdraw_amount >= minWithdraw && withdraw_amount <= user.balance && (withdraw_amount % 100 == 0 || withdraw_amount % 200 == 0 || withdraw_amount % 500 == 0)){
            user.balance -= withdraw_amount;
            adminBalance -= withdraw_amount;

            transactions.add(new Transaction(LocalDateTime.now(), TransactionType.withdraw, withdraw_deposit));

            System.out.println("Transaction successfully");
        }  
        else {
            System.out.println("Transaction failed");
        }
    }

    public int balanceInquiry(int userID){
        User user = getUser(userID);

        return user.balance;
    }

    public void getMiniTranscationHistory(){
        int n = transactions.size();

        for(int i=n-5;i<n;i++){
            System.out.println(transactions.get(i));
        }
    }
}
