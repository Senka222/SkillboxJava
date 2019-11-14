import java.util.Scanner;

public class Main
{
    private static int minIncome = 200000;                      // переменная типа int, минимальный доход
    private static int maxIncome = 900000;                      // переменная типа int, максимальный доход

    private static int officeRentCharge = 140000;               // переменная типа int, аренда офиса
    private static int telephonyCharge = 12000;                 // переменная типа int, телефонные счета
    private static int internetAccessCharge = 7200;             // переменная типа int, счета за интеренет

    private static int assistantSalary = 45000;                 // переменная типа int, зарплата ассистента
    private static int financeManagerSalary = 90000;            // переменная типа int, зарплата финансового менеджера

    private static double mainTaxPercent = 0.24;                // переменная типа double, основной налог 24%
    private static double managerPercent = 0.15;                // переменная типа double, процент менеджера 15%

    private static double minInvestmentsAmount = 100000;        // переменная типа double, минималное количество инвестиций
    private static double breakEvenPoint = (minInvestmentsAmount / (1 - mainTaxPercent) + calculateFixedCharges()) / (1 - managerPercent);


    public static void main(String[] args)                      // так должно быть написано
    {
        while(true)                                             // цикл, не перестанет выполняться если не остановить, потому что всегда будет истин
        {

            System.out.println("Введите сумму доходов компании за месяц " +
                "(от 200 до 900 тысяч рублей): ");              // строка перед вводом текста, для понимания того что воодишь
            int income = (new Scanner(System.in)).nextInt();    // создаем переменную типа int, берем её значение из консоли

            if(!checkIncomeRange(income)) {                     // проверяемто что ввели в методе checkIncomeRange,
                continue;                                       // если истино - продолжаем, если ложно - то начинаем цикл заново
            }

            double managerSalary = income * managerPercent;      // создаем переменную double, зарплата менеджера = доход * на % менеджера
            double pureIncome = income - managerSalary -         // создаем переменную double,  чистый доход = доход - зарплата менеджера - калькуляция фиксированных убытков
                calculateFixedCharges();                         // подстчет которой идет в отдельном методе
            double taxAmount = mainTaxPercent * pureIncome;      // переменная double, размер налога = % налога * чистую прибыль
            double pureIncomeAfterTax = pureIncome - taxAmount;  // деременная double, чистый доход после налога = чистый доход - размер налога


            boolean canMakeInvestments = pureIncomeAfterTax >=   // переменная boolean, может ли фирма инвестировать, истино если чистая прибыль после налогов
                minInvestmentsAmount;                            // больше или равна минимальному размеру инвестиций, и ложно если меньше

            System.out.println("Зарплата менеджера: " + managerSalary); // выводим в консоль зарплату менеджера
            System.out.println("Общая сумма налогов: " +                // ... общую сумму налогов
                (taxAmount > 0 ? taxAmount : 0));                       // если размер налогов больше 0 выводим его размер, если меньше - 0
            System.out.println("Компания может инвестировать: " +       // ... возможность инвестирования компании
                (canMakeInvestments ? "да" : "нет"));                   // если правдиво - да, ложно - нет
            System.out.println("Точка безубыточности компании: " + breakEvenPoint);
            if(pureIncome < 0) {                                        // если чистая прибыль меньше 0,
                System.out.println("Бюджет в минусе! Нужно срочно зарабатывать!");// печатаем эту строку
            }
        }
    }

    private static boolean checkIncomeRange(int income)        // метод проверки соблюдения границ условия
    {
        if(income < minIncome)                                 // если вводится значение меньше минимального дохода
        {
            System.out.println("Доход меньше нижней границы"); // то выводится этот текст
            return false;                                      // в метод Main возвращается значение "ложно" (?)
        }
        if(income > maxIncome)                                 // соответственно елси больше...
        {
            System.out.println("Доход выше верхней границы");
            return false;                                      // в метод Main возвращается значение "ложно" (?)
        }
        return true;                                           // в метод Main возвращается значение "истино" (?)
    }

    private static int calculateFixedCharges()                 //подсчет фиксированных затрат
    {
        return officeRentCharge +
                telephonyCharge +
                internetAccessCharge +
                assistantSalary +
                financeManagerSalary;
    }
}
