package PedraPapelTesoura;

import java.util.Random;
import java.util.Scanner;

/**
 * @author David Félix.
 * Exercício 2 - Laboratório de Programação - C. Computação Noturno - UEPB
 */
public class PedraPapelTesoura {

    public static void main(String args[]) {
        
        Scanner ler = new Scanner(System.in);
        Random random = new Random();
        
        String[] elementos = {"", "Pedra", "Papel", "Tesoura"};
        int n, jogadorUm, jogadorDois;
        int opParada = -1;
        n = elementos.length-1;
        
        do
        {
            // vez do primeiro jogador    
            exibirElementos(elementos);
            jogadorUm = ler.nextInt();
            jogadorUm = verificaJogada(ler, elementos, jogadorUm, n, opParada);

            // vez do segundo jogador     
            exibirElementos(elementos);
 
            //jogadorDois = ler.nextInt();
            // o segundo jogador está sendo o computador
            jogadorDois = random.nextInt(n)+1; // o +1 serve criar o intervalo de (1 a n)
            System.out.println(jogadorDois);
            jogadorDois = verificaJogada(ler, elementos, jogadorDois, n, opParada);

            // jogadas escolhidas
            exibirJogadasEscolhidas(elementos, jogadorUm, jogadorDois);

            // resultado da partida
            exibirResultado(elementos, n, jogadorUm, jogadorDois);
            
        }while(jogadorUm != opParada && jogadorDois != opParada);
    }
    static void exibirElementos(String[] elementos){
        
        int tam = elementos.length;
        for(int i=1; i < tam; i++)
        {
            if(i == tam - 1)
            {
                System.out.print(elementos[i] + " (" + i + ")? "); 
            }else
            {
                System.out.print(elementos[i] + " (" + i + "), ");
            }
        }
    }
    static void exibirJogadasEscolhidas(String[] elementos, int jogadorUm, int jogadorDois){
        
        System.out.println(elementos[jogadorUm].toUpperCase() + " - " + elementos[jogadorDois].toUpperCase());
    }
    static void exibirResultado(String[] elementos, int n, int jogadorUm, int jogadorDois){
        
        int res;
        
        res = (n + jogadorUm - jogadorDois) % n;
        
        if (0 < res && res <= n/2)
        {
            System.out.println("Jogador 1 Ganhou!"); 
        }else if (res > n/2)
        {
            System.out.println("Jogador 2 Ganhou!");
        }else if (res == 0)
        {
            System.out.println("Houve Empate!");
        }
    }
    static int verificaJogada(Scanner ler, String[] elementos, int jogadaJogador, int n, int opParada){
        if (jogadaJogador == opParada)
        {
            System.exit(0);
        }else
        {
            while(jogadaJogador <= 0 || jogadaJogador > n)
            {
                System.out.println("Escolha um valor entre 1 e " + n);
                exibirElementos(elementos);
                jogadaJogador = ler.nextInt();
                if (jogadaJogador == opParada)
                {
                    System.exit(0);
                }
            }
        }    
        return jogadaJogador;
    }
}