package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAndLinkedListExercise {
    public static void main(String[] args){
        List<Usuario> listaarray = new ArrayList<Usuario>();
        listaarray.stream().forEach(System.out::println);
        List<Usuario> listalinked = new LinkedList<Usuario>();
        long antes;
        for(int i=0;i<1000000;i++)
        {
            listaarray.add(new Usuario(i,"collections.Usuario"+i,i));  // En este ejemplo cada usuario lleva datos ficticios
            listalinked.add(new Usuario(i,"collections.Usuario"+i,i));
        }
        System.out.println("Tiempo invertido en insertar una usuario en listaarray (en nanosegundos):");
        antes = System.nanoTime();
        listaarray.add(0,new Usuario(10001,"Prueba",10001)); // Inserción en posicion 0 de una usuario
        System.out.println(System.nanoTime()- antes);
        System.out.println("Tiempo invertido en insertar una usuario en listalinked (en nanosegundos):");
        antes = System.nanoTime();
        listalinked.add(0,new Usuario(10001,"Prueba",10001));  // Inserción en posicion 0 de una usuario
        System.out.println(System.nanoTime()- antes);

        //List<String> stringList = List.of("1",null,"2"); // Esta lista es inmutable, con el método factoria List.of(). No se puede adicionar, remover ni modificar elementos. No admite elementos nulos
    }
}

class Usuario{
    private int idUsuario;
    private String nombre;
    private int altura;

    public Usuario(int idUsuario, String nombre, int altura) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "collections.Usuario-> ID: "+idUsuario+" Nombre: "+nombre+" Altura: "+altura+"\n";
    }

}