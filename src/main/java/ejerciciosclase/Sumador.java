package ejerciciosclase;

public class Sumador extends Thread {
    Contador c;
    String name;

    public Sumador(Contador c, String name) {
        this.c = c;
        this.name = name;
    }


    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            c.incrementar();
        }
    }
}
