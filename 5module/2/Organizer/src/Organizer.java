import java.util.ArrayList;
import java.util.Scanner;

public class Organizer
{
    public static void main(String[] args)
    {
        System.out.println("Это ваш список дел, вы можете использовать несколько команд:\n" +
                "ADD_номер вашего дела_текст вашего дела (добавление нового дела)\n" +
                "ADD_текст вашего дела (добавление нового дела в начало списка)\n" +
                "EDIT_номер вашего дела_текст вашего дела (изменение старого дела, если оно существует)\n" +
                "DELETE_номер вашего дела (удаление старого дела по номеру, если оно существует)\n" +
                "LIST (вывод всего списка ваших дел)");
        ArrayList<String> toDoList = new ArrayList<>(){{
            add("Ваш список дел:");
        }};
        Scanner scanner = new Scanner(System.in);
        for ( ; ; ) {
            String input = scanner.nextLine();
            int placeInList;

            while (!input.matches("^[ADEITLS]{3,6}\\s*\\d*\\s*.*$"))
            {
                System.out.println("Вы ввели что то не то, попробуйте ещё раз: ");
                input = scanner.nextLine();
            }

            if (input.matches("^ADD\\s+\\d+\\s+.*$"))
            {
                String[] addText = input.split("\\s+",3);
                placeInList = Integer.parseInt(addText[1]);
                if (placeInList > toDoList.size())
                {
                    placeInList = toDoList.size();
                    writeInList(toDoList, placeInList, addText);
                }
                else if (placeInList == 0){
                    System.out.println("Вы не можете записать свое дело на 0 позицию, оно будет записано на позицию 1");
                    placeInList = 1;
                    writeInList(toDoList, placeInList, addText);
                }
                else{
                    writeInList(toDoList, placeInList, addText);
                }
            }

            else  if (input.matches("^ADD\\s+.*$"))
            {
                String[] addText = input.split("\\s+",2);
                placeInList = 1;
                toDoList.add(placeInList, addText[1]);
                System.out.println("Дело \"" + addText[1] + "\" записано на позицию " + placeInList + "\nБолее старые дела сдвинуты на позицию вниз.");
            }

            else if (input.matches("^EDIT\\s+\\d+\\s+.*$"))
            {
                String[] addText = input.split("\\s+",3);
                placeInList = Integer.parseInt(addText[1]);
                if (placeInList > toDoList.size() || placeInList == 0)
                {
                    System.out.println("Вы не можете переписать дело на 0 позиции");
                    continue;
                }
                else{
                    toDoList.set(placeInList, addText[2]);
                    System.out.println("Дело \"" + addText[2] + "\" записано на позицию " + placeInList);
                }
            }

            else if (input.matches("^DELETE\\s+\\d+$"))
            {
                placeInList = Integer.parseInt(input.replaceAll("[^0-9]+", ""));
                if (placeInList > toDoList.size() || (placeInList == 0))
                {
                    System.out.println("Вы не можете удалить дело на 0 позиции или на нечуществующей позиции.");
                    continue;
                }
                else{
                    toDoList.remove(placeInList);
                    System.out.println("Вы удалили дело с позиции " + placeInList);
                }
            }

            else if (input.matches("LIST"))
            {
                for (int i = 0 ; i < toDoList.size() ; i++)
                {
                    System.out.println(i + " - " + toDoList.get(i));
                }
            }

            else{
                System.out.println("Ваша команда не распознана, будьте внимательнее!");
            }

            System.out.println("Можете ввести что нибудь ещё:");
        }
    }

    private static void writeInList(ArrayList array, int place, String[] text)
    {
        array.add(place, text[2]);
        System.out.println("Дело \"" + text[2] + "\" записано на позицию " + place);
    }
}
