import java.util.Arrays;

public class Gimnasio {
    private final String codigo;
    private String nombre;
    private Socio[] listaSocios;
    private Sala[] listaSalas;
    private int responsableId;

    private final int MAX_SOCIOS = 12;
    private final int MAX_SALAS = 6;

    private int numeroSociosActual = 0;
    private int numeroSalasActual = 0;

    public Gimnasio(String codigo, String nombre) throws Exception {
        //this.codigo = codigo;
        this.codigo = validarCodigo( codigo );
        this.nombre = nombre;
        //setCodigo(codigo);
        //setNombre(nombre);
        this.listaSocios = new Socio[this.MAX_SOCIOS];
        this.listaSalas = new Sala[this.MAX_SALAS];
        this.responsableId = -1;
    }

    public int validarCodigo(String codigo) throws  Exception{
        int codigoNum = 0;
        //boolean valida = true;

        try {
            codigoNum = Integer.parseInt(codigo);

            if (codigoNum < 0 ){
                //valida = false;
                throw new Exception("Codigo invalido");
            }
        } catch (NumberFormatException e) {
            //valida = false;
            System.err.println("El código no es valido por que no es un número");
        } finally {
            //return valida;
            return codigoNum;
        }
    }

    // setters con IllegalArgumentException
    public void setCodigo(String codigo) {
        if (codigo.trim().equals("") ) {
            throw new IllegalArgumentException("El gimnasio ha de contar con un código");
        }
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        if (nombre.trim().equals("")) {
            throw new IllegalArgumentException("El gimnasio ha de contar con un nombre");
        }
        this.nombre = nombre;
    }

    /**
     * Inserta en la primera posición libre al socio dado como parámetro en caso de haberlo
     * @param socioNuevo  el socio a introducir
     * @return true si se pudo false sino
     */

    public boolean registrarSocio(Socio socioNuevo){
        boolean socioRegistradoCorrectamente = true;
        int posicionNuevoSocio;

        posicionNuevoSocio = buscarHuecoLibreSocio();
        if (posicionNuevoSocio == -1){
            socioRegistradoCorrectamente = false;
        }
        if (socioRegistradoCorrectamente){
            if(existeSocio(socioNuevo.getNumeroSocio())){
                socioRegistradoCorrectamente = false;
            }
        }
        if (socioRegistradoCorrectamente){
            this.listaSocios[posicionNuevoSocio] = socioNuevo;
            numeroSociosActual++;
        }

        return socioRegistradoCorrectamente;
    }

    //TODO: SI EL NUMERO DE SOCIO Y EL INDICE EN EL ARRAY DE SOCIOS COINCIDE O NO

    /**
     * comprueba si el socio dado como parámetro existe, luego lo quita del array de socios y lo devuelve
     * @param socioAExpulsar socio a expulsar
     * @return devuelve al socio si el socio fue eliminado y null si no
     */

    public Socio expulsarSocio_nsocioeindicearray_coinciden(Socio socioAExpulsar){
        Socio socioEliminado = null;
        boolean socioFueEliminado;
        socioFueEliminado = existeSocio(socioAExpulsar.getNumeroSocio());

        if(socioFueEliminado){
            socioEliminado = this.listaSocios[socioEliminado.getNumeroSocio()];
            this.listaSocios[socioEliminado.getNumeroSocio()] = null;
            numeroSociosActual--;
        }

        return socioEliminado;
    }

    /**
     * compara el numero de socio dado como parámetro con todos los socios del array de socios, si el socio fue encontrado para
     * @param numeroDelSocioBuscado el numero de socio a compara con el resto de números de socio para ver si está en el gimnasio
     * @return true si está el numero de socio asignadoa un socio del gimnasio, false si no
     */

    private boolean existeSocio(int numeroDelSocioBuscado){
        boolean socioEncontrado = false;
        for (int i = 0 ; i < this.MAX_SOCIOS && !socioEncontrado  ; i++){
            if (this.listaSocios[i] != null && this.listaSocios[i].getNumeroSocio() == numeroDelSocioBuscado){
                socioEncontrado = true;
            }
        }
        return socioEncontrado;
    }

    /**
     * recorre el array de socios en busca de un hueco donde el socio sea nulo
     * @return la posicion del primer hueco libre o -1 si no la hay
     */

