package org.example._2024_01_25.taski;

public class Main {

    /**
     * Создайте объекты класса Book для каждой строки.
     * Используйте Stream API для преобразования строк в объекты.
     * Сериализуйте список книг в файл с использованием ObjectOutputStream.
     */
    public static void main(String[] args) throws RuntimeException {

    }
}

class Main1 {

    /**
     * Десериализуйте список книг из файла,
     * созданного в предыдущем задании, используя ObjectInputStream.
     * Используйте Stream API для фильтрации книг, например, по автору или году издания.
     * Результаты сохраните в новый сериализованный файл
     */
    public static void main(String[] args) {

    }
}

class Main2 {

    /**
     * Отфильтруйте книги с ценой выше определенной суммы. Сериализуйте отфильтрованный список книг в файл.
     */
    public static void main(String[] args) {

    }
}

class Main3 {

    /**
     Агрегируйте данные, например, подсчитайте среднюю цену книг по каждому автору. Сериализуйте результаты в файл.
     */
    public static void main(String[] args) {
//        try (FileInputStream fis = new FileInputStream("data.txt");
//             Scanner scanner = new Scanner(fis);
//             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("authorAveragePrice.ser"))) {
//
//            Map<String, Double> authorAveragePrice = scanner.useDelimiter("\\A").next().lines()
//                    .skip(1)
//                    .map(line -> line.split(", "))
//
    }
}