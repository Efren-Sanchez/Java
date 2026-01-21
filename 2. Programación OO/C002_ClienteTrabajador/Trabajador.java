/**
 * C002_ClienteTrabajador
 * 
 * Ejemplo básico de aplicación POO con herencia
 * 
 * @author  Efrén Sánchez
 * Fecha    01/12/2025
 * 
 * Clase Trabajador
 * 
 * Cláse hija que desciende de la clase Persona
 */
public class Trabajador extends Persona {
    private String nss; // Nº Seguridad Social
    private String ncc; // Nº Cuenta Correinte

    public Trabajador() {
        // Esto no funciona directamente porque nombre, dni y dirección están como private en la clase padre
        // Si declaramos las propiedades de Persona como protected sí que podríamos hacerlo
        /*
        this.nombre = "";
        this.dni = "";
        this.direccion = "";
        */
       /* Opción 1: no se recomienda, si se modifica la clase padre habrá que modificar esta también
       setNombre("");
       setDireccion("");
       setDni("");
       this.nss = "";
       this.ncc = "";
        */
       // Opción 2:
       super(); // Llamo al constructor de la clase padre, funcionará siempre aunque se modifique la clase padre
       this.nss = "";
       this.ncc = "";
    }

    public Trabajador(String nombre, String dni, String direccion, String nss, String ncc) {
        super(nombre, dni, direccion); // Llamo al constructor de la clase padre
        this.nss = nss;
        this.ncc = ncc;
    }

    public Trabajador(Trabajador t) {
        super(t);
        this.nss = t.nss;
        this.ncc = t.ncc;
    }

    // Getters y Setters
    public void setNcc(String ncc) {
        this.ncc = ncc;
    }

    public String getNcc() {
        return ncc;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getNss() {
        return nss;
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
        return super.toString() + "\nNº S.S.: " + this.nss + "\nC/C: " + this.ncc + "\n(Trabajador)"; 
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

        Trabajador o = (Trabajador) obj;
        return (this.getNombre().equals(o.getNombre()) && 
                this.getDni().equals(o.getDni()) && 
                this.getDireccion().equals(o.getDireccion()) && 
                this.ncc.equals(o.ncc) && 
                this.nss.equals(o.nss));
    }

    /**
     * Método main
     * 
     * Para pruebas unitarias de la clase
     * 
     * @param args
     */
    public static void main(String[] args) {
        Trabajador t1 = new Trabajador();
        t1.setNombre("Efrén");
        t1.setDni("11223344X");
        t1.setDireccion("Debajo de un puento, 32");
        t1.setNcc("ES00 1234 1234 1234 1234 1234");
        t1.setNss("12345678901234");
        System.out.println(t1);
        
        Trabajador t2 = new Trabajador("Rubén", "12345678Z", "C/ Ensenada 21", "12345678901234", "ES00 1234 1234 1234 1234 1234");
        System.out.println(t2);
        
        Trabajador t3 = new Trabajador(t2);
        System.out.println(t3);
        
        System.out.println("¿t2 y t3 son iguales? " + t2.equals(t3)); // Si
        System.out.println("¿t1 y t3 son iguales? " + t1.equals(t3)); // No
        
        System.out.println("¿t2 y t2 son iguales? " + t2.equals(t2)); // Si
        t3.setDireccion(null);
        System.out.println("¿t2 y t3 son iguales? " + t2.equals(t3)); // Si
    }
}
