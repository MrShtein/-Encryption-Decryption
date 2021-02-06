package encryptdecrypt.encrypt;

public class EncryptData {

    private EncryptAlgorithm shiftAlgorithm;

    public void setShiftAlgorithm(EncryptAlgorithm shiftAlgorithm) {
        this.shiftAlgorithm = shiftAlgorithm;
    }

    public String encryptData() {
        return this.shiftAlgorithm.encryptData();
    }
}
