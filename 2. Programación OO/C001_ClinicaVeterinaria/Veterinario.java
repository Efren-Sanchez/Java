/**
 * C001_Clínica Veterinaria
 * Ejemplo básico de aplicación con POO. 
 * 
 * @author  Efrén Sánchez
 * Fecha    01/12/2025
 * 
 * Clase Veterinario
 * 
 * Cláse que representa a un veterinario.
 */
public class Veterinario {
    // Propiedades de la clase
    private String nombre;
    private String nif;
    private String cuenta;  // Cuenta corriente donde se le paga
    private char turno;     // 'm' para mañanas, 't' para tardes
    private int despacho;   

    // Métodos de la clase

    // Constructores
    // Constructor por defecto o nulo
    public Veterinario() {
        this.nombre     = "";
        this.nif        = "";
        this.cuenta     = "";
        this.turno      = 'm';
        this.despacho   = 1;
    }

    // Constructor con parámetros
    public Veterinario(String nombre, String nif, String cuenta, char turno, int despacho) {
        this.nombre     = nombre;
        this.nif        = nif;
        this.cuenta     = cuenta;
        this.turno      = turno;
        this.despacho   = despacho;
    }

    // Podemos crear tantos constructores con parámetros como consideremos oportuno
    public Veterinario(String nombre, String nif) {
        this.nombre     = nombre;
        this.nif        = nif;
        this.cuenta     = "";
        this.turno      = 'm';
        this.despacho   = 1;
    }

    // Constructor de copia
    public Veterinario(Veterinario v) {
        this.nombre     = v.nombre;
        this.nif        = v.nif;
        this.cuenta     = v.cuenta;
        this.turno      = v.turno;
        this.despacho   = v.despacho;
    }

    // Setters
    public void setNombre(String nombre)    { this.nombre = nombre; }
    public void setNif(String nif)          { this.nif = nif;  }
    public void setCuenta(String cuenta)    { this.cuenta = cuenta; }
    public void setTurno(char turno)        { 
        //if (turno != 'm' || turno != 't')
        if (turno != 't') this.turno = 'm';
        else              this.turno = turno; 
    }
    public void setDespacho(int despacho)   { this.despacho = despacho; }

    // Getters
    public String getNombre()               { return nombre; }
    public String getNif()                  { return nif; }
    public String getCuenta()               { return cuenta;  }
    public char getTurno()                  { return turno; }
    public int getDespacho()                { return despacho; }

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
        return  "\nVeterinaro:\n==========\nNombre: \t" + this.nombre + "\nNIF: \t\t" + this.nif + 
                "\nC/C: \t\t" + this.cuenta + "\nTurno: \t\t" + (this.turno == 'm'?"Mañana":"Tarde") + 
                "\nDespacho: \t" + this.despacho;
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
        if (o == null) return false;
        if (o == this) return true;
        if (this.getClass() != o.getClass()) return false;
        Veterinario v = (Veterinario) o;
        return (this.nif == v.nif);
    }

    /**
     * Método main
     * 
     * Para pruebas unitarias de la clase
     * 
     * @param args
     */
    public static void main(String[] args) {
        Veterinario v1 = new Veterinario();
        System.out.println("V1: " + v1);
        //System.out.println("V1: " + v1.toString());
        
        v1.setNombre("Paco Paco Paco");
        v1.setNif("12345678Z");
        v1.setCuenta("1234567890");
        v1.setTurno('t');
        v1.setDespacho(21);

        System.out.println("V1: " + v1);
        
        Veterinario v2 = new Veterinario("Pepe Pepe Pepe", "87654321A", "888555333", 't', 4);
        System.out.println("\n\nV2: " + v2);
        
        Veterinario v3 = new Veterinario(v2);
        System.out.println("\n\nV3: " + v3);
        
        if (v3.equals(v2)) System.out.println("v2 y V3 son iguales!!");
        
    }
}
