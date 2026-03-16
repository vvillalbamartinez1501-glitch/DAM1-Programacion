public class main {
    public static void main(String[] args) {

        Discordito discordito;

        Servidor unServer;

        Canal general;
        Canal bienvenida;
        Canal despedida ;

        Miembro pingu;
        Miembro venus;

        Miembro kapu;
        Miembro gatuko;

        Servidor kapuServer;



        unServer = new Servidor ("Un servidor",10,5);

        general = new Canal(1,"General");
        bienvenida = new Canal(2,"Bienvenida");
        despedida = new Canal(3,"Despedida");

        pingu = new Miembro(1,"Pingu");
        venus = new Miembro(2,"Venusemilio");

        kapu = new Miembro(3,"TheKapu");
        gatuko = new Miembro(4,"Gatuko");

        kapuServer = new Servidor ("TheKapuServer",10,5);

        String resumenServerUnServer;
        String resumenServerKapu;



        System.out.println(general.toString());
        System.out.println(bienvenida.toString());
        System.out.println(despedida.toString());
        System.out.println(pingu.toString());
        System.out.println(venus.toString());


        unServer.agregarCanal(general);
        unServer.agregarCanal(bienvenida);
        unServer.agregarCanal(despedida);

        unServer.agregarMiembro(pingu);
        unServer.agregarMiembro(venus);

        unServer.asignarAdmin(pingu.getId());

        resumenServerUnServer = unServer.realizarResumenServidor();
        System.out.println(resumenServerUnServer);

        /*===================================================*/



        /*
        kapuServer.agregarCanal(general);
        kapuServer.agregarCanal(bienvenida);
        kapuServer.agregarCanal(despedida);

        kapuServer.agregarMiembro(kapu);
        kapuServer.agregarMiembro(venus);
        kapuServer.agregarMiembro(gatuko);
        kapuServer.agregarMiembro(pingu);
         */

        addCanal(kapuServer,general);
        addCanal(kapuServer,bienvenida);
        addCanal(kapuServer,despedida);

        addMiembro(kapuServer,kapu);
        addMiembro(kapuServer,venus);
        addMiembro(kapuServer,gatuko);
        addMiembro(kapuServer,pingu);
        addMiembro(kapuServer,pingu);

        kapuServer.asignarAdmin(kapu.getId());

        resumenServerKapu = kapuServer.realizarResumenServidor();
        System.out.println(resumenServerKapu);


        int opcionIntroducida;
        int[] opcionesValidas;

        int[] opcionesValidasMenuPrincipal = {1,2,3,4,5,6,0};

        String stringBienvenida = DisplayMenu.mostrarBienvenida();

        String menuOpcionesPrincipales = DisplayMenu.menuPrincipal();

        System.out.println(bienvenida);

        /*
                discordito = new Discordito(1,"123","Un server",5);
                discordito.crearServidor_bis(unServer);
                discordito.crearServidor_bis(kapuServer);
                if (discordito.moverMiembroDeServer(1,unServer.getCodigo(),kapuServer.getCodigo())) {

                }
         */

        /*
        do{
            opcionesValidas = opcionesValidasMenuPrincipal;
            opcionIntroducida = LecturaScanner.pedirEleccionMenu(menuOpcionesPrincipales,opcionesValidas);

        }while (opcionIntroducida != 0);

         */

    }



    private static void addMiembro (Servidor servidor, Miembro miembro){
        StringBuilder resultado= new StringBuilder();
        boolean miembroAgregadoCorrectamente;

        miembroAgregadoCorrectamente = servidor.agregarMiembro(miembro);

        resultado.append("El usuario ");
        resultado.append(miembro.getNick());

        if (miembroAgregadoCorrectamente){
            resultado.append(", fue agregado correctamente");
        }else{
            resultado.append(" no pudo ser agregado");
        }

        System.out.println(resultado);
    }

    private static void addCanal (Servidor servidor, Canal canal){
        StringBuilder resultado= new StringBuilder();
        boolean canalAgregadoCorrectamente;

        canalAgregadoCorrectamente = servidor.agregarCanal(canal);

        resultado.append("El canal ");
        resultado.append(canal.getNombre());

        if (canalAgregadoCorrectamente){
            resultado.append(", fue agregado correctamente");
        }else{
            resultado.append(" no pudo ser agregado");
        }

        System.out.println(resultado);
    }

    public static void ejecutarMenuPrincipal(int opcionIntroducida){
        switch(opcionIntroducida){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 0:
                System.out.println("Cerrando Discordito...");
                break;
        }
    }

    public static void menuCambioDeServidor(Discordito discordito, Servidor origen, Servidor destino){
        String listadoDeServidores;

        listadoDeServidores = discordito.listarNombresServidores();
        System.out.println(listadoDeServidores);




    }





}
