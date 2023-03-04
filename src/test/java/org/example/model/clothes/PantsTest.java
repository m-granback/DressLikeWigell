package org.example.model.clothes;

import org.example.patterns.observer.CEO;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class PantsTest {

    @Test
    void testAddPropertyChangeListener() {
        CEO ceo = new CEO();
        Pants pantsMock = mock(Pants.class);
        doNothing().when(pantsMock).addPropertyChangeListener(ceo);
        pantsMock.addPropertyChangeListener(ceo);
        verify(pantsMock, times(1)).addPropertyChangeListener(ceo);
    }
}