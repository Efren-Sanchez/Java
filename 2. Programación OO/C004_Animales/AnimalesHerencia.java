/**
 * C004_Animales
 * 
 * Ejemplo básico de aplicación POO con herencia.
 * 
 * @author  Efrén Sánchez
 * Fecha    01/12/2025
 * 
 * Clase AnimalesHerencia
 * 
 * Clase contenedora que contiene la declaración de otras clases privadas 
 * (aunque también podría tener otro modificador de visibilidad o no tener)
 * para ilustrar el concepto de herencia en Java.
 * 
 * Jerarquía de clases:
 *      Animal -> Perro -> PastorAleman
 *                      -> Bulldog
 */
public class AnimalesHerencia {

    // Clase base concreta (no abstracta)
    private static class Animal {
        void respirar() {
            System.out.println("El animal respira");
        }
    
        void hacerSonido() {
            System.out.println("El animal hace un sonido");
        }
    }

    // Clase abstracta que hereda de una clase concreta
    private static abstract class Perro extends Animal {
        abstract void ladrar();

        // Sobrescribimos este método, aunque no es necesario por ser la clase abstracta
        @Override
        void hacerSonido() {
            System.out.println("El perro hace un sonido");
        }
    }

    // Clase concreta que hereda de una clase abstracta
    private static class PastorAleman extends Perro {
        @Override
        void ladrar() {
            System.out.println("El pastor alemán ladra fuerte");
        }

        @Override
        void hacerSonido() {
            System.out.println("El pastor alemán ladra");
        }
    }

    // Clase concreta que hereda de una clase abstracta
    private static class Bulldog extends Perro {
        @Override
        void hacerSonido() {
            System.out.println("El bulldog gruñe");
        }

        @Override
        void ladrar() {
            System.out.println("El bulldog ladra flojo");
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

        PastorAleman perro = new PastorAleman();
        perro.respirar();
        perro.hacerSonido();
        perro.ladrar();

        Animal[] animales = new Animal[4];

        animales[0] = new PastorAleman();
        animales[1] = new Bulldog();
        animales[2] = new PastorAleman();
        animales[3] = new Animal(); // Podemos crear objetos de tipo Animal, aunque no tiene mucho sentido

        for (Animal animal : animales) {
            animal.respirar();
            if (animal instanceof Perro) {
                ((Perro) animal).hacerSonido();
            }
            if (animal instanceof PastorAleman) {
                System.out.println("Es un Pastor Alemán.");
                ((PastorAleman) animal).hacerSonido();
            } else if (animal instanceof Bulldog) {
                System.out.println("Es un Bulldog.");
                ((Bulldog) animal).hacerSonido();
            }
            if (animal instanceof Animal) {
                animal.hacerSonido();
            }
        }
    }
}