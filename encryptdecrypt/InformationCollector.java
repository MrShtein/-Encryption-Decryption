package encryptdecrypt;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InformationCollector {

    private Scanner scanner;

    public InformationCollector() {
        this.scanner = new Scanner(System.in);
    }

    public String getPhrase() {
        return scanner.nextLine();
    }

    public Integer getOffset() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("It needed to write a digit");
            return null;
        }
    }
}
