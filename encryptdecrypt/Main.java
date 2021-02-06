package encryptdecrypt;


public class Main {
    public static void main(String[] args) {
        InformationCollector collector = new InformationCollector(args);
        InformationHandler informationHandler = new InformationHandler(collector);
        informationHandler.handleInformation();


    }
}
