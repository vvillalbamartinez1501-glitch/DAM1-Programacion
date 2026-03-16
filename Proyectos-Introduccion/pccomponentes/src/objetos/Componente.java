package objetos;

public class Componente {
    private int codigo;
    private String nombre;
    private double precio;

    /**
     * metodo constructor de la clase objetos.Componente
     * @param codigo el codigo que identificará al componente
     * @param nombre El nombre del componente
     * @param precio el precio del componente en €
     */
    public Componente(int codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * getter del codigo del componente
     * @return el codigo del componente
     */

    public int getCodigo() {
        return codigo;
    }

    /**
     * getter del nombre del componente
     * @return el nombre del componente
     */

    public String getNombre() {
        return nombre;
    }
    /**
     * getter del precio del componente
     * @return el precio del componente
     */

    public double getPrecio() {
        return precio;
    }

    /**
     * setter del prcio del componnete
     * @param precio el precio que va a correspnoder al componente
     */

    public void actualizarPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * to string de la clase componente en el formato:
     *  [[codigo]] - [nombre del componente] - [precio del componente]
     * @return la informacion del componente en formato to String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[%d]\t", codigo));
        sb.append(String.format(" - %s", nombre));
        sb.append(String.format(" - %.2f €", precio));
        return sb.toString();
    }
}
