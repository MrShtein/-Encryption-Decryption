package encryptdecrypt;

public class InformationCollector {

    String mode;
    int offset;
    String phrase;


    public InformationCollector(String[] arguments) {
        mode = "enc";
        offset = 0;
        phrase = "";
        parseArguments(arguments);
    }

    public void parseArguments(String[] arguments) {
        for (int i = 0; i < arguments.length; i = i + 2) {
            String argumentTitle = arguments[i];
            String currentArgument = arguments[i + 1];

            if ("-mode".equals(argumentTitle)) {
                mode = currentArgument;
            } else if ("-key".equals(argumentTitle)) {
                offset = Integer.parseInt(currentArgument);
            } else {
                phrase = currentArgument;
            }
        }
    }



}
