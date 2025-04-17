import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        String caminhoArquivo = "caso_102.txt";
        BufferedReader arquivo = new BufferedReader(new java.io.FileReader(caminhoArquivo));
        int n = Integer.parseInt(arquivo.readLine());
        int[] receita = Arrays.stream(arquivo.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();arquivo.close();

        long rodadas = DancaDosRobos.contarRodadasAteRepeticao(receita);
        System.out.println("A dança repete após " + rodadas + " rodadas.");
    }
}
