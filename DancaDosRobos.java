import java.util.Arrays;
import java.util.Scanner;

public class DancaDosRobos {

    public static int[] aplicarReceita(int[] formacao, int[] receita) {
        int[] novaFormacao = new int[formacao.length];
        for (int i = 0; i < formacao.length; i++) {
            novaFormacao[i] = formacao[receita[i]];
        }
        return novaFormacao;
    }

    public static int contarRodadasAteRepeticao(int[] receita) {
        int n = receita.length;
        System.out.println("receita length:"+n);
        int[] formacaoInicial = new int[n];
        for (int i = 0; i < n; i++) {
            formacaoInicial[i] = i;
        }
        System.out.println("formacaoInicial :"+Arrays.toString(formacaoInicial));
    
        int[] formacaoAtual = Arrays.copyOf(formacaoInicial, n);
        int rodadas = 0;
    
        while (!Arrays.equals(formacaoAtual, formacaoInicial) || rodadas == 0) {
            formacaoAtual = aplicarReceita(formacaoAtual, receita);
            rodadas++;
            System.out.println("formacaoAtual :"+Arrays.toString(formacaoAtual));
            System.out.println("rodadas :"+rodadas);
        }
    
        return rodadas;
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de robôs: ");
        int n = scanner.nextInt();

        int[] receita = new int[n];
        System.out.println("Digite a receita (sequência de " + n + " números de 0 a " + (n - 1) + "):");
        for (int i = 0; i < n; i++) {
            receita[i] = scanner.nextInt();
        }

        int rodadas = contarRodadasAteRepeticao(receita);
        System.out.println("A dança repete após " + rodadas + " rodadas.");
    }
}
