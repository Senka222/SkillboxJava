import java.io.File;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

public class Main {
    public static void main(String[] args) {

        long size;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите абсолютный путь папки:" +
                "\nПример: C:/users");
        String inputPath = scanner.nextLine();

        while (!inputPath.matches("[C-Z]:\\/[a-zA-Z0-9\\/]+")) {
            System.out.println("Вы ввели неправильный путь, попробуйте ещё раз:");
            inputPath = scanner.nextLine();
        }
//        String inputPath = "C:/";

        File folder = new File(inputPath);
        size = sizeOfFolder(folder);    //лучше ли будет если использовать меньше переменных и просто пихать модули один в другой?
        String sizeForPrint = FileUtils.byteCountToDisplaySize(size);
        System.out.println("Размер указанной папки: " + sizeForPrint);
    }

    public static long sizeOfFolder(File folder) {

        File[] files = folder.listFiles();
        long size = 0;
        assert files != null; // это я так понимаю проверка на то чтобы файл не был равен 0
        int count = files.length;

        for (int i = 0 ; i < count ; i++) {
            try {
                if (files[i].isFile()) {
                    size += files[i].length();
                } else {
                    size += sizeOfFolder(files[i]);
                }
            }
            catch (NullPointerException ex){
                System.out.println("Невозможно получить доступ к файлу: " + files[i]);
            }
        }
        return size;
    }
}
