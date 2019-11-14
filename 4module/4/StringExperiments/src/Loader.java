import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 100000 рубля, а Маша - 30000 рублей, Паша - 300 рублей, Петрович 50";

        System.out.println(text);

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        ArrayList<Integer> salaries = new ArrayList<>();
        int salariesSum = 0;

        while (matcher.find()) {
//            System.out.println(text.substring(matcher.start(), matcher.end()));
            salaries.add(Integer.parseInt(text.substring(matcher.start(), matcher.end())));
        }

        for (int i = 0 ; i < salaries.size() ; i++){
            salariesSum += salaries.get(i);
        }

        System.out.println("Сумма заработка всех друзей: " + salariesSum);

    }
}