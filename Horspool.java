import java.util.Scanner;

public class Horspool {

    public static int horspool(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();

        int[] shift = new int[256];

        for (int i = 0; i < 256; i++) {
            shift[i] = m;
        }

        for (int j = 0; j < m - 1; j++) {
            shift[(int) pattern.charAt(j)] = m - 1 - j;
        }

        int i = m - 1;

        while (i < n) {
            int k = 0;

            while (k < m && pattern.charAt(m - 1 - k) == text.charAt(i - k)) {
                k++;
            }

            if (k == m) {
                return i - m + 1;
            } else {
                i = i + shift[text.charAt(i)];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        System.out.print("Enter the pattern: ");
        String pattern = sc.nextLine();

        int pos = horspool(text, pattern);

        if (pos >= 0) {
            System.out.println("Pattern found at position: " + pos);
        }
        else {
            System.out.println("Pattern not found");
        }

    }
}