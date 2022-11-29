import edu.duke.*;
import java.io.File;

/**
 * Write a description of Part2 here.
 * This program let you know if you pass some DNA string in lower or up
 * @author (Alessandrror) 
 * @version (No version: Thanks to Duke and Coursera)
 * 
 * What it does it the program?
 * 
 * Part 2: Finding a Gene - Using the Simplified Algorithm Reorganized
 * This assignment will determine if a DNA strand has a gene in it by using 
 * the simplified algorithm from the lesson, but organizing the code in a slightly different way. 
 * You will modify the method findSimpleGene to have three parameters, 
 * one for the DNA string, one for the start codon and one for the stop codon.
 * 
 * Specifically, you should do the following:
 * 
 * 1. Create a new Java Class named Part2 in the StringsFirstAssignments project.
 * 
 * 2. Copy and paste the two methods findSimpleGene and testSimpleGene  from the Part1 class into the Part2 class.
 * 
 * 3. The method findSimpleGene has one parameter for the DNA string named dna.  
 * Modify findSimpleGene to add two additional parameters, 
 * one named startCodon for the start codon and one named stopCodon for the stop codon. 
 * What additional changes do you need to make for the program to compile? 
 * After making all changes, run your program to check that you get the same output as before.
 * 
 * 4. Modify the findSimpleGene method to work with DNA strings that 
 * are either all uppercase letters such as “ATGGGTTAAGTC” or all lowercase letters such as “gatgctataat”. 
 * Calling findSimpleGene with “ATGGGTTAAGTC” should return the answer with uppercase letters, the gene “ATGGGTTAA”, 
 * and calling findSimpleGene with  “gatgctataat” should return the answer with lowercase letters, the gene “atgctataa”. 
 * HINT: there are two string methods toUpperCase() and toLowerCase(). 
 * If dna is the string “ATGTAA” then dna.toLowerCase() results in the string “atgtaa”.
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String result = null;
        
        if (dna.toLowerCase() == dna) {
            startCodon = "atg";
            stopCodon = "taa";
            String dnaLower = dna.toLowerCase();
            int startIn = dnaLower.indexOf(startCodon);
            int stopIn = dnaLower.indexOf(stopCodon,startIn + 3);
            int ans = stopIn - startIn;
            if (startIn == -1 || stopIn == -1 || ans % 3 != 0 ){
                return result = "No gene found!";
            }
            else {
                return result = dnaLower.substring(startIn, stopIn + 3);
            }
        }
        
        if (dna.toUpperCase() == dna) {
            startCodon = "ATG";
            stopCodon = "TAA";
            String dnaUpper = dna.toUpperCase();
            int startIn = dnaUpper.indexOf(startCodon);
            int stopIn = dnaUpper.indexOf(stopCodon,startIn + 3);
            int ans = stopIn - startIn;
            if (startIn == -1 || stopIn == -1 || ans % 3 != 0 ){
                return result = "No gene found!";
            }
            else {
                return result = dnaUpper.substring(startIn, stopIn + 3);
            }
        }
        
        else {
            return "No DNA found!";
        }
    }
    
    public static void main(String[] args){
        Part2 run = new Part2();
        System.out.println(run.findSimpleGene("ATGGGTTAAGTC","",""));
        System.out.println(run.findSimpleGene("gatgctataat","",""));
        System.out.println(run.findSimpleGene("ATGGTTAAGTC","ATG","TAA"));
        System.out.println(run.findSimpleGene("gatgcataat","atg","taa"));
    } 
}
