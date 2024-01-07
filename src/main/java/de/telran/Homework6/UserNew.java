package de.telran.Homework6;

public class UserNew implements Comparable<UserNew> {
    String name;
    int age;

    @Override
    public String toString() {
        return "UserNew{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public UserNew(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(UserNew o) {
        return this.name.compareTo(o.name);
    }
}
