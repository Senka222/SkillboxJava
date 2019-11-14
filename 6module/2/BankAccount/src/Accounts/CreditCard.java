package Accounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CreditCard extends PaymentAccount {

    @Override
    public void withdrawMoney(BigDecimal balance) {
    BigDecimal percent = new BigDecimal(String.valueOf(balance.divide(BigDecimal.valueOf(100)))).setScale(2, RoundingMode.HALF_UP);
    if (getBalance().subtract(balance).subtract(percent).compareTo(BigDecimal.valueOf(0)) >= 0) {
        setBalance(getBalance().subtract(balance).subtract(percent).setScale(2, RoundingMode.HALF_UP));
        System.out.println("Вы сняли со счета: " + balance.setScale(2, RoundingMode.HALF_UP) + "\nУ Вас на счету осталось: " + getBalance() + "\nУдержан процент: " + percent);
    }
    else System.out.println("На счету недостаточно средств!");
    }
}
