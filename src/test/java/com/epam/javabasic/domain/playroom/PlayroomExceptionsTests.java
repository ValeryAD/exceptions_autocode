package com.epam.javabasic.domain.playroom;

import com.epam.javabasic.domain.playroom.bean.Toy;
import com.epam.javabasic.domain.playroom.client.impl.PlayroomBaseClient;
import com.epam.javabasic.domain.playroom.constants.GameType;
import com.epam.javabasic.domain.playroom.constants.Gender;
import com.epam.javabasic.domain.playroom.constants.Material;
import com.epam.javabasic.domain.playroom.constants.Size;
import com.epam.javabasic.domain.playroom.datasource.EndpointReader;
import com.epam.javabasic.domain.playroom.exception.InitializationException;
import com.epam.javabasic.domain.playroom.exception.RemoveToyException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by anton_chyrko on 10/8/20.
 */
class PlayroomExceptionsTests {

    private static final String MESSAGE = "Wrong result of method \nactualList : \n%s \nexpectedList \n%s)";


    //-----------------------getAllToys()--------------------------->>

    @Test
    void shouldReturnAllToys() {
        PlayroomBaseClient playroom = new PlayroomBaseClient(getAllToys());
        List<Toy> actualListOfToys = playroom.getAllToys();
        List<Toy> expectedListOfToys = getAllToys();

        Assertions.assertEquals(actualListOfToys, expectedListOfToys,
                getErrorMsg(actualListOfToys, expectedListOfToys));

        Assertions.assertTrue(Arrays.deepEquals(actualListOfToys.toArray(), expectedListOfToys.toArray()),
                getErrorMsg(actualListOfToys, expectedListOfToys));
    }

    @Test
    void shouldThrowExceptionForGetAllToysMethodWhenNullValue() {
        PlayroomBaseClient playroom = new PlayroomBaseClient(null);
        Assertions.assertThrows(InitializationException.class, playroom::getAllToys);
    }

    //-----------------------getToysByParameter(String parameter, String value)--------------------------->>

    @Test
    void shouldGetToysByParameter() {
        PlayroomBaseClient playroom = new PlayroomBaseClient(getAllToys());
        List<Toy> actualListOfToys = playroom.getToysByParameter("id", "1");
        List<Toy> expectedListOfToys = Collections.singletonList(
                new Toy("Car", GameType.SPORTS, Gender.MALE, 4, Size.SMALL, Material.METAL, 70));

        Assertions.assertTrue(Arrays.deepEquals(actualListOfToys.toArray(), expectedListOfToys.toArray()),
                getErrorMsg(actualListOfToys, expectedListOfToys));
    }

    @Test
    void shouldThrowExceptionForGetToysByParameterMethodWhenNullValue() {
        PlayroomBaseClient playroom = new PlayroomBaseClient(null);
        Assertions.assertThrows(InitializationException.class, () -> playroom.getToysByParameter("id", "1"));
    }

    //-----------------------addToy(Toy toy)-------------------------------->>

    @Test
    void shouldAddToy() {
        PlayroomBaseClient playroom = new PlayroomBaseClient(getAllToys());
        Toy toy = new Toy("Car4", GameType.SPORTS, Gender.FEMALE, 4, Size.SMALL, Material.PLASTIC, 71);
        Assertions.assertAll("Toy removed successfully!",
                () -> Assertions.assertTrue(playroom.addToy(toy), "Check toy added successfully!"),
                () -> Assertions.assertTrue(playroom.getToyList().contains(toy), "Check that list contains added toy!"));
    }

    @Test
    void shouldThrowExceptionForAddToyMethodWhenNullValue() {
        PlayroomBaseClient playroom = new PlayroomBaseClient(null);
        Assertions.assertThrows(InitializationException.class, () -> playroom.addToy(
                new Toy("Car4", GameType.SPORTS, Gender.FEMALE, 4, Size.SMALL, Material.PLASTIC, 71)));
    }

    //-----------------------removeToy(Toy toy)-------------------------------->>

    @Test
    void shouldRemoveToy() {
        PlayroomBaseClient playroom = new PlayroomBaseClient(getAllToys());
        Toy toy = new Toy("Car", GameType.SPORTS, Gender.MALE, 4, Size.SMALL, Material.METAL, 70);

        Assertions.assertAll("Toy removed successfully!",
                () -> Assertions.assertTrue(playroom.removeToy(toy), "Check return value"),
                () -> Assertions.assertFalse(playroom.getToyList().contains(toy), "Check that list is not contained removed toy!"));
    }

    @Test
    void shouldThrowExceptionForRemoveToyMethodWhenNullValue() {
        PlayroomBaseClient playroom = new PlayroomBaseClient(getAllToys());
        Assertions.assertThrows(RemoveToyException.class, () -> playroom.removeToy(null));
    }

    //-----------------------updateToy(Toy toy)-------------------------------->>

    @Test
    void shouldUpdateToy() {
        PlayroomBaseClient playroom = new PlayroomBaseClient(getAllToys());
        Toy toy = new Toy("Car", GameType.SPORTS, Gender.MALE, 4, Size.SMALL, Material.METAL, 70);

        Assertions.assertAll("Toy removed successfully!",
                () -> Assertions.assertTrue(playroom.updateToy("1", toy), "Check return value"),
                () -> Assertions.assertFalse(playroom.getToyList().contains(toy), "Check that list is not contained removed toy!"));
    }

    @Test
    void shouldThrowExceptionForUpdateToyMethodWhenNullValue() {
        PlayroomBaseClient playroom = new PlayroomBaseClient(null);
        Assertions.assertThrows(InitializationException.class, () -> playroom.updateToy("1",
                new Toy("Car", GameType.SPORTS, Gender.MALE, 4, Size.SMALL, Material.METAL, 70)));
    }

    private List<Toy> getAllToys() {
        JsonElement jElement = JsonParser.parseString(EndpointReader.getInstance().getEndpointContent(EndpointReader.Endpoint.TOYS_BASE_TEST));
        Type type = new TypeToken<List<Toy>>() {
        }.getType();
        return new Gson().fromJson(jElement, type);
    }

    private String getErrorMsg(List<Toy> actualListOfToys, List<Toy> expectedListOfToys) {
        return String.format(MESSAGE,
                actualListOfToys.toString(), expectedListOfToys.toString());
    }
}
