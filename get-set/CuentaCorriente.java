import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class CuentaCorriente {
    // --- Clase Usuario ---

    static class Usuario {
        private String titular;
        private long numero_cuenta;
        private double saldo;

        public Usuario(String titular, double saldo) {
            this.titular = titular;
            this.saldo = saldo;
            Random aleatorio = new Random();
            this.numero_cuenta = Math.abs(aleatorio.nextLong());
        }

        public static void setRetiros(Usuario cliente, double cantidad) {
            cliente.saldo -= cantidad;
        }

        public static void setTransferencia(Usuario titu1, Usuario titu2, double cantidad) {
            titu1.saldo -= cantidad;
            titu2.saldo += cantidad;
        }

        public String getRetiros() {
            return "Titular: " + titular + " Saldo actual: " + saldo;
        }

        public String getDatosCuenta() {
            return "Titular: " + titular + " Número de cuenta: " + numero_cuenta + " Saldo: " + saldo;
        }

        // Método creativo: calcular saldo futuro con interés compuesto
        public double calcularSaldoFuturo(double tasaInteresAnual, int meses) {
            double tasaMensual = tasaInteresAnual / 12 / 100;
            return saldo * Math.pow(1 + tasaMensual, meses);
        }
    }
    public static void main(String[] args) {
        double monto;
        Scanner scn = new Scanner (System.in);

        Usuario cuenta1 = new Usuario("JuanPerez", 22000);
        System.out.println(cuenta1.getDatosCuenta());
        System.out.println("*********************************");

        Usuario cuenta2 = new Usuario("MariaLopez", 25000);
        System.out.println(cuenta2.getDatosCuenta());
        System.out.println("*********************************");

System.out.println("¿Qué operación desea realizar? \n\tA - Consultar datos de cuenta \n\tB - Retiros \n\tT - Transferencias");
String seleccion = scn.nextLine();

// toUpperCase para que ignore minúscula y mayúscula
switch (seleccion.toUpperCase()) {
    case "A":
        // ver datos de cuentas
        System.out.println("Seleccione una cuenta:");
        int cuen = scn.nextInt();
        switch (cuen) {
            case 1:
                System.out.println(cuenta1.getDatosCuenta());
                break;
            case 2:
                System.out.println(cuenta2.getDatosCuenta());
                break;
            default:
                System.out.println("No existe esa cuenta.");
                break;
        }
        break;

    case "B":
        // retirar montos de dinero de una cuenta
        System.out.println("Seleccione una cuenta:");
        cuen = scn.nextInt();
        switch (cuen) {
            case 1:
                System.out.print("Retiros: Ingrese el monto a retirar: ");
                monto = scn.nextDouble();
                Usuario.setRetiros(cuenta1, monto);
                System.out.println(cuenta1.getDatosCuenta());
                break;
            case 2:
                System.out.print("Retiros: Ingrese el monto a retirar: ");
                monto = scn.nextDouble();
                Usuario.setRetiros(cuenta2, monto);
                System.out.println(cuenta2.getDatosCuenta());
                break;
            default:
                System.out.println("Nada."); // El texto original dice "Nada"
                break;
        }
        break;

    case "T":
        // Transferencia
        System.out.print("Ingrese monto a transferir: ");
        monto = scn.nextDouble();
        // Asumo que la transferencia es de cuenta1 a cuenta2, como en el ejemplo
        Usuario.setTransferencia(cuenta1, cuenta2, monto);
        System.out.println(cuenta1.getDatosCuenta());
        System.out.println(cuenta2.getDatosCuenta());
        break;

    default:
        System.out.println("Operación no reconocida.");
        break;
}
    }

}