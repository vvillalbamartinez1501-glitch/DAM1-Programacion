import java.util.Scanner;

public class LecturaScanner {
    public static int pedirEleccionMenu(String peticion, int[] opcionesMenu){
        Scanner sc = new Scanner(System.in);
        char intIntroducido;
        boolean opcionIntroducidaValida = false;

        System.out.println(peticion);
        do{

            intIntroducido = sc.nextLine().trim().charAt(0);
            opcionIntroducidaValida = comprobarOpcionIntroducidaValida(intIntroducido,opcionesMenu);

        }while(opcionIntroducidaValida);

        return Integer.getInteger(String.valueOf(intIntroducido));
    }

    public static boolean comprobarOpcionIntroducidaValida(char opcionIntroducida,int[] opcionesMenu){
        boolean opcionIntroducidaValida = false;

        for (int i = 0 ; i < opcionesMenu.length -1 && !opcionIntroducidaValida; i++){
            if (opcionesMenu[i] == Character.getNumericValue(opcionIntroducida)){
                opcionIntroducidaValida = true;
            }
        }

        return opcionIntroducidaValida;
    }

    public static String pedirString(String peticion){
        Scanner sc = new Scanner(System.in);
        String stringIntroducido;

        stringIntroducido = sc.nextLine();

        return stringIntroducido.trim();

    }

    public static String normalizarString(String string){
        return string.trim().toLowerCase();
    }


}
