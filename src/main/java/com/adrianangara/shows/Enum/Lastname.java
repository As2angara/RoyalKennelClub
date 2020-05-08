package com.adrianangara.shows.Enum;

public enum Lastname {

    JOHNSON("Johnson", 1),
    JEFFERSON("Jefferson", 2),
    CHRISTENSON("Christenson", 3),
    JOSEPHSON("Josephson", 4),
    JO("Jo", 5),
    JUSTICE("Justice", 6),
    ADAMSON("Adamson", 7),
    GEORGETOWN("Georgetown", 8),
    WAHAKA("Wahaka", 9),
    LOVE("Love", 10),
    FRANKSON("Frankson", 11),
    GREED("Greed", 12),
    SANTOS("Santos", 13),
    DOM("Dom", 14),
    EVENTHANDLER("Eventhandler", 15),
    SPRINGIOC("Springioc", 16);

    private final String lastname;
    private final int id;

    //constructor
    private Lastname(String lastname, int id) {
        this.lastname = lastname;
        this.id = id;
    }

    //other methods
    public String printLastName() {
        return lastname;
    }

    public int getID() {
        return id;
    }
}
