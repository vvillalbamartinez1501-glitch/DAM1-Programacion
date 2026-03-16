public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int numPaginas;

    /**
     * metodo constructor de Libros
     * @param id identificador del libro
     * @param titulo titulo del libro
     * @param autor autor del libro
     * @param numPaginas numero de páginas del libro
     */
    public Libro(int id,  String titulo, String autor, int numPaginas) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    /**
     *
     * @return devuelve el id del libro
     */
    public int getId() {
        return id;
    }
    /**
     *
     * @return devuelve el titulo del libro
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     *
     * @return devuelve el autor del libro
     */
    public String getAutor() {
        return autor;
    }
    /**
     *
     * @return devuelve el número de páginas del libro
     */
    public int getNumPaginas() {
        return numPaginas;
    }

    /**
     * modifica el numero de paginas del libro, comprobando que el numero recibido sea positivoy mayor a 0
     * @param numPaginas el numero de paginas que va a tener el libro
     */
    public boolean updateNumPaginas(int numPaginas) {
        boolean resultado = true;
        if (numPaginas <= 0){
            resultado = false;
        } else {
            this.numPaginas = numPaginas;

        }
        return resultado;
    }

    /**
     * toString de la información básica del libro
     * @return el informe en formato String del libro
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Libro: ");

        sb.append(String.format("\n id: %d",id));
        sb.append(String.format("\n Título: %s",titulo));
        sb.append(String.format("\n Autor: %s",autor));
        sb.append(String.format("\n Número de páginas: %d",numPaginas));

        return sb.toString();
    }
}
