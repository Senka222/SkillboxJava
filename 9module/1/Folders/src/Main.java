import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

public class Main {

    public static void main(String[] args) {

        long size;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите абсолютный путь папки:" +
                "\nПример: C:/users");
        Path inputPath = Paths.get(scanner.nextLine());

        while (!inputPath.toFile().isDirectory()) {
            System.out.println("Вы ввели неправильный путь, попробуйте ещё раз:");
            inputPath = Paths.get(scanner.nextLine());
        }

//       Path inputPath = Paths.get("C:/Users/senka/");

        try {
            Files.walkFileTree(inputPath, new MyFileVisitor());
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        File folder = new File(inputPath.toString());
        size = sizeOfFolder(folder);    //лучше ли будет если использовать меньше переменных и просто пихать модули один в другой?
        String sizeForPrint = FileUtils.byteCountToDisplaySize(size);
        System.out.println("Размер указанной папки: " + sizeForPrint);
        String sizeForPrintFromVisitor = FileUtils.byteCountToDisplaySize(MyFileVisitor.getSize());
        System.out.println("Размер указанной папки через FileVisitor: " + sizeForPrintFromVisitor);
    }

    public static long sizeOfFolder(File folder) {

        File[] files = folder.listFiles();
        int count = 0;
        long size = 0;
        if (files != null) {
            count = files.length;
        }

        for (int i = 0 ; i < count ; i++) {
                if (files[i].isFile()) {
                    size += files[i].length();
                } else {
                    size += sizeOfFolder(files[i]);
                }
        }
        return size;
    }
}
