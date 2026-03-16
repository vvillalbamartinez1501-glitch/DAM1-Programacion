public class Socio {
    private final int numeroSocio;
    private String nombre;

    // constructor

    public Socio(int numeroSocio, String nombre) {
        this.numeroSocio = numeroSocio;
        this.nombre = nombre;
        //setNumeroSocio(numeroSocio);
        //setNombre(nombre);
    }

    // getters
    public int getNumeroSocio() {
        return this.numeroSocio;
    }

    public String getNombre() {
        return this.nombre;
    }

    // setters con IllegalArgumentException
    public void setNumeroSocio(int numeroSocio) {
        if (numeroSocio < 0 ){
            throw new IllegalArgumentException("El numero de socio no puede ser negativo");
        }
        this.numeroSocio = numeroSocio;
    }

    public void setNombre(String nombre) {
        if (nombre.trim().equals("")) {
            throw new IllegalArgumentException("El socio ha de contar con un nombre");
        }
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return
            String.format("[%d] %s", this.numeroSocio, this.nombre);
    }
}
