public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;

        sumDigits(111111112);
    }

    public static void sumDigits(Integer number)
    {
        System.out.println("Вы ввели число: " + number);
        String sumText = Integer.toString(number);                                     // преобразуем число в строку
        int sumOfNumbers = 0;

        for (int numberOfChar = 0; numberOfChar < sumText.length() ; numberOfChar++)
        {
            char someChar = sumText.charAt(numberOfChar);                              // записываем символ с определенной позиции в переменную
            int someCharToInt = Integer.parseInt(String.valueOf(someChar));            // преобразуем символ в число
            sumOfNumbers += someCharToInt;                                             // суммируем
        }
        System.out.println("Сумма цифр в числе: " + sumOfNumbers);
    }
}
