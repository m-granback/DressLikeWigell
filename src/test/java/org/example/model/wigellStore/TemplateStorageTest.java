package org.example.model.wigellStore;

import org.example.model.clothes.Pants;
import org.example.patterns.observer.CEO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class TemplateStorageTest {

    @Test
    void addToTemplates() {
        Pants pants = new Pants();
        TemplateStorage templateStorageMock = mock(TemplateStorage.class);
        doNothing().when(templateStorageMock).addToTemplates(pants);
        verify(templateStorageMock, times(1)).addToTemplates(pants);
    }

}