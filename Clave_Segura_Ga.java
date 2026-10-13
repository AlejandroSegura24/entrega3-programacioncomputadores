import java.util.Scanner;

public class Clave_Segura_Ga{

public static void main(String[] args){

    Scanner escribir = new Scanner(System.in);

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

}