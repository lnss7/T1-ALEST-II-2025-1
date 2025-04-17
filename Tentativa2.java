import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Tentativa2 {
    public static void main(String[] args) throws IOException {
        String caminhoArquivo = "caso_102.txt";
        BufferedReader arquivo = new BufferedReader(new java.io.FileReader(caminhoArquivo));
        Integer.parseInt(arquivo.readLine());
        int[] receita = Arrays.stream(arquivo.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        arquivo.close();

        boolean[] visitados = new boolean[receita.length];
        List<Long> tamanhosCiclos = new ArrayList<>();

        for (int i = 0; i < receita.length; i++) {
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

        long resultado = calcularMMC(tamanhosCiclos);
        System.out.println("A dança repete após " + resultado + " rodadas.");
    }

    static long calcularMMC(List<Long> numeros) {
        long resultado = 1;
        for (long numero : numeros) {
            long a = resultado;
            long b = numero;
            
            long gcd = b;
            long remainder = a % b;
            
            while (remainder != 0) {
                gcd = remainder;
                remainder = b % remainder;
                b = gcd;
            }
            
            resultado = a / gcd * numero;
        }
        return resultado;
    }
}