package de.telran.HomeworkLesson9;

import lombok.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class Taski {
    public static void main(String[] args) {
//        List<User> users = Arrays.asList(new User("ivan", Arrays.asList("dwa", "fag4re", "hbreko", "fewmo")), new User(
//                "teta", Arrays.asList("fewiop", "fenajiuo", "gvneriuwo")));
//        System.out.println(getAllSkills(users));
//        List<Book> books = List.of(
//                new Book("asdsa", Arrays.asList("dwadwa", "gedsa", "gdsagsd")),
//                new Book("dwadw", Arrays.asList("dwaddwawa", "geddwasa", "gdsdwaagsd")),
//                new Book("asdwadwadsa", Arrays.asList("dwaddwawa", "geddawsa", "gdsdwaagsd"))
//        );
//        System.out.println(getAuthorsTitles(books));
//        Map<String, List<String>> testMap = Map.of(
//                "key1", List.of("value11", "value12", "value13"),
//                "key2", List.of("value21", "value22"),
//                "key3", List.of("value31")
//        );
//        System.out.println(flattenMap(testMap));
//
//        List<List<Integer>> lists = Arrays.asList(
//                Arrays.asList(1, 2, 3, 4, 5, 6),
//                Arrays.asList(2, 4, 8, 9, 6, 5, 4),
//                Arrays.asList(4, 8, 9, 2, 4, 8, 6, 51, 24)
//        );
//        System.out.println(processAndFilter(lists));
        School school1 = new School("School1", Map.of(
                "ClassA", Arrays.asList(
                        new Student("Alice", Arrays.asList(new Subject("Math", 90.0), new Subject("History", 85.0))),
                        new Student("Bob", Arrays.asList(new Subject("Math", 92.0), new Subject("History", 88.0)))
                ),
                "ClassB", Arrays.asList(
                        new Student("Charlie", Arrays.asList(new Subject("Math", 78.0), new Subject("History", 75.0))),
                        new Student("David", Arrays.asList(new Subject("Math", 80.0), new Subject("History", 82.0)))
                )
        ));

        School school2 = new School("School2", Map.of(
                "ClassX", Arrays.asList(
                        new Student("Eve", Arrays.asList(new Subject("Math", 95.0), new Subject("History", 92.0))),
                        new Student("Frank", Arrays.asList(new Subject("Math", 88.0), new Subject("History", 90.0)))
                ),
                "ClassY", Arrays.asList(
                        new Student("Grace", Arrays.asList(new Subject("Math", 85.0), new Subject("History", 80.0))),
                        new Student("Hank", Arrays.asList(new Subject("Math", 92.0), new Subject("History", 95.0)))
                )
        ));

        List<School> schools = Arrays.asList(school1, school2);


        Map<String, Map<String, Double>> result = averageScoreBySubjectForTopStudents(schools);

        System.out.println(result);
    }
//Задача 1: Напишите метод, который принимает список списков целых чисел
//и преобразует его в один список++
    public List<Integer> flattenListOfLists(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(Collection::stream)
                .toList();
    }
//Задача 2: Напишите метод, который преобразует список объектов с вложенными списками в один список всех вложенных элементов.
    static class User {
        private String name;

        public User(String name, List<String> skills) {
            this.name = name;
            this.skills = skills;
        }

        private List<String> skills;
    }


    public static List<String> getAllSkills(List<User> users) {
        return users.stream()
                .flatMap(user -> {
                    String name = user.name;
                    List<String> list = user.skills;
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String s : list) {
                        stringBuilder.append(s).append(" ");
                    }
                    stringBuilder.append(name);
                    return Arrays.stream(stringBuilder.toString().split(" "));
                }).toList();
    }
//    Задача 3: Напишите метод, который объединяет строки из списка объектов.
    static class Book {
        private String title;
        private List<String> authors;

        public Book(String title, List<String> authors) {
            this.title = title;
            this.authors = authors;
        }


    }

    public static List<String> getAuthorsTitles(List<Book> books) {
        return books.stream().flatMap(book -> Stream.concat(book.authors.stream(), Stream.of(book.title.split(" ")))).toList();
    }
