/**
 * C004_Animales
 * 
 * Ejemplo básico de aplicación POO con herencia y bastracción.
 * 
 * @author  Efrén Sánchez
 * Fecha    01/12/2025
 * 
 * Clase AnimalesHerenciaAbstracta
 * 
 * Clase contenedora que contiene la declaración de otras clases privadas 
 * (aunque también podría tener otro modificador de visibilidad o no tener)
 * para ilustrar el concepto de abstracción en Java.
 * 
 * Jerarquía de clases:
 *      Animal -> Mamifero -> Perro
 *                         -> Gato
 *                         -> Elefante
 *                         -> León
 *                         -> Oso
 *             -> Ave      -> Águila
 *                         -> Paloma
 *                         -> Loro
 *                         -> Buho
 *                         -> Alcón
 *             -> Reptil   -> Cobra
 *                         -> Iguana
 *                         -> Tortuga
 *                         -> Caimán
 *                         -> Camaleón
 *             -> Pez      -> Tiburón
 *                         -> Salmón
 *                         -> Pez Payaso
 *                         -> Dorado
 *                         -> Manta Raya
 *             -> Anfibio  -> Rana
 *                         -> Salamandra
 *                         -> Sapo
 *                         -> Ajolote
 *                         -> Cecilia
 */
public class AnimalesHerenciaAbstracta {

    // Clase base
    private static abstract class Animal {
        abstract void hacerSonido();
        void respirar() {
            System.out.println(getClass().getSimpleName() + " está respirando."); // Muestra el nombre de la clase que llama al método
        }
    }

    // Nivel 1 - Clases abstractas que heredan de Animal
    private static abstract class Mamifero extends Animal {}
    private static abstract class Ave extends Animal {}
    private static abstract class Reptil extends Animal {}
    private static abstract class Pez extends Animal {}
    private static abstract class Anfibio extends Animal {}

    // Nivel 2 - Clases concretas que heredan de Mamifero
    private static class Perro extends Mamifero {
        @Override
        void hacerSonido() { System.out.println("El Perro ladra"); }
    }

    private static class Gato extends Mamifero {
        @Override
        void hacerSonido() { System.out.println("El Gato maúlla"); }
    }

    private static class Elefante extends Mamifero {
        @Override
        void hacerSonido() { System.out.println("El Elefante barrita"); }
    }
    
    private static class Leon extends Mamifero {
        @Override
        void hacerSonido() { System.out.println("El León ruge"); }
    }
    
    private static class Oso extends Mamifero {
        @Override
        void hacerSonido() { System.out.println("El Oso gruñe"); }
    }

    // Nivel 2 - Clases concretas que heredan de Ave
    private static class Aguila extends Ave {
        @Override
        void hacerSonido() { System.out.println("El Águila grita"); }
    }

    private static class Paloma extends Ave {
        @Override
        void hacerSonido() { System.out.println("La Paloma arrulla"); }
    }

    private static class Loro extends Ave {
        @Override
        void hacerSonido() { System.out.println("El Loro habla"); }
    }

    private static class Buho extends Ave {
        @Override
        void hacerSonido() { System.out.println("El Búho ulula"); }
    }

    private static class Halcon extends Ave {
        @Override
        void hacerSonido() { System.out.println("El Halcón chilla"); }
    }

    // Nivel 2 - Clases concretas que heredan de Reptil
    private static class Cobra extends Reptil {
        @Override
        void hacerSonido() { System.out.println("La Cobra sisea"); }
    }

    private static class Iguana extends Reptil {
        @Override
        void hacerSonido() { System.out.println("La Iguana hace un sonido bajo"); }
    }

    private static class Tortuga extends Reptil {
        @Override
        void hacerSonido() { System.out.println("La Tortuga hace ruidos suaves"); }
    }

    private static class Caiman extends Reptil {
        @Override
        void hacerSonido() { System.out.println("El Caimán gruñe"); }
    }

    private static class Camaleon extends Reptil {
        @Override
        void hacerSonido() { System.out.println("El Camaleón emite sonidos bajos"); }
    }

    // Nivel 2 - Clases concretas que heredan de Pez
    private static class Tiburon extends Pez {
        @Override
        void hacerSonido() { System.out.println("El Tiburón no emite sonidos audibles"); }
    }

    private static class Salmon extends Pez {
        @Override
        void hacerSonido() { System.out.println("El Salmón chapotea"); }
    }

    private static class PezPayaso extends Pez {
        @Override
        void hacerSonido() { System.out.println("El Pez Payaso hace sonidos de clics"); }
    }

    private static class Dorado extends Pez {
        @Override
        void hacerSonido() { System.out.println("El Dorado salta y chapotea"); }
    }

    private static class MantaRaya extends Pez {
        @Override
        void hacerSonido() { System.out.println("La MantaRaya mueve sus alas en el agua"); }
    }

    // Nivel 2 - Clases concretas que heredan de Anfibio
    private static class Rana extends Anfibio {
        @Override
        void hacerSonido() { System.out.println("La Rana croa"); }
    }

    private static class Salamandra extends Anfibio {
        @Override
        void hacerSonido() { System.out.println("La Salamandra emite sonidos leves"); }
    }
    
    private static class Sapo extends Anfibio {
        @Override
        void hacerSonido() { System.out.println("El Sapo croa fuerte"); }
    }

    private static class Ajolote extends Anfibio {
        @Override
        void hacerSonido() { System.out.println("El Ajolote hace ruidos bajo el agua"); }
    }

    private static class Cecilia extends Anfibio {
        @Override
        void hacerSonido() { System.out.println("La Cecilia hace sonidos subterráneos"); }
    }

    // Main para probar la jerarquía
    /**
     * Método main
     * 
     * Para pruebas unitarias de la clase
     * 
     * @param args
     */
    public static void main(String[] args) {
        Animal[] animales = {
            new Perro(), new Gato(), new Elefante(), new Leon(), new Oso(),
            new Aguila(), new Paloma(), new Loro(), new Buho(), new Halcon(),
            new Cobra(), new Iguana(), new Tortuga(), new Caiman(), new Camaleon(),
            new Tiburon(), new Salmon(), new PezPayaso(), new Dorado(), new MantaRaya(),
            new Rana(), new Salamandra(), new Sapo(), new Ajolote(), new Cecilia()
        };

        for (Animal animal : animales) {
            animal.respirar();
            animal.hacerSonido();
            System.out.println("-----------------\n\n");
        }
    }
}