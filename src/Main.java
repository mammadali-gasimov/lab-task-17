import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] names = {"John", "Alexander", "James", "Kate", "Elena", "Allen", "Marie", "Harry"};

        Scanner scanner = new Scanner(System.in);
        char userChar = getUserChar(scanner);
        for (String name : names) {
            int[] indexes = getIndexesList(userChar, name);
            if (indexes.length > 0) {
                System.out.println("For " + name + " indexes of char " + userChar + " are: " + Arrays.toString(indexes));
            }
        }
    }

    public static char getUserChar(Scanner scanner) {
        System.out.println("Enter character:");
        return scanner.nextLine().charAt(0);
    }

    public static boolean checkWithIgnoreCase(char userChar, char singleChar) {
        return Character.toString(userChar).equalsIgnoreCase(Character.toString(singleChar));
    }

    public static int getIndexesCount(char userChar, String name) {
        int count = 0;
        for (int i = 0; i < name.length(); i++) {
            if (checkWithIgnoreCase(userChar, name.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static int[] getIndexesList(char userChar, String name) {
        int count = getIndexesCount(userChar, name);
        int[] indexes = new int[count];
        int tempIndex= 0;
        for (int i = 0; i < name.length(); i++) {
            if (checkWithIgnoreCase(userChar, name.charAt(i))) {
                indexes[tempIndex] = i;
            }
        }
        return indexes;
    }
}