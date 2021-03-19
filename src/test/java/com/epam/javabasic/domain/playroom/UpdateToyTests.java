package com.epam.javabasic.domain.playroom;

import com.epam.javabasic.domain.playroom.bean.Toy;
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
        PlayroomBaseClient playroom = new PlayroomBaseClient(getAllToys());
        Toy toy = new Toy("Car", GameType.SPORTS, Gender.MALE, 4, Size.SMALL, Material.METAL, 70);

        Assertions.assertAll("Toy updated successfully!",
                () -> Assertions.assertTrue(playroom.updateToy(1L, toy), "Check return value"),
                () -> Assertions.assertFalse(playroom.getToyList().contains(toy), "Check that list is not contained removed toy!"));
    }

    @Test
    void shouldThrowExceptionForUpdateToyMethodWhenNullValue() {
        PlayroomBaseClient playroom = new PlayroomBaseClient(null);
        Assertions.assertThrows(InitializationException.class, () -> playroom.updateToy(1L,
                new Toy("Car", GameType.SPORTS, Gender.MALE, 4, Size.SMALL, Material.METAL, 70)));
    }
}
