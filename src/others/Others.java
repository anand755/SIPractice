package others;

import java.io.*;

public class Others {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean isContinue = true;

        while (isContinue) {
            System.out.print("Enter the String : ");
            String inputStr = reader.readLine().trim();
            String outPut;

            outPut = inputStr.replace("(%)", "_pct");
            outPut = outPut.replace("/%tile ","_pct_");
            outPut = outPut.replace("$","");

            System.out.println(outPut);
            System.out.print("Continue? (Y/N) :");
            isContinue = reader.readLine().trim().equalsIgnoreCase("Y");
        }

    }
}
