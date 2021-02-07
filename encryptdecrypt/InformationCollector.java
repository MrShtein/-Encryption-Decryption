package encryptdecrypt;

public class InformationCollector {

    String mode;
    int offset;
    String phrase;
    String in;
    String out;
    String alg;


    public InformationCollector(String[] arguments) {
        mode = "enc";
        offset = 0;
        phrase = "";
        in = "";
        out = "";
        alg = "shift";
        parseArguments(arguments);
    }

    public void parseArguments(String[] arguments) {
        for (int i = 0; i < arguments.length; i = i + 2) {
            String argumentTitle = arguments[i];
            String currentArgument = arguments[i + 1];

            if ("-mode".equals(argumentTitle)) {
                mode = currentArgument;
            } else if ("-alg".equals(argumentTitle)) {
                   alg = currentArgument;
            } else if ("-key".equals(argumentTitle)) {
                offset = Integer.parseInt(currentArgument);
            } else if ("-data".equals(argumentTitle)) {
                phrase = currentArgument;
            } else if ("-in".equals(argumentTitle)) {
                in = currentArgument;
            } else {
                out = currentArgument;
            }
        }
    }
}
