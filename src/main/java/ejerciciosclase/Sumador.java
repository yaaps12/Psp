package ejerciciosclase;

public class Sumador extends Thread {
    Contador c;

    public Sumador(Contador c, String name) {
        this.c = c;
        super.setName(name);
    }


    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            c.incrementar();
        }
    }
}
