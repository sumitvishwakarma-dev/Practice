import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class ParentChildGeneric {
    void main(){

        Dog [] dogs = new Dog[20];
        Animal[] animals = dogs;
        animals[0] =  new Dog();
        animals[1] =  new Dog();
        animals[2] =  new Dog();
        // animals[3] =  new Animal();  //ArrayStoreException

        for(Animal animal1 : animals){
            if(animal1 == null){
                continue;
            }
            animal1.eat();
        }

        //Correct Way to use Generics if you don't know what going to be pass

        List<Dog> dogList = new ArrayList<>();
        List<Animal> animalList=new ArrayList<>();

        System.out.println("Accessing through Animal ::::");


        animalList.add(new Animal());
        animalList.add(new Animal());


        print(animalList);

        System.out.println("Accessing through Dog ::::");
        dogList.add(new Dog());
        dogList.add(new Dog());
        dogList.add(new Dog());

        print(dogList);


        System.out.println("\nWith Super to allow adding values ::::\n");
        List<Animal> animalSuperList=new ArrayList<>();
        printWithSuper(animalSuperList);

        //List<Integer> intList =new ArrayList<>();
        //print(intList);             // Not allowing because in print method we are allowing only Animal and its sub type


    }
    static void print(List<? extends Animal> animalInPara){
        for(Animal animal: animalInPara){
            animal.eat();
            animal.walk();

        }
    }

    public static void printWithSuper(List<? super Animal> animal){

        animal.add(new Animal());
        animal.add(new Animal());
        animal.add(new Dog());
        animal.add(new Cat());
        animal.add(new Labrador());
        for(Object obj : animal){
            Animal a = (Animal) obj;
            a.eat();
        }
    }

}
class Animal{
    public void eat(){
        System.out.println("Animal is Eating");
    }

    public  void walk(){
        System.out.println("Animal is Walking");
    }
}
class Dog extends Animal{
    @Override
    public void eat(){
        System.out.println("Dog is Eating");
    }


    public void bark(){
        System.out.println("Barking");
    }
}

class Cat extends Animal{
    @Override
    public void eat(){
        System.out.println("cat is Eating");
    }


    public void miaoo(){
        System.out.println("Miaoo");
    }
}

class Labrador extends Dog{
    @Override
    public void eat(){
        System.out.println("Labrador is Eating");
    }

    @Override
    public void bark(){
        System.out.println("Ladrador is Barking");
    }
}
