import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Tentativa1 {
    public static void main(String[] args) throws IOException {
        String caminhoArquivo = "caso_102.txt";
        BufferedReader arquivo = new BufferedReader(new java.io.FileReader(caminhoArquivo));
        Integer.parseInt(arquivo.readLine());
        int[] receita = Arrays.stream(arquivo.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        arquivo.close();

        long rodadas = contarRodadas(receita);
        System.out.println("A dança repete após " + rodadas + " rodadas!");
    }

    public static int[] aplicarReceita(int[] formacao, int[] receita) {
        int[] novaFormacao = new int[formacao.length];
        for (int i = 0; i < formacao.length; i++) {
            novaFormacao[i] = formacao[receita[i]];
        }
        return novaFormacao;
    }

    public static int contarRodadas(int[] receita) {
        int n = receita.length;
        int[] formacaoInicial = new int[n];
        for (int i = 0; i < n; i++) {
            formacaoInicial[i] = i;
        }

        int[] formacaoAtual = Arrays.copyOf(formacaoInicial, n);
        int rodadas = 0;

        while (!Arrays.equals(formacaoAtual, formacaoInicial) || rodadas == 0) {
            formacaoAtual = aplicarReceita(formacaoAtual, receita);
            rodadas++;

        }
        return rodadas;
    }
}
