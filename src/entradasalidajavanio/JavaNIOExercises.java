package entradasalidajavanio;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class JavaNIOExercises {
    public static void main(String[] args) {

        // Interfaz Path -> Representa una ruta a un fichero o directorio, CUANDO SE CREA, NO TIENE EN CUENTA QUE EXISTAN LAS RUTAS O FICHEROS

        Path path = Path.of("/Users/javier.montes/Downloads/mydata.txt");
        path = Paths.get("/Users/javier.montes/Downloads/mydata.txt");// Funciona igual que Path.of()

        // Método getFileName() Devuelve el nombre del fichero o el último elemento del Path
        Path p1 = Path.of("/Users/javier.montes/Downloads/mydata.txt");
        Path p2 = Path.of("/a/b");
        System.out.println(p1.getFileName()); // mydata.txt
        System.out.println(p2.getFileName());// b

        // Método toAbsolutePath() Devuelve la ruta completa del fichero o directorio(Desde la raíz )
        p1 = Path.of("/Users/javier.montes/Downloads/mydata.txt");
        p2 = Path.of("mydataInPackage.txt");
        System.out.println(p1.toAbsolutePath()); // /Users/javier.montes/Downloads/mydata.txt
        System.out.println(p2.toAbsolutePath()); // /Users/javier.montes/Documents/Proyectos/github.com/Java17Exercises/mydataInPackage.txt

        // normalize() resuelve las rutas relativas y devuelve el path normalizado
        p1= Paths.get("temp/../mydataInPackage.txt");
        System.out.println(p1.normalize());// mydataInPackage.txt -> sería la ruta normalizada de temp/../mydataInPackage.txt

        // relativize // Devuelve la ruta relativa de other respecto al path principal
        p1 = Path.of("temp/mydataInsideTempPackage.txt");
        p2 = Path.of("temp/../mydataInPackage.txt");
        System.out.println(p1.relativize(p2));// ../../mydataInPackage.txt -> porque para viajar desde mydataInsideTempPackage.txt hasta mydataInPackage.txt se retroceden dos niveles

        // Exercise relativize
        /*
        Path path1 = Path.of("a/b");
        Path path2 = Paths.get("/c");//
        System.out.println(path2.relativize(path1));// Lanza IllegalArgumentException porque no se pueden mezclar absolutos y relativos paths
        */

        // resolve() Resuelve la ruta de other frente a la principal
        p1= Paths.get("Users/temp/../data.txt");
        p2= Paths.get("new.txt");
        System.out.println(p1.resolve(p2));// c:/temp/../data.txt/new.txt

        System.out.println("número de elementos del path: "+p1.getNameCount());// el método getNameCount devuelve el número de elementos del path sin incluir la raíz
        System.out.println("elemento 0: "+p1.getName(0));// devuelve la parte del path que ocupa la posición indicada
        System.out.println("elemento 1: "+p1.getName(1));
        System.out.println("elemento 2: "+p1.getName(2));
        System.out.println("elemento 3: "+p1.getName(3));

        //Exercise with resolve()
        Path pt1 = Path.of("/Users/javier.montes/Downloads/mydata.txt");
        Path subpath = pt1.subpath(1,4).resolve(pt1);
        System.out.println("subpath -> "+subpath);

        //Exercise: qué se mostrará tras la ejecución del siguiente código?
        p1 = Path.of("c:/user/./../texto.txt");
        p2 = Path.of("../datos.txt");
        System.out.println(p1.resolve(p2).getName(4));


        //Lectura de un Fichero con Files
        //Stream<String> lines(Path path) -> Devuelve un stream con todas ls líneas del fichero. A partir de ahi se pueden aplicar los métodos de streams para realizar búsquedas, transformaciones, filtrados.
        //List<String> readAllLines(Path path) -> a diferencia de lines(Path path) retorna un List<String> donde cada elemento corresponde con una línea
        //BufferedReader newBufferedReader(Path pt) -> devuelve un objeto BufferedReader para realizar lecturas de manera clásica. Permite construir el BufferedReader de una manera más amigable que en java.io

        //Escritura en ficheros
        /*
        try{
            Path p1 = Path.of("/Users/javier.montes/Downloads/mydata.txt");
            Files.writeString(p1,"Some text inside the file written with Files.writeString() method", Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        */

        //static Path copy(InputStream in, Path target, CopyOption... options) Copia el contenido de un fichero en otro
        //static Path move(Path source, Path target, CopyOption... options) Mueve un fichero origen en otro destino
        //static void delete(Path path) Elmina el fichero
        //static void deleteIfExists(Path path) Elmina el fichero, si existe
        //static void createFile(Path path) Crea el fichero indicado vacío, si el fichero ya existe se produce una excepción

    }
}
