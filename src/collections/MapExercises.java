package collections;

import java.util.*;

public class MapExercises {
    public static void main(String[] args){
        //Ejemplo HashMap
        /*Map<Integer,collections.User> mp = new HashMap<>();
        collections.User p = new collections.User(4,"María",167);
        mp.put(4, p); // Añadimos un objeto persona al map
        p = new collections.User(1,"Marta",165);
        mp.put(1, p); // Añadimos un objeto persona al map
        p = new collections.User(3,"Elena",185);
        mp.put(3, p); // Añadimos un objeto persona al map
        p = new collections.User(2,"Yolanda",174);
        mp.put(2, p); // Añadimos un objeto persona al map
        p = new collections.User(5,"María Dolores",169);
        mp.put(4, p); // Esto crea una colisión ¡Dos objetos no pueden tener la misma clave!
        System.out.println("Users en el mapa: \n"+mp.toString().replaceAll(",", "\n"));

        //{1=collections.User-> ID: 1 Nombre: Marta Altura: 165
        // 2=collections.User-> ID: 2 Nombre: Yolanda Altura: 174
        // 3=collections.User-> ID: 3 Nombre: Elena Altura: 185
        // 4=collections.User-> ID: 5 Nombre: María Dolores Altura: 169}

        //Ahora bien ¿Por qué sale en distinto orden a como lo hemos introducido? Pues si nos fijamos, hay 4 Users,
        // es como si una hubiera desaparecido. Pues bien, lo que ha pasado es que para el campo clave ha habido lo que se llama una colisión.
        // Es decir hemos querido insertar en el mapa 2 objetos collections.User con el mismo valor clave. En nuestro caso ese valor clave es el
        // Integer “4”, donde primero metimos a María con id 4 y altura 167 y posteriormente intodujimos con ese mismo valor clave “4” a la
        // collections.User María Dolores con id 5 y altura 169.
        //Para evitar las colisiones es tan importante no asignar dos claves iguales a distintos objetos.
        // También es importante definir bien los métodos equals y hashCode que utilicemos en los objetos de la clase correspondiente a las claves de los mapas.
        // En nuestro caso al tratarse de claves Integer pues se estarían utilizando los métodos por defecto que trae Integer para equals y hashCode.
        */

        //Ejemplo SortedMap
        /*
        collections.User u = new collections.User(1,"María",167);
        u.getAgendatel().put("Trabajo", "954825748");
        u.getAgendatel().put("Oficina", "958746362");
        u.getAgendatel().put("Móvil","666555444");
        u.getAgendatel().put("Casa","952473456");
        System.out.println("Users en el mapa: \n"+u);// El TreeMap se va ordenando por clave, en este caso por orden natural
        */
        //collections.User-> ID: 1 Nombre: María Altura: 167
        //Agenda:
        //{Casa=952473456
        // Móvil=666555444
        // Oficina=958746362
        // Trabajo=954825748}


        //2o ejemplo SortedMap por el objeto collections.Persona, implementando comparable ordenando por el atributo altura
        /*
        SortedMap<collections.Persona,String> sortedMap = new TreeMap<>();
        collections.Persona p = new collections.Persona(3,"Omar",170);
        sortedMap.put(p,"Omar");
        p = new collections.Persona(1,"Marta",165);
        sortedMap.put(p,"Marta");
        p = new collections.Persona(2,"Elena",155);
        sortedMap.put(p,"Elena");
        p = new collections.Persona(2,"Elena",155);
        sortedMap.put(p,"Elena");
        System.out.println("Personas en el mapa ordenado por persona: "+sortedMap);
        */

        /*
        Map<Integer,String> students = Map.of(1, "John", 2, null, 3, "Paula"); // Este map es inmutable, con el método factoria Map.of(). No se puede adicionar, remover ni modificar elementos. No admite elementos nulos
        //students.put(2, "Ava");
        */
        /*
        Map<Integer,String> students = Map.ofEntries(
                Map.entry(1,"Jhon"),
                Map.entry(2,null)); // No admite elementos nulos
        */
    }
}

/* Ejemplo Interface Map y SortedMap, clase HashMap y TreeMap aprenderaprogramar.com */

class User {

    private int idUser;
    private String nombre;
    private int altura;
    SortedMap<String,String> agendatel;
    
    public User(int idUser, String nombre, int altura) { 
        this.idUser = idUser; 
        this.nombre = nombre; 
        this.altura=altura;
        this.agendatel = new TreeMap<>();
    }

    public SortedMap<String,String> getAgendatel() { return agendatel; }
    
    @Override
    public String toString() { return "collections.User-> ID: "+idUser+" Nombre: "+nombre + " Altura: "+altura + " \nAgenda:\n" + agendatel.toString().replaceAll(",","\n"); }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {   return false;  }
        if (getClass() != obj.getClass()) {  return false;   }
        final User other = (User) obj;
        return this.idUser == other.idUser;
    }

}