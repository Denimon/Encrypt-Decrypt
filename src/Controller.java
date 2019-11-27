


public class Controller {

    private View view;
    private EncryptionEngine encryptionEngine;


    public Controller(){
        view = new View(this);
        encryptionEngine = new EncryptionEngine();

    }
    public void encryptionButtonClicked() {


        String encryptedString = "";
        String inputText = view.getInputText();

        try {
            encryptionEngine.setEncryptionKey(view.getEncryptionKey());
            encryptedString = encryptionEngine.encrypt(inputText);

        } catch (NumberFormatException nfe) {
            System.out.println("Not a number try again");
        } catch (InvalidCharException e) {
            System.out.println(e.getMessage());
        }
        view.setOutputText(encryptedString);
    }
    public void decryptionButtonClicked(){


        String decryptedString ="";
        String inputText = view.getInputText();

        try{
            encryptionEngine.setEncryptionKey(view.getEncryptionKey());
            decryptedString = encryptionEngine.decrypt(inputText);
        }
        catch (InvalidCharException nfe){
            System.out.println("Not a number, try again");
        }
        catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
        view.setOutputText(decryptedString);

    }

}
