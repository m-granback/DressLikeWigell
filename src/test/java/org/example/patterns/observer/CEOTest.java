package org.example.patterns.observer;

import org.example.model.clothes.Pants;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CEOTest {

    @Test
    void testPropertyChange() {
        CEO ceoMock = mock(CEO.class);
        Pants pants = new Pants();
        pants.addPropertyChangeListener(ceoMock);
        PropertyChangeEvent pce = new PropertyChangeEvent(pants, "", false, true);
        doNothing().when(ceoMock).propertyChange(pce);
        ceoMock.propertyChange(pce);
        verify(ceoMock, times(1)).propertyChange(pce);
    }
}