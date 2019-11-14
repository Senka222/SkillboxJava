import Accounts.CreditCard;
import Accounts.Deposit;
import Accounts.PaymentAccount;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        PaymentAccount paymentAccount = new PaymentAccount();
        Deposit deposit = new Deposit();
        CreditCard creditCard = new CreditCard();

        Scanner scanner = new Scanner(System.in);
        int input;

        paymentAccount.putMoney(BigDecimal.valueOf(120));
        System.out.println(paymentAccount.getBalance());
        paymentAccount.withdrawMoney(BigDecimal.valueOf(20));
        System.out.println(paymentAccount.getBalance());
        creditCard.putMoney(BigDecimal.valueOf(150));
        System.out.println(creditCard.getBalance());
        creditCard.withdrawMoney(BigDecimal.valueOf(50));
        System.out.println(creditCard.getBalance());
        creditCard.withdrawMoney(BigDecimal.valueOf(100));
        System.out.println(creditCard.getBalance());
        deposit.putMoney(BigDecimal.valueOf(120));
        deposit.withdrawMoney(BigDecimal.valueOf(-20));
        deposit.putMoney(BigDecimal.valueOf(120));

        for (;;){
            input = scanner.nextInt();
            deposit.setBalance(BigDecimal.valueOf(input));
        }

    }
}
