public class Main {
    public static void main(String[] args){
        Libro elPincipito = new Libro(1,"El principito","Antoine de Saint-Exupéry",120);
        Libro quijote = new Libro(2,"Don Quijote de la Mancha","Miguel de Cervantes",1234567890);

        Biblioteca biblioteca = new Biblioteca(5);

        System.out.println(biblioteca.addLibro(elPincipito));
        System.out.println(biblioteca.addLibro(quijote));

        System.out.println(biblioteca.obtainCatalogo());
    }
}
