package es.medac.alu.ftt0003;

    public class Circulo extends Poligono implements Dibujable, Calculable {
        private double radio;

        public Circulo(Punto centro, double radio) {
            super(new Punto[]{centro});
            this.radio = radio;
        }

        @Override
        public String toString() {
            return "Círculo: Centro en " + getPuntos()[0] + ", Radio: " + radio;
        }

        @Override
        public void lineaRecta(Punto p1, Punto p2) {
            System.out.println("Línea recta de " + p1 + " a " + p2);
        }

        @Override
        public void lineaCurva(Punto p1, Punto p2, Punto control) {
            System.out.println("Curva de " + p1 + " a " + p2 + " con control en " + control);
        }

        @Override
        public void dibujar() {
            System.out.println("Dibujando círculo:");
            Punto centro = getPuntos()[0];
            lineaCurva(centro, centro, new Punto(centro.getX() + radio, centro.getY()));
            lineaCurva(centro, centro, new Punto(centro.getX() - radio, centro.getY()));
        }

        @Override
        public double calcularArea() {
            return Math.PI * radio * radio;
        }

        @Override
        public double calcularPerimetro() {
            return 2 * Math.PI * radio;
        }
    }
