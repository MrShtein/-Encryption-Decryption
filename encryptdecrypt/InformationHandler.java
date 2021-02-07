package encryptdecrypt;

import encryptdecrypt.decrypt.DecryptData;
import encryptdecrypt.decrypt.ShiftDecryptAlgorithm;
import encryptdecrypt.decrypt.UnicodeDecryptAlgorithm;
import encryptdecrypt.encrypt.EncryptData;
import encryptdecrypt.encrypt.ShiftEncAlgorithm;
import encryptdecrypt.encrypt.UnicodeEncAlgorithm;

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
        String processedData = null;
        String strategy = collector.alg;
        if ("enc".equals(collector.mode)) {
            EncryptData encryptData = new EncryptData();
            if ("shift".equals(strategy)) {
                encryptData.setEncryptAlgorithm(new ShiftEncAlgorithm(collector.offset, collector.phrase));
            } else {
                encryptData.setEncryptAlgorithm(new UnicodeEncAlgorithm(collector.offset, collector.phrase));
            }
            processedData = encryptData.workWithData();
        } else {
            if ("shift".equals(strategy)) {
                DecryptData decryptData = new DecryptData();
                decryptData.setDecryptAlgorithm(new ShiftDecryptAlgorithm(collector.offset, collector.phrase));
                processedData = decryptData.workWithData();
            } else {
                DecryptData decryptData = new DecryptData();
                decryptData.setDecryptAlgorithm(new UnicodeDecryptAlgorithm(collector.offset, collector.phrase));
                processedData = decryptData.workWithData();
            }
        }
        if (!"".equals(collector.out)) {
            writeFile(processedData);
        } else {
            System.out.println(processedData);
        }
    }

}
