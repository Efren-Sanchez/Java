// Ejemplo con variables finales transient
// Las variables finales se serializan directamente con sus valores.
// final int x= 10;
// System.out.println(x); // El compilador modificará esta sentencia como System.out.println(10)->10 porque x es de tipo final
import java.io.*;

class Perro implements Serializable{
    int i=10;
    transient final int j=20;
}

class Serializacion3 {
    public static void main (String[] args) throws IOException,ClassNotFoundException {
        Perro p1=new Perro();
        // Serializamos
        FileOutputStream fos= new FileOutputStream("serializado3.bin");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(p1);

        //Deserializamos
        FileInputStream fis=new FileInputStream("serializado3.bin");
        ObjectInputStream ois=new ObjectInputStream(fis);
        Perro p2=(Perro) ois.readObject();

        // Resultados finales
        System.out.println("Datos del objeto de tipo Perro:\n");
        System.out.println(p2.i + "\t" + p2.j);
    }
}