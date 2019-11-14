import java.text.SimpleDateFormat;
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
        Calendar calendar = Calendar.getInstance();         // тут кстати увидел что можно было бы сразу создать григорианский кадендарь с нужной датой
                                                            //        Calendar calendar = new GregorianCalendar(date[2],date[1] - 1,date[0]); // как то так
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date currentDate = calendar.getTime();              // текущая дата для определения был ли в этом году уже день рождения или ещё нет
        int currentYear = calendar.get(Calendar.YEAR);      // сохраним год на всякий случай, для последующих вычислеинй
        calendar.set(date[2],date[1] - 1,date[0]);
        int currentAge = currentYear - date[2];

        for (int i = 0 ; i <= currentAge ; i++)             //в пирнципе можно было бы сделать и (calendar.get(Calendar.YEAR) ; calendar.get(Calendar.YEAR) < currentYear ; calendar.add(Calendar.YEAR, 1))
        {                                                   // но подумал что все равно пришлось бы вводить  какое то i чтобы отображать номер дня рождения, поэтому сделал currentAge
            if (currentDate.before(calendar.getTime())){
//                System.out.println("А в этом году ты ещё не родился =Ъ");
                break;
            }
            System.out.println("День рождения №" + i + "\tДата: " + dateFormat.format(calendar.getTime()) + "\tДень недели: " + calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("ru")));
            calendar.add(Calendar.YEAR, 1);
        }
    }
    private static int[] stringToInt(String input)           // вынес в отдельный метод чтобы много кода, не переписывать в цикл проверки даты
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
