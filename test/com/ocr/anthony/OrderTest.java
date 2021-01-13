package com.ocr.anthony;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


public class OrderTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    Order order = new Order();

    @Test
    public void Given_Nothing_When_DisplayMenuSelection_Then_ShouldDisplayText() {
        order.displayAvailableMenu();
        assertFalse(outContent.toString().isEmpty());
    }
    /* TEST AVEC LA FONCTION CONTENANT UN IF */
    @Test
    public void Given_Chicken_When_DisplayMenuSelected_The_DisplayChickenSentenceWithIF() {
        order.displaySelectedMenuWithIF(1);
        assertEquals("Vous avez choisi le menu : poulet\n", outContent.toString().replace("\r\n", "\n"));
    }
    @Test
    public void Given_Beef_When_DisplayMenuSelected_The_DisplayBeefSentenceWithIF() {
        order.displaySelectedMenuWithIF(2);
        assertEquals("Vous avez choisi le menu : boeuf\n", outContent.toString().replace("\r\n", "\n"));
    }
    @Test
    public void Given_Vegetarien_When_DisplayMenuSelected_The_DisplayVegetarienSentenceWithIF() {
        order.displaySelectedMenuWithIF(3);
        assertEquals("Vous avez choisi le menu : végétarien\n", outContent.toString().replace("\r\n", "\n"));
    }
    @Test
    public void Given_TooBigValue_When_DisplayMenuSelected_The_DisplayErrorSentenceWithIF() {
        order.displaySelectedMenuWithIF(15);
        assertEquals("Vous n'avez pas choisi de menu parmi les choix proposés\n", outContent.toString().replace("\r\n", "\n"));
    }
    @Test
    public void Given_NegativeValue_When_DisplayMenuSelected_The_DisplayErrorSentenceWithIF() {
        order.displaySelectedMenuWithIF(-6);
        assertEquals("Vous n'avez pas choisi de menu parmi les choix proposés\n", outContent.toString().replace("\r\n", "\n"));
    }
    /* TEST AVEC LA FONCTION CONTENANT UN SWITCH */
    @Test
    public void Given_Chicken_When_DisplayMenuSelected_The_DisplayChickenSentenceWithSWITCH() {
        order.displaySelectedMenuWithSWITCH(1);
        assertEquals("Vous avez choisi le menu : poulet\n", outContent.toString().replace("\r\n", "\n"));
    }
    @Test
    public void Given_Beef_When_DisplayMenuSelected_The_DisplayBeefSentenceWithSWITCH() {
        order.displaySelectedMenuWithSWITCH(2);
        assertEquals("Vous avez choisi le menu : boeuf\n", outContent.toString().replace("\r\n", "\n"));
    }
    @Test
    public void Given_Vegetarien_When_DisplayMenuSelected_The_DisplayVegetarienSentenceWithSWITCH() {
        order.displaySelectedMenuWithSWITCH(3);
        assertEquals("Vous avez choisi le menu : végétarien\n", outContent.toString().replace("\r\n", "\n"));
    }
    @Test
    public void Given_TooBigValue_When_DisplayMenuSelected_The_DisplayErrorSentenceWithSWITCH() {
        order.displaySelectedMenuWithSWITCH(15);
        assertEquals("Vous n'avez pas choisi de menu parmi les choix proposés\n", outContent.toString().replace("\r\n", "\n"));
    }
    @Test
    public void Given_NegativeValue_When_DisplayMenuSelected_The_DisplayErrorSentenceWithSWITCH() {
        order.displaySelectedMenuWithSWITCH(-6);
        assertEquals("Vous n'avez pas choisi de menu parmi les choix proposés\n", outContent.toString().replace("\r\n", "\n"));
    }
