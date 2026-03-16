public class Main {
    public static void main(String[] args) {
        // prueba 1

        Pirata luffy;
        Pirata zoro;
        Pirata pingu;
        Pirata venus;
        Barco thousandSunny;
        Tripulacion tripulacionTS;


        luffy = new Pirata (1,"Monkey D. Luffy",1234567890);
        zoro  = new Pirata (2,"Zoro",3.14159265358979323846264338327950288419716939937510592307);
        thousandSunny = new Barco("Thousan Sunny",100);

        pingu = new Pirata (3,"Abel Martínez Villalba",1234567890);
        venus  = new Pirata (4,"Venus Emilio",3.14159265358979323846264338327950288419716939937510592307);

        luffy.toString();
        zoro.toString();
        thousandSunny.toString();





        tripulacionTS = new Tripulacion ("Tripulación del Thousand Sunny",thousandSunny);


        tripulacionTS.reclutarPirata(luffy);
        tripulacionTS.reclutarPirata(zoro);
        tripulacionTS.reclutarPirata(pingu);
        tripulacionTS.reclutarPirata(venus);

        tripulacionTS.nombrarCapitan(pingu.getId());

        System.out.println(tripulacionTS.generarInforme());


    }
}
