public class Biblioteca {

    private Libro[] catalogo;
    private final int MAX_LIBROS;

    public Biblioteca(int max_libros){
        MAX_LIBROS = max_libros;
        this.catalogo = new Libro[MAX_LIBROS];
    }

    /**
     * busca el primer libro que encuentra con el mismo id que el recibido como parámetro
     * @param idLibroBuscado id por el que se buscará el libro
     * @return el libro con id coincidente al dado, nulo en caso de no encontrarlo
     */

    public Libro findLibro(int idLibroBuscado){
        Libro libroBuscado = null;
        for (int i = 0 ;libroBuscado == null && i < MAX_LIBROS ; i++){
            if ( catalogo[i] != null && catalogo[i].getId() == idLibroBuscado){
                libroBuscado =  catalogo[i];
            }
        }
        return libroBuscado;
    }

    /**
     * agrega el libro dado como partametro al array de catalogo en caso de no estar ya en el array y de haber hueco para meterlo
     * @param libroAAgregar el libro a agregar en el array de categoria
     * @return true si se pudo, false si no
     */

    public boolean addLibro(Libro libroAAgregar){
        boolean libroAgregadoCorrectamente = true;
        int posicionLibro;

        if (findLibro(libroAAgregar.getId()) == null){
            posicionLibro = buscarPrimerHuecoLibre();
            if (posicionLibro >= 0){
                catalogo[posicionLibro] = libroAAgregar;
            }
        }

        return libroAgregadoCorrectamente;
    }

    /**
     * recibe el id de un libro y borra el libro del array catalogo cuyo id coincida
     * @param idLibroAEliminar el id del libro a eliminar del catalogo
     * @return el libro eliminado o nulo en caso de no haberlo encontrado en el array catalogo
     */

    public Libro deleteLibro(int idLibroAEliminar){
        Libro libroBorrado = null;

        for (int i = 0 ;libroBorrado == null &&  i <  MAX_LIBROS ; i++){
            if (catalogo[i] != null && catalogo[i].getId() == idLibroAEliminar){
                libroBorrado = catalogo[i];
                catalogo[i] = null;
            }
        }
        return libroBorrado;
    }

    /**
     * metodo que modifica le numero de paginas de un libro del catalogo
     * @param idLIbro id del libro cuyo numero d epaginas habra de ser actualizado
     * @param numPaginas el numero de paginas que va a tener el libro tras la actualizacion, pudiendose solo en caso de ser mayor q 0
     * @return true si se pudo, false si no
     */
    public boolean updateNumeroPaginas(int idLIbro, int numPaginas){
        boolean numPaginasActualizadasCorrectamente = false;

        Libro libroACambiar;

        libroACambiar = findLibro(idLIbro);
        if (libroACambiar != null){
            numPaginasActualizadasCorrectamente = libroACambiar.updateNumPaginas(numPaginas);
        }
        return numPaginasActualizadasCorrectamente;
    }


    /**
     * metodo que recorre el array de categoria en busca del un valor nulo
     * @return el indice del primer hueco en el array cuyo valor sea nulo, en caso d eno haberlo, -1
     */

    private int buscarPrimerHuecoLibre(){
        int primerHuecoLibre = -1;
        for (int i = 0 ;primerHuecoLibre == -1 && i < MAX_LIBROS ; i++){
            if (catalogo[i] == null){
                primerHuecoLibre = i;
            }
        }
        return  primerHuecoLibre;
    }

    /**
     * toString de la Biliboteca
     * @return informacion de la biblioteca en formato toString
     */
    public String obtainCatalogo(){
        StringBuilder sb = new StringBuilder("Libros en la bilbioteca");

        sb.append("\n");

        for (int i = 0 ; i < MAX_LIBROS ; i++ ){
            if (catalogo[i] != null){
                sb.append(catalogo[i].toString());
                sb.append("\n");

            }
        }

        sb.append("\n");

        return sb.toString();
    }

}
