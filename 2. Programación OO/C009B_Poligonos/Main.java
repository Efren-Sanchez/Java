package es.medac.alu.ftt0003;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Poligono[] figuras = {
                new Triangulo(new Punto[]{new Punto(0, 0), new Punto(3, 0), new Punto(0, 4)}),
                new Rectangulo(new Punto[]{new Punto(0, 0), new Punto(4, 0), new Punto(4, 3), new Punto(0, 3)}),
                new Circulo(new Punto(0, 0), 5),
                new Elipse(new Punto(0, 0), new Punto(2, 0), 5),
                new PoligonoRegular(new Punto[]{new Punto(0, 0), new Punto(1, 0), new Punto(1, 1), new Punto(0, 1)})
        };

        for (Poligono figura : figuras) {
            System.out.println(figura);
            if (figura instanceof Calculable) {
                Calculable calculable = (Calculable) figura;
                System.out.printf("Área: %.2f%n", calculable.calcularArea());
                System.out.printf("Perímetro: %.2f%n", calculable.calcularPerimetro());
            }
            if (figura instanceof Dibujable) {
                Dibujable dibujable = (Dibujable) figura;
                dibujable.dibujar();
            }
            System.out.println();
        }
    }
}