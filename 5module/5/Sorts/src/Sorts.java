import java.util.*;

public class Sorts
{
    public static void main(String[] args)
    {
        ArrayList<String> blatNumbers = blatNumbersGenerator();
        System.out.println("Количество сгенерированных номеров:" + blatNumbers.size());
        System.out.println("Введите \"блатной\" номер для поиска, буквы латинские (ABEKMHOPCTYX):");
        Scanner scanner = new Scanner(System.in);

        for (;;)
        {
            String input = scanner.nextLine();
            while (!input.matches("^[ABEKMHOPCTYX][1-9]{3}[ABEKMHOPCTYX]{2}[1-9][0-9]{0,2}"))
            {
                System.out.println("Вы ввели номер неправильное, попробуйте ещё:");
                input = scanner.nextLine();
            }

            directSearch(blatNumbers, input);
            binarySearch(blatNumbers, input);
            hashSetSearch(blatNumbers, input);
            treeSetSearch(blatNumbers, input);
        }
    }
    private static ArrayList<String> blatNumbersGenerator()
    {
        ArrayList<String> temps = new ArrayList<>();
        String[] letters = new String[]{"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};
        StringBuilder number = new StringBuilder();

        for (int firstLetter = 0 ; firstLetter < letters.length ; firstLetter++)
        {
            number.append(letters[firstLetter]);
            for (int secondFourthNumbers = 1 ; secondFourthNumbers <= 9 ; secondFourthNumbers++)
            {
                number.append(secondFourthNumbers).append(secondFourthNumbers).append(secondFourthNumbers);
                for (int fifthLetter = 0 ; fifthLetter < letters.length ; fifthLetter++)
                {
                    number.append(letters[fifthLetter]);
                    for (int sixthLetter = 0 ; sixthLetter < letters.length ; sixthLetter++)
                    {
                        number.append(letters[sixthLetter]);
                        for (int lastNumber = 1 ; lastNumber <= 197 ; lastNumber++)
                        {
                            number.append(lastNumber);
                            temps.add(number.toString());
                            number.delete(6,number.length());
                        }
                        number.delete(5,number.length());
                    }
                    number.delete(4,number.length());
                }
                number.delete(1,number.length());
            }
            number.delete(0,number.length());
        }
        return temps;
    }

    private static void directSearch (ArrayList<String> array, String lookFor)
    {
        long start = System.currentTimeMillis();
        boolean directSearch = array.contains(lookFor);
        long duration = System.currentTimeMillis() - start;
        if (directSearch)
        {
            System.out.println("Номер " + lookFor + " найден прямым перебором, это заняло: " + duration + "мс");
        }
        else {
            System.out.println("Номер не найден!");
        }
    }

    private static void binarySearch (ArrayList<String> array, String lookFor)
    {
        long start = System.currentTimeMillis();
        int binarySearch = Collections.binarySearch(array, lookFor);
        long duration = System.currentTimeMillis() - start;
        if (binarySearch != -1)
        {
            System.out.println("Номер " + lookFor + " найден бинарным поиском, это заняло: " + duration + "мс");
        }
        else {
            System.out.println("Номер не найден!");
        }
    }

    private static void hashSetSearch (ArrayList<String> array, String lookFor)
    {
        HashSet<String> arrayToHash = new HashSet<>(array);
        long start = System.currentTimeMillis();
        boolean hashSearch = arrayToHash.contains(lookFor);
        long duration = System.currentTimeMillis() - start;
        if (hashSearch)
        {
            System.out.println("Номер " + lookFor + " найден в HashSet'е, это заняло: " + duration + "мс");
        }
        else {
            System.out.println("Номер не найден!");
        }
    }

    private static void treeSetSearch (ArrayList<String> array, String lookFor)
    {
        TreeSet<String> arrayToTree = new TreeSet<>(array);
        long start = System.currentTimeMillis();
        boolean treeSearch = arrayToTree.contains(lookFor);
        long duration = System.currentTimeMillis() - start;
        if (treeSearch)
        {
            System.out.println("Номер " + lookFor + " найден в TreeSet'е, это заняло: " + duration + "мс");
        }
        else {
            System.out.println("Номер не найден!");
        }
    }
}
