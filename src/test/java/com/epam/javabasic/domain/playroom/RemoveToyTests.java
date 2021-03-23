package com.epam.javabasic.domain.playroom;

import com.epam.javabasic.domain.playroom.bean.Toy;
import com.epam.javabasic.domain.playroom.client.IPlayroom;
import com.epam.javabasic.domain.playroom.client.impl.PlayroomBaseClient;
import com.epam.javabasic.domain.playroom.constants.GameType;
import com.epam.javabasic.domain.playroom.constants.Gender;
import com.epam.javabasic.domain.playroom.constants.Material;
import com.epam.javabasic.domain.playroom.constants.Size;
import com.epam.javabasic.domain.playroom.exception.RemoveToyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveToyTests extends AbstractBaseTests {

    @Test
    void shouldRemoveToy() {
        Toy toy = new Toy(5L, "Toy kitchen", GameType.STORY, Gender.FEMALE, 7, Size.LARGE, Material.PLASTIC, 1170);

        Assertions.assertAll("Toy removed successfully!",
                () -> Assertions.assertTrue(playroom.removeToy(toy), "Check return value"),
                () -> Assertions.assertFalse(playroom.getAllToys().contains(toy), "Check that list is not contained removed toy!"));
    }

    @Test
    void shouldThrowExceptionForRemoveToyMethodWhenNullValue() {
        Assertions.assertThrows(RemoveToyException.class, () -> playroom.removeToy(null));
    }
}
