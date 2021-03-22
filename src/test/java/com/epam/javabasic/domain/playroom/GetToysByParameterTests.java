package com.epam.javabasic.domain.playroom;

import com.epam.javabasic.domain.playroom.client.IPlayroom;
import com.epam.javabasic.domain.playroom.client.impl.PlayroomBaseClient;
import com.epam.javabasic.domain.playroom.exception.GetToysByParameterException;
import com.epam.javabasic.domain.playroom.exception.InitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetToysByParameterTests extends AbstractBaseTests {

    @Test
    void testGetToysByParameterNoSuchToyExceptionById() {
        Assertions.assertThrows(GetToysByParameterException.class, () -> playroom.getToysByParameter("id", "465"));
    }

    @Test
    void shouldThrowExceptionForGetToysByParameterMethodWhenNullValue() {
        IPlayroom playroom = new PlayroomBaseClient(null);
        Assertions.assertThrows(InitializationException.class, () -> playroom.getToysByParameter("id", "1"));
    }
}
