import BankAccounts.Client;
import BankAccounts.Entity;
import BankAccounts.Individual;
import BankAccounts.IndividualEntrepreneur;

import java.math.BigDecimal;

public class Main
{
    public static void main(String[] args)
    {
        Individual individual = new Individual();
        individual.putMoney(BigDecimal.valueOf(500));
        System.out.println(individual.getBalance());
        individual.withdrawMoney(BigDecimal.valueOf(250.50));
        System.out.println(individual.getBalance());

        System.out.println("=======================================");

        Entity entity = new Entity();
        entity.putMoney(BigDecimal.valueOf(500));
        System.out.println(entity.getBalance());
        entity.withdrawMoney(BigDecimal.valueOf(200));
        System.out.println(entity.getBalance());

        System.out.println("=======================================");

        IndividualEntrepreneur individualEntrepreneur = new IndividualEntrepreneur();
        individualEntrepreneur.putMoney(BigDecimal.valueOf(500));
        System.out.println(individualEntrepreneur.getBalance());
        individualEntrepreneur.putMoney(BigDecimal.valueOf(1000));
        System.out.println(individualEntrepreneur.getBalance());
        individualEntrepreneur.putMoney(BigDecimal.valueOf(1500));
        System.out.println(individualEntrepreneur.getBalance());
        individualEntrepreneur.withdrawMoney(BigDecimal.valueOf(1000));
        System.out.println(individualEntrepreneur.getBalance());

    }
}
