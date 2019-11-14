import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Birthdays
{
    public static void main(String[] args)
    {
        System.out.println("Введите ваш день рождения цифрами, в формате Дата.Месяц.Год:");
        Scanner scanner = new Scanner(System.in);
        String inputDate = scanner.nextLine();
        int[] forCheck = stringToInt(inputDate);

        while (!inputDate.matches("^\\d{1,2}\\.\\d{1,2}\\.\\d{4}$") || (forCheck[0] == 0 || forCheck[1] == 0 || forCheck[2] == 0)) // не придумал нормальную регулярку чтобы она отсеивала числа если там 0 вместо дат, поэтому немного костылей
        {
            System.out.println("Вы ввели день рождения в неправильном формате (Дата.Месяц.Год), попробуйте ещё раз:");
            inputDate = scanner.nextLine();
            forCheck = stringToInt(inputDate);
        }

        birthday(stringToInt(inputDate));

    }
    private static void birthday(int[] date)
    {
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = LocalDate.of(date[2], date[1], date[0]);
        Locale russianLocale = new Locale("ru", "RU");
        int currentAge = currentDate.getYear() - birthDate.getYear();

        for (int i = 0 ; i <= currentAge ; i++)
        {
            if (birthDate.isAfter(currentDate)){
                break;
            }
            Date printDate = Date.from(birthDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            System.out.println("День рождения №" + i + "\tДата: " + birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy\tДень недели: EEEE", russianLocale)));

            birthDate = birthDate.plusYears(1);
        }
    }
    private static int[] stringToInt(String input)           // вынес в отдельный метод, чтобы много кода не переписывать в цикл проверки даты
    {
        String[] dateArray = input.split("\\.");
        int[] dateArrayInt = new int[dateArray.length];

        for (int i = 0 ; i < dateArray.length ; i++)
        {
            dateArrayInt[i] = Integer.parseInt(dateArray[i]);
        }
        return dateArrayInt;
    }
}
