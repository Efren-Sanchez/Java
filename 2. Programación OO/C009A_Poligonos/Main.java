import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Lista de polígonos
        ArrayList<Poligono> figuras = new ArrayList<>();

        // Agregar distintas figuras geométricas
        figuras.add(new Rectangulo(new Punto(0, 0), new Punto(4, 0), new Punto(4, 3), new Punto(0, 3)));
        figuras.add(new Triangulo(new Punto(0, 0), new Punto(4, 0), new Punto(2, 3)));
        figuras.add(new PoligonoRegular(6, new Punto(0, 0), 5));
        figuras.add(new Circulo(new Punto(3, 4), 5));
        figuras.add(new Elipse(new Punto(2, 3), new Punto(6, 3), 5, 3));

        // Iterar sobre la lista de figuras y aplicar métodos
        for (Poligono figura : figuras) {
            System.out.println(figura); // Imprime la información
            ((Dibujable) figura).dibujar(); // Llama al método de dibujo
            System.out.println("------------------------------------");
        }
    }
}
