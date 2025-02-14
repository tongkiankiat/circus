package circus;

import circus.animal.Animal;
import circus.animal.Duck;
import circus.animal.Parrot;
import circus.animal.Tiger;
import circus.animal.Elephant;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void printAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        System.out.println("Number of animals: " + animals.length);
//        makeAnimalsTalk();
//        System.out.println("Total value of animals " + calculateAssetValue(animals));
//        System.out.println("Total value of equipments " + calculateAssetValue(equipments));
//         This won't work as the animals is of fixed size
//        animals[3] = new Elephant("Strong One");
//        System.out.println("Number of animals: " + animals.length);

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));

        // Substitutability allows us to add specific animals to the "Animal" array list
        Parrot perry = new Parrot("Perry");
        animalArrayList.add(perry);
        animalArrayList.add(new Elephant("Brute"));
        Duck andy =  new Duck("Andy");
        animalArrayList.add(andy);

        System.out.println("Size of ArrayList: " + animalArrayList.size());

        System.out.println("Perry is in position: " + animalArrayList.indexOf(perry));

        System.out.println("Before sorting");
        printAnimals(animalArrayList);
        System.out.println("Size of ArrayList: " + animalArrayList.size());

        animalArrayList.sort(Animal.AnimalNameComparator);

        System.out.println("After sorting");
        printAnimals(animalArrayList);
        System.out.println("Size of ArrayList: " + animalArrayList.size());
    }
}
