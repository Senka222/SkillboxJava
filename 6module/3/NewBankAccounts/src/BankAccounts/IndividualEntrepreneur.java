package BankAccounts;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IndividualEntrepreneur extends Client {
    @Override
    public void putMoney(BigDecimal balance) {
        if (balance.compareTo(BigDecimal.valueOf(1000)) < 0) {
            putMoneyWithPercent(BigDecimal.valueOf(0.01), balance);
            }
        else {
            putMoneyWithPercent(BigDecimal.valueOf(0.005), balance);
        }
    }

    private void putMoneyWithPercent (BigDecimal percentScale, BigDecimal balance) {
        BigDecimal percent = new BigDecimal(String.valueOf(balance.multiply(percentScale))).setScale(2, RoundingMode.HALF_UP);
        setBalance(getBalance().add(balance).subtract(percent).setScale(2, RoundingMode.HALF_UP));
        System.out.println("Вы положили на счет: " + balance.setScale(2, RoundingMode.HALF_UP) + "\nУ Вас на счету: " + getBalance() + "\nС Вас удержан процент: " + percent);

    }
}
