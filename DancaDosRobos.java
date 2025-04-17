import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class DancaDosRobos {

    public static long mmc(long a, long b) {
        return a / mdc(a, b) * b;
    }

    public static long mdc(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long mmcMultiplo(List<Long> numeros) {
        long resultado = 1;
        for (long num : numeros) {
            resultado = mmc(resultado, num);
        }
        return resultado;
    }

    public static long contarRodadasAteRepeticao(int[] receita) {
        int n = receita.length;
        boolean[] visitados = new boolean[n];
        List<Long> tamanhosCiclos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visitados[i]) {
                int tamanhoCiclo = 0;
                int atual = i;

                while (!visitados[atual]) {
                    visitados[atual] = true;
                    atual = receita[atual];
                    tamanhoCiclo++;
                }

                if (tamanhoCiclo > 0) {
                    tamanhosCiclos.add((long) tamanhoCiclo);
                }
            }
        }

        return mmcMultiplo(tamanhosCiclos);
    }
}