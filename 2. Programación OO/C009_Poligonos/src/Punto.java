public class Punto {
    private int x;
    private int y;

    public Punto() {
        this.x = 0;
        this.y = 0;
    }

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Punto(Punto p) {
        this.x = p.x;
        this.y = p.y;    
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != this.getClass()) return false;
        Punto p = (Punto) obj;
        return this.x == p.x && this.y == p.y;
    }

    public double calcularDistancia(Punto p) {
        // Distancia de Manhattan
        return (Math.abs(this.x - p.x) + Math.abs(this.y - p.y));
    }

    public static double calcularDistancia(Punto p1, Punto p2) {
        // Distancia de Manhattan
        return (Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y));
    }

    public static double calcularDistancia(int x1, int y1, int x2, int y2) {
        // Distancia de Manhattan
        return (Math.abs(x1 - x2) + Math.abs(y1 - y2));
    }

    public static void main(String[] args) {
        Punto p1 = new Punto();
        Punto p2 = new Punto(2, 2);
        Punto p3 = new Punto(p2);

        System.out.println(p1.toString());
        p1.setX(5);
        p1.setY(5);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        
        if (p2.equals(p3)) System.out.println("Los puntos p2 y p3 son iguales.");

        // Calculoar distancias
        System.out.println("La distancia entre p1=" + p1.toString() + " y p2=" + p2.toString() + " es: " + p1.calcularDistancia(p2));
        System.out.println("La distancia entre p2=" + p2.toString() + " y p1=" + p1.toString() + " es: " + p2.calcularDistancia(p1));

        System.out.println("La distancia entre p1=" + p1.toString() + " y p2=" + p2.toString() + " es: " + Punto.calcularDistancia(p1, p2));

        System.out.println("La distancia entre p2=" + p2.toString() + " y p1=" + p1.toString() + " es: " + Punto.calcularDistancia(p2, p1));

        System.out.println("La distancia entre p2=" + p2.toString() + " y p1=" + p1.toString() + " es: " + Punto.calcularDistancia(p1.x, p1.y, p2.x, p2.y));
    }
}
