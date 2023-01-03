package challenges;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Sigma {


    @Test
    public void question1() {
        HashSet<Cat> cats = new HashSet<Cat>();
        cats.add(new Cat("Snow", 5));
        cats.add(new Cat("Little", 1));
        cats.add(new Cat("Snow", 5));
        System.out.println(cats.size());
    }

    // It would print: 3 (integer)

    @Test
    public void question2() {
        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.stream().filter(s -> {System.out.println(s); return true;}).forEach(s -> System.out.println("forEach: " + s));;
    }

    // Nothing would be printed here, because a stream is only executed when its terminal operation is called, in this example there is no terminal operation
    // A terminal operation could be .anyMatch() or .collect() or .min() and so on..

    public void question3() {
        //Cat cat = new Cat();
        //ystem.out.println(cat.name);
    }

    //Compile time error, because the class Animal (in its constructor) needs one parameter to be initialized, as Cat extends animal it must initialize the super class.
    //In this case, Cat implementation is wrong, it should initialize its super class (Animal) in the constructor;

    public static class Cat {
        public String name;
        public Integer age;
        public Cat(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

    }

    public static class Cat2 extends Animal {


        public Cat2() {
            super("Unnamed cat");
        }

        public Cat2(String name) {
            super(name);
        }
    }

    public static class Animal {
        public String name;
        public Animal(String name) {
            this.name = name;
        }

    }

}
