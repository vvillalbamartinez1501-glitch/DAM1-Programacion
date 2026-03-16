public class Miembro {
    private int id;
    private String nick;
    // private static int siguienteId = 0;

    /*
    El constructor siempre tiene el mismo nombre que la clase. y no se indica que devuelva nada
     */
    public Miembro(int id, String nick) {
        // this.id = siguienteId +=1;
        this.id = id;
        this.nick = nick;
    }

    public int getId() {
        return this.id;
    }

    public String getNick() {
        return this.nick;
    }

    @Override
    public String toString() {
        return "miembro{" +
                "id=" + this.id +
                ", nick='" + this.nick + '\'' +
                '}';
    }




}
