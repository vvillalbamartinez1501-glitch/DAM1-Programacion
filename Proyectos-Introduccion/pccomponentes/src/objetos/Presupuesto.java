package objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Presupuesto {
    private ArrayList<Componente> componentes;

    /**
     * metodo constructor de la clase presupuesto
     */
        public Presupuesto (){
            componentes = new ArrayList<>();
        }

    /**
     * metodo que agrega un componente al array list de componentes
     * @param componente el componente a agregar al arraylist
     * @return true si se agregó, false si no
     */
    // añadir compoenente bool - comp
    public boolean addComponente(Componente componente){
        boolean resultado = false;

        componentes.add(componente);
        resultado = true;

        return resultado;
    }

    /**
     * metodo que busca un componnete cuyo id coincida con el dado como parámetro
     * @param codigo el codigo a buscar en los componentes
     * @return el componente de id coincidente, null si no se encontró
     */

    // buscar comp - cod
    public Componente buscarComponente(int codigo){
        Componente componente = null;

        for (int i = 0 ; componente == null && i < componentes.size() ; i++){
            if (componentes.get(i).getCodigo() == codigo){
                componente = componentes.get(i);
            }
        }
        return componente;
    }

    /**
     * metodo que busca un componente por id, y is existe, lo alimina del array list de componentes
     * @param codigo el codigo del componente a eliminar del array list
     * @return true si lo eliminó, false si no
     */

    // eliminar bool - cod
    public boolean deleteComponente(int codigo){
        boolean resultado = false;
        Componente componente;
        componente = buscarComponente(codigo);
        if (componente != null){
            componentes.remove(componente);
            resultado = true;
        }
        return resultado;
    }

    /**
     * metodo que lista todos los componentes del array list
     * @return el listado de componentes
     */
    // listar  string - void
    public String listarComponentes(){
        StringBuilder sb = new StringBuilder();

        if (componentes.isEmpty()){
            sb.append("No hay componentes registrados");
        } else {
            for (Componente componente : componentes){
                sb.append(componente.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }


    /**
     * metodo que suma todos los precios de los componentes en el array list
     * @return el precio total de los componentes
     */
    // calcular precio total  double  -  void
    public double calcularPrecioTotal(){
        double resultado;
        resultado = 0;
        for (int i = 0 ; i < componentes.size() ; i++){
            resultado += componentes.get(i).getPrecio();
        }
        return resultado;
    }

    public String stringPrecioTotal(){
        double precio = calcularPrecioTotal();
        return String.format("Precio total: %.2f €", precio);
    }

    /**
     * metodo que cambia el precio de un componente, buscando el componente por su codigo
     * @param codigo el codigo por el que se buscará el componente cuyo precio se cambiará
     */

    // cambiar precio  void  -  cod
    public void cambiarPrecio(int codigo ){
        Componente componente;
        double precioNuevo;

        componente = buscarComponente(codigo);

        if (componente != null){
            precioNuevo = pedirPrecioNuevo();
            componente.actualizarPrecio(precioNuevo);
        }
    }

    /**
     * metodo que pide un double positivo
     * @return el double introducido por el usuario
     */

    public double pedirPrecioNuevo(){
        double resultado;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Introduce el precio a asignar al componente");
            resultado = sc.nextDouble();
            if (resultado <= 0){
                System.out.println("EL precio ha de ser positivo");
            }
        } while (resultado <= 0);
        return resultado;
    }

    /**
     * metodo que crea un componnete
     * @param codigo el codigo del nuevo componente
     * @param nombre el nombre dle nuevo componente
     * @param precio precio del nuevo componente
     * @return el componente creado
     */

    public Componente crearComponente(int codigo, String nombre, double precio){
        Componente componente = new Componente(codigo, nombre, precio);
        return componente;
    }

}