    private int buscarHuecoLibreSocio(){
        int huecoLibreSocio = -1;
        for (int i = 0 ; numeroSociosActual != MAX_SOCIOS && i < MAX_SOCIOS && huecoLibreSocio == -1; i++){
            if (this.listaSocios[i] == null){
                huecoLibreSocio = i;
            }
        }
        return huecoLibreSocio;
    }

    /**
     * asigna al responsableId el numero de socio dado como parámetro
     * @param numeroDeSocioAAsignar numeroDeSocio a asignar como responsable
     * @return boolean si se pudo, false sino
     */

    public boolean designarResponsable(int numeroDeSocioAAsignar){
        boolean responsableAsignado = true;
        /* TODO: QUITAR SI SE PUEDE DESTITUIR AL RESPONSABLE
        if (this.responsableId == -1){
            responsableAsignado = false;
        }
         */
        if (!existeSocio(numeroDeSocioAAsignar)){
            responsableAsignado = false;
        }
        if (responsableAsignado){
            this.responsableId = (numeroDeSocioAAsignar);
        }
        return responsableAsignado;
    }

    /**
     * agrega una sala al array de salas ai hay hueco y su codigo no está repetido
     * @param salaAIncorporar la sala que se incorporará al array
     * @return true si se agregó, false si no
     */
    // Gestión de salas TODO: NO SÉ SI LA GESTIÓN DE SALAS IRÁ EN EL GIMNASIO
    public boolean incorporarSala(Sala salaAIncorporar){
        boolean salaIncorporadaCorrectamente = true;
        int posicionSalaIncorporada = -1;

        if (existeSala(salaAIncorporar.getCodigoSala())){
            salaIncorporadaCorrectamente = false;
        }
        if (salaIncorporadaCorrectamente){
            posicionSalaIncorporada= buscarHuecoLibreSala();
        }
        if (posicionSalaIncorporada < 0){
            salaIncorporadaCorrectamente = false;
        }
        if (salaIncorporadaCorrectamente){
            listaSalas[posicionSalaIncorporada] = salaAIncorporar;
            numeroSalasActual++;
        }
        return salaIncorporadaCorrectamente;
    }

    /**
     * comprueba si hay un codigo de sala en array de salas en comparación al dado como parámetro
     * @param codigoDeSalaBuscada codigo de sala a comparar para buscarlo
     * @return true si se concntro un codigo coincidente, false si no
     */

    private boolean existeSala(int codigoDeSalaBuscada){
        boolean salaEncontrada = false;
        for (int i = 0 ; i < MAX_SALAS && !salaEncontrada  ; i++){
            if (this.listaSalas[i] != null &&  this.listaSalas[i].getCodigoSala() == codigoDeSalaBuscada){
                salaEncontrada = true;
            }
        }
        return salaEncontrada;
    }

    /**
     * busca un indice de array cuyo valor sea nulo
     * @return devuelve el indice encontrado o -1
     */

    private int buscarHuecoLibreSala(){
        int huecoLibreSala = -1;
        for (int i = 0 ;numeroSalasActual != MAX_SALAS && i < MAX_SALAS && huecoLibreSala == -1 ; i++){
            if (this.listaSalas[i] == null){
                huecoLibreSala = i;
            }
        }
        return huecoLibreSala;
    }

    /**
     * busca el indice de una sala en el array cuyo codigo concida con el introducido como parámetro
     * @param codigoDeSalaBuscada codigo a comparar con el resto de salas en el array
     * @return el indice de la sala buscada o -1 si no hay una sala con el mismo codigo introducido como parámetro
     */

    private int buscarIndiceDeSalaEnElArray(int codigoDeSalaBuscada){
        int posicionSalaEncontrada = -1;
        for (int i = 0 ; i < MAX_SALAS && posicionSalaEncontrada == -1  ; i++){
            if (this.listaSalas[i] != null && this.listaSalas[i].getCodigoSala() == codigoDeSalaBuscada){
                posicionSalaEncontrada = i;
            }
        }
        return posicionSalaEncontrada;
    }

