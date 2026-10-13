import java.util.Arrays;
import java.util.Scanner;

public class Mediana {
 public static void main(String[] args){
     Scanner teclado = new Scanner(System.in);

     System.out.print("Ingrese la cantidad de elementos del arreglo: ");
     int cantidad = teclado.nextInt();
     if (cantidad <= 0) {
         System.out.println("El arreglo debe tener al menos un elemento.");
         teclado.close();
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
     teclado.close();
 }

}
