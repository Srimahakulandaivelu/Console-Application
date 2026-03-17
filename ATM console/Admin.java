import java.util.*;

public class Admin{
    private int adminID;
    private int adminPassword;
    public int adminBalance;
    private int totalTransactions;
    public int minWithdraw = 500;
    public List<User> userData;

    public Admin(int adminID, int password, int balance){
        this.adminID = adminID;
        this.adminPassword = password;
        this.adminBalance = balance;
        this.totalTransactions = 0;
    }

    public Admin(){}

    public boolean verifyAdmin(int id, int password){
        if(this.adminID == id && this.adminPassword == password){
            return true;
        }

        return false;
    }

    public void adminDeposit(int deposit_amount){
        this.adminBalance += deposit_amount;
        this.totalTransactions = this.totalTransactions + 1;
    }

    public void adminWithdraw(int withdraw_amount){
        this.adminBalance -= withdraw_amount;
        this.totalTransactions = this.totalTransactions + 1;
    }

    public int checkAdminBalance(){
        return this.adminBalance;
    }

    public void addUser(User newuser){
        userData.add(newuser);
    }

    public User getUser(int userID){
        for(int i=0;i<userData.size();i++){
            if(userData.get(i).userID == userID) {
                return userData.get(i);
            }
        }
        return null;
    }

    public int checkTotalTransactions(){
        return this.totalTransactions;
    }


}
