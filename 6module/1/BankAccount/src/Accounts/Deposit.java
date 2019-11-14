package Accounts;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deposit extends PaymentAccount {

    private LocalDate start = LocalDate.now();

    @Override
    public void putMoney(BigDecimal balance) {
        setBalance(getBalance().add(balance));
        this.start = LocalDate.now().plusMonths(1);
        System.out.println("Вы занесли на депозит: " + getBalance() + "\nСнятие возможно после " + this.start.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }

    @Override
    public void withdrawMoney(BigDecimal balance) {
        LocalDate now = LocalDate.now();
        if (now.isBefore(start)){
            System.out.println("С последнего взноса ещё не прошел месяц!");
        }
        else {
            if (getBalance().subtract(balance).compareTo(BigDecimal.valueOf(0)) >= 0) {
                setBalance(getBalance().subtract(balance));
                System.out.println("Вы сняли со счета: " + balance + "\nУ Вас на счету осталось: " + getBalance());
            }
            else System.out.println("На счету недостаточно средств!");
        }
    }
}