//    Задача 4: Напишите метод, который преобразует Map в список значений.
    public static List<String> flattenMap(Map<String, List<String>> map) {
        return map.entrySet().stream()
                .flatMap(el -> el.getValue().stream())
                .toList();
    }
//    Задача 5: Напишите метод, который принимает список списков и фильтрует все четные числа, а затем умножает их на 2.
    public static List<Integer> processAndFilter(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(Collection::stream)
                .filter(integer -> integer % 2 == 0)
                .map(el -> el * 2)
                .toList();
    }
//Задача 6: Преобразование и фильтрация объектов в списках
//Задание: Напишите метод, который фильтрует список объектов по некоторому условию,
//а затем извлекает и объединяет определённые атрибуты этих объектов в один список.
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static class Employee {
        private String department;
        private List<String> languages;
        private double salary;
    }

    public List<String> getLanguagesFromDepartment(List<Employee> employees, String department) {
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .flatMap(employee -> Stream.concat(Stream.of(employee.getDepartment()),
                        employee.getLanguages().stream()))
                .toList();
    }
//Задача 7: Напишите метод, который принимает список списков списков чисел и преобразует его в один список чисел.
    public List<Integer> flattenDeepListOfLists(List<List<List<Integer>>> deepList) {
        return deepList.stream()
                .flatMap(Collection::stream)
                .flatMap(Collection::stream)
                .toList();
    }
//Задача 8: Напишите метод, который принимает список объектов с вложенными коллекциями,
//сортирует вложенные элементы и возвращает отсортированный список всех элементов.
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static class Project {
        private String name;
        private List<String> tasks;
    }

    public List<String> getSortedTasks(List<Project> projects) {
        return projects.stream().flatMap(project -> Stream.concat(Stream.of(project.getName()),
                project.getTasks().stream().sorted(Comparator.naturalOrder()))).toList();
    }
//Задача 9: Напишите метод, который преобразует карту, где ключи - это строки, а значения -
//списки объектов, в один список уникальных строк, извлечённых из атрибутов объектов.
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static class Product {
        private String category;
        private String name;
    }

    public List<String> getUniqueProductNames(Map<String, List<Product>> categoryMap) {
        return categoryMap.values().stream()
                .flatMap(List::stream)
                .map(Product::getName)
                .distinct()
                .toList();
        //        return categoryMap.entrySet().stream()
//                .flatMap(stringListEntry -> Stream.concat(Stream.of(stringListEntry.getKey()),
//                        Arrays.stream(stringListEntry.getValue().toString().split(" ")))).toList();
    }
//Задача 10: Напишите метод, который объединяет данные из нескольких списков и
//преобразует их в один список, применяя к каждому элементу определённую функцию.
    public List<String> combineAndTransform(List<Integer> list1, List<Double> list2,
                                            Function<Number, String> transformer) {
//        list2.addAll(list1.stream().mapToDouble(Integer::doubleValue).boxed().toList());
//        return list2.stream().map(transformer).toList();
//        return Stream.concat(list1.stream(),list2.stream()).toList().stream().map(transformer).toList();
        return Stream.concat(list1.stream().map(transformer), list2.stream().map(transformer)).toList();
    }
