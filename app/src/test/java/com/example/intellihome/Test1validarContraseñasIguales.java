package com.example.intellihome;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import android.content.Context;
import android.widget.DatePicker;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Calendar;

public class Test1validarContraseñasIguales {
    private Validator validator;

    @Mock
    private Context mockContext;
    @Mock
    private DatePicker mockDatePicker;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        validator = new Validator(mockContext);
    }

    @Test
    public void testTarjetaValida() {
        String cardNumber = "1234567890123456";
        String cvv = "123";
        Calendar calendar = Calendar.getInstance();
        when(mockDatePicker.getYear()).thenReturn(calendar.get(Calendar.YEAR) + 1);
        when(mockDatePicker.getMonth()).thenReturn(calendar.get(Calendar.MONTH) + 1);

        boolean isValid = validator.validarTarjeta(cardNumber, cvv, mockDatePicker);
        assertTrue(isValid);
    }

    @Test
    public void testCVV(){
        String cardNumber = "1234567890123456";
        String cvv = "1234565";
        Calendar calendar = Calendar.getInstance();
        when(mockDatePicker.getYear()).thenReturn(calendar.get(Calendar.YEAR) + 1);
        when(mockDatePicker.getMonth()).thenReturn(calendar.get(Calendar.MONTH) + 1);

        boolean isValid = validator.validarTarjeta(cardNumber, cvv, mockDatePicker);
        assertFalse(isValid);
    }

    @Test
    public void testDigitosTarjeta(){
        String cardNumber = "1234567890123456789";
        String cvv = "357";
        Calendar calendar = Calendar.getInstance();
        when(mockDatePicker.getYear()).thenReturn(calendar.get(Calendar.YEAR) + 1);
        when(mockDatePicker.getMonth()).thenReturn(calendar.get(Calendar.MONTH) + 1);

        boolean isValid = validator.validarTarjeta(cardNumber, cvv, mockDatePicker);
        assertFalse(isValid);
    }

}



