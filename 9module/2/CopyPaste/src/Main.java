import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Какую папку нужно скопировать: " +
                "\nПример C:/users");
        File copy = new File(inputModule().toString());

        System.out.println("Куда будем копировать?");
        File paste = new File(inputModule().toString());

//        File copy = new File("C:/Users/senka/Desktop/Test");
//        File paste = new File("C:/Users/senka/Desktop/Test2");

        copyFolder(copy, paste);
        System.out.println("Копирование завершено.");
    }
    private static Path inputModule(){
        Scanner scanner = new Scanner(System.in);
        Path input = Paths.get(scanner.nextLine());

        while(!input.toFile().isDirectory()){
            input = Paths.get(scanner.nextLine());
        }
        return input;
    }
    private static void copyFolder(File copy, File paste){
        if (copy.isDirectory()) {

            if (!paste.exists()) {
                paste.mkdir();
                System.out.println("Папка: " + paste + " создана.");
            }

            String[] files = copy.list();
            if (files != null) {
                for (String file : files) {

                    File copyFile = new File(copy, file);
                    File pasteFile = new File(paste, file);

                    copyFolder(copyFile, pasteFile);
                }
            }
        }
        else{
            try {
                Files.copy(copy.toPath(), paste.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Скопирован файл: " + paste);
            }
            catch (IOException ex){
                System.out.println("Ошибка копирования файла:" + paste);
            }
        }
    }
}
