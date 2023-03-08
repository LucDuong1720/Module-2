import java.util.Scanner;

public class NumberToWords {
    public static void main(String[] args) {
        System.out.printf("Nhập số cần đọc: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String result = convertNumberToWord(number);
        System.out.println(result);

    }

    private static String convertNumberToWord(int number) {
        if (number < 0 || number > 999) {
            return "Out of ability";
        }
        String[] onesArray = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tensArray = {"", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] fix = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String result = "";
        if (number < 20) {
            result = onesArray[number];
        } else if (number < 100) {
            int tens = number / 10;
            int ones = number % 10;
            result = tensArray[tens] + " " + onesArray[ones];
        } else if (number < 120 && number > 109) {
            int hundred = number / 100;
            int tens = number % 10;
            result = onesArray[hundred] + " hundred " + fix[tens];

        }
        else {
            int hundred = number / 100;
            int tens = (number % 100) / 10;
            int ones = number % 10;
            result = onesArray[hundred] + " hundred";
            if (tens > 0) {
                result += " " +tensArray[tens];
            }
            if (ones > 0) {
                result += " " + onesArray[ones];
            }
        }
        return result;
    }
}