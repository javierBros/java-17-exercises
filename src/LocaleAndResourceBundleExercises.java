import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleAndResourceBundleExercises {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        // Se obtiene el conjunto de recursos definidos como Messages para el idioma inglés (en)
        ResourceBundle bundle = ResourceBundle.getBundle("Messages");
        // Se obtiene la cadena de texto del conjunto de recursos a través de la clave asociada. En este caso, el valor será "car"
        String message = bundle.getString("car");
        System.out.println("Valor car: " + message);
        // Una vez cargado el conjunto de recursos, se pueden obtener varias cadenas
        message = bundle.getString("house");
        System.out.println("Valor house: " + message);

        bundle = ResourceBundle.getBundle("Messages", new Locale("es"));
        message = bundle.getString("car");
        System.out.println("Valor car: " + message);
        message = bundle.getString("house");
        System.out.println("Valor house: " + message);

        bundle = ResourceBundle.getBundle("Messages", new Locale("fr"));
        message = bundle.getString("car");
        System.out.println("Valor car: " + message);// Carga el que está por defecto, en este caso del fichero Messages_es.properties
        message = bundle.getString("house");
        System.out.println("Valor house: " + message);// Carga el que está por defecto, en este caso del fichero Messages_es.properties
    }
}
