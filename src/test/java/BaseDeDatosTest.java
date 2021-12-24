import org.mockito.Mockito;

import static org.junit.Assert.*;

public class BaseDeDatosTest {

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
}