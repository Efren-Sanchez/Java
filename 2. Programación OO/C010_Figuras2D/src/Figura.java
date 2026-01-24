/**
 * 
 */

//import java.util.Arrays;

public abstract class Figura implements Calculable, Dibujable {
    protected Punto[] puntos;
    protected String color;
    protected double centroX;
    protected double centroY;
    protected int id;
    private static int contadorId = 0;

    // Constructor por defecto
    public Figura() {
        this.puntos = new Punto[0];
        this.color = "";
        this.centroX = 0;
        this.centroY = 0;
        this.id = ++contadorId;
    }

    // Constructor con parámetros (vector de puntos)
    public Figura(Punto[] puntos) {
        if (puntos != null) {
            this.puntos = new Punto[puntos.length];
            for (int i = 0; i < puntos.length; i++) {
                if (puntos[i] != null) {
                    this.puntos[i] = new Punto(puntos[i]);
                } else {
                    this.puntos[i] = null;
                }
            }
        } else {
            this.puntos = new Punto[0];
        }
        this.color = "";
        this.centroX = calcularCentroideX();
        this.centroY = calcularCentroideY();
        this.id = ++contadorId;
    }

    // Constructor con parámetros (vector de puntos)
    public Figura(Punto[] puntos, String color) {
        if (puntos != null) {
            this.puntos = new Punto[puntos.length];
            for (int i = 0; i < puntos.length; i++) {
                if (puntos[i] != null) {
                    this.puntos[i] = new Punto(puntos[i]);
                } else {
                    this.puntos[i] = null;
                }
            }
        } else {
            this.puntos = new Punto[0];
        }
        this.color = color;
        this.centroX = calcularCentroideX();
        this.centroY = calcularCentroideY();
        this.id = ++contadorId;
    }
    
    // Constructor de copia
    public Figura(Figura otraFigura) {
        if (otraFigura.puntos != null) {
            this.puntos = new Punto[otraFigura.puntos.length];
            for (int i = 0; i < otraFigura.puntos.length; i++) {
                if (otraFigura.puntos[i] != null) {
                    this.puntos[i] = new Punto(otraFigura.puntos[i]);
                } else {
                    this.puntos[i] = null;
                }
            }
        } else {
            this.puntos = new Punto[0];
        }
        this.color = otraFigura.getColor();
        this.centroX = otraFigura.getCentroX();
        this.centroY = otraFigura.getCentroY();
        this.id = ++contadorId;
    }

    // Getters y Setters
    public Punto[] getPuntos() {
        if (puntos != null) {
            Punto[] copia = new Punto[puntos.length];
            for (int i = 0; i < puntos.length; i++) {
                if (puntos[i] != null) {
                    copia[i] = new Punto(puntos[i]);
                } else {
                    copia[i] = null;
                }
            }
            return copia;
        } else {
            return new Punto[0];
        }
    }

    public void setPuntos(Punto[] puntos) {
        if (puntos != null) {
            this.puntos = new Punto[puntos.length];
            for (int i = 0; i < puntos.length; i++) {
                if (puntos[i] != null) {
                    this.puntos[i] = new Punto(puntos[i]);
                } else {
                    this.puntos[i] = null;
                }
            }
        } else {
            this.puntos = new Punto[0];
        }
        this.centroX = calcularCentroideX();
        this.centroY = calcularCentroideY();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCentroX() {
        return centroX;
    }

    public double getCentroY() {
        return centroY;
    }

    public int getId() {
        return id;
    }

    // Métodos abstractos de Calculable
    @Override
    public abstract double calcularArea();

    @Override
    public abstract double calcularPerimetro();

    // Método de Dibujable
    @Override
    public void dibujar() {
        System.out.println("Dibujando figura (implementación pendiente)");
    }

    // Métodos Adicionales
    public void trasladar(double deltaX, double deltaY) {
        if (puntos != null) {
            for (Punto punto : puntos) {
                if (punto != null) {
                    punto.desplazar(deltaX, deltaY);
                }
            }
        }
        this.centroX += deltaX;
        this.centroY += deltaY;
    }

    public abstract void rotar(double angulo);

    public void escalar(double factor) {
        if (puntos != null) {
            for (Punto punto : puntos) {
                if (punto != null) {
                    punto.setX(centroX + factor * (punto.getX() - centroX));
                    punto.setY(centroY + factor * (punto.getY() - centroY));
                }
            }
        }
    }

    public boolean contienePunto(Punto punto) {
        // Implementación específica en subclases
        return false;
    }

    public double distanciaA(Figura otraFigura) {
        return Calculable.calcularDistancia(new Punto(centroX, centroY), new Punto(otraFigura.getCentroX(), otraFigura.getCentroY()));
    }

    public boolean intersecta(Figura otraFigura) {
        // Implementación específica en subclases
        return false;
    }

    public int getNumeroLados() {
        if (puntos != null) {
            return puntos.length;
        }
        return 0;
    }

    private double calcularCentroideX() {
        if (puntos == null || puntos.length == 0) {
            return 0;
        }
        double sumaX = 0;
        for (Punto punto : puntos) {
            if (punto != null) {
                sumaX += punto.getX();
            }
        }
        return sumaX / puntos.length;
    }

    private double calcularCentroideY() {
        if (puntos == null || puntos.length == 0) {
            return 0;
        }
        double sumaY = 0;
        for (Punto punto : puntos) {
            if (punto != null) {
                sumaY += punto.getY();
            }
        }
        return sumaY / puntos.length;
    }

    // Método toString() (puede ser sobreescrito en las subclases)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Puntos: ");
        if (puntos != null) {
            for (Punto punto : puntos) {
                sb.append(punto.toString()).append(" ");
            }
        } else {
            sb.append("ninguno");
        }
        return "Figura ID: " + id + ", Color: " + color + ", Centro: (" + centroX + ", " + centroY + "), " + sb.toString();
    }
/*
    // toString() y equals()
    @Override
    public String toString() {
        return "Figura ID: " + id + ", Color: " + color + ", Centro: (" + centroX + ", " + centroY + "), Puntos: " + Arrays.toString(puntos);
    }
*/

