public class Sala {
    private final int codigoSala;
    private String descripcion;

    public Sala(int codigoSala, String descripcion) {
        this.codigoSala = codigoSala;
        // setCodigoSala(codigoSala);
        this.descripcion = descripcion;
    }

    public int getCodigoSala() {
        return codigoSala;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // setters con IllegalArgumentException
    public void setCodigoSala(int codigoSala) {
        if (codigoSala < 0 ){
            throw new IllegalArgumentException("El numero de socio no puede ser negativo");
        }
        this.codigoSala = codigoSala;
    }

    /**
     * Informe en versión toString
     * @return el informe
     */

    @Override
    public String toString() {
        return
                String.format("[%d] %s", this.codigoSala, this.descripcion);
    }
}
