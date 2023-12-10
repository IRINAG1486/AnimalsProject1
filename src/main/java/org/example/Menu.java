package org.example;
import java.util.ArrayList;
import java.util.Scanner;
public class Menu {

    static Scanner scanner = new Scanner(System.in);

    // Метод, показывающий главное меню программы
    public static void showMainMenu() {
        System.out.println("Введите цифру необходимого действия: \n" +
                "1. Показать всех животных\n" +
                "2. Показать вписок комманд");
    }


//    public static void printOnlyThisClass(Farm<Animal> animalFarm) {
//        System.out.println("Выберите вид животных: \n" +
//                "1. Домашние\n" +
//                "2. Вьючные");
//        int userSelectedClass = scanner.nextInt();
//
//        switch (userSelectedClass) {
//            case 1:
//                animalFarm.printOnlyThisClass(1);
//                break;
//            case 2:
//                animalFarm.printOnlyThisClass(2);
//                break;
//        }
//    }

//    public static void typeOfAnimals(){
//        System.out.println("Выберите вид животного: \n" +
//                "1. Собаки\n" +
//                "2. Кошки\n" +
//                "3. Хомячки\n" +
//                "4. Лошади\n" +
//                "5. Ослики");
//        int userSelectedClass = scanner.nextInt();
//
//        switch (userSelectedClass) {
//            int userSelected;
//            case 1:
//                System.out.println("Выберите команду для данного типа животного: \n" +
//                        "1. Посмотреть информацию о животном\n" +
//                        "2. Добавить новую команду\n" +
//                        "3. Добавить новое животное\n");
//                userSelected = scanner.nextInt();
//                switch (userSelected) {
//                    case 1:
//                        ArrayList commands = new ArrayList<String>();
//                        Dogs.showCommands(commands);
//                        break;
//                    case 2:
//
//                        break;
//                    case 3:
//                        Hamster.Comands();
//                        break;
//                }
//                break;
//            case 2:
//                System.out.println("Выберите вид животных: \n" +
//                        "1. Посмотреть информацию о животном\n" +
//                        "2. Добавить новую команду\n" +
//                        "3. Добавить новое животное\n");
//                userSelected = scanner.nextInt();
//                switch (userSelected) {
//                    case 1:
//                        Camel.Comands();
//                        break;
//                    case 2:
//                        Donkey.Comands();
//                        break;
//                    case 3:
//                        Horse.Comands();
//                        break;
//                }
//                break;
//        }
//
//    }
//
//    public static void newComand(){
//
//
//    }
//
//    public static void newAnimal(){
//
//    }

}
