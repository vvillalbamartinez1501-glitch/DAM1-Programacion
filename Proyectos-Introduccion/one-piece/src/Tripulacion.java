public class Tripulacion {
    private String nombre;
    private Barco barco;
    private Pirata[] tripulacion;
    private int capitanId;

    private int MAX_TRIPULACION = 10;
    private int numeroPiratas = 0;

    /**
     * constructor para la clase Tripulacion
     * @param nombre nombre de la tripulacion
     * @param barco barco al que corresponde esta tripulacion
     */
    public Tripulacion (String nombre, Barco barco/*, int capitanId*/) {
        this.nombre = nombre;
        this.barco = barco;
        //this.capitanId = capitanId;
        this.tripulacion = new Pirata[MAX_TRIPULACION];
    }

    /**
     * recorre el array de tripulacion hasta que encuentra un pirata con el mismo id que el introducido como parámetro
     * @param idPirataBuscado el id del pirata cuya existencia quieres comprobar
     * @return true si el pirata fue encontrado en la tripulacion, false si no
     */

    public boolean existePirata(int idPirataBuscado){
        boolean estaEnTripulacion = false;

        for (int i = 0 ; !estaEnTripulacion && i < MAX_TRIPULACION ; i++){
            if (tripulacion[i].getId() == idPirataBuscado){
                estaEnTripulacion = true;
            }
        }
        return estaEnTripulacion;
    }

    /**
     * recorre el array de tripulacion hasta que encuentra un pirata con el mismo id que el introducido como parámetro
     * @param idPirataBuscado el id del pirata cuya existencia quieres comprobar
     * @return el indice en el array de piratas del pirata buscado, -1 si no fue encontrado
     */

    private int buscarIndicePirata(int idPirataBuscado){
        int posicionPirataEnTripulacion = -1;

        for (int i = 0 ; posicionPirataEnTripulacion == -1 && i < MAX_TRIPULACION ; i++){
            if (tripulacion[i] != null && tripulacion[i].getId() == idPirataBuscado){
                posicionPirataEnTripulacion = i;
            }
        }
        return posicionPirataEnTripulacion;
    }

    /**
     * busca la existencia del pirata en el array de tripulacion,si lo encuentra, no lo mete a la tripulacion, si no lo encuentra, busca un hueco libre en el array de tripulacion, si lo encuentra, lo guarda en ese hueco, si no, no por que no tiene sitio.
     * Si logra añadir al pirata, suma 1 al numero de piratas en la tripulacion
     * @param pirataAReclutar pirata que quieres anexionar en el array de tripuacion
     * @return true si se pudo false si no
     */

    public boolean reclutarPirata(Pirata pirataAReclutar){
        boolean pirataReclutado= true;
        int posicionPirataEnTripulacion;

        posicionPirataEnTripulacion = buscarIndicePirata(pirataAReclutar.getId());

        if (posicionPirataEnTripulacion != -1){
            pirataReclutado = false;
        } else {
            posicionPirataEnTripulacion = buscarHuecoLibreTripulacion();
            tripulacion[posicionPirataEnTripulacion] = pirataAReclutar;
            numeroPiratas++;
        }
        return pirataReclutado;
    }

    /**
     * recorre el array de tripulacion hasta que encuentre un valor nulo, si no lo hay devuelve -1
     * @return el indice del valor nulo en el array tripulacion
     */

    private int buscarHuecoLibreTripulacion(){
        int posicionLibre = -1;
        for (int i = 0 ;posicionLibre == -1 &&  i < MAX_TRIPULACION ; i++){
            if (tripulacion[i] == null){
                posicionLibre = i;
            }
        }
        return posicionLibre;
    }

    /**
     * busca al pirata en el array tripulacion, si lo encuentra, en su indice da valor nulo y resta la cantidad de piratas actual en la tripulacion, si no, no hace nada
     * @param idPirataAExpulsar
     * @return
     */

    public Pirata expulsarPirata(int idPirataAExpulsar){
        Pirata pirataExpulsado = null;
        int posicionPirataEnTripulacion;

        posicionPirataEnTripulacion =  buscarIndicePirata(idPirataAExpulsar);

        if(posicionPirataEnTripulacion != -1){
            pirataExpulsado = tripulacion[posicionPirataEnTripulacion];
            tripulacion[posicionPirataEnTripulacion] = null;
            numeroPiratas--;
        }

        return pirataExpulsado;
    }

    /**
     * busca le indice del pirata cuyo id es dado como parametro, si está en la tripulacion, da su posicion como valor del indice del capitanm sino, no hace nada
     * @param idPirataAAscender el id del pìrata al que quieres nombrar capitán
     * @return true si se pudo asignar eel capitan, false si no
     */

    public boolean nombrarCapitan(int idPirataAAscender){
        int posicionPirataEnTripulacion;
        boolean capitanActualizado = true;

        posicionPirataEnTripulacion = buscarIndicePirata(idPirataAAscender);

        if (posicionPirataEnTripulacion == -1){
            capitanActualizado = false;
        } else {
            this.capitanId = posicionPirataEnTripulacion;
        }

        return capitanActualizado;
    }

    /**
     * informe completo con la información de la tripulacion y del nombre barco
     * @return el informe en format string
     */

    public String generarInforme(){
        StringBuilder informe = new StringBuilder("Informe completo de la tripulacion:");

        informe.append("Nombre de la tripulacion: ");
        informe.append(this.nombre);
        informe.append("\n");

        informe.append("Nombre del barco: ");
        informe.append(this.barco.getNombre());
        informe.append("\n");

        informe.append("Número de miembros / Capacidad del barco: ");
        informe.append("\n");

        informe.append(numeroPiratas);
        informe.append("/");
        informe.append(MAX_TRIPULACION);
        informe.append("\n");

        informe.append("Capitán del barco: ");
        informe.append(tripulacion[capitanId].getNombre());
        informe.append("\n");

        informe.append("Listado de piratas: ");
        informe.append("\n");

        if (numeroPiratas == 0){
            informe.append("No hay tripulación abordo de este barco");
        } else {
            for (int i = 0 ; i < MAX_TRIPULACION ; i++){
                if (tripulacion[i] != null){
                    informe.append(tripulacion[i].toString());
                }
            }
        }

        return informe.toString();
    }

}
