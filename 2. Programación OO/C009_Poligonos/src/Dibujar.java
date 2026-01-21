public interface Dibujar {
    static void lineaRecta(Punto p1, Punto p2) { 
        System.out.println("Pinto una recta");
    } 
    
    static void lineaCurva(Punto p1, Punto p2, Punto control) { 
        System.out.println("Pinto una curva");
    } 
}
