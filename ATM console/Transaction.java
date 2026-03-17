import java.time.LocalDateTime;

public class Transaction{
    LocalDateTime dateTime;

    enum TransactionType{
        deposit,
        withdraw
    };

    int amount;
}


public Transaction(LocalDateTime dateTime, TransactionType type, int amount){
    this.dateTime = dateTime; 
    this.type = type;
    this.amount = amount;
}

