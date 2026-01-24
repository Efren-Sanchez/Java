import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int MAX_FIGURAS = 100;
    private static Figura[] figuras = new Figura[MAX_FIGURAS];
    private static int numFiguras = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = obtenerOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Agregar figura");
        System.out.println("2. Mostrar figuras");
        System.out.println("3. Calcular área/perímetro");
        System.out.println("4. Calcular distancia puntos");
        System.out.println("5. Agregar figura aleatoria");
        System.out.println("0. Salir");
        System.out.print("Ingrese opción: ");
    }

    private static int obtenerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Ingrese un número entero.");
            scanner.nextLine();
            System.out.print("Ingrese opción: ");
        }
        return scanner.nextInt();
    }

    private static void ejecutarOpcion(int opcion) {
        scanner.nextLine();
        switch (opcion) {
            case 1:
                mostrarMenuAgregarFigura();
                break;
            case 2:
                mostrarFiguras();
                break;
            case 3:
                calcularAreaPerimetro();
                break;
            case 4:
                calcularDistanciaPuntos();
                break;
            case 5:
                agregarFiguraAleatoria();
                break;
            case 0:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private static void mostrarMenuAgregarFigura() {
        if (numFiguras >= MAX_FIGURAS) {
            System.out.println("No se pueden agregar más figuras. El vector está lleno.");
            return;
        }

        System.out.println("\n--- Agregar Figura ---");
        System.out.println("1. Triángulo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Círculo");
        System.out.println("4. Elipse");
        System.out.println("5. Arco");
        System.out.println("6. Parábola");
        System.out.println("7. Hipérbola");
        System.out.print("Ingrese opción: ");

        int opcion = obtenerOpcion();
        scanner.nextLine();
        switch (opcion) {
            case 1:
                agregarTriangulo();
                break;
            case 2:
                agregarCuadrado();
                break;
            case 3:
                agregarCirculo();
                break;
            case 4:
                agregarElipse();
                break;
            case 5:
                agregarArco();
                break;
            case 6:
                agregarParabola();
                break;
            case 7:
                agregarHiperbola();
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private static void agregarTriangulo() {
        System.out.print("Color: ");
        String color = scanner.nextLine();
        Punto[] puntos = obtenerPuntos(3);
        figuras[numFiguras++] = new Triangulo(puntos, color);
        System.out.println("Triángulo agregado.");
    }

    private static void agregarCuadrado() {
        System.out.print("Color: ");
        String color = scanner.nextLine();
        Punto[] puntos = obtenerPuntos(4);
        figuras[numFiguras++] = new Cuadrilatero(puntos, color);
        System.out.println("Cuadrado agregado.");
    }

    private static void agregarCirculo() {
        System.out.print("Color: ");
        String color = scanner.nextLine();
        Punto centro = obtenerPunto("centro");
        double radio = obtenerDouble("radio");
        figuras[numFiguras++] = new Circulo(centro, radio, color);
        System.out.println("Círculo agregado.");
    }

    private static void agregarElipse() {
        System.out.print("Color: ");
        String color = scanner.nextLine();
        Punto centro = obtenerPunto("centro");
        double ejeMayor = obtenerDouble("eje mayor");
        double ejeMenor = obtenerDouble("eje menor");
        figuras[numFiguras++] = new Elipse(centro, ejeMayor, ejeMenor, color);
        System.out.println("Elipse agregada.");
    }

    private static void agregarArco() {
        System.out.print("Color: ");
        String color = scanner.nextLine();
        Punto centro = obtenerPunto("centro");
        double radio = obtenerDouble("radio");
        double anguloInicial = obtenerDouble("ángulo inicial");
        double anguloFinal = obtenerDouble("ángulo final");
        figuras[numFiguras++] = new Arco(centro, radio, anguloInicial, anguloFinal, color);
        System.out.println("Arco agregado.");
    }

    private static void agregarParabola() {
        System.out.print("Color: ");
        String color = scanner.nextLine();
        Punto vertice = obtenerPunto("vértice");
        double parametro = obtenerDouble("parámetro");
        figuras[numFiguras++] = new Parabola(vertice, parametro, color);
        System.out.println("Parábola agregada.");
    }

    private static void agregarHiperbola() {
        System.out.print("Color: ");
        String color = scanner.nextLine();
        Punto centro = obtenerPunto("centro");
        double a = obtenerDouble("semieje mayor");
        double b = obtenerDouble("semieje menor");
        figuras[numFiguras++] = new Hiperbola(centro, a, b, color);
        System.out.println("Hipérbola agregada.");
    }

    private static Punto[] obtenerPuntos(int cantidad) {
        Punto[] puntos = new Punto[cantidad];
        for (int i = 0; i < cantidad; i++) {
            puntos[i] = obtenerPunto(i + 1);
        }
        return puntos;
    }

    private static Punto obtenerPunto(int numeroPunto) {
        System.out.print("Punto " + numeroPunto + " (x y): ");
        return obtenerPunto();
    }

    private static Punto obtenerPunto(String nombrePunto) {
        System.out.print(nombrePunto + " (x y): ");
        return obtenerPunto();
    }

    private static Punto obtenerPunto() {
        double x = obtenerDouble("x");
        double y = obtenerDouble("y");
        return new Punto(x, y);
    }

    private static double obtenerDouble(String nombre) {
        System.out.print(nombre + ": ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Ingrese un número.");
            scanner.nextLine();
            System.out.print(nombre + ": ");
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }

    private static void mostrarFiguras() {
        System.out.println("\n--- Lista de Figuras ---");
        for (int i = 0; i < numFiguras; i++) {
            System.out.println(figuras[i]);
        }
    }

    private static void calcularAreaPerimetro() {
        System.out.println("\n--- Calcular Área/Perímetro ---");
        System.out.print("Índice de la figura (0-" + (numFiguras - 1) + "): ");
        int indice = obtenerOpcion();
        scanner.nextLine();

        if (indice >= 0 && indice < numFiguras) {
            Figura figura = figuras[indice];
            System.out.println("Área: " + figura.calcularArea());
            if (figura instanceof Poligono) {
                System.out.println("Perímetro: " + ((Poligono) figura).calcularPerimetro());
            } else if (figura instanceof Curva) {
                System.out.println("Longitud: " + ((Curva) figura).calcularLongitud());
            }
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void calcularDistanciaPuntos() {
        System.out.println("\n--- Calcular Distancia Puntos ---");
        Punto punto1 = obtenerPunto("Punto 1");
        Punto punto2 = obtenerPunto("Punto 2");
        System.out.println("Distancia: " + Calculable.calcularDistancia(punto1, punto2));
    }
        
    // ... (otros métodos para agregar figuras)

    private static void agregarFiguraAleatoria() {
        int tipoFigura = random.nextInt(7) + 1; // 1-7 (tipos de figuras)
        switch (tipoFigura) {
            case 1:
                agregarTrianguloAleatorio();
                break;
            case 2:
                agregarCuadradoAleatorio();
                break;
            case 3:
                agregarCirculoAleatorio();
                break;
            case 4:
                agregarElipseAleatorio();
                break;
            case 5:
                agregarArcoAleatorio();
                break;
            case 6:
                agregarParabolaAleatorio();
                break;
            case 7:
                agregarHiperbolaAleatorio();
                break;
        }
        System.out.println("Figura aleatoria agregada.");
    }

    private static void agregarTrianguloAleatorio() {
        String color = obtenerColorAleatorio();
        Punto[] puntos = obtenerPuntosAleatorios(3);
        figuras[numFiguras++] = new Triangulo(puntos, color);
    }

    private static void agregarCuadradoAleatorio() {
        String color = obtenerColorAleatorio();
        Punto[] puntos = obtenerPuntosAleatorios(4);
        figuras[numFiguras++] = new Cuadrilatero(puntos, color);
    }

    private static void agregarCirculoAleatorio() {
        String color = obtenerColorAleatorio();
        Punto centro = obtenerPuntoAleatorio();
        double radio = obtenerDoubleAleatorio();
        figuras[numFiguras++] = new Circulo(centro, radio, color);
    }

    private static void agregarElipseAleatorio() {
        String color = obtenerColorAleatorio();
        Punto centro = obtenerPuntoAleatorio();
        double ejeMayor = obtenerDoubleAleatorio();
        double ejeMenor = obtenerDoubleAleatorio();
        figuras[numFiguras++] = new Elipse(centro, ejeMayor, ejeMenor, color);
    }

    private static void agregarArcoAleatorio() {
        String color = obtenerColorAleatorio();
        Punto centro = obtenerPuntoAleatorio();
        double radio = obtenerDoubleAleatorio();
        double anguloInicial = obtenerDoubleAleatorio();
        double anguloFinal = obtenerDoubleAleatorio();
        figuras[numFiguras++] = new Arco(centro, radio, anguloInicial, anguloFinal, color);
    }

    private static void agregarParabolaAleatorio() {
        String color = obtenerColorAleatorio();
        Punto vertice = obtenerPuntoAleatorio();
        double parametro = obtenerDoubleAleatorio();
        figuras[numFiguras++] = new Parabola(vertice, parametro, color);
    }

    private static void agregarHiperbolaAleatorio() {
        String color = obtenerColorAleatorio();
        Punto centro = obtenerPuntoAleatorio();
        double a = obtenerDoubleAleatorio();
        double b = obtenerDoubleAleatorio();
        figuras[numFiguras++] = new Hiperbola(centro, a, b, color);
    }

    private static String obtenerColorAleatorio() {
        String[] colores = {"Rojo", "Azul", "Verde", "Amarillo", "Naranja", "Morado", "Rosa", "Gris", "Cian", "Magenta"};
        return colores[random.nextInt(colores.length)];
    }

    private static Punto[] obtenerPuntosAleatorios(int cantidad) {
        Punto[] puntos = new Punto[cantidad];
        for (int i = 0; i < cantidad; i++) {
            puntos[i] = obtenerPuntoAleatorio();
        }
        return puntos;
    }

    private static Punto obtenerPuntoAleatorio() {
        double x = random.nextDouble() * 20 - 10; // Rango -10 a 10
        double y = random.nextDouble() * 20 - 10;
        return new Punto(x, y);
    }

    private static double obtenerDoubleAleatorio() {
        return random.nextDouble() * 10; // Rango 0 a 10
    }

    // ... (otros métodos)
}

/*
import java.util.Scanner;

public class Main {

    private static final int MAX_FIGURAS = 100;
    private static Figura[] figuras = new Figura[MAX_FIGURAS];
    private static int numFiguras = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = obtenerOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Agregar figura");
        System.out.println("2. Mostrar figuras");
        System.out.println("3. Calcular área/perímetro");
        System.out.println("4. Calcular distancia puntos");
        System.out.println("0. Salir");
        System.out.print("Ingrese opción: ");
    }

    private static int obtenerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Ingrese un número entero.");
            scanner.nextLine();
            System.out.print("Ingrese opción: ");
        }
        return scanner.nextInt();
    }

    private static void ejecutarOpcion(int opcion) {
        scanner.nextLine();
        switch (opcion) {
            case 1:
                mostrarMenuAgregarFigura();
                break;
            case 2:
                mostrarFiguras();
                break;
            case 3:
                calcularAreaPerimetro();
                break;
            case 4:
                calcularDistanciaPuntos();
                break;
            case 0:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private static void mostrarMenuAgregarFigura() {
        if (numFiguras >= MAX_FIGURAS) {
            System.out.println("No se pueden agregar más figuras. El vector está lleno.");
            return;
        }

        System.out.println("\n--- Agregar Figura ---");
        System.out.println("1. Triángulo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Círculo");
        System.out.println("4. Elipse");
        System.out.println("5. Arco");
        System.out.println("6. Parábola");
        System.out.println("7. Hipérbola");
        System.out.print("Ingrese opción: ");

        int opcion = obtenerOpcion();
        scanner.nextLine();
        switch (opcion) {
            case 1:
                agregarTriangulo();
                break;
            case 2:
                agregarCuadrado();
                break;
            case 3:
                agregarCirculo();
                break;
            case 4:
                agregarElipse();
                break;
            case 5:
                agregarArco();
                break;
            case 6:
                agregarParabola();
                break;
            case 7:
                agregarHiperbola();
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private static void agregarTriangulo() {
        System.out.print("Color: ");
        String color = scanner.nextLine();
        Punto[] puntos = obtenerPuntos(3);
        figuras[numFiguras++] = new Triangulo(puntos, color);
        System.out.println("Triángulo agregado.");
    }

    private static void agregarCuadrado() {
        System.out.print("Color: ");
        String color = scanner.nextLine();
        Punto[] puntos = obtenerPuntos(4);
        figuras[numFiguras++] = new Cuadrilatero(puntos, color);
        System.out.println("Cuadrado agregado.");
    }

    private static void agregarCirculo() {
        System.out.print("Color: ");
        String color = scanner.nextLine();
        Punto centro = obtenerPunto("centro");
        double radio = obtenerDouble("radio");
        figuras[numFiguras++] = new Circulo(centro, radio, color);
        System.out.println("Círculo agregado.");
    }

    private static void agregarElipse() {
        System.out.print("Color: ");
        String color = scanner.nextLine();
        Punto centro = obtenerPunto("centro");
        double ejeMayor = obtenerDouble("eje mayor");
        double ejeMenor = obtenerDouble("eje menor");
        figuras[numFiguras++] = new Elipse(centro, ejeMayor, ejeMenor, color);
        System.out.println("Elipse agregada.");
    }

    private static void agregarArco() {
        System.out.print("Color: ");
        String color = scanner.nextLine();
        Punto centro = obtenerPunto("centro");
        double radio = obtenerDouble("radio");
        double anguloInicial = obtenerDouble("ángulo inicial");
        double anguloFinal = obtenerDouble("ángulo final");
        figuras[numFiguras++] = new Arco(centro, radio, anguloInicial, anguloFinal, color);
        System.out.println("Arco agregado.");
    }

    private static void agregarParabola() {
        System.out.print("Color: ");
        String color = scanner.nextLine();
        Punto vertice = obtenerPunto("vértice");
        double parametro = obtenerDouble("parámetro");
        figuras[numFiguras++] = new Parabola(vertice, parametro, color);
        System.out.println("Parábola agregada.");
    }

    private static void agregarHiperbola() {
        System.out.print("Color: ");
        String color = scanner.nextLine();
        Punto centro = obtenerPunto("centro");
        double a = obtenerDouble("semieje mayor");
        double b = obtenerDouble("semieje menor");
        figuras[numFiguras++] = new Hiperbola(centro, a, b, color);
        System.out.println("Hipérbola agregada.");
    }

    private static Punto[] obtenerPuntos(int cantidad) {
        Punto[] puntos = new Punto[cantidad];
        for (int i = 0; i < cantidad; i++) {
            puntos[i] = obtenerPunto(i + 1);
        }
        return puntos;
    }

    private static Punto obtenerPunto(int numeroPunto) {
        System.out.print("Punto " + numeroPunto + " (x y): ");
        return obtenerPunto();
    }

    private static Punto obtenerPunto(String nombrePunto) {
        System.out.print(nombrePunto + " (x y): ");
        return obtenerPunto();
    }

    private static Punto obtenerPunto() {
        double x = obtenerDouble("x");
        double y = obtenerDouble("y");
        return new Punto(x, y);
    }

    private static double obtenerDouble(String nombre) {
        System.out.print(nombre + ": ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida. Ingrese un número.");
            scanner.nextLine();
            System.out.print(nombre + ": ");
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }

    private static void mostrarFiguras() {
        System.out.println("\n--- Lista de Figuras ---");
        for (int i = 0; i < numFiguras; i++) {
            System.out.println(figuras[i]);
        }
    }

    private static void calcularAreaPerimetro() {
        System.out.println("\n--- Calcular Área/Perímetro ---");
        System.out.print("Índice de la figura (0-" + (numFiguras - 1) + "): ");
        int indice = obtenerOpcion();
        scanner.nextLine();

        if (indice >= 0 && indice < numFiguras) {
            Figura figura = figuras[indice];
            System.out.println("Área: " + figura.calcularArea());
            if (figura instanceof Poligono) {
                System.out.println("Perímetro: " + ((Poligono) figura).calcularPerimetro());
            } else if (figura instanceof Curva) {
                System.out.println("Longitud: " + ((Curva) figura).calcularLongitud());
            }
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void calcularDistanciaPuntos() {
        System.out.println("\n--- Calcular Distancia Puntos ---");
        Punto punto1 = obtenerPunto("Punto 1");
        Punto punto2 = obtenerPunto("Punto 2");
        System.out.println("Distancia: " + Calculable.calcularDistancia(punto1, punto2));
    }
        
    }

/* ------------------------------------------------------------------------- */

/*
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Figura[] figuras = new Figura[100]; // Tamaño máximo del vector
        int numFiguras = 0;
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    agregarFigura(figuras, numFiguras, scanner);
                    numFiguras++;
                    break;
                case 2:
                    mostrarFiguras(figuras, numFiguras);
                    break;
                case 3:
                    calcularAreaPerimetro(figuras, numFiguras, scanner);
                    break;
                case 4:
                    calcularDistanciaPuntos(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Agregar figura");
        System.out.println("2. Mostrar figuras");
        System.out.println("3. Calcular área/perímetro");
        System.out.println("4. Calcular distancia puntos");
        System.out.println("0. Salir");
        System.out.print("Ingrese opción: ");
    }

    private static void agregarFigura(Figura[] figuras, int numFiguras, Scanner scanner) {
        System.out.println("\n--- Agregar Figura ---");
        System.out.print("Tipo de figura (Triangulo, Cuadrado, Circulo, etc.): ");
        String tipo = scanner.nextLine();

        switch (tipo.toLowerCase()) {
            case "triangulo":
                agregarTriangulo(figuras, numFiguras, scanner);
                break;
            case "cuadrado":
                agregarCuadrado(figuras, numFiguras, scanner);
                break;
            case "circulo":
                agregarCirculo(figuras, numFiguras, scanner);
                break;
            // Agregar casos para otras figuras
            default:
                System.out.println("Tipo de figura no soportado.");
        }
    }

    private static void agregarTriangulo(Figura[] figuras, int numFiguras, Scanner scanner) {
        // Lógica para agregar un triángulo (pedir puntos, color, etc.)
        System.out.print("Color: ");
        String color = scanner.nextLine();

        Punto[] puntos = new Punto[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Punto " + (i + 1) + " (x y): ");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            puntos[i] = new Punto(x, y);
            scanner.nextLine(); // Consumir la nueva línea
        }

        figuras[numFiguras] = new Triangulo(puntos, color);
        System.out.println("Triángulo agregado.");
    }

    private static void agregarCuadrado(Figura[] figuras, int numFiguras, Scanner scanner) {
        // Lógica para agregar un cuadrado
        System.out.print("Color: ");
        String color = scanner.nextLine();

        Punto[] puntos = new Punto[4];
        for (int i = 0; i < 4; i++) {
            System.out.print("Punto " + (i + 1) + " (x y): ");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            puntos[i] = new Punto(x, y);
            scanner.nextLine(); // Consumir la nueva línea
        }

        figuras[numFiguras] = new Cuadrado(puntos, color);
        System.out.println("Cuadrado agregado.");
    }

    private static void agregarCirculo(Figura[] figuras, int numFiguras, Scanner scanner) {
        // Lógica para agregar un círculo
        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Centro (x y): ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        scanner.nextLine(); // Consumir la nueva línea
        Punto centro = new Punto(x, y);

        System.out.print("Radio: ");
        double radio = scanner.nextDouble();
        scanner.nextLine(); // Consumir la nueva línea

        figuras[numFiguras] = new Circulo(centro, radio, color);
        System.out.println("Círculo agregado.");
    }

    private static void mostrarFiguras(Figura[] figuras, int numFiguras) {
        System.out.println("\n--- Lista de Figuras ---");
        for (int i = 0; i < numFiguras; i++) {
            System.out.println(figuras[i]);
        }
    }

    private static void calcularAreaPerimetro(Figura[] figuras, int numFiguras, Scanner scanner) {
        System.out.println("\n--- Calcular Área/Perímetro ---");
        System.out.print("Índice de la figura (0-" + (numFiguras - 1) + "): ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        if (indice >= 0 && indice < numFiguras) {
            Figura figura = figuras[indice];
            System.out.println("Área: " + figura.calcularArea());
            if (figura instanceof Poligono) {
                System.out.println("Perímetro: " + ((Poligono) figura).calcularPerimetro());
            } else if (figura instanceof Curva) {
                System.out.println("Longitud: " + ((Curva) figura).calcularLongitud());
            }
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void calcularDistanciaPuntos(Scanner scanner) {
        System.out.println("\n--- Calcular Distancia Puntos ---");
        System.out.print("Punto 1 (x y): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        scanner.nextLine(); // Consumir la nueva línea
        Punto punto1 = new Punto(x1, y1);

        System.out.print("Punto 2 (x y): ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        scanner.nextLine(); // Consumir la nueva línea
        Punto punto2 = new Punto(x2, y2);

        System.out.println("Distancia: " + Calculable.calcularDistancia(punto1, punto2));
    }
}
*/

/* ------------------------------------------------------------------------- */

/*
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Figura> figuras = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    agregarFigura(figuras, scanner);
                    break;
                case 2:
                    mostrarFiguras(figuras);
                    break;
                case 3:
                    calcularAreaPerimetro(figuras, scanner);
                    break;
                case 4:
                    calcularDistanciaPuntos(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Agregar figura");
        System.out.println("2. Mostrar figuras");
        System.out.println("3. Calcular área/perímetro");
        System.out.println("4. Calcular distancia puntos");
        System.out.println("0. Salir");
        System.out.print("Ingrese opción: ");
    }

    private static void agregarFigura(List<Figura> figuras, Scanner scanner) {
        System.out.println("\n--- Agregar Figura ---");
        System.out.print("Tipo de figura (Triangulo, Cuadrado, Circulo, etc.): ");
        String tipo = scanner.nextLine();

        switch (tipo.toLowerCase()) {
            case "triangulo":
                agregarTriangulo(figuras, scanner);
                break;
            case "cuadrado":
                agregarCuadrado(figuras, scanner);
                break;
            case "circulo":
                agregarCirculo(figuras, scanner);
                break;
            // Agregar casos para otras figuras
            default:
                System.out.println("Tipo de figura no soportado.");
        }
    }

    private static void agregarTriangulo(List<Figura> figuras, Scanner scanner) {
        // Lógica para agregar un triángulo (pedir puntos, color, etc.)
        System.out.print("Color: ");
        String color = scanner.nextLine();

        Punto[] puntos = new Punto[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Punto " + (i + 1) + " (x y): ");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            puntos[i] = new Punto(x, y);
            scanner.nextLine(); // Consumir la nueva línea
        }

        figuras.add(new Triangulo(puntos, color));
        System.out.println("Triángulo agregado.");
    }

    private static void agregarCuadrado(List<Figura> figuras, Scanner scanner) {
        // Lógica para agregar un cuadrado
        System.out.print("Color: ");
        String color = scanner.nextLine();

        Punto[] puntos = new Punto[4];
        for (int i = 0; i < 4; i++) {
            System.out.print("Punto " + (i + 1) + " (x y): ");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            puntos[i] = new Punto(x, y);
            scanner.nextLine(); // Consumir la nueva línea
        }

        figuras.add(new Cuadrado(puntos, color));
        System.out.println("Cuadrado agregado.");
    }

    private static void agregarCirculo(List<Figura> figuras, Scanner scanner) {
        // Lógica para agregar un círculo
        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Centro (x y): ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        scanner.nextLine(); // Consumir la nueva línea
        Punto centro = new Punto(x, y);

        System.out.print("Radio: ");
        double radio = scanner.nextDouble();
        scanner.nextLine(); // Consumir la nueva línea

        figuras.add(new Circulo(centro, radio, color));
        System.out.println("Círculo agregado.");
    }

    private static void mostrarFiguras(List<Figura> figuras) {
        System.out.println("\n--- Lista de Figuras ---");
        for (Figura figura : figuras) {
            System.out.println(figura);
        }
    }

    private static void calcularAreaPerimetro(List<Figura> figuras, Scanner scanner) {
        System.out.println("\n--- Calcular Área/Perímetro ---");
        System.out.print("Índice de la figura (0-" + (figuras.size() - 1) + "): ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        if (indice >= 0 && indice < figuras.size()) {
            Figura figura = figuras.get(indice);
            System.out.println("Área: " + figura.calcularArea());
            if (figura instanceof Poligono) {
                System.out.println("Perímetro: " + ((Poligono) figura).calcularPerimetro());
            } else if (figura instanceof Curva) {
                System.out.println("Longitud: " + ((Curva) figura).calcularLongitud());
            }
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void calcularDistanciaPuntos(Scanner scanner) {
        System.out.println("\n--- Calcular Distancia Puntos ---");
        System.out.print("Punto 1 (x y): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        scanner.nextLine(); // Consumir la nueva línea
        Punto punto1 = new Punto(x1, y1);

        System.out.print("Punto 2 (x y): ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        scanner.nextLine(); // Consumir la nueva línea
        Punto punto2 = new Punto(x2, y2);

        System.out.println("Distancia: " + Calculable.calcularDistancia(punto1, punto2));
    }
}
 */