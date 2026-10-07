import java.util.Scanner;

public class Ejercicios {

    // =========================== EJERCICIO 2: CONTRASEÑA SEGURA ===========================

    /**
     * Decide si una contraseña es segura. Debe cumplir todo lo siguiente:
     *  - Longitud mayor o igual a 10
     *  - Al menos una letra (A-Z, a-z)
     *  - Al menos un dígito (0-9)
     *  - Al menos un símbolo (cualquier carácter que no sea letra ni dígito)
     */
    public static boolean esContrasenaSegura(String contrasena) {
        // Regla 1: longitud mínima de 10 caracteres
        if (contrasena.length() < 10) {
            return false;
        }

        // Banderas que se activan cuando encontramos cada tipo de carácter
        boolean tieneLetra = false;
        boolean tieneDigito = false;
        boolean tieneSimbolo = false;

        // Recorremos la cadena carácter por carácter
        for (int i = 0; i < contrasena.length(); i++) {
            char c = contrasena.charAt(i);

            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                tieneLetra = true;      // es una letra
            } else if (c >= '0' && c <= '9') {
                tieneDigito = true;     // es un dígito
            } else {
                tieneSimbolo = true;    // no es letra ni dígito: es símbolo
            }
        }

        // La contraseña es segura solo si las tres banderas son verdaderas
        return tieneLetra && tieneDigito && tieneSimbolo;
    }

    public static void ejercicio2(Scanner entrada) {
        System.out.println("=== EJERCICIO 2: CONTRASEÑA SEGURA ===");
        System.out.print("Ingrese la contraseña: ");
        String contrasena = entrada.nextLine();

        if (esContrasenaSegura(contrasena)) {
            System.out.println("La contraseña es SEGURA.");
        } else {
            System.out.println("La contraseña NO es segura.");
        }
    }

    // =========================== EJERCICIO 3: CADENAS AMIGAS ===========================

    public static boolean sonAmigas(String s, String t) {
        // Si tienen distinto tamaño, es imposible que sean amigas
        if (s.length() != t.length()) {
            return false;
        }

        // u y v deben ser no vacías, así que se necesitan al menos 2 caracteres
        if (s.length() < 2) {
            return false;
        }

        // Probamos todos los puntos de corte posibles.
        // i va de 1 a length-1 para que u (inicio) y v (final) nunca queden vacías.
        for (int i = 1; i < s.length(); i++) {
            String u = s.substring(0, i);   // primera parte de S
            String v = s.substring(i);      // segunda parte de S

            // Si v + u es igual a T, encontramos la división: son amigas
            if ((v + u).equals(t)) {
                return true;
            }
        }

        // Ningún punto de corte funcionó
        return false;
    }

    public static void ejercicio3(Scanner entrada) {
        System.out.println("=== EJERCICIO 3: CADENAS AMIGAS ===");
        System.out.print("Ingrese la cadena S: ");
        String s = entrada.nextLine();
        System.out.print("Ingrese la cadena T: ");
        String t = entrada.nextLine();

        if (sonAmigas(s, t)) {
            System.out.println("\"" + s + "\" y \"" + t + "\" son AMIGAS.");
        } else {
            System.out.println("\"" + s + "\" y \"" + t + "\" NO son amigas.");
        }
    }

    // =========================== PROGRAMA PRINCIPAL: permite elegir qué ejercicio ejecutar ===========================
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Seleccione el ejercicio a ejecutar (2 o 3): ");
        int opcion = Integer.parseInt(teclado.nextLine().trim());

        switch (opcion) {
            case 2:
                ejercicio2(teclado);
                break;
            case 3:
                ejercicio3(teclado);
                break;
            default:
                System.out.println("Opción no válida.");
        }

        teclado.close();
    }
}