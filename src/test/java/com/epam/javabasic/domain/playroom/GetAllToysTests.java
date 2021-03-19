package com.epam.javabasic.domain.playroom;

import com.epam.javabasic.domain.playroom.bean.Toy;
import com.epam.javabasic.domain.playroom.client.impl.PlayroomBaseClient;
import com.epam.javabasic.domain.playroom.exception.InitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class GetAllToysTests extends AbstractBaseTests {

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
}
