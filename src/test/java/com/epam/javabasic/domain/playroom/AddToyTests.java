package com.epam.javabasic.domain.playroom;

import com.epam.javabasic.domain.playroom.bean.Toy;
import com.epam.javabasic.domain.playroom.client.IPlayroom;
import com.epam.javabasic.domain.playroom.client.impl.PlayroomBaseClient;
import com.epam.javabasic.domain.playroom.constants.GameType;
import com.epam.javabasic.domain.playroom.constants.Gender;
import com.epam.javabasic.domain.playroom.constants.Material;
import com.epam.javabasic.domain.playroom.constants.Size;
import com.epam.javabasic.domain.playroom.exception.InitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddToyTests extends AbstractBaseTests {

    @Test
    void shouldAddToy() {
        Toy toy = new Toy(4L, "Car4", GameType.SPORTS, Gender.FEMALE, 4, Size.SMALL, Material.PLASTIC, 71);
        Assertions.assertAll("Toy added successfully!",
                () -> Assertions.assertTrue(playroom.addToy(toy), "Check toy added successfully!"),
                () -> Assertions.assertTrue(playroom.getAllToys().contains(toy), "Check that list contains added toy!"));
    }

    @Test
    void shouldThrowExceptionForAddToyMethodWhenNullValue() {
        IPlayroom playroom = new PlayroomBaseClient(null);
        Toy toy = new Toy(4L, "Car4", GameType.SPORTS, Gender.FEMALE, 4, Size.SMALL, Material.PLASTIC, 71);
        Assertions.assertThrows(InitializationException.class, () -> playroom.addToy(toy));
    }
}
