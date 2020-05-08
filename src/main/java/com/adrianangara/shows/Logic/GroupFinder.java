package com.adrianangara.shows.Logic;

import com.adrianangara.shows.Models.Contestant;

public class GroupFinder {

    public String findGroup(String breed){

        String group = "";

        switch (breed) {
            case "Affenpinscher":
            case "Cavalier King Charles Spaniel":
            case "Maltese":
                group = "Toy";
                break;
            case "Golden Retriever":
            case "Labrador Retriever":
            case "American Water Spaniel":
                group = "Sporting";
                break;
            case "Afghan Hound":
            case "Beagle":
            case "Basset Hound":
                group = "Hound";
                break;
            case "American Eskimo Dog":
            case "Bichon Frise":
            case "French Bulldog":
                group = "Non-Sporting";
                break;
            case "Airedale Terrier":
            case "Australian Terrier":
            case "Border Terrier":
                group = "Terrier";
                break;
            case "Border Collie":
            case "Briard":
            case "German Shepherd Dog":
                group = "Herding";
                break;
            case "Rottweiler":
            case "Saint Bernard":
            case "Boxer":
                group = "Working";
                break;
        }

        return group;

    }
}
