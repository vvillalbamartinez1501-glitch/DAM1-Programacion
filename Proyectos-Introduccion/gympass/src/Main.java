
public class Main {
    public static void main(String[] args) {

        // crear 2 socios + info.
        Socio pingu = new Socio(1,"Pingu");
        Socio venus = new Socio(2,"Venus Emilio");
        Socio esther = new Socio(3,"Esther");

        //crear 2 salas  + info.
        Sala crossfit = new Sala(1,"Sala de crossfit");
        Sala maquinas = new Sala(2,"Sala de máquinas");

/*
        System.out.print(pingu.toString());
        System.out.print(venus.toString());
        System.out.print(crossfit.toString());
        System.out.print(maquinas.toString());
*/

        // 2º prueba Main
        // crear un gimnasio
        /*
        try{
            Gimnasio UAXFitnessCenter = new Gimnasio("UAX-FC","UAX Fitness Center");
        } catch (Exception e){
            System.err.println("Gimnasio creado por defecto");
        } finally {
            Gimnasio UAXFitnessCenter = new;
        }
         */


        // registrar 3 socios
        UAXFitnessCenter.registrarSocio(pingu);
        UAXFitnessCenter.registrarSocio(venus);
        UAXFitnessCenter.registrarSocio(esther);

        // agregar 2 salas
        UAXFitnessCenter.incorporarSala(crossfit);
        UAXFitnessCenter.incorporarSala(maquinas);

        //mostrar el informe
        System.out.println(UAXFitnessCenter.obtenerInforme());

        UAXFitnessCenter.designarResponsable(pingu.getNumeroSocio());
        UAXFitnessCenter.expulsarSocio(esther.getNumeroSocio());

        System.out.println(UAXFitnessCenter.obtenerInforme());



        /*
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]  );
        }
        /* ejemplo gimnasio creado en base a parámetros introducidos por consola
        Gimnasio nuevo = new Gimnasio(args[0], args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));

        Gimnasio nuevo = new Gimnasio("NewGym","Vitalfit",12,12);

        System.out.println(nuevo.obtenerInforme());
         */

    }

}
