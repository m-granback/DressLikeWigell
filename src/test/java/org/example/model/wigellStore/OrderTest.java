package org.example.model.wigellStore;

import org.example.model.clothes.Pants;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class OrderTest {

    @Test
    void testAddToOrder() {
        Pants pants = new Pants();
        Order orderMock = mock(Order.class);
        doNothing().when(orderMock).addToOrder(pants);
        orderMock.addToOrder(pants);
        verify(orderMock, times(1)).addToOrder(pants);
    }

}