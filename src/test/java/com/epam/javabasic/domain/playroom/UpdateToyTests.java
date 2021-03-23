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

class UpdateToyTests extends AbstractBaseTests {

    @Test
    void shouldUpdateToy() {
        Toy toy = new Toy("Car", GameType.SPORTS, Gender.MALE, 4, Size.SMALL, Material.METAL, 70);

        Assertions.assertAll("Toy updated successfully!",
                () -> Assertions.assertTrue(playroom.updateToy(1L, toy), "Check return value"),
                () -> Assertions.assertFalse(playroom.getAllToys().contains(toy), "Check that list is not contained removed toy!"));
    }

    @Test
    void shouldThrowExceptionForUpdateToyMethodWhenNullValue() {
        IPlayroom playroom = new PlayroomBaseClient(null);
        Toy toy = new Toy("Car", GameType.SPORTS, Gender.MALE, 4, Size.SMALL, Material.METAL, 70);
        Assertions.assertThrows(InitializationException.class, () -> playroom.updateToy(1L,toy));
    }
}
