/**
 * C006_Biblioteca_3.0
 * 
 * Ejemplo básico de aplicación con POO. 
 * 
 * @author  Efrén Sánchez
 * Fecha    23/09/2025
 * 
 * Clase Main
 * 
 * Cláse que funciona como programa principal.
 */
public class Main {
    static final int MAX_PRESTAMOS = 10;
    public static void main(String[] args) throws Exception {
        Prestamo [] prestamos = new Prestamo[MAX_PRESTAMOS];

        Usuario u = new Usuario();
        Trabajador t = new Trabajador();
        Libro l = new Libro();
        Prestamo p1 = new Prestamo();
        Prestamo p2 = new Prestamo(l, u, t, "");

        prestamos[0] = p1;
        prestamos[1] = p2;

        System.out.println(prestamos[0].toString());
        System.out.println(prestamos[1].toString());

        // Probamos el polimorfismo
        //Persona p = new Persona();    // Persona es abstracta y no podemos crear objetos
        Persona [] vec = new Persona[2];
        
        vec[0] = u;
        vec[1] = t;
        //vec[2] = p;

        for (Persona per : vec) {
            System.out.println(per.getClass().getSimpleName());
            System.out.println(per.toString());
        }

    }
}
