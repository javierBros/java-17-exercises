package enums;

import java.io.FileNotFoundException;

public class EnumsExercises {
    public static void main(String[] args){
        // Instanciamos el enumerado
        Equipo villareal = Equipo.VILLAREAL;

        // Devuelve un String con el nombre de la constante
        System.out.println("villareal.name()= "+villareal.name());

        // Devuelve el contenido de los atributos
        System.out.println("villareal.getNombreClub()= "+villareal.getNombreClub());
        System.out.println("villareal.getPuestoLiga()= "+villareal.getPuestoLiga());
    }
}

enum Equipo implements IEquipo {
    BARÇA("FC Barcelona",1,new ExampleClass()), REAL_MADRID("Real Madrid",2,new ExampleClass()),
    SEVILLA("Sevilla FC", 4,new ExampleClass()), VILLAREAL("Villareal", 7,new ExampleClass());

    private String nombreClub;
    private int puestoLiga;
    private ExampleClass p;

    private Equipo(String nombreClub, int puestoLiga, ExampleClass p){
        this.nombreClub=nombreClub;
        this.puestoLiga=puestoLiga;
        this.p=p;
    }

    public String getNombreClub() {
        return nombreClub;
    }

    public int getPuestoLiga() {
        return puestoLiga;
    }

    @Override
    public void myMethod() throws FileNotFoundException {

    }
}