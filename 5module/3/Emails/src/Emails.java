import org.apache.commons.validator.routines.EmailValidator;
import java.util.HashSet;
import java.util.Scanner;

public class Emails
{
    public static void main(String[] args)
    {
        System.out.println("Вы можете искользовать команды:\n" +
                "ADD ваш_email (для добавления email'а в список)\n" +
                "LIST (для вывода списка email'ов)\n" +
                "Введите команду:");

        HashSet<String> emails = new HashSet<>();

        Scanner scanner = new Scanner(System.in);

        for ( ; ; ) {
            String input = scanner.nextLine();

            if (input.matches("^ADD\\s+.+$")) {
                String emailString = input.replaceAll("^ADD\\s+", "");
                EmailValidator validator = EmailValidator.getInstance();
                if (validator.isValid(emailString))
                {
                    emails.add(emailString);
                    System.out.println("Вы добавили email \"" + emailString + "\" в список");
                }
                else {
                    System.out.println("Вы неправильно ввели email.");
                }
            }
            else if (input.matches("LIST")) {
                System.out.println("Список email'ов:");
                for (String email : emails)
                {
                    System.out.println(email);
                }
            }
            else{
                System.out.println("Вы неправильно ввели команду.");
            }
            System.out.println("Можете ввести ещё команду:");
        }
    }
}
