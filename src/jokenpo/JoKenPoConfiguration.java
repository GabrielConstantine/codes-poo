package jokenpo;

import java.util.Random;
import java.util.Scanner;

public record JoKenPoConfiguration(
        Players user,
        Players IA,
        int rounds
) {
    public void toPlay() {
        System.out.println("\n*====================* SEJA BEM-VINDO(A), " + user.getName() + " *====================*");

        for(int i = 1; i <= rounds; i++){
            int choiceUser = choiceUser();
            if(choiceUser < 1 || choiceUser > 3) {
                System.out.println("\n\t\t\t╔═════ JOGADA INVÁLIDA!! ═════╗");
                System.out.println("\t\t\t║\t\tPONTO PARA "+IA.getName()+"\t\t  ║");
                System.out.println("\t\t\t╚═════════════════════════════╝\n");
                System.out.println("*******************************************************************");
                IA.incrementScore();
                continue;
            }
            int choiceIA = choiceIA();
            System.out.println("\n\t\t\t══════ RESULTADO DO ROUND ══════");
            System.out.println("\t\t\t\t\t\t   "+choiceUser+" X "+choiceIA);
            int result = choiceUser - choiceIA;
            winnerRound(result);
        }
    }
    private int choiceUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\t\t*======*1 - PEDRA || 2 - PAPEL || 3 - TESOURA *======*");
        System.out.print("——> Informe sua jogada: ");
        return scan.nextInt();
    }
    private int choiceIA() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }
    private void winnerRound(int result) {
        String winnerRound;
        if(result == 0) {
            winnerRound = "EMPATE!";
        } else {
            if(result == -1 || result == 2) {
                IA().incrementScore();
                winnerRound = IA().getName()+" wins!!";
            } else {
                user.incrementScore();
                winnerRound = user.getName()+" wins!!";
            }
        }
        System.out.println("\t\t\t\t\t\t "+winnerRound);
        System.out.println("\t\t\t════════════════════════════════\n");
        System.out.println("*******************************************************************");
    }
    public void showFinalResult() {
        int finalUserScore = user.getScore();
        int finalIAScore = IA.getScore();

        System.out.println("\n\t\t\t═══════ RESULTADO FINAL ═══════");
        System.out.println("\t\t\t\t\t" + user.getName() + " " + user.getScore() + " X " + IA.getScore() + " " + IA.getName());

        if (finalIAScore == finalUserScore) {
            System.out.println("\t\t\t\t\t\tEMPATE!");
        } else {
            String finalWinner = (finalIAScore > finalUserScore) ? IA.getName() : user.getName();
            System.out.println("\t\t\t\t\t\t   " + finalWinner.toUpperCase()+" wins!!");
        }
        System.out.println("\t\t\t═══════════════════════════════\n");
        System.out.println("***************************************************************");
    }

}