package ratones;

import usables.Crono;

public class Raton implements Runnable {
    private String nombre;
    private int tiempoAlimentacion;

    public Raton(String nombre, int tiempoAlimentacion) {
        super();
        this.nombre = nombre;
        this.tiempoAlimentacion = tiempoAlimentacion;
    }

    public void comer() {
        try {
            System.out.printf("El ratón %s ha comenzado a alimentarse%n", nombre);
            Thread.sleep(tiempoAlimentacion * 1000);
            System.out.printf("El ratón %s ha terminado de alimentarse%n", nombre);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Raton fievel = new Raton("Fievel", 4);
        Raton jerry = new Raton("Jerry", 5);
        Raton pinky = new Raton("Pinky", 3);
        Raton mickey = new Raton("Mickey", 6);

        Thread hiloFievel = new Thread(fievel);
        Thread hiloJerry = new Thread(jerry);
        Thread hiloPinky = new Thread(pinky);
        Thread hiloMickey = new Thread(mickey);

        Crono.start();
        hiloJerry.start();
        hiloMickey.start();
        hiloFievel.start();
        hiloPinky.start();

        hiloJerry.join();
        hiloMickey.join();
        hiloFievel.join();
        hiloPinky.join();

        System.out.println(Crono.stop());
    }

    @Override
    public void run() {
        comer();
    }
}
