package com.adrianangara.shows.Logic;


import com.adrianangara.shows.Enum.Firstname;
import com.adrianangara.shows.Enum.Lastname;
import com.adrianangara.shows.Models.User;

public class GenerateUser {

    public User generateUser() {

        //Define needed parameters
        String email = "";
        String firstname = "";
        String lastname = "";
        String password = "";

        //Generate Random First Name
        int rn1 = (int)Math.floor(Math.random() * 16) + 1;
        for(Firstname n: Firstname.values()) {
            if(rn1 == n.getID()) {
                firstname = n.printFirstName();
                break;
            }
        }

        //Generate Random Last Name
        int rn2 = (int)Math.floor(Math.random() * 16) + 1;
        for(Lastname n: Lastname.values()) {
            if(rn2 == n.getID()) {
                lastname = n.printLastName();
                break;
            }
        }

        //Generate email
        email = firstname + "." + lastname + "@gmail.com";

        return new User(0, email, firstname, lastname, password);

    }

}
