package org.example;

import java.util.ArrayList;

public class Horses extends PackAnimals {


    public Horses(int id, String name, String birthdate, ArrayList commands, String breed) {
        super(id, name, birthdate, commands, breed);
    }


    public void showCommands() {
        System.out.println(commands);

    }
}
