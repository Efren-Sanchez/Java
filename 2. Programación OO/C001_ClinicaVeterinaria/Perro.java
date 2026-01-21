/**
 * C001_Clínica Veterinaria
 * Ejemplo básico de aplicación con POO. 
 * 
 * @author  Efrén Sánchez
 * Fecha    01/12/2025
 * 
 * Clase Perro
 * 
 * Cláse que representa a un perro que va al veterinario.
 */
public class Perro {
    // Propiedades de la clase
    private String nombre;
    private String raza;
    private int edad;
    private String color;
    // ...

    // Métodos de la clase

    // Constructores
    // Constructor nulo o por defecto
    Perro() {
        this.nombre = "";
        this.raza = "";
        this.edad = 0;
        this.color = "";
    }

    // Constructor con parámetros
    Perro(String nombre, String raza, int edad, String color) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.color = color;
    }
    
    // Constructor con parámetros
    Perro(String nombre) {
        this.nombre = nombre;
        this.raza = "";
        this.edad = 0;
        this.color = "";
    }
    
    // Constructor de copia
    Perro(Perro p) {
        this.nombre = p.nombre;
        this.raza = p.raza;
        this.edad = p.edad;
        this.color = p.color;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public String getRaza() {
        return raza;
    }

    public String getColor() {
        return color;
    }

    public int getEdad() {
        return edad;
    }

    // Funciones sobreescritas de la clase Object
    // Todas las clases que se crean en Java descienden de la clase Object

    /**
     * Método toString
     * 
     * Convierte el objeto en una cadena de texto imprimible por pantalla.
     * 
     * @author Efrén Sánchez
     * 
     * Entrada: void
     * 
     * Salida:  
     *   @return String     Cadena de texto que representa al objeto
     */ 
    @Override   // Override notifica al compilador que vamos a sobreescribir algún método ya implementado en alguna clase superior
                // Si no se detecta la función que se sobreescribe (p.e. si hay un error en el nombre), el compilador avisa
    public String toString() {
        return  "\nPerro\n-----\nNombre: " + this.nombre + 
                "\nRaza: " + this.raza + "\nEdad: " + this.edad + 
                "\nColor:" + this.color;
    }

    /**
     * Método equals
     * 
     * Compara entre dos objetos del mismo tipo.
     * 
     * @author Efrén Sánchez
     * 
     * Entrada:
     * @param Objetc o  Objeto con el que comparar
     * 
     * Salida:
     * @return boolean  True si son iguales, fasle si no lo son
     */
    @Override
    public boolean equals(Object o) {
        // Si el objeto pasado por parámetro es nulo o de otra clase
        if (o == null || this.getClass() != o.getClass()) return false;

        // Si el objeto pasado por parámetro es el mismo (misma dirección de memoria)
        if (this == o) return true;

        // Convierto el objeto o en un perro (se supone que llegados a este punto sabemos que es un perro)
        Perro p = (Perro) o;

        // Ahora ya puedo hacer la comparación de las propiedades adecuadas
        return (this.raza.equals(p.raza) && this.color.equals(p.color));
        //return (this.raza == p.raza && this.color == p.color);    // OJO: la comparación entre cadenas con == no da el resultado esperado
                                                                    // El operador == compara las direcciones de memoria de los objetos
                                                                    // Solo dará true si comparamos la cadena consigo misma
                                                                    // Debemos usar equals, equalsIgnoreCase o compareTo
    }

    /**
     * Método main
     * 
     * Para pruebas unitarias de la clase
     * 
     * @param args
     */
    public static void main(String[] args) {
        Perro p1 = new Perro();
        Perro p2 = new Perro();
        
        // Puedo, pero no debo. Debería usar los getters
        // Pero como estoy dentro de la propia clase, no hay problema
        //p1.getNombre("Bobby");
        p1.nombre = "Bobby";
        p1.raza = "Pastor alemán";
        p1.edad = 64; // Años caninos
        p1.color = "negro";
        
        p2.nombre = "Vicky";
        p2.raza = "Pomeranian";
        p2.edad = 18; // Años caninos

        Perro p3 = new Perro("Sanxe", "PSEO", 50, "rojo");
        Perro p4 = new Perro("Rajoy");

        System.out.println("Perro 1: " + p1);
        System.out.println("Perro 2: " + p2);
        System.out.println("Perro 3: " + p3);
        System.out.println("Perro 4: " + p4);

        Perro p5 = new Perro("Sanxe1", "PSEO", 50, "rojo");
        Perro p6 = new Perro("Sanxe2", "PSEO", 50, "rojo");

        if(p5.equals(p6)) System.out.println("Los perros p5 y p6 son iguales");
    }
}
