import edu.duke.*;
import java.io.File;

/**
 * Write a description of Part1 here.
 * This program let you know if you pass some DNA string or not
 * @author (Alessandrror) 
 * @version (No version: Thanks to Duke and Coursera)
 * 
 * What it does the program?
 * 
 * Part 1: Finding a Gene - Using the Simplified Algorithm
 * This assignment is to write the code from the lesson from scratch by following the steps below. 
 * This will help you see if you really understood how to put the code together, 
 * and might identify a part that you did not fully understand. 
 * If you get stuck, then you can go back and watch the coding videos that go with this lesson again. 
 * We recommend you try this with many of the future Java coding examples before starting programming exercises.
 * 
 * Specifically, you should do the following:
 * 
 * 1. Create a new Java project named StringsFirstAssignments. 
 * You can put all the classes for this programming exercise in this project.
 * 
 * 2. Create a new Java Class named Part1. The following methods go in this class.
 * 
 * 3. . Write the method findSimpleGene that has one String parameter dna, representing a string of DNA. 
 * This method does the following:
 * 
 * Finds the index position of the start codon “ATG”. If there is no “ATG”, return the empty string.
 * 
 * Finds the index position of the first stop codon “TAA” appearing after the “ATG” that was found. 
 * If there is no such “TAA”, return the empty string. 
 * 
 * If the length of the substring between the “ATG” and “TAA” is a multiple of 3, 
 * then return the substring that starts with that “ATG” and ends with that “TAA”.
 * 
 * 4. Write the void method testSimpleGene that has no parameters. 
 * You should create five DNA strings. 
 * The strings should have specific test cases, such as: 
 * DNA with no “ATG”, 
 * DNA with no “TAA”, 
 * DNA with no “ATG” or “TAA”, 
 * DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene), 
 * and DNA with ATG, TAA and the substring between them is not a multiple of 3. 
 * For each DNA string you should: 
 * 
 * Print the DNA string. 
 * 
 * See if there is a gene by calling findSimpleGene with this string as the parameter. 
 * If a gene exists following our algorithm above, then print the gene, otherwise print the empty string.
 */
public class Part1 {
    public String findSimpleGene(String dna) {
        String result = null;
        int startIn = dna.indexOf("ATG");
        int stopIn = dna.indexOf("TAA",startIn + 3);
        int ans = stopIn - startIn;
        if (startIn == -1 || stopIn == -1 || ans % 3 != 0 ){
            return result = "";
        }
        else {
            return result = dna.substring(startIn, stopIn + 3);
        }
    }
    
    public void testSimpleGene() {
        //dna with no ATG and no TAA
        String dna = "ACGTATATGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        //dna with no ATG but TAA
        dna = "ACGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        //dna with ATG but no TAA 
        dna = "AATGCTAGGGTATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        //dna with ATG, TAA and substring multiple of 3
        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        //dna with ATG, TAA and substring not multiple of 3
        dna = "ATCCTATGTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        //dna with ATG, TAA and not substring between
        dna = "ATGTAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
    }

    public static void main(String[] args){
        Part1 run = new Part1();
        run.testSimpleGene();
    } 
}
