import java.util.Arrays;
import java.util.Scanner;

/**
// Trabajo evaluativo - Escenario 7 - grupo B4 - Politecnico Grancolombiano
// Trabajo realizado por: 
// - Viviana Avila Martinez
// - Gabriel Cardenas Arenas
// - Jeisson Masmela Riveros
// - David Segura Reina
 */

public class TrabajoGrupoB4Escenario7 {

    // ================================== PROGRAMA PRINCIPAL ==================================
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Seleccione el ejercicio que desea ejecutar.");
        System.out.println("1. Mediana - Viviana Avila Martinez");
        System.out.println("2. Validador de contraseña 1 - Jeisson Masmela Riveros");
        System.out.println("3. Validador de contraseña 2 - Gabriel Cardenas Arenas");
        System.out.println("4. Cadenas amigas - David Segura Reina");
        System.out.print("Opción: ");

        int opcion = Integer.parseInt(teclado.nextLine().trim());

        switch (opcion) {
            case 1:
                mediana(teclado);
                break;
            case 2:
                validadorContrasena(teclado);
                break;
            case 3:
                claveSegura(teclado);
                break;
            case 4:
                cadenasAmigas(teclado);
                break;
            default:
                System.out.println("Opción inválida.");
        }

        teclado.close();
    }


    // ================================== EJERCICIO 1: MEDIANA - Viviana Avila Martinez ==================================

    public static void mediana(Scanner teclado){
     System.out.print("Ingrese la cantidad de elementos del arreglo: ");
     int cantidad = teclado.nextInt();
     if (cantidad <= 0) {
         System.out.println("El arreglo debe tener al menos un elemento.");
         teclado.nextLine();
         return;
     }
     double arreglo[] = new double[cantidad];

     System.out.println("Ingrese los valores reales del arreglo:");
     for (int x = 0; x < arreglo.length; x++) {
         arreglo[x] = teclado.nextDouble();
     }

     Arrays.sort(arreglo);
     double mediana;
     int mitad = arreglo.length/2;
     if (arreglo.length % 2 ==0) {
         mediana =(arreglo [mitad  - 1] + arreglo[mitad]) / 2.0;
     } else {
         mediana =arreglo[mitad];
     }
     System.out.println("Los valores ordenados son: ");
     for (int x = 0; x < arreglo.length; x++) {
         if (arreglo[x] == (int) arreglo[x]) {
             System.out.printf("%d ", (int) arreglo[x]);
         } else {
             System.out.printf("%s ", arreglo[x]);
         }
     }
     System.out.printf("\nLa mediana es: %.2f%n", mediana);
     teclado.nextLine();
    }

    // ================================== EJERCICIO 2: VALIDADOR DE CONTRASEÑA - Jeisson Masmela Riveros ==================================
    public static void validadorContrasena(Scanner scanner) {
        System.out.print("Ingrese una contraseña: ");
        String password = scanner.nextLine();

        if (esSegura(password)) {
            System.out.println("La contraseña es segura");
        } else {
            System.out.println("La contraseña NO es segura. Debe tener al menos 10 caracteres, una minúscula, una mayúscula, un número y un símbolo.");
        }
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

    // ================================== EJERCICIO 2: VALIDADOR DE CONTRASEÑA - Gabriel Cardenas Arenas ==================================

    public static void claveSegura(Scanner escribir){

    System.out.println("Ingrese su contraseña segura:");
    String clave = escribir.nextLine();
    String claveSegura = "NO";

    boolean comprobar= comprobarClave(clave);
    if (comprobar == true){
        claveSegura = "SÍ";
    }
    System.out.println("Contraseña es: " + clave);
    System.out.println("La clave " + claveSegura + " es segura");
    }

    static boolean comprobarClave(String clave){
        boolean claveEsSegura = false;
        boolean contieneLetras = false;
        boolean contieneDigitos = false;
        boolean contieneDistinto = false;
        //Comprobar tamaño
        if (clave.length() >=10 ) {
            for (int i = 0; (i < clave.length())  && claveEsSegura == false; i++) {
                // "A" en ASCII
                int mayusculas = 65;
                // "a" en ASCII
                int minusculas = 97;
                // "0" en ASCII
                int digitos = 48;

                boolean Letra = false;

                boolean Digito = false;

                // "A" a "Z" y "a" a "z" Letras
                for (; (mayusculas < 91 && minusculas < 123) ; mayusculas++, minusculas++) {
                    if (clave.charAt(i) == (char)mayusculas) {
                        contieneLetras = true;
                        Letra = true;
                    }
                    else if (clave.charAt(i) == (char)minusculas) {
                        contieneLetras = true;
                        Letra = true;
                    }

                }
                // "0" a "9" Digitos
                for (;digitos < 58 ; digitos++){
                    if (clave.charAt(i) == (char)digitos){
                        contieneDigitos = true;
                        Digito = true;
                    }

                }
                //Caracter Especial
                if (Letra == false && Digito == false) {
                    contieneDistinto = true;
                }
                }
                // Continuar bucle?
                if (contieneLetras == true && contieneDigitos == true && contieneDistinto == true){
                    claveEsSegura = true;
                }
            }
        return claveEsSegura;
        }

    // ================================== EJERCICIO 3: CADENAS AMIGAS - David Segura Reina ==================================

    public static boolean sonAmigas(String s, String t) {
        // Si tienen un tamaño diferente, es imposible que sean amigas.
        if (s.length() != t.length()) {
            return false;
        }

        // u y v deben ser no vacías, así que se necesitan al menos 2 caracteres.
        if (s.length() < 2) {
            return false;
        }

        // i va de 1 a length-1 para que u (inicio) y v (final) nunca queden vacías.
        for (int i = 1; i < s.length(); i++) {
            String u = s.substring(0, i);   // primera parte de S
            String v = s.substring(i);      // segunda parte de S

            // Si v + u es igual a T, encontramos la división: son amigas.
            if ((v + u).equals(t)) {
                return true;
            }
        }

        // Si no encontramos ninguna división que funcione, no son amigas.
        return false;
    }

    // Programa principal: lee las dos cadenas e imprime el resultado.
    public static void cadenasAmigas(Scanner teclado) {
        System.out.print("Ingrese la cadena S: ");
        String s = teclado.nextLine();
        System.out.print("Ingrese la cadena T: ");
        String t = teclado.nextLine();

        if (sonAmigas(s, t)) {
            System.out.println("\"" + s + "\" y \"" + t + "\" son AMIGAS.");
        } else {
            System.out.println("\"" + s + "\" y \"" + t + "\" NO son amigas.");
        }
    }
}
