package com.adrianangara.shows.Logic;

import com.adrianangara.shows.Models.Contestant;

public class GroupFinder {

    public Contestant findGroup(Contestant con){

        switch (con.breed) {
            case "Affenpinscher":
            case "Cavalier King Charles Spaniel":
            case "Maltese":
                con.group = "Toy";
                break;
            case "Golden Retriever":
            case "Labrador Retriever":
            case "American Water Spaniel":
                con.group = "Sporting";
                break;
            case "Afghan Hound":
            case "Beagle":
            case "Basset Hound":
                con.group = "Hound";
                break;
            case "American Eskimo Dog":
            case "Bichon Frise":
            case "French Bulldog":
                con.group = "Non-Sporting";
                break;
            case "Airedale Terrier":
            case "Australian Terrier":
            case "Border Terrier":
                con.group = "Terrier";
                break;
            case "Border Collie":
            case "Briard":
            case "German Shepherd Dog":
                con.group = "Herding";
                break;
            case "Rottweiler":
            case "Saint Bernard":
            case "Boxer":
                con.group = "Working";
                break;
        }

        return con;

    }
}
