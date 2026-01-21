/**
 * C002_ClienteTrabajador
 * 
 * Ejemplo básico de aplicación POO con herencia
 * 
 * @author  Efrén Sánchez
 * Fecha    01/12/2025
 * 
 * Clase Main
 * 
 * Cláse que funciona como programa principal de la aplicación.
 */
public class Main {
    public static void main(String[] args) {
        Trabajador t1 = new Trabajador("Efrén", null, null, null, null);

        Cliente c1 = new Cliente("Diego", null, null, null, null);
        
        Persona p1 = new Persona("Teresa", null, null);
        Persona p2 = new Trabajador("Juan", null, null, null, null);
        Persona p3 = new Cliente("Josep", null, null, null, null);

        // Creamos un vector de personas que contiene tanto personas como trabajadores y clientes
        // A esto se le llama polimorfismo
        Persona [] vector = new Persona[5];
        vector[0] = p1; // Persona persona
        vector[1] = p2; // Persona trabajadora
        vector[2] = p3; // Persona cliente
        vector[3] = t1; // Trabajador
        vector[4] = c1; // Cliente

        for (int i = 0; i < vector.length; i++)
            System.out.println(vector[i].toString());
    }
}
