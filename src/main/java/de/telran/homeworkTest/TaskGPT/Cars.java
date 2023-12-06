package de.telran.homeworkTest.TaskGPT;

public class Cars {
    public static final int currentYear = 2023;
    public static void main(String[] args) {
        Car[] cars = {
                new Car("Toyota", "Camry", 2022),
                new Car("Honda", "Civic", 2020),
                new Car("Ford", "Mustang", 2021),
                new Car("Chevrolet", "Silverado", 2019),
                new Car("BMW", "X5", 2023)
        };
        displayCars(cars);
    }
    public static int calculateAge(int currentYear, int yearCar){
        return currentYear - yearCar;
    }

    public static void displayCars(Car[] cars) {
        for (Car car : cars) {
            if (calculateAge(currentYear,car.year) == 0){
                System.out.println("Автомобиль "+car.make+" "+car.model + " новый!");
            }else {
                System.out.println("Возраст автомобиля "+car.make+" "+car.model+": " + calculateAge(currentYear,car.year));
            }

            System.out.println("Марка: " + car.make + ", " + "Модель: " + car.model + ", " + "Год: " + car.year + ".");
        }
    }
}
// Создайте класс Car с тремя полями: make (марка автомобиля), model (модель автомобиля) и year (год выпуска).
// Затем создайте массив объектов типа Car и заполните его несколькими автомобилями.
// Напишите метод displayCars, который принимает массив автомобилей в качестве параметра и выводит информацию о каждом автомобиле.
