/**
 * C006_Biblioteca_3.0
 * 
 * Ejemplo básico de aplicación con POO. 
 * 
 * @author  Efrén Sánchez
 * Fecha    23/09/2025
 * 
 * Clase Usuario
 * 
 * Cláse que representa a un usuario de una biblioteca.
 */
public class Usuario extends Persona{
    private String nsocio;
    private String finscripcion;
    
    // Constructores
    public Usuario() {
        super();
        this.nsocio     = "";
        this.finscripcion   = "";
    }

    public Usuario(String nombre, String apellido, String dni, int edad, String nscoio, String finscripcion) {
        super(nombre, apellido, dni, edad);
        this.nsocio     = "";
        this.finscripcion   = "";
    }

    public Usuario(Persona p, String nscoio, String finscripcion) {
        super(p);
        this.nsocio     = "";
        this.finscripcion   = "";
    }

    public Usuario(Usuario u) {
        super(u);
        this.nsocio       = u.nsocio;
        this.finscripcion = u.finscripcion;
    }

    // Getters y Setters
    public String getNsocio() {
        return nsocio;
    }

    public void setNsocio(String nsocio) {
        this.nsocio = nsocio;
    }

    public String getFinscripcion() {
        return finscripcion;
    }

    public void setFinscripcion(String finscripcion) {
        this.finscripcion = finscripcion;
    }

    // Métodos comunes
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
    @Override
    public String toString() {
        return "\n\nUsuario:\n======" + 
                "\nNombre: " + this.getNombre() + 
                "\nApellido: " + this.getApellido() + 
                "\nDNI: " + this.getDni() + 
                "\nEdad: " + this.getEdad()+ 
                "\nNº Socio: " + this.getNsocio()+ 
                "\nInscripción: " + this.getFinscripcion();
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
    public boolean equals(Object obj) {
        if (obj == null) return false; // Comparo con nulo
        if (obj == this) return true;  // Comparo si es el propio objeto
        if (obj.getClass() != this.getClass()) return false; // Comparo si son de diferente clase
        
        // Llegados a este punto, puedo afirmar que el objeto pasado por parámetro es de toipo Libro
        Usuario u = (Usuario) obj;

        return ((this.getNombre().equals(u.getNombre())) && 
                (this.getApellido().equals(u.getApellido())) && 
                (this.getDni().equals(u.getDni())) && 
                (this.getEdad() == u.getEdad()) && 
                (this.getNsocio().equals(u.getNsocio())) && 
                (this.getFinscripcion().equals(u.getFinscripcion()))
            );
        // return (this.dni.equals(l.dni));
    }

    /**
     * Método mostrarLibros
     * 
     * Muestra los libros prestados por el trabajador.
     * 
     * @author Efrén Sánchez
     * 
     * Entrada:
     * @param Prestamo [] p  Vector con los préstamos
     * 
     * 
    */
    // Es imprescindible implementar este método para que compile correctamente la clase
    @Override
    public void mostrarLibros(Prestamo [] prestamos, int nPrestamos) {
        for (int i = 0; i < nPrestamos; i++)
            if (this == prestamos[i].getU()) 
                System.out.println(prestamos[i].getL().toString());

        // Ojo con esta implementación. Habría que ver que tienen las posiciones no ocupadas... Habría que rellenarlo con nulls (u otra cosa), y ver que no falle el bucle.
        /*
        for (Prestamo p: prestamos) {
            if (this == p.getU()) {
                System.out.println(p.getL().toString());
            }
        }
        */
    }

    /**
     * Método main
     * 
     * Para pruebas unitarias de la clase
     * 
     * @param args
     */
    public static void main(String[] args) {
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario("Efrén", "Sánchez", "12345678Z", 25, "1234", "01/01/2020");
        Usuario u3 = new Usuario(u2);

        // El ser Persona abstracta, esto ya no tiene sentido
        //Persona p = new Persona("Juan", "", "", 10);
        //Usuario u4 = new Usuario(p, "1238", "01/10/2022");

        u1.setNombre("Juan");
        u1.setApellido("Juánez");
        u1.setDni("22446688A");
        u1.setEdad(50);

        u3.setNombre("Perico");

        System.out.println(u1.toString());
        System.out.println(u2.toString());
        System.out.println(u3.toString());
        //System.out.println(u4.toString());

        if (u3.equals(u2))
            System.out.println("\n\nLos objetos u2 y u3 son iguales.");
        else
            System.out.println("\n\nLos objetos u2 y u3 NO son iguales.");

        if (u1.equals(u2))
            System.out.println("\n\nLos objetos u1 y u2 son iguales.");
        else
            System.out.println("\n\nLos objetos u1 y u2 NO son iguales.");
    }
}
