import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Hospital
{
    public static void main(String[] args)
    {
        BigDecimal[] temperature = new BigDecimal[30];                      //делаем массивы
        ArrayList<Double> healthyPatients = new ArrayList<>();

        for (int i = 0 ; i < temperature.length ; i++)
        {
            BigDecimal temp = new BigDecimal(Math.random() * 8 + 32).setScale(1, RoundingMode.HALF_UP);
            temperature[i] = temp;                                          //создаем рандомные температуры и округляем
            if (temp.doubleValue() >= 36.2 && temp.doubleValue() <= 36.9){  //ищем здоровых пациентов
                healthyPatients.add(temp.doubleValue());                    //заносим в соответствующий массив
            }
        }

        System.out.println("Температуры всех пациентов:");
        for (BigDecimal v : temperature) {
            System.out.print(v + " ");
        }

        System.out.println("\nКоличество здоровых пациентов: " + healthyPatients.size());
        averageTemperature(temperature);
    }
    private static void averageTemperature(BigDecimal[] numbers) //считаем среднюю температуру
    {
        BigDecimal average = new BigDecimal(0).setScale(1, RoundingMode.HALF_UP);
        for (BigDecimal number : numbers) {
            average = average.add(number);
        }
        System.out.println("Средняя температура по больнице: " + average.divide(BigDecimal.valueOf(numbers.length),RoundingMode.HALF_UP));
    }
}
