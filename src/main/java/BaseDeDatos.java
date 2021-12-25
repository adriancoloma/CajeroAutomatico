public class BaseDeDatos {
    private static final BaseDeDatos instance = new BaseDeDatos();

    public static BaseDeDatos getInstance() {
        return instance;
    }

    private Cuenta[] cuentas;

    public BaseDeDatos(){
        cuentas = new Cuenta[3];
        cuentas[0] = new Cuenta(1, 1234, 200, 300);
        cuentas[1] = new Cuenta(2, 5678, 500, 600);
        cuentas[2] = new Cuenta(3, 4321, 1000, 1100);
    }

    public BaseDeDatos(Cuenta[] cuentas){
        this.cuentas = cuentas;
    }
    public boolean autenticarUsuario(int numeroCuenta, int pin){
        for(Cuenta a: cuentas) {
            if(a.getNumCuenta() ==  numeroCuenta) {
                return a.validarPin(pin);
            }
        }
        return false;
    }

    public double getDineroDisponible(int numeroCuenta){
        if (buscarCuenta(numeroCuenta) != null) {
            return buscarCuenta(numeroCuenta).getSaldoTotal();
        }
        return -1;
    }

    public double getSaldoTotal(int numeroCuenta){
        if (buscarCuenta(numeroCuenta) != null) {
            return buscarCuenta(numeroCuenta).getSaldoTotal();
        }
        return -1;
    }

    public void retirarDinero(int numeroCuenta, double cantidad){

    }
    private Cuenta buscarCuenta(int numeroCuenta){
        Cuenta cuenta;
        for(Cuenta miCuenta: cuentas) {
            if (miCuenta.getNumCuenta() == numeroCuenta) {
                cuenta = miCuenta;
                return cuenta;
            }
        }
        cuenta = null;
        return cuenta;
    }
}
