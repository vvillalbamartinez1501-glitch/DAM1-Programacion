public class DisplayMenu {
    public static String mostrarBienvenida() {
        StringBuilder sb = new StringBuilder();

        sb.append("--------------------------------------");
        sb.append(" \t \tIniciando Discordito...\n");
        sb.append("--------------------------------------");

        return sb.toString();
    }

    public static String menuPrincipal() {
        StringBuilder sb = new StringBuilder();

        sb.append("1. Crear Servidor");
        sb.append("\n");
        sb.append("2. Añadir miembro a servidor");
        sb.append("\n");
        sb.append("3. Crear canal en servidor");
        sb.append("\n");
        sb.append("4. Asignar admin en servidor");
        sb.append("\n");
        sb.append("5. Mover miembro entre servidores");
        sb.append("\n");
        sb.append("6. Listar estado");
        sb.append("\n");
        sb.append("0. Salir");

        return sb.toString();
    }

    public String pedirServidor(Servidor[] servidor) {
        StringBuilder sb = new StringBuilder("Listado de servidores:");

        sb.append("\n");
        for (int i = 0; i < servidor.length; i++) {
            sb.append(i+1);
            sb.append(" - ");
            sb.append(servidor[i].toString());
            sb.append("\n");
        }

        return sb.toString();
    }
    
}









/*
    public static String opcionesDeCreacion(){
        StringBuilder sb = new StringBuilder();

        sb.append("Crear servidor");
        sb.append("Crear canal");
        sb.append("Crear miembro");

        return sb.toString();
    }

    public static String opcionesDeAgregar(){
        StringBuilder sb = new StringBuilder();
        sb.append("Agregar canal existente a servidor");
        sb.append("Crear canal en servidor");
        sb.append("Agregar miembro existente a servidor");
        sb.append("Crear miembro y agregar a servidor");
        return sb.toString();
    }

    public static String opcionesDeCambiarNombre(){
        StringBuilder sb = new StringBuilder();

        sb.append("Cambiar nombre a servidor");
        sb.append("Cambiar nombre a canal");
        sb.append("Cambiar nombre a miembro");

        return sb.toString();
    }

    public static String opcionesDeCambioDeServidor(){
        StringBuilder sb = new StringBuilder();

        sb.append("Cambiar canal a otro servidor");
        sb.append("Cambiar miembro a otro servidor");

        return sb.toString();
    }
    */

