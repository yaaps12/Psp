package ejerciciosclase;

public class Contador {
    int c = 0;

    public Contador() {
    }

    public Contador(int c) {
        this.c = c;
    }

    public synchronized void incrementar() {
        c++;
    }
    public synchronized void decrementar() {
        c--;
    }

    public int valor() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
