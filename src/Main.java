import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        readTextFile(); //Text který se vypíše z file.
    }
    public static String textFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Contents of text file: ");
        String textUser = scanner.nextLine();

        scanner.close();
        return textUser;
    }
    public static void createTextFile(){
        File file = new File("src\\text.txt");
        String textContent = textFromUser();
        try(FileWriter writer = new FileWriter(file)) {
            writer.write(textContent);
        }
        catch (IOException e){
            System.out.println("Something went wrong. 😔");
        }
    }
    public static void readTextFile(){
        createTextFile();
        File textFile = new File("src\\text.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(textFile))) {
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("The file is not find.");
        }
        catch (IOException e){
            System.out.println("Something went wrong.");
        }
    }
}