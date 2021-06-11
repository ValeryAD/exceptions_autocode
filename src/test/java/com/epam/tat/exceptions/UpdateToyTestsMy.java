package com.epam.tat.exceptions;

import com.epam.tat.exceptions.bean.Toy;
import com.epam.tat.exceptions.client.IPlayroom;
import com.epam.tat.exceptions.client.impl.PlayroomBaseClient;
import com.epam.tat.exceptions.constants.GameType;
import com.epam.tat.exceptions.constants.Gender;
import com.epam.tat.exceptions.constants.Material;
import com.epam.tat.exceptions.constants.Size;
import com.epam.tat.exceptions.exception.InitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UpdateToyTestsMy extends AbstractBaseTests{
    long id = 1L;

    @Test
    void shouldUpdateToy() {
        Toy replacementToy = new Toy("Car", GameType.SPORTS, Gender.MALE, 4, Size.SMALL, Material.METAL, 70);
        Toy toyToBeReplaced = playroom.getAllToys().stream().filter(tempToy -> tempToy.getId() == id).findFirst().get();

        Assertions.assertAll("Toy updated successfully!",
                () -> Assertions.assertTrue(playroom.updateToy(id, replacementToy), "Check return value"),
                () -> Assertions.assertFalse(playroom.getAllToys().contains(toyToBeReplaced), "Check that list doesn't contain toy that should have been replaced"),
                () -> Assertions.assertTrue(playroom.getAllToys().contains(replacementToy), "Check that list contains replacement toy!"));
    }

    @Test
    void shouldThrowExceptionForUpdateToyMethodWhenNullValue() {
        IPlayroom playroom = new PlayroomBaseClient(null);
        Toy toy = new Toy("Car", GameType.SPORTS, Gender.MALE, 4, Size.SMALL, Material.METAL, 70);
        Assertions.assertThrows(InitializationException.class, () -> playroom.updateToy(id,toy));
    }
}
