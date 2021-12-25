import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BaseDeDatosTest {

    @Parameterized.Parameters
    public static List<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
                {1, 200},
                {2, 500},
                {3, 1000}
        });
    }
    @org.junit.Test
    public void when_user_authenticated_return_ok() {
        Cuenta[] cuentas = new Cuenta[1];
        Cuenta cuentaMock = Mockito.mock(Cuenta.class);
        cuentas[0] = cuentaMock;
        Mockito.when(cuentaMock.validarPin(Mockito.anyInt())).thenReturn(true);
        Mockito.when(cuentaMock.getNumCuenta()).thenReturn(1);
        BaseDeDatos baseDatos = new BaseDeDatos(cuentas);
        boolean actual = baseDatos.autenticarUsuario(1, 1234);
        assertTrue(actual);
    }

    @org.junit.Test
    public void get_int_SaldoTotal_with_numCount() {
        Cuenta cuentaMock = Mockito.mock(Cuenta.class);
        double expected = 100.0;
        Mockito.when(cuentaMock.getSaldoTotal()).thenReturn(expected);
        Mockito.when(cuentaMock.getNumCuenta()).thenReturn(1);
        BaseDeDatos baseDatos = new BaseDeDatos(new Cuenta[]{cuentaMock});
        double actual = baseDatos.getSaldoTotal(1);
        assertEquals(expected, actual, 0);

    }
}