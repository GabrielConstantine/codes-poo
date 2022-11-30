package jokenpo;

import java.util.Scanner;

public class CoreMain {
    public static JoKenPoConfiguration startGame() {
        Scanner scan = new Scanner(System.in);

        System.out.println("*==========================* Jo-Ken-Po *==========================*");
        System.out.println("——> Infome seu nome: ");
        String playersName = scan.next().toUpperCase();

        Players user = new Players(playersName);
        Players IA = new Players("IA");

        System.out.print(playersName+", informe quantos rounds você vai jogar: ");
        int rounds = scan.nextInt();

        return new JoKenPoConfiguration(user, IA, rounds);
    }
    public static void main(String[] args) {
        JoKenPoConfiguration jokenPo = startGame();
        jokenPo.toPlay();
        jokenPo.showFinalResult();
    }
}
