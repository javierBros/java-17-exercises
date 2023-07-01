package entradasalidajavaio;

import java.io.*;
import java.util.Scanner;

public class JavaIOExercises {
    public static void main(String[] args) {


    //  System.out.println("Hola");
    // [-----\----][--|---]
        // Objeto    Método
        // PrintSt

        //System.out -> Objeto PrintStream
        //println() -> Método // Escritura de cualquier tipo de dato incluyendo salto de línea
        //print() -> Método // Escritura de cualquier tipo de dato sin incluir salto de línea
        //printf() -> Método // Escritura de datos con formato


        //------------------------------------------------------SALIDA con java.io------------------------------------------------------------------------

        String dir = "/Users/javier.montes/Downloads/mydata.txt";
        /*
        // Utilizando PrintStream
        try(PrintStream out = new PrintStream(dir)){// PrinStream es una subclase de OutputStream que proporciona métodos para
        // enviar datos a cualquier flujo de salida. Si no existe el fichero se crea en esta línea. Si no existe la ruta de carpetas se crea un error
           out.println("dato1");// out vendría a ser el flujo de salida que está apuntando al fichero
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        */
        // Utilizando FileOutputStream
        // FileOutputStream es una subclase de OutputStream que representa un flujo de salida asociado a un fichero.
        /*try(FileOutputStream fos = new FileOutputStream(dir, true);// Si el parámetro append está en true, permite escribir en modo append, es decir, se añade a lo ya existente
            //
            PrintStream out= new PrintStream(fos)){ // Permite realizar la escritura en modo append
            out.println("dato1");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/

        // Utilizando FileWriter (Otra alternativa de escribir en ficheros)

        try(FileWriter out = new FileWriter(dir,true)){// FileWriter graba los datos en modo sobrescritura(reemplaza el contenido existente en el fichero). Si el fichero no existe se crea.
            out.append("adicionado").write("dato1");// el método append me permite adicionar sobre el contenido existente y retorna nuevamente el FileWriter. El método write() sobre escribe o adiciona dependiendo si el segundo parámetro del FileWriter está en true
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        /*
        // Utilizando FileWriter modo append
        try(FileWriter out = new FileWriter(dir, true)){// FileWriter graba los datos en modo append(se añade a lo ya existente). Si el fichero no existe se crea.
            out.write("dato1");
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        */
        /*
        // Utilizando BufferedWriter dentro de FileWriter
        try(FileWriter out = new FileWriter(dir, true);
            BufferedWriter bw = new BufferedWriter(out)){// Escritura de datos a través de BufferedWriter que mejora el rendimiento
            bw.write("dato1");
            bw.newLine();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        */


        //------------------------------------------------------ENTRADA con java.io------------------------------------------------------------------------

        /*
        InputStream -> Clase abstracta que representa un flujo de entrada de bytes
        FileInputStream -> Subclase de InputStream que representa un flujo de entrada a un fichero
        FileReader -> Clase específica para la lectura de texto en un fichero
        BufferedReader -> Proporciona un mecanismo eficiente para la lectura de cadenas de texto de una fuente externa
         */

        // Lectura mediante BufferedReader por entrada de teclado
        /*
        try(InputStreamReader reader = new InputStreamReader(System.in);// Se debe crear un InputStream aociado a la entrada estandar (System.in)(Entrada por teclado)
            BufferedReader br = new BufferedReader(reader)){
            String name = br.readLine();
            System.out.println(name);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        */
        // Lectura mediante Scanner -> Scanner se encuentra en java.util.
        /*
        Scanner sc = new Scanner(System.in);// Scanner dispone de otros métodos para leer datos como tipos primitivos(nextInt, next Doublle)
        System.out.println("Introduce tu nombre: ");
        String name = sc.nextLine();
        System.out.println(name);
        */

        // Lectura de un fichero
        /*
        try(FileReader fr = new FileReader(dir);
            BufferedReader br = new BufferedReader(fr)){// LEctura de todas las líneas del fichero. Si el fichero no existe, se produce una excepción
            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        */

        //FileInputStream -> Utilizado para lectura de ficheros bnarios (Falta ejemplos)

        // Clase File
        /*
        File file = new File(dir);
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        */
        //file.delete();// Elimina el elemento. Devuelve true si ha conseguido eliminarlo

    }
}
