package de.telran.Homework12_file_path;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

public class AdvancedFileOperations {

    public static void main(String[] args) throws IOException {
//        countWordsInFile();
//        findTxtFilesInDirectory("C:\\Program Files");
        copyLastParagraphUsingRandomAccess();
    }

    // Усложненное Задание 1: Работа с классом File

    /**
     * Написать метод, который читает файл "example.txt",
     * подсчитывает количество слов в файле и записывает это количество
     * в новый файл "word_count.txt". Использовать BufferedReader и BufferedWriter
     * для эффективной работы с текстом.
     */
    public static void countWordsInFile() throws IOException {
        File file = new File("example.txt");
        if (file.exists()){
            try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
                    BufferedWriter writer = new BufferedWriter(new FileWriter("word_count.txt"))){
                writer.write(Integer.toString((int)Arrays.stream(reader.readLine().split(" ")).count()));
            }
        }
    }

    // Усложненное Задание 2: Работа с классом Path

    /**
     * Написать метод, который ищет все файлы с расширением ".txt"
     * в текущей директории и её поддиректориях. Результаты поиска
     * (пути к файлам) записать в файл "found_files.txt".
     */
    public static void findTxtFilesInDirectory(String startDir) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("found_files.txt"))) {
//            Files.list(Paths.get(startDir)).filter(path -> path.toString().endsWith(".txt"))
//                    .forEach(path -> {
//                        try {
//                            writer.write(path+"\n");
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//                    });
//            Files.walkFileTree(Paths.get(startDir), new FileVisitor<Path>() {
//                @Override
//                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
//                    return FileVisitResult.CONTINUE;
//                }
//
//                @Override
//                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//                    if (file.toString().endsWith(".txt")){
//                        writer.write(file+"\n");
//                    }
//                    return FileVisitResult.CONTINUE;
//                }
//
//                @Override
//                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
//                    return FileVisitResult.CONTINUE;
//                }
//
//                @Override
//                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
//                    return FileVisitResult.CONTINUE;
//                }
//            });
            Files.walkFileTree(Paths.get(startDir), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toString().endsWith(".txt")) {
                        writer.write(file + "\n");
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
        }
    }

    // Усложненное Задание 3: Работа с классом RandomAccessFile

    /**
     * Написать метод, который открывает файл "example.txt"
     * с использованием RandomAccessFile, переходит к последнему абзацу
     * в файле и копирует его содержимое в новый файл "last_paragraph.txt".
     */
    public static void copyLastParagraphUsingRandomAccess() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("last_paragraph.txt"))){
            RandomAccessFile file = new RandomAccessFile("example.txt","rw");
            long position = file.length()-1;
            int lastChar = '\n';
            while (position>=0){
                file.seek(position);
                if (file.read() == lastChar){
                    break;
                }
                position--;
            }
            writer.write(file.readLine());
        }
    }
}
