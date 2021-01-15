package com.bolcoq.tesdy;

import java.util.Scanner;

public class Interaction {
    static Scanner sc = new Scanner(System.in);

    public static void askSomething(String things, String[] responses) {
        System.out.println("Choix " + things);
        for (int i = 1; i <= responses.length; i++) System.out.println(i + " - " + responses[i - 1]);
        System.out.println("Que souhaitez vous comme " + things + " ?");
        int nbResponse;
        boolean responseIsGood;
        do {
            nbResponse = sc.nextInt();
            responseIsGood = nbResponse >= 1 && nbResponse <= responses.length;
            if (responseIsGood) System.out.println("Vous avez choisi comme " + things + " : " + responses[nbResponse - 1]);
            else {
                boolean isVoyel = "aeiouy".contains(things.substring(0,1));
                if (isVoyel) System.out.println("Vous n'avez pas choisi d'" + things + " parmi les choix proposés");
                else System.out.println("Vous n'avez pas choisi de " + things + " parmi les choix proposés");
            }
        } while (!responseIsGood);
    }
}
