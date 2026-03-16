public class Canal {
    private int id;
    private String nombre;
    // private static int siguienteId = 0;


    public Canal(int id,String nombre) {
        //this.id = siguienteId +1;
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "canal{" +
                "id=" + this.id +
                ", nombre='" + this.nombre + '\'' +
                '}';
    }



}
