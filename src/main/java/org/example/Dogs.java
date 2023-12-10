package org.example;

import java.util.ArrayList;

public class Dogs extends Pets{



    public Dogs(int id, String name, String birthdate, ArrayList commands, String breed) {
        super(id, name, birthdate,commands, breed);
    }



    public void showCommands(){
        System.out.println(commands);

    }



}
