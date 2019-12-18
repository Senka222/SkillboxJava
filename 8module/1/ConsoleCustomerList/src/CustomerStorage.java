import java.io.IOException;
import java.util.HashMap;
import org.apache.commons.validator.routines.EmailValidator;


public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws IOException, ExceptionInHash {
        String[] components = data.split("\\s+");
        String name = components[0] + " " + components[1];
        EmailValidator validator = EmailValidator.getInstance();
        String phoneNumber = components[3].replaceAll("[^0-9]","");
        if (components.length != 4)
        {
            throw new IOException("Неверный формат ввода.\nПример корректоного ввода:\n" + "add Василий Петров " +
                    "vasily.petrov@gmail.com +79215637722");
        }
        if (storage.containsKey(name)){
            throw new ExceptionInHash("Такое имя уже введено.");
        }
        if (!validator.isValid(components[2]))
        {
            throw new IOException("Email введен неверно.\nПример: vasily.petrov@gmail.com");
        }
        if (phoneNumber.length() >= 10 && phoneNumber.length() <= 11) {

            if (phoneNumber.length() == 10) {
                phoneNumber = "+7" + phoneNumber;
            }
            if (phoneNumber.matches("\\b8\\d+")) {
                phoneNumber = phoneNumber.replaceAll("\\b8", "+7");
            }
            phoneNumber = components[3];
        }
        else {
            throw new IOException("Номер телефона введен неверно.");
        }

        storage.put(name, new Customer(name, components[3], components[2]));
        System.out.println("Вы ввели:" + storage.get(name));
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) throws ExceptionInHash {
        if (!storage.containsKey(name))
        {
            throw new ExceptionInHash("Такого имени для удаления не существует."); //так что можно и просто условием, скорее всего
        }                                                                          //но раз уж модуль по ексепшенам
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}