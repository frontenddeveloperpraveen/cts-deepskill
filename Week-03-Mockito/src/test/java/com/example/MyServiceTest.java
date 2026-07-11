package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

public class MyServiceTest {
    @Test
    public void testExternalApi() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");
        MyService service = new MyService(mockApi);
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        verify(mockApi).getData();
    }

    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.process(anyInt())).thenReturn("Matched Process");
        MyService service = new MyService(mockApi);
        assertEquals("Matched Process", service.processValue(42));
        verify(mockApi).process(eq(42));
    }

    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doNothing().when(mockApi).logAction(anyString());
        MyService service = new MyService(mockApi);
        service.doLogging("Hello");
        verify(mockApi).logAction("Hello");
    }

    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData())
            .thenReturn("First Mock Data")
            .thenReturn("Second Mock Data");
        MyService service = new MyService(mockApi);
        assertEquals("First Mock Data", service.fetchData());
        assertEquals("Second Mock Data", service.fetchData());
    }

    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        service.doLogging("Done");
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).logAction("Done");
    }

    @Test
    public void testVoidMethodWithException() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doThrow(new IllegalArgumentException("Error occurred")).when(mockApi).logAction("fail");
        MyService service = new MyService(mockApi);
        assertThrows(IllegalArgumentException.class, () -> service.doLogging("fail"));
    }
}
