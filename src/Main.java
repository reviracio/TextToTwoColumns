import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File("./src/text.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String text = fileScanner.nextLine();
        int columnWidth = 40;
        String oneLine = "";
        List allLines = new ArrayList();

        int head = 0;
        int tail = columnWidth;
        while (!text.isEmpty()) {
            text = text.trim();
            if (text.length() > columnWidth) {
                if ((text.charAt(tail) == ' ' || text.charAt(tail) == ',' || text.charAt(tail) == '.')) {
                    tail = columnWidth;
                    oneLine = text.substring(head, tail);
                    allLines.add(oneLine);
                } else if ((text.charAt(tail - 2) == ' ')) {
                    text = text.substring(0, tail - 2) + "  " + text.substring(tail - 2, text.length());
                    tail = columnWidth;
                    oneLine = text.substring(head, tail);
                    allLines.add(oneLine);
                } else if ((text.charAt(tail - 3) == ' ')) {
                    text = text.substring(0, tail - 3) + "   " + text.substring(tail - 3, text.length());
                    tail = columnWidth;
                    oneLine = text.substring(head, tail);
                    allLines.add(oneLine);
                } else if ((text.charAt(tail - 1) == ' ')) {
                    text = text.substring(0, tail - 1) + " " + text.substring(tail - 1, text.length());
                    tail = columnWidth;
                    oneLine = text.substring(head, tail);
                    allLines.add(oneLine);
                } else {
                    tail = columnWidth - 1;
                    oneLine = text.substring(head, tail);
                    oneLine += "-";
                    allLines.add(oneLine);
                }

            } else {
                allLines.add(text);
            }

            if (text.length() > columnWidth) {
                text = text.substring(tail, text.length());
            } else {
                text = "";
            }

        }
        int middleLine = (int) Math.ceil(allLines.size() / 2.0);
        List leftColumn = new ArrayList();
        List rightColumn = new ArrayList();
        leftColumn = allLines.subList(0, middleLine);
        rightColumn = allLines.subList(middleLine, allLines.size());
        for (int i = 0; i < middleLine; i++) {
            System.out.print(leftColumn.get(i));
            System.out.print("\t");
            if (rightColumn.size() > i) {
                System.out.println(rightColumn.get(i));
            }

        }


    }
}
