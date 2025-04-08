import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("Digite o número de robôs:");
        int n = kb.nextInt();
        kb.nextLine();

        int[] receita = new int[n];

        for (int i = 0; i < receita.length; i++) {
            System.out.println("Digite a receita da dança de 0 até " + (n - 1) + ":");
            receita[i] = kb.nextInt();
            kb.nextLine(); // Consume the newline character
        }

        int a = simulaDanca(n, receita);
        System.out.println("ola mundo!");
        System.out.println("O número de rodadas é: " + a);

        kb.close(); // Close the Scanner to prevent resource leak
    }

    public static int simulaDanca(int n, int receita[]) {
        int formacaoInical[] = new int[n];
        for (int i = 0; i < n; i++) {
            formacaoInical[i] = i;
        }

        int novaFormacao[] = Arrays.copyOf(formacaoInical, n);
        int rodadas = 0;

        while (true) {
            int[] tempFormacao = new int[n]; // Array temporário para evitar sobrescrita
            for (int i = 0; i < n; i++) {
                tempFormacao[receita[i]] = novaFormacao[i];
            }
            rodadas++;
            if (Arrays.equals(tempFormacao, formacaoInical)) {
                break;
            }
            novaFormacao = Arrays.copyOf(tempFormacao, n); // Atualizar novaFormacao
        }
        return rodadas; 
        
    }
}