    // Método equals() (puede ser sobreescrito en las subclases)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Figura otraFigura = (Figura) obj;
        if (puntos == null && otraFigura.puntos == null) {
            return true;
        }
        if (puntos == null || otraFigura.puntos == null || puntos.length != otraFigura.puntos.length) {
            return false;
        }
        for (int i = 0; i < puntos.length; i++) {
            if (!puntos[i].equals(otraFigura.puntos[i])) {
                return false;
            }
        }
        return true;
    }

/* 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Figura otraFigura = (Figura) obj;
        return Arrays.deepEquals(puntos, otraFigura.puntos) && color.equals(otraFigura.color) && centroX == otraFigura.centroX && centroY == otraFigura.centroY && id == otraFigura.id;
    }
*/
}

/* -------------------------------------------------------------------------- */

/*
public abstract class Figura implements Calculable, Dibujable {
    protected Punto[] puntos; // Vector de puntos que definen la figura

    // Constructor por defecto
    public Figura() {
        this.puntos = new Punto[0]; // Inicialmente sin puntos
    }

    // Constructor con parámetros (vector de puntos)
    public Figura(Punto[] puntos) {
        if (puntos != null) {
            this.puntos = new Punto[puntos.length];
            for (int i = 0; i < puntos.length; i++) {
                if (puntos[i] != null) {
                    this.puntos[i] = new Punto(puntos[i]); // Copia en profundidad de cada punto
                } else {
                    this.puntos[i] = null; // Manejar puntos nulos si existen
                }
            }
        } else {
            this.puntos = new Punto[0];
        }
    }

    // Constructor de copia
    public Figura(Figura otraFigura) {
        if (otraFigura.puntos != null) {
            this.puntos = new Punto[otraFigura.puntos.length];
            for (int i = 0; i < otraFigura.puntos.length; i++) {
                if (otraFigura.puntos[i] != null) {
                    this.puntos[i] = new Punto(otraFigura.puntos[i]); // Copia en profundidad de cada punto
                } else {
                    this.puntos[i] = null; // Manejar puntos nulos si existen
                }
            }
        } else {
            this.puntos = new Punto[0];
        }
    }

    // Getter para el vector de puntos
    public Punto[] getPuntos() {
        if (puntos != null) {
            Punto[] copia = new Punto[puntos.length];
            for (int i = 0; i < puntos.length; i++) {
                if (puntos[i] != null) {
                    copia[i] = new Punto(puntos[i]); // Copia en profundidad de cada punto
                } else {
                    copia[i] = null; // Manejar puntos nulos si existen
                }
            }
            return copia;
        } else {
            return new Punto[0];
        }
    }

    // Setter para el vector de puntos
    public void setPuntos(Punto[] puntos) {
        if (puntos != null) {
            this.puntos = new Punto[puntos.length];
            for (int i = 0; i < puntos.length; i++) {
                if (puntos[i] != null) {
                    this.puntos[i] = new Punto(puntos[i]); // Copia en profundidad de cada punto
                } else {
                    this.puntos[i] = null; // Manejar puntos nulos si existen
                }
            }
        } else {
            this.puntos = new Punto[0];
        }
    }

    // Métodos abstractos de la interfaz Calculable (deben ser implementados por las subclases)
    @Override
    public abstract double calcularArea();

    @Override
    public abstract double calcularPerimetro();

    // Método de la interfaz Dibujable (puede ser implementado o dejado vacío en las subclases)
    @Override
    public void dibujar() {
        System.out.println("Dibujando figura (implementación pendiente)");
    }

    // Método toString() (puede ser sobreescrito en las subclases)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Puntos: ");
        if (puntos != null) {
            for (Punto punto : puntos) {
                sb.append(punto.toString()).append(" ");
            }
        } else {
            sb.append("ninguno");
        }
        return sb.toString();
    }

    // Método equals() (puede ser sobreescrito en las subclases)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Figura otraFigura = (Figura) obj;
        if (puntos == null && otraFigura.puntos == null) {
            return true;
        }
        if (puntos == null || otraFigura.puntos == null || puntos.length != otraFigura.puntos.length) {
            return false;
        }
        for (int i = 0; i < puntos.length; i++) {
            if (!puntos[i].equals(otraFigura.puntos[i])) {
                return false;
            }
        }
        return true;
    }
}
*/

