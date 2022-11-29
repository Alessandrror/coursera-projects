import edu.duke.*;
import java.io.*;

/**
 * Write a description of Part4 here.
 * 
 * @author (Alessandrror) 
 * @version (No version. Thanks to Duke and Coursera)
 * 
 * What does it the program
 * 
 * Part 4: Finding Web Links
 * Write a program that reads the lines from the file at this URL location, 
 * http://www.dukelearntoprogram.com/course2/data/manylinks.html, 
 * and prints each URL on the page that is a link to youtube.com. 
 * Assume that a link to youtube.com has no spaces in it 
 * and would be in the format 
 * (where [stuff] represents characters that are not verbatim): “http:[stuff]youtube.com[stuff]”
 * 
 * Here are suggestions to get started.
 * 
 * 1. Create a new Java Class named Part4 in the StringsFirstAssignments project and put your code in that class.
 * 
 * 2. Use URLResource to read the file at http://www.dukelearntoprogram.com/course2/data/manylinks.html word by word.
 * 
 * 3. For each word, check to see if “youtube.com” is in it. 
 * If it is, find the double quote to the left and right of the occurrence of “youtube.com” 
 * to identify the beginning and end of the URL.  Note, the double quotation mark is a special character in Java. 
 * To look for a double quote, look for (\”), 
 * since the backslash (\) character indicates we want the literal quotation marks (“) 
 * and not the Java character. The string you search for would be written “\”” for one double quotation mark.
 * 
 * 4. In addition to the String method indexOf(x, num), 
 * you might want to consider using the String method lastIndexOf(s, num) 
 * that can be used with two parameters s and num. 
 * The parameter s is the string or character  to look for,  
 * and num is the last position in the string to look for it. 
 * This method returns the last match from the start of the string up to the num position, 
 * so it is a good option for finding the opening quotation mark of a string searching backward from “youtube.com.” 
 * More information on String methods can be found in the Java documentation for Strings: 
 * http://docs.oracle.com/javase/7/docs/api/java/lang/String.html.
 * 
 * Caution: The word Youtube could appear in different cases 
 * such as YouTube, youtube, or YOUTUBE. 
 * You can find the URLs more easily by converting the string to lowercase. 
 * However, you will need the original string (with uppercase and lowercase letters) 
 * to view the YouTube URL to answer a quiz question because YouTube links are case sensitive. 
 * The link https://www.youtube.com/watch?v=ji5_MqicxSo 
 * is different than the link https://www.youtube.com/watch?v=ji5_mqicxso, 
 * where all the letters are lowercase.
 * 
 */
public class Part4 {
    public void printYTUrls(String url) {
        URLResource file = new URLResource(url);
        for(String words : file.words()) {
            if(words.toLowerCase().contains("youtube.com")) {
                int startIn = words.indexOf("\"");
                int endIn = words.lastIndexOf("\"");
                System.out.println(words.substring(startIn + 1, endIn));
            }
        }
    }

    public void testUrl(){
        printYTUrls("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
    }

    public static void main (String[] args){
        Part4 run = new Part4();
        run.testUrl();
    }
}
