package practicaud1.linuxdebian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InstaladorLinux {

    public static void instalarOpcion(int opcion) {
        /**
         * actualizar Repositorios
         * IntelliJ
         * Vs Code
         * Git
         * MySQL
         * Dbeaver
         * Node.js + npm
         */

        switch (opcion) {
            case 1 -> {
                System.out.println("Actualizando los repositorios");
                ejecutarComando("sudo", "apt", "update");
            }
            case 2 -> {
                if (estaInstalado("intellij-idea-community")) {
                    System.out.println("El paquete intellij-idea-community esta instalado.");
                } else {
                    System.out.println("Instalando Intellij");
                    ejecutarComando("sudo", "apt", "install", "intellij-idea-community");
                }
            }
            case 3 -> {
                if (estaInstalado("code")) {
                    System.out.println("El paquete code esta instalado.");

                } else {
                    System.out.println("Instalando Vs Code");
                    ejecutarComando("sudo", "apt", "install", "code");
                }
            }
            case 4 -> {
                if (estaInstalado("git")) {
                    System.out.println("El paquete git esta instalado.");

                } else {
                    System.out.println("Instalando Git");
                    ejecutarComando("sudo", "apt", "install", "git");
                }
            }
            case 5 -> {
                if (estaInstalado("mysql-server")) {
                    System.out.println("El paquete mysql-server esta instalado.");

                } else {
                    System.out.println("Instalando MySQL");
                    ejecutarComando("sudo", "apt", "install", "mysql-server");
                }
            }
            case 6 -> {
                if (estaInstalado("dbeaver-ce")) {
                    System.out.println("El paquete dbeaver-ce esta instalado.");

                } else {
                    System.out.println("Instalando DBeaver");
                    ejecutarComando("sudo", "apt", "install", "dbeaver-ce");
                }
            }

            case 7 -> {
                boolean faltaNode = !estaInstalado("nodejs");
                boolean faltaNpm = !estaInstalado("npm");

                if (!faltaNode && !faltaNpm) {
                    System.out.println("Node.js y npm ya están instalados.");
                } else {
                    System.out.println("Instalando entorno Node.js y npm...");
                    ejecutarComando("sudo", "apt", "install", "nodejs", "npm");
                }
            }

            case 8 -> System.out.println("Saliendo...");


            default -> System.out.println("Opcion no valida. Intentelo de nuevo.");

        }
    }


    private static boolean estaInstalado(String paquete) {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "dpkg-query", "-W", "-f='${Status}'", paquete);
            Process proceso = pb.start();

            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream()));
            String linea = lector.readLine();
            proceso.waitFor();

            if (linea != null && linea.contains("install ok installed")) {
                return true;
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Excepción al comprobar el paquete " + paquete + ": " +
                    e.getMessage());
        }
        return false;
    }

    private static void ejecutarComando(String... comando) {
        try {
            ProcessBuilder pb = new ProcessBuilder(comando);
            pb.inheritIO();
            Process proceso = pb.start();
            int codigoSalida = proceso.waitFor();

            if (codigoSalida != 0) {
                System.out.println("Hubo algún problema. Código de salida: " + codigoSalida);
                return;
            }

            System.out.println("Instalación completada con exito.");

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejectuar el comando: " + e.getMessage());
        }

    }
}
