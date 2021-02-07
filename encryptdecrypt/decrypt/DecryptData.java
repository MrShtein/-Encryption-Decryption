package encryptdecrypt.decrypt;

public class DecryptData {

    private DecryptAlgorithm decryptAlgorithm;

    public void setDecryptAlgorithm(DecryptAlgorithm decryptAlgorithm) {
        this.decryptAlgorithm = decryptAlgorithm;
    }

    public String workWithData() {
        return this.decryptAlgorithm.decryptData();
    }

}
