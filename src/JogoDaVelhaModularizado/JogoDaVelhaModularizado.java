package JogoDaVelhaModularizado;

/**
 *
 * Aluno: David Félix da S. Filho
 */
import java.util.Scanner;

public class JogoDaVelhaModularizado {

    public static void main(String args[]) {
        char tabuleiro[][] = new char[3][3];
        final char O = 'O';
        final char X = 'X';
        int jogada = 0;
        Scanner sc = new Scanner(System.in);

        iniciaTabuleiroVazio(tabuleiro);

        while (jogada <= 9) {

            desenhaEstadoDoTabuleiro(tabuleiro);

            jogada = pegaCoordenadas(jogada, tabuleiro, sc, X, O);

            jogada = verificaVencedor(tabuleiro, X, O, jogada);

        }
        sc.close(); //fecha o objeto Scanner
    }

    static void iniciaTabuleiroVazio(char tabuleiro[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
        System.out.print("  JOGO DA VELHA \n");
    }

    static void desenhaEstadoDoTabuleiro(char tabuleiro[][]) {
        for (int i = 0; i < 3; i++) {
            System.out.print(tabuleiro[i][0] + "|" + tabuleiro[i][1] + "|" + tabuleiro[i][2]);
            if (i < 3 - 1) {
                System.out.print("\n------\n");
            }
        }
    }

    static int pegaCoordenadas(int jogada, char tabuleiro[][], Scanner sc, char X, char O) {
        System.out.println("\nINSIRA AS COORDENADAS");
        if ((jogada % 2) == 1) {
            System.out.print("PLAYER 2\nLINHA: ");
        } else {
            System.out.print("PLAYER 1\nLINHA: ");
        }

        int i = sc.nextInt();
        System.out.print("COLUNA: ");
        int j = sc.nextInt();

        if (tabuleiro[i - 1][j - 1] == ' ') {

            if ((jogada % 2) == 1) {
                tabuleiro[i - 1][j - 1] = X;
            } else {
                tabuleiro[i - 1][j - 1] = O;
            }
            jogada++;
        }
        return jogada;
    }

    static int verificaVencedor(char tabuleiro[][], char X, char O, int jogada) {

        if ((tabuleiro[0][0] == O && tabuleiro[0][1] == O && tabuleiro[0][2] == O)
                || (tabuleiro[1][0] == O && tabuleiro[1][1] == O && tabuleiro[1][2] == O)
                || (tabuleiro[2][0] == O && tabuleiro[2][1] == O && tabuleiro[2][2] == O)
                || (tabuleiro[0][0] == O && tabuleiro[1][0] == O && tabuleiro[2][0] == O)
                || (tabuleiro[0][1] == O && tabuleiro[1][1] == O && tabuleiro[2][1] == O)
                || (tabuleiro[0][2] == O && tabuleiro[1][2] == O && tabuleiro[2][2] == O)
                || (tabuleiro[0][0] == O && tabuleiro[1][1] == O && tabuleiro[2][2] == O)
                || (tabuleiro[0][2] == O && tabuleiro[1][1] == O && tabuleiro[2][0] == O)) {

            desenhaEstadoDoTabuleiro(tabuleiro);
            System.out.print("\nJogador 1, VOCE VENCEU!!!");
            jogada = decideContinuacao(jogada, tabuleiro);

        }
        if ((tabuleiro[0][0] == X && tabuleiro[0][1] == X && tabuleiro[0][2] == X)
                || (tabuleiro[1][0] == X && tabuleiro[1][1] == X && tabuleiro[1][2] == X)
                || (tabuleiro[2][0] == X && tabuleiro[2][1] == X && tabuleiro[2][2] == X)
                || (tabuleiro[0][0] == X && tabuleiro[1][0] == X && tabuleiro[2][0] == X)
                || (tabuleiro[0][1] == X && tabuleiro[1][1] == X && tabuleiro[2][1] == X)
                || (tabuleiro[0][2] == X && tabuleiro[1][2] == X && tabuleiro[2][2] == X)
                || (tabuleiro[0][0] == X && tabuleiro[1][1] == X && tabuleiro[2][2] == X)
                || (tabuleiro[0][2] == X && tabuleiro[1][1] == X && tabuleiro[2][0] == X)) {

            desenhaEstadoDoTabuleiro(tabuleiro);
            System.out.print("\nJogador 2, VOCE VENCEU!!!");
            jogada = decideContinuacao(jogada, tabuleiro);
  
        }

        if (jogada == 9) {

            desenhaEstadoDoTabuleiro(tabuleiro);
            System.out.print("\nPARTIDA EMPATADA");
            jogada = decideContinuacao(jogada, tabuleiro);

        }
        return jogada;
    }

    static int decideContinuacao(int jogada, char tabuleiro[][]) {
        Scanner lerOp = new Scanner(System.in);
        int op;
        System.out.println("\n[1] Iniciar Nova Partida\n[2] Finalizar Jogo: ");
        op = lerOp.nextInt();
        if (op == 1) {
            iniciaTabuleiroVazio(tabuleiro);
            jogada = 0;
        } else {
            System.out.println("Jogo Finalizado!");
            System.exit(0);
        }
        return jogada;
    }
}
