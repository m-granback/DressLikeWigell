package org.example.model.wigellStore;

import org.example.model.Customer;
import org.example.model.clothes.Pants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class ReceiptTest {

    @Test
    void testShowReceipt() {
        Customer customer = new Customer();
        customer.setId(1);
        Order order = new Order(1, customer);
        order.addToOrder(new Pants());
        order.setCustomerId(1);
        Receipt receiptMock = mock(Receipt.class);
        doNothing().when(receiptMock).showReceipt(order,customer);
        receiptMock.showReceipt(order, customer);
        verify(receiptMock, times(1)).showReceipt(order, customer);
    }
}