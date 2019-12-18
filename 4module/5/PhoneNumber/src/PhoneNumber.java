import java.lang.reflect.Array;
import java.util.Scanner;

public class PhoneNumber
{
    public static void main(String[] args)
    {
        System.out.println("Введите телефоный номер в любом формате:");
/*        Scanner scanner = new Scanner(System.in);
        String phoneNumber = scanner.nextLine().replaceAll("[^0-9]", "");

        while (phoneNumber.length() < 10 || phoneNumber.length() >11){
            System.out.println("Вы ввели неправильный номер, попробуйте ещё раз:");
            phoneNumber = scanner.nextLine().replaceAll("[^0-9]", "");
        }

        if (phoneNumber.length() == 10){
            phoneNumber = "7" + phoneNumber;
        }
        if (phoneNumber.matches("\\b8\\d+")){
            phoneNumber = phoneNumber.replaceAll("\\b8", "7");
       }
*/
        String phoneNumber = "79021234567";
        int[] fPhoneNumber = new int[11];

        for (int i = 0 ; i < fPhoneNumber.length ; i++)
        {
            fPhoneNumber[i] = Character.getNumericValue(phoneNumber.charAt(i));
        }

        System.out.printf("+%1$d (%2$d%3$d%4$d) %5$d%6$d%7$d-%8$d%9$d-%10$d%11$d", fPhoneNumber[0],fPhoneNumber[1],fPhoneNumber[2],fPhoneNumber[3],fPhoneNumber[4],fPhoneNumber[5],fPhoneNumber[6],fPhoneNumber[7],fPhoneNumber[8],fPhoneNumber[9],fPhoneNumber[10]);
    }
}
