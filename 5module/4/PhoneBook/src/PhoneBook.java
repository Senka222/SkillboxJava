import java.util.*;

public class PhoneBook
{
    public static void main(String[] args)
    {
        System.out.println("Перед вами \"телефонная книга\", вы можете писать имя, либо номер телефона в любом формате" +
                "\nТак же существует команда \"LIST\" которая выводит полный список в формате \"Имя: номер\"." +
                "\nВведите что нибудь:");

        HashMap<String, String> phoneBook = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        for(;;)
        {
            String input = textInput(scanner.nextLine());
            String phoneNumber = input.replaceAll("[^0-9]","");

            if (input.equals("LIST")){
                Map<String, String> sortedMap = sortByValue(phoneBook);
                for (String key : sortedMap.keySet()){
                    System.out.println(sortedMap.get(key) + ": " + key);
                }
            }
            else if (phoneNumber.length() >= 11 && phoneNumber.length() < 16)
            {
                if (phoneBook.containsKey(phoneNumber))
                {
                    System.out.println("Этот номер телефона уже сохранен для контакта " + phoneBook.get(phoneNumber));
                }
                else {
                    System.out.println("Введите имя для сохранения с этим контактом:");
                    String name = textInput(scanner.nextLine());
                    phoneBook.put(phoneNumber, name);
                    System.out.println("Вы сохранили контакт " + phoneBook.get(phoneNumber) + " с номером " + phoneNumber);
                }
            }
            else{
                if (phoneBook.containsValue(input))
                {
                    System.out.println("Это имя уже сохранено для номера(ов):");
                    for (String key : getKeysByValue(phoneBook, input)) {
                        System.out.println("\t" + key);
                    }
                }
                else {
                    System.out.println("Введите номер для сохранения с этим контактом:");
                    phoneNumber = phoneNumberInput(scanner.nextLine());
                    if (phoneBook.containsKey(phoneNumber))
                    {
                        System.out.println("Контакт с таким номером уже существует! Сохранение контакта отменено!");
                        System.out.println("Можете ввести что нибудь ещё:");
                        continue;
                    }
                    phoneBook.put(phoneNumber, input);
                    System.out.println("Вы сохранили контакт " + phoneBook.get(phoneNumber) + " с номером " + phoneNumber);
                }
            }
            System.out.println("Можете ввести что нибудь ещё:");
        }
    }
    private static <K, V> Set<K> getKeysByValue(Map<K, V> map, V value) {
        Set<K> keys = new HashSet<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }
    private static String textInput(String input)
    {
        Scanner scanner = new Scanner(System.in);
        input = input.trim();
        while (!input.matches(".+"))
        {
            System.out.println("Вы ничего не ввели, попробуйте ещё:");
            input = scanner.nextLine().trim();
        }
        return input;
    }
    private static String phoneNumberInput(String input) {
        Scanner scanner = new Scanner(System.in);
        String phone = input.replaceAll("[^0-9]", "");
        while (phone.length() < 11 || phone.length() > 15) {
            System.out.println("Номер введен неверно, попробуйте ещё:");
            phone = scanner.nextLine().replaceAll("[^0-9]", "");
        }
        return phone;
    }
    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
