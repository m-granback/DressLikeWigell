package org.example.model.clothes;

import org.example.patterns.observer.CEO;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class SkirtTest {

    @Test
    void testAddPropertyChangeListener() {
        CEO ceo = new CEO();
        Skirt skirtMock = mock(Skirt.class);
        doNothing().when(skirtMock).addPropertyChangeListener(ceo);
        skirtMock.addPropertyChangeListener(ceo);
        verify(skirtMock, times(1)).addPropertyChangeListener(ceo);
    }
}