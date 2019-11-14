import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int containersInTrack = 12;
        int boxesInContainer = 27;

        System.out.println("Введите количество ящиков:");
        Scanner scanner = new Scanner(System.in);
        int boxesCount = scanner.nextInt();

        int track = 0;
        int container = 0;

        for (int box = 1 ; box <= boxesCount ; box++)
        {
            if (box % boxesInContainer == 1)
            {
                if (box % (containersInTrack * boxesInContainer) == 1)
                {
                    track++;
                    System.out.println("Грузовик №" + track + ":");
                }

                container++;
                System.out.println("\tКонтейнер №" + container + ":");
            }

            System.out.println("\t\tЯщик №" + box);
        }

        System.out.println("Общее число грузовиков: " + track + "\nОбщее число контейнеров: " + container);
    }
}
