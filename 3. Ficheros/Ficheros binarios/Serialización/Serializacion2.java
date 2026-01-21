// Ejemplo de lectura/escritura de objetos Java desde/hacia ficheros binarios utilizando la serialización
import java.io.*;

class Emp implements Serializable {
    /* serialversionUID es un número que debemos obtener de nuestro sistema. Se utiliza para comprobar que 
       tanto el lecto como el escritor de objetos serializados están usando versión de la clase que son 
       compatibles entre sí y que no darán problemas.
       Para obtener este UID necesitamos ejecutar el siguiente comando en nuestr consola:
            serialver -classpath ruta_de_classpath
    */
    private static final long serialversionUID = 129348938L;

    // Los valores estáticos o de tipo transient no se guardan en el proceso de serialización
    transient int a; // Si queremos que un dato no se guarde lo hacemos transient
    static int b;
    
    // Valores normales que sí que se serializan
    String nombre;
    int edad;

    public Emp(String nombre, int edad, int a, int b) {
            this.nombre = nombre;
            this.edad = edad;
            this.a = a;
            this.b = b;
        }
}

public class Serializacion2 {
    public static void imprimirDatos(Emp objecto) {
        System.out.println("Nombre = " + objecto.nombre);
        System.out.println("Edad = " + objecto.edad);
        System.out.println("a = " + objecto.a);
        System.out.println("b = " + objecto.b);
    }

    public static void main(String[] args) {
        Emp objecto = new Emp("Efren", 20, 2, 1000);
        String filename = "serializado2.bin";

        // Serialización
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(objecto);

            out.close();
            file.close();

            System.out.println("El objecto ha sido serializado\n"+ "Datos antes de la deserializacion.");
            imprimirDatos(objecto);

            // Cambiamos el valor del dato estático
            objecto.b = 2000;
        }
        catch (IOException ex) {
            System.out.println("Se ha producido una IOException");
        }

        objecto = null;

        // Deserializacion
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            objecto = (Emp)in.readObject();

            in.close();
            file.close();
            System.out.println("El objecto ha sido deserializado\n" + "Datos después de la deserializacion.");
            imprimirDatos(objecto);
        }
        catch (IOException ex) {
            System.out.println("Se ha producido una IOException");
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Se ha producido una ClassNotFoundException");
        }
    }
}