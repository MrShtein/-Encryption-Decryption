package encryptdecrypt.encrypt;

public class EncryptData {

    private EncryptAlgorithm encryptAlgorithm;

    public void setEncryptAlgorithm(EncryptAlgorithm encryptAlgorithm) {
        this.encryptAlgorithm = encryptAlgorithm;
    }

    public String workWithData() {
        return this.encryptAlgorithm.encryptData();
    }
}
