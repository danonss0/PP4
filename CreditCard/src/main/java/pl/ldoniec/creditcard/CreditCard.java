package pl.ldoniec.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal creditLimit;
    private BigDecimal balance;



    public void assignCredit(BigDecimal creditLimit) {
        if(isCreditAlreadyAssigned()){
            throw new CreditAlreadyAssignedException();
        }

        if(isCreditBelowThreshold(creditLimit)){
            throw new CreditCardBelowThresholdException();
        }

        this.creditLimit = creditLimit;
        this.balance = creditLimit;



    }

    private boolean isCreditAlreadyAssigned() {
        return this.creditLimit != null;
    }

    private static boolean isCreditBelowThreshold(BigDecimal creditLimit) {
        return BigDecimal.valueOf(100).compareTo(creditLimit) > 0;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void pay(BigDecimal money) {
        if(!canAfford(money)){
            throw new NotEnoughMoneyException();
        }
        this.balance = this.balance.subtract(money);
    }

    public boolean canAfford(BigDecimal money){
        return this.balance.subtract(money).compareTo(BigDecimal.ZERO) >0;
    }
}
