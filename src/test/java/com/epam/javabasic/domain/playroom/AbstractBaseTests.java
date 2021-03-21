package com.epam.javabasic.domain.playroom;

import com.epam.javabasic.domain.playroom.bean.Toy;
import com.epam.javabasic.domain.playroom.constants.GameType;
import com.epam.javabasic.domain.playroom.constants.Gender;
import com.epam.javabasic.domain.playroom.constants.Material;
import com.epam.javabasic.domain.playroom.constants.Size;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractBaseTests {

    private static final String MESSAGE = "Wrong result of method \nactualList : \n%s \nexpectedList \n%s)";

    protected List<Toy> getAllToys() {
        List<Toy> toyList = new ArrayList<>();
        toyList.add(new Toy(1L, "Doll", GameType.STORY, Gender.FEMALE, 6, Size.MEDIUM, Material.PLASTIC, 150));
        toyList.add(new Toy(2L, "Car", GameType.SPORTS, Gender.MALE, 4, Size.SMALL, Material.METAL, 70));
        toyList.add(new Toy(3L, "Car", GameType.SPORTS, Gender.FEMALE, 4, Size.LARGE, Material.METAL, 70));
        toyList.add(new Toy(5L, "Toy kitchen", GameType.STORY, Gender.FEMALE, 7, Size.LARGE, Material.PLASTIC, 1170));
        toyList.add(new Toy(8L, "Car", GameType.SPORTS, Gender.FEMALE, 3, Size.SMALL, Material.PLUSH, 330));
        toyList.add(new Toy(13L, "Bug", GameType.PUZZLES, Gender.MALE, 5, Size.SMALL, Material.WOODEN, 220));
        toyList.add(new Toy(21L, "Car", GameType.SPORTS, Gender.MALE, 4, Size.SMALL, Material.METAL, 70));
        return toyList;
    }

    protected String getErrorMsg(List<Toy> actualListOfToys, List<Toy> expectedListOfToys) {
        return String.format(MESSAGE,
                actualListOfToys.toString(), expectedListOfToys.toString());
    }
}
