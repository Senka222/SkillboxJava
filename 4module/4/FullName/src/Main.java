import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Введите ФИО через пробел:");
        Scanner scanner = new Scanner(System.in);
        String inputName = scanner.nextLine();
        String[] words = inputName.split("\\s+");
        String[] fullName = {"Фамилия: ", "Имя: ", "Отчество: "};

//        System.out.println(words.length);

        while (words.length != 3 || !inputName.matches("^([^'\\-][\\p{L}'\\-]+[^'\\-]){3}$")){
            System.out.println("Вы ввели неполное или слишком длинное ФИО, попробуйте ещё раз:");
            inputName = scanner.nextLine();
            words = inputName.split("\\s+");
        }


        for (int i = 0 ; i < words.length ; i++)
        {
//            if (words[i].matches("^[\\p{L}'\\-]\b[\\p{L}'\\-]\b[\\p{L}'\\-]$")) {
                System.out.println(fullName[i] + words[i]);
//            }
//            else {
//                System.out.println(fullName[i] + "неправильный ввод");
//            }
        }
    }
}
