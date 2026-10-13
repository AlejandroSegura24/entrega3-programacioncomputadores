import java.util.Scanner;

public class Eje_2_Validador_Contrasena {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una contraseña: ");
        String password = scanner.nextLine();

        if (esSegura(password)) {
            System.out.println("La contraseña es segura");
        } else {
            System.out.println("La contraseña NO es segura. Debe tener al menos 10 caracteres, una minúscula, una mayúscula, un número y un símbolo.");
        }

        scanner.close();
    }

    public static boolean esSegura(String pass) {
        if (pass == null) {
            return false;
        }
        pass = pass.trim();

        // Validar longitud
        if (pass.length() < 10) {
            return false;
        }

        // Validar los requisitos
        boolean tieneMinuscula = false;
        boolean tieneMayuscula = false;
        boolean tieneDigito = false;
        boolean tieneSimbolo = false;

        // Validar caracteres
        for (int i = 0; i < pass.length(); i++) {
            char caracterActual = pass.charAt(i);

            if (Character.isLowerCase(caracterActual)) {
                tieneMinuscula = true;
            } else if (Character.isUpperCase(caracterActual)) {
                tieneMayuscula = true;
            } else if (Character.isDigit(caracterActual)) {
                tieneDigito = true;
            } else {
                tieneSimbolo = true; // Si no es letra ni dígito, es un símbolo
            }
        }

        // Si todas las reglas son correctas el resultado es true
        return tieneMinuscula && tieneMayuscula && tieneDigito && tieneSimbolo;
    }
}