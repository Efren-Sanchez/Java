/*******************************************************************************
 * 
 * E091_CuentaCaracteres
 * 
 * Autor: Efrén Sánchez
 * Fecha: Octubre 2025
 * 
 * Cuenta caracteres
 *
 * Programa que cuenta los caracteres, los espacios no, de un texto.
 * 
 ******************************************************************************/

public class E091_CuentaCaracteres {
    public static void main(String[] args) {

		System.out.println("\n\n\n* E091_CuentaCaracteres *\n\n  --- Inicio del programa ---\n\n");
		
        String texto = "  E   fr    é n     ";
        int letras = 0;

        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) != ' ') 
                letras++;
        }

        System.out.println("El texto: \n-----------\n" + texto + "\n------------\ntiene " + letras + " caracteres.");

		System.out.println("\n\n  --- Fin del programa ---\n\n");
    }
}