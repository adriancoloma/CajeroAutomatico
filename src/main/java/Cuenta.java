public class Cuenta {
    private int numeroCuenta;
    private int pin;
    private double saldoDisponible;
    private double saldoTotal;

    public Cuenta(int numeroCuenta, int pin, double saldoDisponible, double saldoTotal) {
        super();
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.saldoDisponible = saldoDisponible;
        this.saldoTotal = saldoTotal;
    }

    public boolean validarPin(int pin) {
        return this.pin == pin;
    }

    public void retirarDinero(double cantidad) {
        this.saldoDisponible = this.saldoDisponible - cantidad;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public int getNumCuenta() {
        return numeroCuenta;
    }
}