    /**
     *
     * @return informe completo con los datos del Gimnasio
     */
    public String obtenerInforme(){
        StringBuilder informe = new StringBuilder("Informe completo:");

        informe.append("\n");
        informe.append(this.codigo);
        informe.append(" - ");
        informe.append(this.nombre);
        informe.append("\n");

        informe.append("Socios: ");
        informe.append(this.numeroSociosActual);
        informe.append("/");
        informe.append(this.MAX_SOCIOS);
        informe.append("\n");

        informe.append("Listado de socios: ");
        informe.append("\n");
        for (int p = 0 ; p < MAX_SOCIOS ; p++){
            if (listaSocios[p] != null){
                informe.append(listaSocios[p].toString());
                informe.append("\n");
            }
        }

        informe.append("Responsable del gimnasio:");

        if (this.responsableId == -1){
            informe.append("No hay responsable asignado a este gimnasio");
        }else{
            informe.append(listaSocios[buscarIndiceDeSalaEnElArray(this.responsableId)].getNombre());

        }
        informe.append("\n");


        informe.append("Salas del gimnasio:");
        informe.append(this.numeroSalasActual);
        informe.append("/");
        informe.append(this.MAX_SALAS);
        informe.append("\n");
        informe.append("Listado de salas:");
        informe.append("\n");
        for (int p = 0 ; p < MAX_SALAS ; p++){
            if (listaSalas[p] != null){
                informe.append(listaSalas[p].toString());
                informe.append("\n");
            }
        }

        return informe.toString();
    }

    /**
     * recorre el array socios y suma 1 por cada valor no nulo
     * @return el numero total de socios
     *
    private int contarNumeroDeSocios(){
        int numeroDeSociosActuales = 0;
        for (int i = 0 ; i < MAX_SOCIOS ; i++){
            if (this.listaSocios[i] != null){
                numeroDeSociosActuales++;
            }
        }
        return numeroDeSociosActuales;
    }

    /**
     * recorre el array salas y suma 1 por cada valor no nulo
     * @return el numero total de salas

    private int contarNumeroDeSalas(){
        int numeroDeSalasActuales = 0;
        for (int i = 0 ; i < MAX_SALAS ; i++){
            if (this.listaSalas[i] != null){
                numeroDeSalasActuales++;
            }
        }
        return numeroDeSalasActuales;
    }
    */

    // todo esto también podria hacerse en el existe socio
    // metodo en caso de que no coincida el numero de socio con el indice en el array

    /**
     * recorre el array de socios y devuelve el indice en el mismo del socio con el numero de socio coincidente con el parámetro introducido
     * @param numeroDelSocioBuscado numero del socio que va a compararse con el resto de socios en el array
     * @return
     */
    private int buscarIndiceDelSocioEnElArray(int numeroDelSocioBuscado){
        int posicionSocioEncontrado = -1;
        for (int i = 0 ; i < MAX_SOCIOS && posicionSocioEncontrado == -1  ; i++){
            if (this.listaSocios[i] != null &&this.listaSocios[i].getNumeroSocio() == numeroDelSocioBuscado){
                posicionSocioEncontrado = i;
            }
        }
        return posicionSocioEncontrado;
    }

    /**
     * con el booleano socioFueEliminado comprueba si existe el socio buscado mediante el metodo existeSocio
     * si la comprobacion anterior da true, busca el indice del socio en el array, identifica para devolver sl socio buscado y asigna nulo su indice en el array de listaSocios
     * @param numeroSocioAExpulsar numeroDelSocioAExpulsar
     * @return el socio expusado o nulo si no se pudo
     */

    public Socio expulsarSocio(int numeroSocioAExpulsar){
        Socio socioEliminado = null;
        boolean socioFueEliminado;
        int posicionSocioAEliminar;
        socioFueEliminado = existeSocio(numeroSocioAExpulsar);

        if(socioFueEliminado){
            posicionSocioAEliminar = buscarIndiceDelSocioEnElArray(numeroSocioAExpulsar);
            socioEliminado = this.listaSocios[posicionSocioAEliminar];
            this.listaSocios[posicionSocioAEliminar] = null;
            numeroSociosActual--;
        }

        return socioEliminado;
    }

    /**
     * informe del gimnasio en versión toString
     * @return el informe

    @Override
    public String toString() {
        return "Gimnasio{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", listaSocios=" + Arrays.toString(listaSocios) +
                ", listaSalas=" + Arrays.toString(listaSalas) +
                ", responsableId=" + responsableId +
                ", MAX_SOCIOS=" + MAX_SOCIOS +
                ", MAX_SALAS=" + MAX_SALAS +
                '}';
    }
     */
}
