import objetos.*;

public class Main {
    public static void main(String[] args) {

                Componente c1;
                Componente c2;
                Componente c3;
                Componente c4;
                Componente c5;

                Presupuesto presupuesto;

                presupuesto = new Presupuesto();

                // crear componentes
                c1 = presupuesto.crearComponente(1, "Ram", 500.50);
                c2 = presupuesto.crearComponente(2, "Tarjeta Gráfica", 250);
                c3 = presupuesto.crearComponente(3, "Teclado mecánico", 90.99);
                c4 = presupuesto.crearComponente(4, "Ratón inalámbrico", 12.99);
                c5 = presupuesto.crearComponente(5, "Cargador", 29.50);

                // agregar componentes
                presupuesto.addComponente(c1);
                presupuesto.addComponente(c2);
                presupuesto.addComponente(c3);
                presupuesto.addComponente(c4);
                presupuesto.addComponente(c5);

                // quitar componente
                System.out.println(presupuesto.listarComponentes());
                presupuesto.deleteComponente(c1.getCodigo());

                // cambiar precio a componente
                presupuesto.cambiarPrecio(c2.getCodigo());
                System.out.println(presupuesto.listarComponentes());


                // buscar componente que no está y que está
                System.out.println(presupuesto.buscarComponente(c2.getCodigo()).toString());
                System.out.println(presupuesto.buscarComponente(c1.getCodigo()));

                System.out.println(presupuesto.stringPrecioTotal());

            }
        }

