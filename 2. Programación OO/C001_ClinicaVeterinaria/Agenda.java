import java.util.Arrays;

/**
 * C001_Clínica Veterinaria
 * 
 * Ejemplo básico de aplicación con POO. 
 * 
 * @author  Efrén Sánchez
 * Fecha    23/09/2025
 * 
 * Clase Agenda
 * 
 * Cláse que representa al conjunto de consultas agendadas para un día en concreto.
 */
public class Agenda {
    private Consulta [] lista;  // Vector con las consultas del día
    private String fecha;       // Fecha de las consultas agendadas

    // Constructores
    // Por defecto
    public Agenda() {
        //this.lista = null;            // No debemos hacer esto
        this.lista = new Consulta[0];   // Este vector está vacío, pero no falla; NULL sí
        this.fecha = "01/01/2025";
    }

    // Con parámetros
    public Agenda(Consulta [] a, String f) {
        this.lista = a;
        this.fecha = f;
    }

    // De copia
    public Agenda(Agenda a) {
        this.lista = a.lista;
        this.fecha = a.fecha;
    }
    
    // Getters
    public Consulta[] getLista() {
        return lista;
    }
    
    public String getFecha() {
        return fecha;
    }

    // Setters
    public void setLista(Consulta[] lista) {
        this.lista = lista;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
        String salida = "";
        salida += "\n\nAgenda del día " + this.fecha + "\n";
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null)
                salida += "\n" + i + ": " + this.lista[i].toString();
        }

        return salida;
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
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        Agenda a = (Agenda) o;

        return (Arrays.equals(this.lista, a.lista) && this.fecha.equals(a.fecha));
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
        
        p1.setNombre("Bobby");
        p1.setRaza("Pastor alemán");
        p1.setEdad(64); // Años caninos
        p1.setColor("negro");
        
        p2.setNombre("Vicky");
        p2.setRaza("Pomeranian");
        p2.setEdad(18); // Años caninos

        Perro p3 = new Perro("Sanxe", "PSEO", 50, "rojo");
        Perro p4 = new Perro("Rajoy");

        Veterinario v1 = new Veterinario();
        
        v1.setNombre("Paco Paco Paco");
        v1.setNif("12345678Z");
        v1.setCuenta("1234567890");
        v1.setTurno('t');
        v1.setDespacho(21);

        Veterinario v2 = new Veterinario("Pepe Pepe Pepe", "87654321A", "888555333", 't', 4);

        Consulta c1 = new Consulta(v1, p1, "01/01/2025", "09:00", 30);
        Consulta c2 = new Consulta(v1, p2, "01/01/2025", "11:00", 45);
        Consulta c3 = new Consulta(v2, p3, "01/01/2025", "12:00", 22);
        Consulta c4 = new Consulta(v2, p4, "01/01/2025", "17:00", 77);

        Consulta [] l = new Consulta[8];

        l[0] = c1;
        l[2] = c2;
        l[3] = c3;
        l[6] = c4;

        Agenda a = new Agenda(l, "01/01/2025");
        System.out.println(a);
    }
}
