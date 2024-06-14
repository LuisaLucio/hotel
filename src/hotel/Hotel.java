package hotel;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Hotel {
    public static void main(String[] args) {
        
        Recepcion r = new Recepcion();
        Scanner sc=new Scanner (System.in);
        int num;
        do {
            
            System.out.println("Bienvenido a UNPA´s hotel\nMENÚ DE OPCIONES:\n1.Consultar habitaciones\n2. Reservar habitaciones\n3. Salida de huespedes\n4. Generar informe por habitación\n5. Generar informe por huesped\n6. Salir\n Elige una opción");
            num = sc.nextInt(); 
            switch(num){
                case 1 :
                    r.listadoHabitaciones();
                    break;
                
                case 2 :  
                    r.reservarHabitacion();        
                    break;
                
                case 3 :
                    r.salidaHuesped();
                    break;
             

                case 4 : 
                    r.informeHabitacion();
                    break;
                
                case 5 : 
                    r.informeHuesped();
                    break;
                case 6:
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 6.");
            }
        } while(num!=6);
    }
}
