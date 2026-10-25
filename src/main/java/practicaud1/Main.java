package practicaud1;

import practicaud1.linuxdebian.InstaladorLinux;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            if (esWindows()) {
                System.out.println("En proceso...");
                return;
            } else {
                menuLinux();

                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();

                    InstaladorLinux.instalarOpcion(opcion);
                } else {
                    System.out.println("Error: Debes introducir un número válido.");
                    scanner.next();
                    opcion = -1;
                }
            }

        } while (opcion != 8);

        System.out.println("Programa finalizado con éxito Buen trabajo.");
        scanner.close();
    }

    private static void menuLinux() {
        System.out.println("INSTALADOR HERRAMIENTAS DESARROLLADOR");
        System.out.println("1. Actualizar repositorios");
        System.out.println("2. IntelliJ IDEA Community");
        System.out.println("3. Visual Studio Code");
        System.out.println("4. Git");
        System.out.println("5. MySQL Server");
        System.out.println("6. DBeaver");
        System.out.println("7. Node.js + npm");
        System.out.println("8. Salir");
        System.out.print("Elige una opción (1-8): ");
    }

    public static boolean esWindows() {
        return System.getProperty("os.name").toLowerCase().contains("windows");
    }

}

