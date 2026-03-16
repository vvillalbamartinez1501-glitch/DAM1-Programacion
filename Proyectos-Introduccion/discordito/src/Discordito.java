public class Discordito {
    private int id;
    private String codigo;
    private String nombre;

    private Servidor[] servidores;
    private int contadorServidores;

    public final int MAX_SERVIDORES;

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Servidor[] getServidores() {
        return servidores;
    }

    public int getMAX_SERVIDORES() {
        return MAX_SERVIDORES;
    }

    // public Discordito() {}

    public Discordito(int id, String codigo, String nombre, int MAX_SERVIDORES) {
        this.id = id;
        this.codigo = codigo;
        //this.codigo = crearCodigo();
        this.nombre = nombre;
        this.servidores = new Servidor[MAX_SERVIDORES];
        this.MAX_SERVIDORES = MAX_SERVIDORES;
    }

    private String crearCodigo (){
        String codigo = this.nombre.charAt(0) + this.nombre.charAt(nombre.length()) + "-" + id;
        return codigo;
    }

    /**
     * comprueba si el numero de servidores es igual o mayor que el máximo de servidores que habrian de haber en el discordito
     * @return return si equivale el numero actual de servidores con el maximo de servidores true, sino false
     */

    private boolean comprobarDiscorditoLleno(){
        boolean discorditoLleno = false;
        if (contadorServidores >= MAX_SERVIDORES){
            discorditoLleno = true;
        }
        return discorditoLleno;
    }

    /**
     * recorre el array de servidores en busca de uno cuyo id equivalga al dado como parámetro
     * @param idServidorBuscado id del servidor que se busca
     * @return el indice del servidor en el array de servidores del discordito, -1 si no encuentra un servidos con el mismo id que el dado como parámetro
     */

    public int buscarPosicionServidorEnDiscordito(int idServidorBuscado){
        int posicionServidorEnDiscordito = -1;
        for (int i = 0; i < MAX_SERVIDORES && posicionServidorEnDiscordito == -1; i++){
            if (servidores[i].getId() == idServidorBuscado){
                posicionServidorEnDiscordito = i;
            }
        }
        return posicionServidorEnDiscordito;
    }

    /**
     * busca un servidor de codigo coincidente en el array de servidores
     * @param codigoServidorBuscado
     * @return la posicion del servidor de codigo coincidente al dado como parámetro, sino lo hay -1
     */

    public int buscarPosicionServidorEnDiscorditoPorCodigo(String codigoServidorBuscado){
        int posicionServidorEnDiscordito = -1;
        for (int i = 0; i < MAX_SERVIDORES && posicionServidorEnDiscordito == -1; i++){
            if (servidores[i].getCodigo().equals(codigoServidorBuscado)){
                posicionServidorEnDiscordito = i;
            }
        }
        return posicionServidorEnDiscordito;
    }

    public Servidor buscarServidorPorCodigo(String codigoServidorBuscado){
        int posicionServidorEnDiscordito = -1;
        for (int i = 0; i < MAX_SERVIDORES && posicionServidorEnDiscordito == -1; i++){
            if (servidores[i].getCodigo().equalsIgnoreCase(codigoServidorBuscado)){
                posicionServidorEnDiscordito = i;
            }
        }
        return servidores[posicionServidorEnDiscordito];
    }

    public Servidor buscarServidorPorCodigo_bis(String codigoServidorBuscado){
        Servidor servidorBuscado = null;
        boolean servidorEncontrado = false;

        for (int i = 0; i < MAX_SERVIDORES && !servidorEncontrado; i++){
            if (servidores[i].getCodigo().equalsIgnoreCase(codigoServidorBuscado)){
                servidorEncontrado = true;
                servidorBuscado = servidores[i];
            }
        }
        return servidorBuscado;
    }

    /**
     * comprueba si el servidor que se quiere crear ya existe comprobando los codigos d elos servidores en el array, sino existe, busca el primer hueco libre en el array de servidores, de haberlo, lo garda ahí, de no haberlo, no hace nada
     * @param servidor el servidor que quiere agregarse a discordito
     * @return true si se pudo agregar el servidor, false si no
     */

    public boolean crearServidor_visavis(Servidor servidor){
        boolean resultado = true;
        int posicionServidorEnDiscordito;
        if (buscarServidorPorCodigo(servidor.getCodigo()) == null){
            resultado = false;
        }
        if (resultado){
            posicionServidorEnDiscordito = buscarPrimerHuecoServidores();
            if (posicionServidorEnDiscordito == -1){
                resultado = false;
            } else {
                introducirServidor(servidor, posicionServidorEnDiscordito);
                contadorServidores+=1;
            }
        }
        return resultado;
    }

    /**
     * comprueba si el servidor que se quiere crear ya existe comprobando los codigos d elos servidores en el array, sino existe, busca el primer hueco libre en el array de servidores, de haberlo, lo garda ahí, de no haberlo, no hace nada
     * @param servidor el servidor que quiere agregarse a discordito
     * @return true si se pudo agregar el servidor, false si no
     */

    public boolean crearServidor_bis(Servidor servidor){
        boolean resultado = false;
        int posicionServidorEnDiscordito;

        posicionServidorEnDiscordito = buscarPrimerHuecoServidores();

        if (  posicionServidorEnDiscordito != -1 && buscarServidorPorCodigo(servidor.getCodigo()) == null ){
            resultado = true;
        }
        if (resultado){
            servidores[posicionServidorEnDiscordito] = servidor;
        }

        return resultado;
    }


    /**
     * dado un servidor y su posición, lo garda en el array de servidores
     * @param servidor
     * @param posicion
     */

    private void introducirServidor(Servidor servidor, int posicion){
        servidores[posicion] = servidor;
    }



    /**
     * recorre el array de servidores en busca de uno que sea nulo, en caso de encontrarlo, lo devuelve, si no lo hay, devuelve -1
     * @return la el indice libre en el array o -1 si no hay
     */

    private int buscarPrimerHuecoServidores(){
        int primerHuecoServidores = -1;
        for (int i = 0 ; i < MAX_SERVIDORES && primerHuecoServidores == -1; i++){
            if (servidores[i] == null ){
                primerHuecoServidores = i;
            }
        }
        return primerHuecoServidores;
    }

    /**
     * cambia a un usuario de servidor para ello, debe de encontrarse en el viejo servidor al miembro y deber de haber hueco en el servidor de destino
     * @param origen servidor en el que se encuentra el miembro antes de moverlo
     * @param destino servidor donde quiere introducirse el miembro
     * @param miembro miembro que quiere cambiarse
     * @return devuelve true si se pudo, false sino
     */

    public boolean moverMiembroDeServer_bis(Servidor origen, Servidor destino, Miembro miembro){
        boolean resultado;
        int posicionMiembroEnServerNew;
        int posicionMiembroEnServerOld;

        posicionMiembroEnServerOld = origen.buscarPosicionMiembroEnElServidorPorId(miembro.getId());
        if (posicionMiembroEnServerOld == -1){
            System.out.println(String.format("No se encontró a %s en el servidor %s",miembro.getNick(),origen.getNombre()));
            resultado = false;
        } else {
            resultado = true;
        }
        if (resultado){
            posicionMiembroEnServerNew = destino.buscarHuecoLibreMiembros();
            if (posicionMiembroEnServerNew == -1){
                System.out.println(String.format("No hay hueco para %s en el servidor %s",miembro.getNick(),destino.getNombre()));
                resultado = false;
            } else {
                destino.introducirMiembroEnArray(miembro,posicionMiembroEnServerNew);
                origen.quitarMiembroPorId(miembro.getId());
                System.out.println(String.format("%s ha sido movido correctamente a %s",miembro.getNick(),destino.getNombre()));
            }
        }
        return resultado;
    }

    /**
     * cambia a un usuario de servidor para ello, debe de encontrarse en el viejo servidor al miembro y deber de haber hueco en el servidor de destino
     * @param codOrigen codigo de servidor en el que se encuentra el miembro antes de moverlo
     * @param codDestino codigo de servidor donde quiere introducirse el miembro
     * @param idMiembro id de miembro que quiere cambiarse
     * @return devuelve true si se pudo, false sino
     */

    public boolean moverMiembroDeServer(int idMiembro, String codOrigen, String codDestino){
        Miembro miembro;
        Servidor origen;
        Servidor destino;
        boolean resultado = false;

        origen = buscarServidorPorCodigo(codOrigen);
        if (origen != null){
            destino = buscarServidorPorCodigo(codDestino);
            if (destino != null){
                miembro = origen.quitarMiembroPorId(idMiembro);
                if (miembro != null){
                    destino.agregarMiembro(miembro);
                    resultado = true;
                }
            }
        }
    return resultado;
    }

    private int[] darIndicesServidores(){
        int[] indices;
        int indiceArrayIndices = 0;

        indices = new int[contadorServidores];

        for (int i = 0; i < MAX_SERVIDORES; i++){
            if (servidores[i] != null){
                indices[indiceArrayIndices] = i;
                indiceArrayIndices++;
            }
        }
    }

    public Servidor elegirServidorPorIndice(String peticion){
        String listaDeServidores;
        int indiceServidorElegido;
        int[] indicesServidores;

        indicesServidores = darIndicesServidores();

        listaDeServidores = listarNombresServidores();
        System.out.println(listaDeServidores);

        indiceServidorElegido = LecturaScanner.pedirEleccionMenu(peticion,)


    }


    public String listarNombresServidores(){
        StringBuilder nombresServidores = new StringBuilder();
        for (int i = 0; i < MAX_SERVIDORES; i++){
            if (servidores[i] != null){
                nombresServidores.append(buscarPosicionServidorEnDiscordito(servidores[i].getId()) +1);
                nombresServidores.append(" - ");
                nombresServidores.append(servidores[i].getNombre());
                nombresServidores.append("\n");
            }
        }
        return nombresServidores.toString();
    }

    /**
     * Devuelve en un String el resumen de servidor de cada servidor en discordito
     * @return
     */

    public String listarEstado(){
        StringBuilder sb = new StringBuilder();

        sb.append("Hay ");
        sb.append(contadorServidores);
        sb.append("/");
        sb.append(MAX_SERVIDORES);

        sb.append("\n");

        if (contadorServidores > 0){
            sb.append("Listado de servidores:");
            sb.append("\n");
            for (Servidor miServidor : servidores){
                if (miServidor != null){
                    sb.append(miServidor.realizarResumenServidor());
                }
            }
        }
        return sb.toString();
    }


}

