package org.example.model.clothes;

import org.example.patterns.observer.CEO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class TShirtTest {

    @Test
    void addPropertyChangeListener() {
        CEO ceo = new CEO();
        TShirt tShirtMock = mock(TShirt.class);
        doNothing().when(tShirtMock).addPropertyChangeListener(ceo);
        tShirtMock.addPropertyChangeListener(ceo);
        verify(tShirtMock, times(1)).addPropertyChangeListener(ceo);
    }
}