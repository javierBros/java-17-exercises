import java.io.IOException;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.*;

public class InventoryExercise {
    private static final String FILE_PATH = "products.txt";
    private static final Charset CHARSET = StandardCharsets.UTF_8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Registrar producto");
            System.out.println("2. Consultar productos");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    registerProduct(scanner);
                    break;
                case 2:
                    listProducts();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
                    break;
            }
        }
    }

    private static void registerProduct(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String productName = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double productPrice = scanner.nextDouble();
        scanner.nextLine();

        String productData = productName + "," + productPrice;

        try {
            Files.write(Paths.get(FILE_PATH), (productData + System.lineSeparator()).getBytes(CHARSET), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Producto registrado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al registrar el producto: " + e.getMessage());
        }
    }

    private static void listProducts() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH), CHARSET);

            if (lines.isEmpty()) {
                System.out.println("No hay productos registrados.");
            } else {
                System.out.println("Lista de productos:");

                for (String line : lines) {
                    String[] parts = line.split(",");
                    String productName = parts[0];
                    double productPrice = Double.parseDouble(parts[1]);

                    System.out.println("Nombre: " + productName + ", Precio: " + productPrice);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al consultar los productos: " + e.getMessage());
        }
    }
}
