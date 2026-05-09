import java.util.Scanner;

class string
{
    static void stringMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        boolean found = false;

        for (int i = 0; i <= n - m; i++) {
            int j;


            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                System.out.println("Pattern found at index: " + i);
                System.out.println(text);
                String str="  ";
                for (int u=0;u<i;u++)
                {
                   System.out.println(str.repeat(u)+pattern);
                }
                found = true;
            }
        }

        if (!found) {
            System.out.println("Pattern not found in the text.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = sc.nextLine();

        System.out.print("Enter the pattern to search: ");
        String pattern = sc.nextLine();

        stringMatch(text, pattern);

    }
}

