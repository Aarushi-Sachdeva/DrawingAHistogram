// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.FileReader;
import java.util.Arrays;
public class LetterFrequency {
    public static void main(String[] args) {
        double[] count = new double[26];
        for(int i=0;i<26;i++){
            count[i] = 0;
        }
        String fileName = args[0];

        try(FileReader reader = new FileReader(fileName)){
            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                char character = (char) currentChar;
                if (Character.isLetter(character)){
                    character = Character.toLowerCase(character);
                    int index = ((int) character) - 97;
                    if ( index < 26 && index >=0) {
                        count[index]++;
                    }
                }

            }
            double max = Arrays.stream(count).max().getAsDouble();
            for(int j=0;j<26;j++){
                count[j] = count[j]/max;
            }

            StdDraw.setCanvasSize(800, 400);
            StdDraw.setXscale(0, 26);
            StdDraw.setYscale(0, 1);
            StdDraw.setFont(new java.awt.Font("COURIER", java.awt.Font.BOLD, 15));



            for(int k=0;k<26;k++){
                if (k%2 ==0){
                    StdDraw.setPenColor(StdDraw.RED);
                }
                else{
                    StdDraw.setPenColor(StdDraw.ORANGE);
                }
                StdDraw.filledRectangle(k + 0.5, 0.5*count[k],  0.5,  0.5*count[k]);
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(k+0.5, 0.1, Character.toString((char) k+97));
                StdDraw.show();

            }

        }
        catch(Exception e){

            System.out.println(e + " Error reading file");
        }
    }
}