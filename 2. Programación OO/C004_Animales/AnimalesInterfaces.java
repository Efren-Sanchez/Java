/**
 * C004_Animales
 * 
 * Ejemplo básico de aplicación POO con interfaces.
 * 
 * @author  Efrén Sánchez
 * Fecha    01/12/2025
 * 
 * Clase AnimalesInterfaces
 * 
 * Clase contenedora que contiene la declaración de dos interfaces privadas 
 * (aunque también podría tener otro modificador de visibilidad o no tener)
 * para ilustrar el concepto de interfaz en Java.
 */
public class AnimalesInterfaces {
    
    // Primera interfaz
    private interface Volador {
        void volar();
    }

    // Segunda interfaz
    private interface Nadador {
        void nadar();
    }

    // Clase que implementa ambas interfaces
    private static class Ballena implements Nadador {
        @Override
        public void nadar() {
            System.out.println("La ballena está nadando.");
        }
    }

    // Clase que implementa ambas interfaces
    private static class Pato implements Volador, Nadador {
        @Override
        public void volar() {
            System.out.println("El pato está volando.");
        }

        @Override
        public void nadar() {
            System.out.println("El pato está nadando.");
        }
    }

    /**
     * Método main
     * 
     * Para pruebas unitarias de la clase
     * 
     * @param args
     */
    public static void main(String[] args) {
        Ballena ballena = new Ballena();
        ballena.nadar();
        
        Pato pato = new Pato();
        pato.volar();
        pato.nadar();
    }
}