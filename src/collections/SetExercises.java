package collections;

import java.util.*;

public class SetExercises {
    public static void main(String[] args){
        Set<Persona> cjsp = new HashSet<>();
        SortedSet<Persona> cjssp = new TreeSet<>();
        SortedMap<Persona,String> sortedMap = new TreeMap<>();
        Persona p = new Persona(3,"Omar",170);
        cjsp.add(p);
        cjssp.add(p);
        sortedMap.put(p,"Omar");
        p = new Persona(1,"Marta",165);
        cjsp.add(p);
        cjssp.add(p);
        sortedMap.put(p,"Marta");
        p = new Persona(2,"Elena",155);
        cjsp.add(p);
        cjssp.add(p);
        sortedMap.put(p,"Elena");
        p = new Persona(2,"Elena",155);
        cjsp.add(p);
        cjssp.add(p);
        sortedMap.put(p,"Elena");
        System.out.println("Personas en el conjunto: "+cjsp);
        System.out.println("Personas en el conjunto ordenado: "+cjssp);
        System.out.println("Personas en el mapa ordenado por persona: "+sortedMap);
        System.out.println("hashCode cualquier persona: " + p.hashCode());


    }
}