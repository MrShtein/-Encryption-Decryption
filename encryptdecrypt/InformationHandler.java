package encryptdecrypt;

import java.io.*;

public class InformationHandler {

    private InformationCollector collector;

    public InformationHandler(InformationCollector informationCollector) {
        collector = informationCollector;
    }

    public void handleInformation() {
        if (isInformationInFile() && !"".equals(collector.phrase)) {
            encryptOrDecryptInformation();
        } else if (isInformationInFile()) {
            readFile();
            encryptOrDecryptInformation();
        } else {
            encryptOrDecryptInformation();
        }
    }

    public boolean isInformationInFile() {
        return !"".equals(collector.in);
    }

    public void readFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(collector.in))) {
            collector.phrase = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeFile(String phraseToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(collector.out))) {
            bufferedWriter.write(phraseToWrite);
        } catch (IOException e) {
            System.out.println("Error! You put incorrect data");
        }
    }

    public boolean hasInformationOutFile() {
        return !"".equals(collector.out);
    }

    public void encryptOrDecryptInformation() {
        if ("enc".equals(collector.mode)) {
            Encryptor encryptor = new Encryptor(collector.phrase, collector.offset);
            if (!"".equals(collector.out)) {
                writeFile(encryptor.encryptPhraseWithDigit());
            } else {
                System.out.println(encryptor.encryptPhraseWithDigit());
            }
        } else {
            Decryptor encryptor = new Decryptor(collector.phrase, collector.offset);
            if (!"".equals(collector.out)) {
                writeFile(encryptor.decryptPhraseWithDigit());
            } else {
                System.out.println(encryptor.decryptPhraseWithDigit());
            }
        }
    }

}
