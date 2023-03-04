package org.example.controller;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ControllerTest {

    @Test
    void testRun() {
        Controller controllerMock = mock(Controller.class);
        doNothing().when(controllerMock).run();
        controllerMock.run();
        verify(controllerMock, times(1)).run();

    }

    @Test
    void testNewCustomerOrder() {
        Controller controllerMock = mock(Controller.class);
        doNothing().when(controllerMock).newCustomerOrder();
        controllerMock.newCustomerOrder();
        verify(controllerMock, times(1)).newCustomerOrder();
    }
}