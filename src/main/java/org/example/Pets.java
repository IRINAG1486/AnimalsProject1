package org.example;

import java.util.ArrayList;

public abstract class Pets extends Animals {

    public Pets(int id, String name, String birthdate, ArrayList commands, String breed) {
        super(id, name, birthdate, commands, breed);
    }
}
