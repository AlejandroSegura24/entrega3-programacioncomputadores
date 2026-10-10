import java.util.Scanner;

// =====================================================================
// EJERCICIO 3: CADENAS AMIGAS
// =====================================================================
public class Ejercicios {

    /**
     * S y T son amigas si existen u y v NO vacías tales que S = uv y T = vu.
     * Es decir, T es S "rotada": se corta S en un punto, y las dos partes
     * se intercambian de lugar.
     * Ejemplo: S = "tokyo" = "to" + "kyo"  ->  T = "kyo" + "to" = "kyoto"
     */
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

    // Programa principal: lee las dos cadenas e imprime el resultado
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cadena S: ");
        String s = sc.nextLine();
        System.out.print("Ingrese la cadena T: ");
        String t = sc.nextLine();

        if (sonAmigas(s, t)) {
            System.out.println("\"" + s + "\" y \"" + t + "\" son AMIGAS.");
        } else {
            System.out.println("\"" + s + "\" y \"" + t + "\" NO son amigas.");
        }

        sc.close();
    }
}