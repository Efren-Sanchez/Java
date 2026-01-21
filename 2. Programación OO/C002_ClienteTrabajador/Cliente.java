/**
 * C002_ClienteTrabajador
 * 
 * Ejemplo básico de aplicación POO con herencia
 * 
 * @author  Efrén Sánchez
 * Fecha    01/12/2025
 * 
 * Clase Cliente
 * 
 * Cláse hija que desciende de la clase Persona
 */
public class Cliente extends Persona {
    private String nsocio; // Nº Seguridad Social
    private String tarjeta; // Nº Cuenta Correinte

    // Constructores
    public Cliente() {
       super(); // Llamo al constructor de la clase padre
       this.nsocio  = "";
       this.tarjeta = "";
    }

    public Cliente(String nombre, String dni, String direccion, String nsocio, String tarjeta) {
        super(nombre, dni, direccion); // Llamo al constructor de la clase padre
        this.nsocio = nsocio;
        this.tarjeta = tarjeta;
    }

    public Cliente(Cliente c) {
        super(c);
        this.nsocio  = c.nsocio;
        this.tarjeta = c.tarjeta;
    }
    
    // Getters y Setters
    public void setNsocio(String nsocio) {
        this.nsocio = nsocio;
    }

    public String getNsocio() {
        return nsocio;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getTarjeta() {
        return tarjeta;
    }

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
        return super.toString() + "\nNº Socio.: " + this.nsocio + "\nTarjeta: " + this.tarjeta + "\n(Cliente)"; 
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
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;

        Cliente o = (Cliente) obj;
        return (this.getNombre().equals(o.getNombre()) && 
                this.getDni().equals(o.getDni()) && 
                this.getDireccion().equals(o.getDireccion()) && 
                this.nsocio.equals(o.nsocio) && 
                this.tarjeta.equals(o.tarjeta));
    }

    /**
     * Método main
     * 
     * Para pruebas unitarias de la clase
     * 
     * @param args
     */
    public static void main(String[] args) {
        Cliente c1 = new Cliente();
        c1.setNombre("Efrén");
        c1.setDni("11223344X");
        c1.setDireccion("Debajo de un puento, 32");
        c1.setNsocio("ES00 1234 1234 1234 1234 1234");
        c1.setTarjeta("12345678901234");
        System.out.println(c1);
        
        Cliente c2 = new Cliente("Rubén", "12345678Z", "C/ Ensenada 21", "12345678901234", "ES00 1234 1234 1234 1234 1234");
        System.out.println(c2);
        
        Cliente c3 = new Cliente(c2);
        System.out.println(c3);
        
        System.out.println("¿c2 y c3 son iguales? " + c2.equals(c3)); // Si
        System.out.println("¿c1 y c3 son iguales? " + c1.equals(c3)); // No
        
        System.out.println("¿c2 y c2 son iguales? " + c2.equals(c2)); // Si
        c3.setDireccion(null);
        System.out.println("¿c2 y c3 son iguales? " + c2.equals(c3)); // Si
    }
}
