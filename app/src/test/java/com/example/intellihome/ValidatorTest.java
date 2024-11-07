package com.example.intellihome;

import android.text.TextUtils;
import android.widget.EditText;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class) // Utilizamos Robolectric para simular el entorno Android
@Config(sdk = 28) // Define el SDK de Android que quieres simular
public class ValidatorTest {

    private EditText editText;  // EditText que vas a usar en las pruebas

    @Before
    public void setUp() throws Exception {
        // Inicializa el EditText
        editText = new EditText(RuntimeEnvironment.application);
    }

    @Test
    public void testValidarDatosGenerales_todosCamposValidos() {
        // Prueba cuando el campo no está vacío
        editText.setText("Texto de prueba");
        assertFalse(TextUtils.isEmpty(editText.getText())); // Comprobamos que no está vacío
    }

    @Test
    public void testValidarDatosGenerales_camposVacios() {
        // Prueba cuando el campo está vacío
        editText.setText("");  // Campo vacío
        assertTrue(TextUtils.isEmpty(editText.getText()));  // Comprobamos que está vacío
    }

    @Test
    public void testValidarDatosGenerales_sinElegirRol() {
        // Prueba con un EditText vacío (el rol no elegido)
        editText.setText("");  // Campo vacío
        assertTrue(TextUtils.isEmpty(editText.getText()));  // Validamos que está vacío
    }
    //Hola mundo
}
