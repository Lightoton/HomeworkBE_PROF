package de.telran.Homework12_file_path;

import java.io.*;

public class FileOperationExamples {

    public static void main(String[] args) throws IOException {
        copyFileUsingFileStreams();
        copyFileUsingPath();
        copyFileUsingRandomAccessFile();
    }

    // Задание 1: Работа с классом File

    /**
     * Написать метод, который создает файл с именем
     * "example.txt" в текущей директории, затем считывает
     * этот файл с использованием FileInputStream и записывает
     * его содержимое в новый файл "copy_example.txt" с использованием FileOutputStream.
     */
    public static void copyFileUsingFileStreams() throws IOException {
        File file = new File("example.txt");
        if (file.createNewFile()) {
            try (BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
                 BufferedWriter writer = new BufferedWriter(new FileWriter("copy_example.txt"))) {
                writer.write(reader.readLine());
            }
        }
    }

    // Задание 2: Работа с классом Path

    /**
     * Написать метод, который использует Path и Files
     * для копирования файла "example.txt" в новый файл "copy_example_path.txt".
     * Проверить, существует ли файл "example.txt" перед копированием.
     */
    public static void copyFileUsingPath() throws IOException {
        File file = new File("example.txt");
        if (file.exists()) {
            try (BufferedReader inputStream = new BufferedReader(new FileReader("example.txt"));
                 BufferedWriter outputStream = new BufferedWriter(new FileWriter("copy_example_path.txt"))) {
                outputStream.write(inputStream.readLine());
            }
            ;

        }
    }


    // Задание 3: Работа с классом RandomAccessFile

    /**
     * Написать метод, который открывает файл "example.txt"
     * с использованием RandomAccessFile, читает первые 20 байт и записывает
     * их в новый файл "random_access_copy.txt".
     */
    public static void copyFileUsingRandomAccessFile() throws IOException {
        try (RandomAccessFile accessFile = new RandomAccessFile("example.txt", "rw");
             BufferedWriter writer = new BufferedWriter(new FileWriter("random_access_copy.txt"))) {
            byte[] buffer = new byte[20];
            accessFile.read(buffer, 0, 20);
            writer.write(new String(buffer));
        }
    }
}
