package com.epam.tat.exceptions;

import com.epam.tat.exceptions.client.IPlayroom;
import com.epam.tat.exceptions.client.impl.PlayroomBaseClient;
import com.epam.tat.exceptions.exception.GetToysByParameterException;
import com.epam.tat.exceptions.exception.InitializationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetToysByParameterTests extends AbstractBaseTests {

    @Test
    void shouldNotThrowExceptionDueToNoSuchId() {
        Assertions.assertTrue(playroom.getToysByParameter("id", "465").isEmpty());
    }

    @Test
    void shouldThrowExceptionForGetToysByParameterMethodWhenNullValue() {
        IPlayroom playroom = new PlayroomBaseClient(null);
        Assertions.assertThrows(InitializationException.class, () -> playroom.getToysByParameter("id", "1"));
    }
}
