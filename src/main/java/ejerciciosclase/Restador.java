package ejerciciosclase;

public class Restador implements Runnable {
    Contador c;


    public Restador(Contador c, String name) {
        this.c = c;
        Thread.currentThread().setName(name);
    }


    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            c.decrementar();
        }
    }
}
