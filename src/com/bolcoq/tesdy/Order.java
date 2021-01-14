package com.bolcoq.tesdy;

import java.util.Scanner;

public class Order {
    Scanner sc = new Scanner(System.in);

    /**
     * Display all available menus in the restaurant.
     */
    public void displayAvailableMenu() {
        System.out.println("Choix Menu");
        System.out.println("1 - poulet");
        System.out.println("2 - boeuf");
        System.out.println("3 - végétarien");
        System.out.println("Que souhaitez-vous comme menu ?");
    }
    /**
     * Display a selected menu.
     * @param nbMenu The selected menu.
     */
    public void displaySelectedMenuWithIF(int nbMenu) {
        if (nbMenu == 1) {
            System.out.println("Vous avez choisi le menu : poulet");
        } else if (nbMenu == 2) {
            System.out.println("Vous avez choisi le menu : boeuf");
        } else if (nbMenu == 3) {
            System.out.println("Vous avez choisi le menu : végétarien");
        } else {
            System.out.println("Vous n'avez pas choisi de menu parmi les choix proposés");
        }
    }
    /**
     * Display a selected menu.
     * @param nbMenu The selected menu.
     */
    public void displaySelectedMenuWithSWITCH(int nbMenu) {
        switch (nbMenu) {
            case 1 -> System.out.println("Vous avez choisi le menu : poulet");
            case 2 -> System.out.println("Vous avez choisi le menu : boeuf");
            case 3 -> System.out.println("Vous avez choisi le menu : végétarien");
            default -> System.out.println("Vous n'avez pas choisi de menu parmi les choix proposés");
        }
    }
    /**
     * Display all available sides depending on all sides enable or not.
     * All sides = vegetables, frites and rice
     * No All Sides = rice or not
     * @param allSideEnable boolean -> enable display for all side or not
     */
    private void displayAvailableSide(boolean allSideEnable) {
        System.out.println("Choix accompagnement");
        if (allSideEnable) {
            System.out.println("1 - légumes frais");
            System.out.println("2 - frites");
            System.out.println("3 - riz");
        } else {
            System.out.println("1 - riz");
            System.out.println("2 - pas de riz");
        }
        System.out.println("Que souhaitez-vous comme accompagnement ?");
    }
    private void displayAvailableDrink() {
        System.out.println("Choix boisson");
        System.out.println("1 - eau");
        System.out.println("2 - eau gazeuse");
        System.out.println("3 - soda");
        System.out.println("Que souhaitez vous comme boisson ?");
    }
    /**
     * Display a selected side depending on all sides enable or not.
     * All sides = vegetables, frites and rice
     * No all sides = rice or not
     * @param nbSide int -> The selected Side
     * @param allSidesEnable boolean -> Enable display for all side or not
     */
    public void displaySelectedSide(int nbSide, boolean allSidesEnable) {
        if (allSidesEnable) {
            switch(nbSide) {
                case 1 -> System.out.println("Vous avez choisi comme accompagnement : légumes frais");
                case 2 -> System.out.println("Vous avez choisi comme accompagnement : frites");
                case 3 -> System.out.println("Vous avez choisi comme accompagnement : riz");
                default -> System.out.println("Vous n'avez pas choisi d'accompagnement parmi les choix proposés");
            }
        } else {
            switch(nbSide) {
                case 1 -> System.out.println("Vous avez choisi comme accompagnement : riz");
                case 2 -> System.out.println("Vous avez choisi comme accompagnement : pas de riz");
                default -> System.out.println("Vous n'avez pas choisi d'accompagnement parmi les choix proposés");
            }
        }
    }
    /**
     * Display a selected drink
     * @param nbDrink int -> the selected drink
     */
    public void displaySelectedDrink(int nbDrink) {
        switch(nbDrink) {
            case 1 -> System.out.println("Vous avez choisi comme boisson : eau");
            case 2 -> System.out.println("Vous avez choisi comme boisson : eau gazeuse");
            case 3 -> System.out.println("Vous avez choisi comme boisson : soda");
            default -> System.out.println("Vous n'avez pas choisi de boisson parmi les choix proposés");
        }
    }
    public void runMenu() {
        this.displayAvailableMenu();
        int nbMenu;
        do {
            nbMenu = sc.nextInt();
            this.displaySelectedMenuWithIF(nbMenu);
            // Si nb = 3 => allSide = false
            switch(nbMenu) {
                case 1:
                    displayAvailableSide(true);
                    int nbSide = sc.nextInt();
                    displaySelectedSide(nbSide, true);
                    displayAvailableDrink();
                    int nbDrink = sc.nextInt();
                    displaySelectedDrink(nbDrink);
                    break;
                case 2:
                    displayAvailableSide(true);
                    nbSide = sc.nextInt();
                    displaySelectedSide(nbSide, true);
                    break;
                case 3:
                    displayAvailableSide(false);
                    nbSide = sc.nextInt();
                    displaySelectedSide(nbSide, false);
                    displayAvailableDrink();
                    nbDrink = sc.nextInt();
                    displaySelectedDrink(nbDrink);
                    break;
            }
        } while (nbMenu < 1 || nbMenu > 3);
    }

    public void runMenus() {
        /* TROIS FOIS le même code mais avec des conditions différentes :
        // WHILE() {}
        System.out.println("while () {");
        System.out.println("Combien souhaitez-vous commander de menu(s) ?");
        int nbMenusWhile = sc.nextInt();
        while (nbMenusWhile > 0) {
            this.runMenu();
            nbMenusWhile--;
        }
        System.out.println("}");
*/
        // FOR() {}
        System.out.println("for () {");
        System.out.println("Combien souhaitez-vous commander de menu(s) ?");
        int nbMenusFor = sc.nextInt();
        for (int i = 0; i < nbMenusFor; i++) {
            this.runMenu();
        }
        System.out.println("}");
/*
        // DO {} WHILE()
        System.out.println("do {");
        System.out.println("Combien souhaitez-vous commander de menu(s) ?");
        int nbMenusDoWhile = sc.nextInt();
       do {
            this.runMenu();
            nbMenusDoWhile--;
        } while (nbMenusDoWhile > 0);
        System.out.println("} while ()");
    */
    }
}