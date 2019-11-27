public class EncryptionEngine {

    private int encryptionKey;

    public EncryptionEngine(){


    }

    public void setEncryptionKey(int encryptionKey) {
        this.encryptionKey = encryptionKey;
    }
    public int getEncryptionKey(){
        return encryptionKey;
    }

    public String encrypt(String inputText) throws InvalidCharException {

        char[] inCharArr = inputText.toCharArray();


        for (int i= 0; i<inCharArr.length; i++) {

            if (inCharArr[i] == ' '){
                continue;
            }

            if (inCharArr[i] <'A'|| inCharArr[i] >'Z'){
                throw new InvalidCharException("Wrong input. only uppercase characters is valid");
            }

            char encryptChar = (char) ((inCharArr[i] - 'A' + encryptionKey) % 26 + 'A');
            inCharArr[i] = encryptChar;
        }

        return String.valueOf(inCharArr); // convert char arr back to a string
    }

    public String decrypt(String inputText) throws InvalidCharException{

        char[] inCharArr = inputText.toCharArray();

        for(int i = 0; i<inCharArr.length; i++) {
            if(inCharArr[i] == ' '){
                continue;
            }
            if(inCharArr[i] <'A' || inCharArr[i] > 'Z'){
                throw new InvalidCharException("Wrong input. Only uppercase characters is valid");
            }
            char decryptChar = (char) ((inCharArr[i] - 'A' +26 - encryptionKey) % 26 + 'A');
            inCharArr[i] = decryptChar;
        }
        return String.copyValueOf(inCharArr);
    }
}
