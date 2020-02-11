import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

    private static long size;
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        size += dir.toFile().length();
//        System.out.println("Имя папки: \"" + dir + "\" её размер: " +
//                FileUtils.byteCountToDisplaySize(dir.toFile().length()));
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        size += file.toFile().length();
//        System.out.println("Имя файла: \"" + file + "\" его размер: " +
//                FileUtils.byteCountToDisplaySize(file.toFile().length()));
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Невозможно получить доступ к " + file); //оставли чтобы хоть видеть что программа работает на больших папках
        return FileVisitResult.CONTINUE;
    }

    public static long getSize() {
        return size;
    }
}
