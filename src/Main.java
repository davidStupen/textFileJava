import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        answer();

    }
    public static String textFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("přidáš text do file: ");
        String textUser = scanner.nextLine().toLowerCase();

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
    public static List<String> readTextFile(){
        createTextFile();
        List<String> greetList = new ArrayList<>();
        File textFile = new File("src\\text.txt");
        try(BufferedReader reader = new BufferedReader(new FileReader(textFile))) {
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
                if (line.equals("ahoj") || line.equals("zdar") || line.equals("čus") || line.equals("dobrý den")){
                    greetList.add("ahoj");
                    greetList.add("zdar");
                    greetList.add("čus");
                    greetList.add("dobrý den");
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("The file is not find.");
        }
        catch (IOException e){
            System.out.println("Something went wrong.");
        }
        return greetList;
    }
    public static void answer(){
        List<String> greets = readTextFile();
        if (!greets.isEmpty()) {
            System.out.println("*****************");
            System.out.println("Odpověď počitače na pozdrav:");
            Random random = new Random();
            System.out.println(greets.get(random.nextInt(greets.size())));
        }
    }
}