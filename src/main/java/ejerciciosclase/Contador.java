package ejerciciosclase;

public class Contador {
    int c = 0;

    public Contador() {
    }

    public Contador(int c) {
        this.c = c;
    }

    public void incrementar() {
        c++;
    }
    public void decrementar() {
        c--;
    }

    public int valor() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
