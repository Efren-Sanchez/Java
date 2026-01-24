public enum TipoIVA {
    NORMAL(21.0),
    REDUCIDO(10.0),
    SUPER_REDUCIDO(4.0);

    private final double porcentaje;

    TipoIVA(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    // Ejemplo de uso
    /*
    public static void main(String[] args) {
        for (TipoIVA tipo : TipoIVA.values()) {
            System.out.println(tipo + ": " + tipo.getPorcentaje() + "%");
        }
    }
    */
}
