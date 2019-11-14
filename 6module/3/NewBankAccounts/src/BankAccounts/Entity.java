package BankAccounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Entity extends Client {
    @Override
    public void withdrawMoney(BigDecimal balance) {
        BigDecimal percent = new BigDecimal(String.valueOf(balance.multiply(BigDecimal.valueOf(0.01))));
        if (getBalance().subtract(balance).subtract(percent).compareTo(BigDecimal.valueOf(0)) >= 0) {
            setBalance(getBalance().subtract(balance).subtract(percent).setScale(2, RoundingMode.HALF_UP));
            System.out.println("Вы сняли со счета: " + balance.setScale(2, RoundingMode.HALF_UP) + "\nУ Вас на счету осталось: " + getBalance() + "\nУдержан процент: " + percent);
        }
        else System.out.println("На счету недостаточно средств!");
    }
}