/* ---------------------------------------------------------------------------- */

/*
La elección de inicializar this.puntos con new Punto[0] en lugar de null se 
debe a varias consideraciones importantes relacionadas con la claridad del 
código, la prevención de errores y la facilidad de uso. Aquí te explico las 
razones principales:

1. Evitar NullPointerExceptions:
    Cuando trabajas con un vector que es null, cualquier intento de acceder a 
    sus elementos o a su longitud resultará en una NullPointerException. Esto 
    puede llevar a errores difíciles de depurar.

    Al inicializar el vector como new Punto[0], te aseguras de que siempre 
    exista un objeto vector válido, incluso si no contiene elementos. Esto 
    elimina la necesidad de realizar comprobaciones de null constantes antes 
    de realizar operaciones con el vector.

2. Claridad y Consistencia del Código:
    Inicializar el vector como un vector vacío (new Punto[0]) comunica 
    claramente la intención de que la figura puede tener cero puntos, en 
    lugar de un estado indeterminado (null).

    Esto hace que el código sea más legible y fácil de entender, ya que el 
    comportamiento del vector es consistente en todas las circunstancias.

3. Facilidad de Iteración:
    Si el vector es null, no puedes iterar sobre él utilizando bucles 
    for-each o bucles for tradicionales sin realizar comprobaciones de null.
    
    Con un vector vacío, puedes iterar sobre él de forma segura, ya que el 
    bucle simplemente no se ejecutará si el vector no contiene elementos.

4. Compatibilidad con Métodos de Arrays:
    Muchos métodos de la clase Arrays en Java están diseñados para trabajar 
    con vectores, y algunos de ellos pueden lanzar excepciones si se les pasa 
    un vector null.
    Al usar un vector vacío, te aseguras de que estos métodos funcionen 
    correctamente, incluso cuando la figura no tiene puntos.

 */


 /* ---------------------------------------------------------------------------- */

/* Alternativa a esta implementación */
/*
import java.util.Arrays;

public abstract class Figura implements Calculable, Dibujable {
    protected Punto[] puntos; // Vector de puntos que definen la figura

    // Constructor por defecto
    public Figura() {
        this.puntos = new Punto[0]; // Inicialmente sin puntos
    }

    // Constructor con parámetros (vector de puntos)
    public Figura(Punto[] puntos) {
        this.puntos = puntos.clone(); // Clonamos el vector para evitar modificaciones externas
    }

    // Constructor de copia
    public Figura(Figura otraFigura) {
        this.puntos = otraFigura.getPuntos().clone();
    }

    // Getter para el vector de puntos
    public Punto[] getPuntos() {
        return puntos.clone(); // Devolvemos una copia para evitar modificaciones externas
    }

    // Setter para el vector de puntos
    public void setPuntos(Punto[] puntos) {
        this.puntos = puntos.clone();
    }

    // Métodos abstractos de la interfaz Calculable (deben ser implementados por las subclases)
    @Override
    public abstract double calcularArea();

    @Override
    public abstract double calcularPerimetro();

    // Método de la interfaz Dibujable (puede ser implementado o dejado vacío en las subclases)
    @Override
    public void dibujar() {
        System.out.println("Dibujando figura (implementación pendiente)");
    }

    // Método toString() (puede ser sobreescrito en las subclases)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Puntos: ");
        if (puntos != null) {
            for (Punto punto : puntos) {
                sb.append(punto.toString()).append(" ");
            }
        } else {
            sb.append("ninguno");
        }
        return sb.toString();
    }

    // Método equals() (puede ser sobreescrito en las subclases)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Figura otraFigura = (Figura) obj;
        return Arrays.deepEquals(puntos, otraFigura.puntos);
    }
}

 */