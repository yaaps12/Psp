package ejerciciosclase;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> v = new ArrayList<>();
        Contador c = new Contador(100);
        Restador restador = new Restador(c, "res");

        for (int i = 0; i < 15; i++) {
            new Sumador(c, "sum").start();
            new Thread(restador).start();
            v.add(c.valor());

            c.setC(100);
        }

        System.out.println(v);
    }

}
