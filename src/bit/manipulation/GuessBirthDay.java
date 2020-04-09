package bit.manipulation;

import javax.swing.*;

public class GuessBirthDay {
    public static void main(String[] args) {
        String[] datesArr = new String[5];
        int bDay = 0;

        for (int i = 0; i < 5; i++) {
            datesArr[i] = "";
            for (int n = 1; n <= 31; n++) {
                if (((1 << i) & n) == (1 << i)) {
                    datesArr[i] += n + " ";
                    datesArr[i] = (datesArr[i].split("\\s").length % 4 == 0) ? datesArr[i] + "\n" : datesArr[i];
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            int answer = JOptionPane.showConfirmDialog(null, "Is Your birthday in these numbers\n" + datesArr[i]);
            if (answer == JOptionPane.YES_OPTION)
                bDay += 1 << i;
        }
        JOptionPane.showMessageDialog(null, "Your birthday is " + bDay + "!");
    }
}