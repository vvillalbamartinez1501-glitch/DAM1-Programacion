public class Servidor {
    private int id;
    private String codigo;
    private String nombre;

    private Miembro[] miembros;
    private Canal[] canales;
    private int adminId;
    private static int siguienteId = 0;

    public final int MAX_MIEMBROS;
    public final int MAX_CANALES;
    private int contador;

    public Servidor(String nombre, int cantidadMaximaDeMiembros, int cantidadMaximaCanales) {
        this.nombre = nombre;
        this.codigo = generarCodigoServidor();
        this.MAX_MIEMBROS = cantidadMaximaDeMiembros;
        this.MAX_CANALES = cantidadMaximaCanales;
        this.miembros = new Miembro[MAX_MIEMBROS];
        this.canales = new Canal[MAX_CANALES];
        this.adminId = -1;
        this.id = siguienteId++;
        this.contador = 0;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Miembro[] getMiembros() {
        return miembros;
    }

    public Canal[] getCanales() {
        return canales;
    }

    public int getAdminId() {
        return adminId;
    }




    // boolean agregar miembro (Miembro m)
    public boolean agregarMiembroSinClicker(Miembro miembro){
        boolean resultado = true;
        int huecoLibre = buscarHuecoLibreMiembros();
        boolean miembroEstaEnServidor = contieneMiembro(miembro.getId());
        if (huecoLibre == -1){
            resultado = false;
        }

        if (resultado && !miembroEstaEnServidor){
            miembros[huecoLibre] = miembro;
        } else{
            resultado = false;
        }

        return resultado;
    }

    // cambio en la comprobacion
    public boolean agregarMiembro(Miembro miembro){
        boolean resultado = true;
        boolean aforoCompleto = comprobarSiHayHuecoClicker();
        int huecoLibre /*= buscarHuecoLibreMiembros()*/;
        boolean miembroEstaEnServidor/* = contieneMiembro(miembro.getId())*/;

        if (!aforoCompleto){
            resultado = false;
        }

        huecoLibre = buscarHuecoLibreMiembros();
        miembroEstaEnServidor = contieneMiembro(miembro.getId());
        if (resultado && !miembroEstaEnServidor){
            introducirMiembroEnArray(miembro,huecoLibre);
        } else{
            resultado = false;
        }

        return resultado;
    }

    public void introducirMiembroEnArray(Miembro miembro,int posicion){
        miembros[posicion] = miembro;
    }

    public int buscarHuecoLibreMiembros(){
        int huecoLibre = -1;

        for(int i  = 0; i < MAX_MIEMBROS && huecoLibre == -1; i++){
            if (miembros[i] == null){
                huecoLibre = i;
            }
        }

        return huecoLibre;
    }

    private boolean comprobarSiHayHueco(){
        boolean hayHueco = false;
        for(int i  = 0; i < MAX_MIEMBROS && !hayHueco ; i++){
            if (miembros[i] == null){
                hayHueco = true;
            }
        }
        return hayHueco;
    }

    /**
     * COmprueba que el array de miembros está completo mediante un contador de aforo
     * Compara el valor del atributo contador con
     * @see
     * @return true si hay hueco (aforo disponible) o false si no hay hueco (aforo completo)
     */

    public boolean comprobarSiHayHuecoClicker(){
        boolean hayHueco;
        if(MAX_MIEMBROS > contador){
            hayHueco = true;
        } else {
            hayHueco = false;
        }
        return hayHueco;
    }

    public boolean comprobarSiHayHuecoPaseo(){
        boolean hayHueco = false;
        for(int i  = 0; i < MAX_MIEMBROS && !hayHueco ; i++){
            if (miembros[i] == null){
                hayHueco = true;
            }
        }
        return hayHueco;
    }

    // boolean contiene miembro (id)
    /*
    public boolean contieneMiembro(int idMiembro){
        boolean miembroEstaEnElServidor = false;
        boolean miembroEncontrado = false;
        for(Miembro miMiembro : miembros){
            if (!miembroEncontrado) {
                if (miMiembro != null && miMiembro.getId() == idMiembro){
                    miembroEstaEnElServidor = true;
                    miembroEncontrado = true;
                }
            }
        }
        return miembroEstaEnElServidor;
    }

    public boolean contieneMiembro(int idMiembro){
    boolean resultado = false;

    for (int i = 0 ; i < MAX_MIEMBROS && !resultado ; i++){
        if (miembros[i] != null && miembros[i].getId() == idMiembro){
            resultado = true;
        }
    }
    return resultado;
    }

        public boolean contieneMiembro(int idMiembro){
        boolean miembroEstaEnElServidor = false;
        boolean miembroEncontrado = false;
        int i = 0;
        do{
            if (miembros[i] != null && miembros[i].getId() == idMiembro){
                miembroEstaEnElServidor = true;
                miembroEncontrado = true;
            }
        }while(!miembroEncontrado);

        return miembroEstaEnElServidor;
    }
     */



    public boolean contieneMiembro(int idMiembro){
        boolean resultado = false;
        for (int i = 0 ; i < MAX_MIEMBROS && !resultado ; i++){
            if (miembros[i] != null && miembros[i].getId() == idMiembro){
                resultado = true;
            }
        }
        return resultado;
    }

    public int buscarPosicionMiembro(int idMiembro){
        int resultado =-1;
        for (int i = 0 ; i < MAX_MIEMBROS && resultado == -1 ; i++){
            if (miembros[i] != null && miembros[i].getId() == idMiembro){
                resultado = i;
            }
        }
        return resultado;
    }

    /**
     *
     * @param id
     * @return miembro sacado del server o nulo en caso de no estar
     */
    public Miembro quitarMiembroPorId(int id){
        Miembro miembroEliminado;
        int posicionMiembroAEliminar ;
        posicionMiembroAEliminar = buscarPosicionMiembro(id);
        if (posicionMiembroAEliminar == -1){
            miembroEliminado = null;
        } else {
            miembroEliminado = miembros[posicionMiembroAEliminar];
            miembros[posicionMiembroAEliminar] = null;
        }

        return miembroEliminado;

    }



    public int buscarPosicionMiembroEnElServidorPorId(int idMiembro){
        int posicionMiembroEnElServidor = -1;

        for (int i = 0 ; i < MAX_MIEMBROS  && posicionMiembroEnElServidor == -1; i++){
            if (miembros[i] != null && miembros[i].getId() == idMiembro){
                posicionMiembroEnElServidor = i;
            }
        }
        return posicionMiembroEnElServidor;
    }

    // boolean asignar admin (int id miembro)
    public boolean asignarAdmin(int idMiembro){
        boolean resultado = true;
        boolean hayAdmin;
        boolean miembroEstaEnServidor;
        int posicionMiembroEnElServidor = buscarPosicionMiembro(idMiembro);

        if (posicionMiembroEnElServidor == -1){
            miembroEstaEnServidor = false;
        } else {
            miembroEstaEnServidor = true;
        }
        hayAdmin = comprobarSiHayAdmin();
        if (hayAdmin || !miembroEstaEnServidor){
            resultado = false;
        }
        if (resultado){
            this.adminId = posicionMiembroEnElServidor;
        }
        return resultado;
    }

    public boolean comprobarSiHayAdmin(){
        boolean hayAdmin = false;
        if (adminId != -1){
            hayAdmin = true;
        }
        return hayAdmin;
    }

    //boolean agregar canal (canal)
    public boolean agregarCanal(Canal canal){
        int indiceNuevoCanal = -1;
        int posicionCanalEnElServidor;
        boolean canalAgregado = true;

        posicionCanalEnElServidor = darPosicionCanalEnELServidor(canal.getId());
        if (posicionCanalEnElServidor == -1){
            canalAgregado = false;
        }

        if (!canalAgregado){
            indiceNuevoCanal = buscarHuecoLibreCanales();
            if (indiceNuevoCanal == -1){
                canalAgregado = false;
            }
        }
        if (!canalAgregado){
            canales[indiceNuevoCanal] = canal;
        }

        return canalAgregado;
    }

    private int darPosicionCanalEnELServidor(int idCanal){
        int posicionCanalEnElServidor = -1;

        for (int i = 0 ; i < MAX_CANALES && posicionCanalEnElServidor == -1 ; i++){
            if (canales[i] != null && canales[i].getId() == idCanal ){
                posicionCanalEnElServidor = i;
            }
        }
        return posicionCanalEnElServidor;
    }

    private int buscarHuecoLibreCanales(){
        int posicionNuevoCanal = -1;
        for (int i = 0 ; i < MAX_CANALES && posicionNuevoCanal == -1 ; i++){
            if ( canales[i] == null){
                posicionNuevoCanal = i;
            }
        }
        return posicionNuevoCanal;
    }


    public Canal quitarCanalPorId(int idCanal){
        Canal canalAEliminar = null;
        for (int i = 0 ; i < MAX_CANALES ; i++){
            darPosicionCanalEnELServidor(idCanal);
            if (canales[i] != null && canales[i].getId() == idCanal ){
                canalAEliminar = canales[i];
                canales[i] = null;
            }
        }
        return canalAEliminar;
    }


    public int contarPlazasLibresMiembros(){
        int hayPlazasLibresMiembros = buscarHuecoLibreMiembros();
        int numeroPlazasLibres = 0;
        boolean resultado = true;
        if (hayPlazasLibresMiembros == -1){
            resultado = false;
        }
        if(resultado){
            for (int i = 0 ; i < MAX_MIEMBROS ; i++){
                if (miembros[i] == null){
                    numeroPlazasLibres++;
                }
            }
        }
        return numeroPlazasLibres;
    }

    public int contarPlazasLibresCanales(){
        int hayPlazasLibresCanales = buscarHuecoLibreCanales();
        int numeroPlazasLibres = 0;
        boolean resultado = true;
        if (hayPlazasLibresCanales == -1){
            resultado = false;
        }
        if(resultado){
            for (int i = 0 ; i < MAX_CANALES ; i++){
                if (miembros[i] == null){
                    numeroPlazasLibres++;
                }
            }
        }
        return numeroPlazasLibres;
    }

    public String sacarNombreAdmin(){
        String nombreAdmin;
        if (adminId == -1){
            nombreAdmin = "No hay admin en este servidor";
        } else{
            nombreAdmin = String.format("Nombre del admin: %s",this.miembros[adminId].getNick());
        }
        return nombreAdmin;
    }

    public String listarMiembros(){
        StringBuilder lista = new StringBuilder();
        int numeroPlazasLibresMiembros = contarPlazasLibresMiembros();

        if (numeroPlazasLibresMiembros == 0){
            lista.append("No hay miembros en este sevidor");
        }else{
            for (Miembro miMiembro : miembros){
                if (miMiembro != null){
                    lista.append("-");
                    lista.append(miMiembro.getNick());
                    lista.append("\n");
                }
            }
        }
        return lista.toString();
    }

    public String listarCanales(){
        StringBuilder lista = new StringBuilder();
        int numeroPlazasLibresCanales = contarPlazasLibresCanales();

        if (numeroPlazasLibresCanales == 0){
            lista.append("No hay canales en este sevidor");
        }else{
            for (Canal miCanal : canales){
                if (miCanal != null){
                    lista.append("-");
                    lista.append(miCanal.getNombre());
                    lista.append("\n");
                }
            }
        }
        return lista.toString();
    }

    private String generarCodigoServidor(){
        StringBuilder codigoServidor = new StringBuilder();

        codigoServidor.append(this.nombre.charAt(0));
        codigoServidor.append("-");
        codigoServidor.append(this.id);

        this.codigo = codigoServidor.toString();

        return codigoServidor.toString();
    }


    //string resumenServidor
    public String realizarResumenServidor(){
        StringBuilder sb = new StringBuilder();
        int numeroDePlazasLibres = contarPlazasLibresMiembros();
        String nombreAdmin = sacarNombreAdmin();
        String listadoMiembros = listarMiembros();
        String listadoCanales = listarCanales();

        sb.append("====================\n");

        sb.append("Servidor: ");
        sb.append(nombre);
        sb.append(" (");
        sb.append(codigo);
        sb.append(")");
        sb.append("\n");


        sb.append("Canales: ");
        sb.append("\n");

        sb.append(listadoCanales);


        sb.append("\n");

        sb.append("Miembros: ");
        sb.append("\n");

        sb.append(listadoMiembros);


        if (numeroDePlazasLibres == 0){
            sb.append("Servidor lleno");
        } else {
            sb.append("Plazas libres: ");
            sb.append(numeroDePlazasLibres);
        }
        sb.append("\n");

        sb.append(nombreAdmin);

        sb.append("\n====================");

        return sb.toString();

    }
}
