package org.exito.com.util;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utilitarios {
    public static int generarNumeroAleatorio(int limiteInicial, int LimiteFinal) {
        return Math.abs(ThreadLocalRandom.current().nextInt(limiteInicial, LimiteFinal));
    }

    public static int generarNumeroAleatorio(List<Integer> lista) {
        return lista.get(new Random().nextInt(lista.size()));
    }
}