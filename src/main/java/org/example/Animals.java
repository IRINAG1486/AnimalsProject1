package org.example;
import java.util.ArrayList;
public abstract class Animals {
    public int id;
    public String name;
    public String birthdate;

    public static ArrayList commands = new ArrayList<String>();

    private String breed;

    public Animals(int id, String name, String birthdate, ArrayList commands, String breed) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        Animals.commands = commands;
        this.breed = breed;
    }


    public int getId() {
        return id;
    }

    public int setId(int id) {
        return this.id = id;

    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        return this.name = name;

    }

    public String getBirthdate() {
        return birthdate;
    }

    public String setBirthdate() {
        return this.birthdate = birthdate;
    }


    @Override
    public String toString() {
        return String.format("id: %d\nName: %s\nРожден: %s\nКомманды: %s\nПорода: %s", this.id, this.name, this.birthdate, this.commands, this.breed);

    }


    public String getCommands() {
        return commands.toString();
    }

    public void setCommands(String commands) {
        Animals.commands.add(commands);
    }

    public void showCommands() {
        System.out.println(Animals.commands);
    }


    public void addCommand(ArrayList commands, String newCommand) {
//        if (commands.stream().filter(x -> x.equals(newCommand)).findFirst().isEmpty()) {
//            return;
//        }

        commands.add(newCommand);
        for (int i = 0; i < commands.size(); i++) {
            System.out.println(commands);
        }
//        System.out.println(commands);
    }

    public void addAnimal(Animals animal) {
        ArrayList animals = new ArrayList<String>();
        animals.add(animal);
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animal.toString());
        }

    }
}




