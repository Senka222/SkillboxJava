package Accounts;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class PaymentAccount {
    private BigDecimal balance = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);

    public BigDecimal getBalance() {
        return balance;
    }

    protected void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void putMoney(BigDecimal balance) {
        this.balance = this.balance.add(balance);
        System.out.println("Вы занесли на счет: " + balance + "\nУ Вас на счету: " + this.balance);
    }

    public void withdrawMoney(BigDecimal balance) {
        if (this.balance.subtract(balance).compareTo(BigDecimal.valueOf(0)) >= 0) {
            this.balance = this.balance.subtract(balance).setScale(2, RoundingMode.HALF_UP);
            System.out.println("Вы сняли со счета: " + balance + "\nУ Вас на счету осталось: " + this.balance);
        }
        else System.out.println("На счету недостаточно средств!");
    }
}
