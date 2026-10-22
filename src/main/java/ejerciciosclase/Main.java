package ejerciciosclase;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> v = new ArrayList<>();
        Contador c = new Contador(100);
        Restador restador = new Restador(c, "res");

        for (int i = 0; i < 15; i++) {
            Sumador s = new Sumador(c, "sum");
            Thread r = new Thread(restador);

            s.start();
            r.start();

            s.join();
            r.join();

            v.add(c.valor());
        }

        System.out.println(v);
    }

}
