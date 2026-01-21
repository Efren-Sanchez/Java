/**
 * C003_Biblioteca_1.0
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
        Libro l = new Libro();
        Prestamo p1 = new Prestamo();
        Prestamo p2 = new Prestamo(l, u, "");

        prestamos[0] = p1;
        prestamos[1] = p2;

        System.out.println(prestamos[0].toString());
        System.out.println(prestamos[1].toString());
    }
}
