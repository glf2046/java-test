package super_bound;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guff
 * @since 2019-06-3:07 PM
 */
public class GenericsTester {

    //catList's element type are super types of Cat, so adding Cat or subtypes of Cat is ok.
    public static void addCat(List<? super Cat> catList) {
        catList.add(new Cat());
        System.out.println("Cat Added");
    }

    //catList's element type are sub types of cat, so can't really determine what type can be added, even for Object type.
    public static void addCat2(List<? extends Cat> catList) {
//        catList.add(new RedCat());
        System.out.println("Cat Added");
    }

    public static void main(String[] args) {

        List<? super Cat> list = new ArrayList<>();
        list.add(new RedCat());

        List<Animal> animalList = new ArrayList<Animal>();
        List<Cat> catList = new ArrayList<Cat>();
        List<RedCat> redCatList = new ArrayList<RedCat>();
        List<Dog> dogList = new ArrayList<Dog>();

        //add list of super class Animal of Cat class
        addCat(animalList);

        //add list of Cat class
        addCat(catList);

        //compile time error
        //can not add list of subclass RedCat of Cat class
        //addCat(redCatList);

        //compile time error
        //can not add list of subclass Dog of Superclass Animal of Cat class
        //addCat.addMethod(dogList);
    }
}

class Animal {
}

class Cat extends Animal {
}

class RedCat extends Cat {
}

class Dog extends Animal {
}
