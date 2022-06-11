import java.util.Scanner;

public class test {
   public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            while (true){
                otp UI = new otp();

                String word = s.nextLine();
                if (word.equals("q") || word.equals("quit")){
                    break;
                }
                byte[] encryptWord = UI.encryptWord(word);
                UI.printBytes(encryptWord);

                UI.print(UI.decryptWord(encryptWord));
            }
        }

        
    }
}