//    @Test
//    public void Given_ChickenInStandardInput_When_MenuIsRun_Then_DisplayCorrectProcess() {
//        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
//        order = new Order();
//        order.runMenu();
//        String output = outContent.toString().replace("\r\n", "\n");
//        assertEquals(output.endsWith("Vous avez choisi le menu : poulet\n"), true);
//        assertEquals(output.length() > "Vous avez choisi le menu : poulet\n".length(), true);
//    }
    @Test
    public void Given_ChickenWithFriesAndWaterInStandardInput_When_MenuIsRun_Then_DisplayCorrectProcess() {
        System.setIn(new ByteArrayInputStream("1\n2\n3\n".getBytes()));
        order = new Order();
        order.runMenu();
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Vous avez choisi comme menu : poulet", output[5]);
        assertEquals("Vous avez choisi comme accompagnement : frites", output[11]);
        assertEquals("Vous avez choisi comme boisson : soda", output[17]);
    }
    @Test
    public void Given_BeefWithVegetableInStandardInput_When_MenuIsRun_Then_DisplayCorrectProcess() {
        System.setIn(new ByteArrayInputStream("2\n1\n".getBytes()));
        order = new Order();
        order.runMenu();
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Vous avez choisi comme menu : boeuf", output[5]);
        assertEquals("Vous avez choisi comme accompagnement : légumes frais", output[11]);
    }
    @Test
    public void Given_VegetarianWithNoRiceAndSparklingWaterAndWaterInStandardInput_When_MenuIsRun_Then_DisplayCorrectProcess() {
        System.setIn(new ByteArrayInputStream("3\n2\n2\n".getBytes()));
        order = new Order();
        order.runMenu();
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Vous avez choisi comme menu : végétarien", output[5]);
        assertEquals("Vous avez choisi comme accompagnement : pas de riz", output[10]);
        assertEquals("Vous avez choisi comme boisson : eau gazeuse", output[16]);
    }
    @Test
    public void Given_VegetablesAndAllSides_When_DisplaySideSelected_Then_DisplayVegetablesSentence() {
                order.displaySelectedSide(1, true);
                String output = outContent.toString().replace("\r\n", "\n");
                assertEquals("Vous avez choisi comme accompagnement : légumes frais\n", output);
    }
    @Test
    public void Given_FriesAndAllSides_When_DisplaySideSelected_Then_DisplayFriesSentence() {
        order.displaySelectedSide(2, true);
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals("Vous avez choisi comme accompagnement : frites\n", output);
    }
    @Test
    public void Given_RiceAndAllSides_When_DisplaySideSelected_Then_DisplayRiceSentence() {
        order.displaySelectedSide(3, true);
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals("Vous avez choisi comme accompagnement : riz\n", output);
    }
    @Test
    public void Given_BadValueAndAllSides_When_DisplaySideSelected_Then_DisplayErrorSentence() {
        order.displaySelectedSide(5, true);
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals("Vous n'avez pas choisi d'accompagnement parmi les choix proposés\n", output);
    }
    @Test
    public void Given_RiceNotAllSides_When_DisplaySideSelected_Then_DisplayRiceSentence() {
        order.displaySelectedSide(1, false);
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals("Vous avez choisi comme accompagnement : riz\n", output);
    }
    @Test
    public void Given_NoRiceAndNotAllSides_When_DisplaySideSelected_Then_DisplayNoRiceSentence() {
        order.displaySelectedSide(2, false);
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals("Vous avez choisi comme accompagnement : pas de riz\n", output);
    }
    @Test
    public void Given_BadValueAndNotAllSides_When_DisplaySideSelected_Then_DisplayErrorSentence() {
        order.displaySelectedSide(5, false);
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals("Vous n'avez pas choisi d'accompagnement parmi les choix proposés\n", output);
    }
    @Test
    public void Given_Water_When_DisplayDrinkSelected_Then_DisplayWaterSentence() {
        order.displaySelectedDrink(1);
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals("Vous avez choisi comme boisson : eau\n", output);
    }
    @Test
    public void Given_SparklingWater_When_DisplayDrinkSelected_Then_DisplaySparklingWaterSentence() {
        order.displaySelectedDrink(2);
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals("Vous avez choisi comme boisson : eau gazeuse\n", output);

    }
    @Test
    public void Given_Soda_When_DisplayDrinkSelected_Then_DisplaySodaSentence() {
        order.displaySelectedDrink(3);
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals("Vous avez choisi comme boisson : soda\n", output);

    }
    @Test
    public void Given_BadValue_When_DisplayDrinkSelected_Then_DisplayErrorSentence() {
        order.displaySelectedDrink(15);
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals("Vous n'avez pas choisi de boisson parmi les choix proposés\n", output);

    }

}