//**
//
//Задача 11: Обработка вложенных структур с условными фильтрами
//Задание: Напишите метод, который обрабатывает вложенные структуры данных
//(например мапы, содержащих списки), фильтрует элементы по условию и объединяет их в один список.
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static
    class Order {
        private String customerName;
        private List<Item> items;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static
    class Item {
        private String name;
        private double price;
    }

    public List<Item> getItemsByCustomerName(List<Order> orders, String customerName) {
        return orders.stream()
                .filter(order -> order.getCustomerName().equals(customerName))
                .flatMap(order -> order.getItems().stream())
                .toList();
    }
//Задача 12: Напишите метод, который объединяет данные из вложенных коллекций разных объектов и считает сумму некоторого числового атрибута.
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static class Department {
        private String name;
        private List<Employee1> employees;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static class Employee1 {
        private String name;
        private double salary;
    }

    public double getTotalSalaryByDepartment(List<Department> departments, String departmentName) {// как я понял
        // нужно ещё и отфильтровать по имени
        return departments.stream().filter(department -> department.getName().equals(departmentName))
                .flatMap(department -> department.getEmployees().stream())
                .mapToDouble(Employee1::getSalary)
                .sum();
    }
//Задача 13: Напишите метод, который принимает несколько списков различных типов данных, преобразует их и объединяет в один список.
    public List<String> combineAndTransformComplex(List<Integer> integers, List<String> strings, List<Double> doubles) {
//        List<String> resList = new ArrayList<>();
//        resList.addAll(integers.stream().map(Object::toString).toList());
//        resList.addAll(strings);
//        resList.addAll(doubles.stream().map(Object::toString).toList());
//        return resList;
        return Stream.concat(Stream.concat(integers.stream().map(Object::toString),
                doubles.stream().map(Object::toString)), strings.stream()).toList();
    }
//***
//Задача 14:  Напишите метод, который обрабатывает список объектов, содержащих другие объекты с коллекциями.
//Ваша задача - вычислить среднее значение некоторого числового поля для каждого уникального ключа.
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static class Company {
        private String name;
        private List<DepartmentNew> departments;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static class DepartmentNew {
        private String name;
        private List<Employee> employees;
    }

    public Map<String, Double> averageSalaryByCompany(List<Company> companies) {
        Map<String, Double> doubleMap = new HashMap<>();
        for (Company company : companies) {
            double avgSalary = company.getDepartments().stream()
                    .flatMapToDouble(departmentNew -> departmentNew.getEmployees().stream()
                            .mapToDouble(Employee::getSalary))
                    .average()
                    .orElse(0.0);
            doubleMap.put(company.getName(), avgSalary);
        }
        return doubleMap;
    }
//Задача 15: Напишите метод, который анализирует данные из нескольких различных коллекций,
//соединяет их и выводит результаты, соответствующие определённым критериям.
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static
    class ProductNew {
        private String name;
        private String category;
        private double price;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static
    class OrderNew {
        private String customerName;
        private List<ProductNew> products;
    }

    public Map<String, List<String>> highValueProductsByCustomer(List<OrderNew> orders, double threshold) {
        Map<String, List<String>> resMap = new HashMap<>();
        for (OrderNew order : orders) {
            resMap.put(order.getCustomerName(), order.getProducts().stream()
                    .filter(productNew -> productNew.getPrice() > threshold)
                    .map(ProductNew::getName)
                    .toList());
        }
        return resMap;
    }
//!!!!!
//Задача 16:
//Каждая школа содержит информацию о своих классах и студентах в этих классах.
//Задача состоит в том, чтобы вычислить средний балл по каждому предмету среди студентов,
//чей средний балл по всем предметам выше определённого порога (например, 8.0 из 10).
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static
    class School {
        private String name;
        private Map<String, List<Student>> studentsByClass;
//        Ключ - название класса
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static
    class Student {
        private String name;
        private List<Subject> subjects;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static
    class Subject {
        private String name;
        private double score;
    }

    public static Map<String, Map<String, Double>> averageScoreBySubjectForTopStudents(List<School> schools) {
        Map<String, Map<String, Double>> resMap = new HashMap<>();
        for (School school : schools) {
            Map<String, Double> resClass = new HashMap<>();
            double avgScore = schools.stream()
                    .flatMap(school1 -> school1.getStudentsByClass().values().stream())
                    .flatMap(Collection::stream)
                    .flatMap(student -> student.getSubjects().stream())
                    .mapToDouble(Subject::getScore)
                    .average()
                    .orElse(0.0);
            school.getStudentsByClass().values().stream()
                    .flatMap(Collection::stream)
                    .filter(student ->
                        student.getSubjects().stream()
                                .mapToDouble(Subject::getScore)
                                .average().orElse(0.0) > avgScore)
                    .forEach(student -> resClass.put(student.getName(),student.getSubjects().stream()
                            .mapToDouble(Subject::getScore)
                            .average().orElse(0.0)));
            resMap.put(school.getName(),resClass);
        }
        return resMap;
    }
}
