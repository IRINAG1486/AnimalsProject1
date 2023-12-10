package org.example;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.



public class Main {


    public static ArrayList<Animals> listDogs = new ArrayList<>();
    public static ArrayList<Animals> listCats = new ArrayList<>();
    public static ArrayList<Animals> listHamsters = new ArrayList<>();
    public static ArrayList<Animals> listHorses = new ArrayList<>();
    public static ArrayList<Animals> listDankeys = new ArrayList<>();
    public static ArrayList<Animals> dogListCommands = new ArrayList<>();
    public static ArrayList<Animals> catListCommands = new ArrayList<>();
    public static ArrayList<Animals> hamsterListCommands = new ArrayList<>();
    public static ArrayList<Animals> horseListCommands = new ArrayList<>();
    public static ArrayList<Animals> dankeyListCommands = new ArrayList<>();
    public static ArrayList<Animals> allAnimals = new ArrayList<>();
    public static ArrayList<Animals> allCommands = new ArrayList<>();

    public static void main(String[] args) {


        Dogs dog = new Dogs(1, "charli", "2121", dogListCommands, "g");
        //listDogs.add(dog);
        dog.addCommand(dogListCommands, "sit");
        dog.addCommand(dogListCommands, "voice");
        dog.showCommands();
        dog.addAnimal(dog);

        Cats cat = new Cats(1, "Lisa", "2222", catListCommands, "h");
        //listDogs.add(dog);
        cat.addCommand(catListCommands, "eat");
        cat.showCommands();
        cat.addAnimal(cat);

        Hamsters hamster = new Hamsters(1, "odri", "5555", hamsterListCommands, "e");
        //listDogs.add(dog);
        hamster.addCommand(hamsterListCommands, "run");
        hamster.showCommands();
        hamster.addAnimal(hamster);

        Horses horse = new Horses(1, "Eva", "4444", horseListCommands, "k");
        //listDogs.add(dog);
        horse.addCommand(dogListCommands, "step");
        horse.showCommands();
        horse.addAnimal(horse);

        Dankeys dankey = new Dankeys(1, "uta", "5553", dankeyListCommands, "c");
        //listDogs.add(dog);
        dankey.addCommand(dogListCommands, "twostep");
        dankey.showCommands();
        dankey.addAnimal(dankey);
//        for (Animals animal : listDogs) {
//            System.out.println(animal.toString());
//        }
//
        allAnimals.addAll(listDogs);
        for (Animals animal : allAnimals) {
            System.out.println(animal.toString());
        }

        allCommands.addAll(dogListCommands);


        //      try {
        while (true) {

            Menu.showMainMenu();
            try (
                Scanner sc = new Scanner(System.in)){
                int i = sc.nextInt();
                switch (i) {
                    case 1:
                        for (Animals animal : allAnimals) {
                            System.out.println(animal.toString());
                        }
                        break;
                    case 2:
                        for (int j = 0; j < allCommands.size(); j++) {
                            System.out.println(allCommands);
                            break;

                        }

                    default:
                        System.out.println("Такого варианта нет, введите число от 0 до 3");
                        break;

                }
            } catch (Exception e) {
                System.out.println("Try one more time");

            }
        }
    }
}









