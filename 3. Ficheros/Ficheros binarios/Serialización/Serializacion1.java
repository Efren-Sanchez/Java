// Ejemplo de lectura/escritura de objetos Java desde/hacia ficheros binarios utilizando la serialización
import java.io.*;

class Demo implements java.io.Serializable {
    public int a;
    public String b;

    // Default constructor
    public Demo(int a, String b) {
        this.a = a;
        this.b = b;
    }
}

class Serializacion1 {
    public static void main(String[] args) {   
        Demo objecto = new Demo(1, "Texto guardado en el objeto");
        String filename = "serializado1.bin";
        
        // Serializamos el objeto para guardarlo en un fichero
        try {   
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            
            // Escribimos el objeto serializado
            out.writeObject(objecto);
            
            out.close();
            file.close();
            
            System.out.println("El objeto se ha serializado");
        } catch(IOException ex) {
            System.out.println("Se ha producido una IOException");
        }

        Demo objecto1 = null;

        // Leemos un objeto serializado de un fihcero
        try {   
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            
            // Lee el objeto y lo devuelve3 deserializado
            objecto1 = (Demo)in.readObject();
            
            in.close();
            file.close();
            
            System.out.println("El objecto ha sido deserializado");
            System.out.println("a = " + objecto1.a);
            System.out.println("b = " + objecto1.b);
        } 
        catch(IOException ex) {
            System.out.println("Se ha producido una IOException");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Se ha producido una ClassNotFoundException");
        }
    }
}