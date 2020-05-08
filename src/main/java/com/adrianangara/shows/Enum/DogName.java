package com.adrianangara.shows.Enum;

public enum DogName {

    MAX("Max", true, 1),
    CHARLIE("Charlie", true, 2),
    COOPER("Cooper", true, 3),
    BUDDY("Buddy", true, 4),
    JACK("Jack", true, 5),
    ROCKY("Rocky", true, 6),
    OLLY("Olly", true, 7),
    BEAR("Bear", true, 8),
    DUKE("Duke", true, 9),
    BELLA("Bella", false, 10),
    LUCY("Lucy", false, 11),
    DAISY("Daisy", false, 12),
    LUNA("Luna", false, 13),
    LOLA("Lola", false, 14),
    SADIE("Sadie", false, 15),
    MOLLY("Molly", false, 16),
    MAGGIE("Maggie", false, 17),
    BAILEY("Bailey", false, 18);

    private final String name;
    private final boolean isMale;
    private final int id;

    //constructor
    private DogName(String name, boolean isMale, int id) {
        this.name = name;
        this.isMale = isMale;
        this.id = id;
    }

    //other methods
    public String printDogName() {
        return name;
    }

    public boolean printGender() {
        return isMale;
    }

    public int getID() {
        return id;
    }
}
