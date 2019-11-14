package Accounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCard extends PaymentAccount {

    @Override
    public void withdrawMoney(BigDecimal balance) {
    BigDecimal percent = new BigDecimal(String.valueOf(balance.setScale(2, RoundingMode.HALF_UP).divide(BigDecimal.valueOf(100))));
        if (getBalance().subtract(balance).subtract(percent).compareTo(BigDecimal.valueOf(0)) >= 0) {
            setBalance(getBalance().subtract(balance.abs()).subtract(percent));
            System.out.println("Вы сняли со счета: " + balance + "\nУ Вас на счету осталось: " + getBalance() + "\nУдержан процент: " + percent);
        }
        else System.out.println("На счету недостаточно средств!");
    }
}
