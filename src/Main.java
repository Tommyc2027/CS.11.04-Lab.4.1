public class Main {

    public static void main(String[] args) {
        System.out.println(parenthesesCheck("()"));
        System.out.println(parenthesesCheck(")(()))"));
        System.out.println(parenthesesCheck("("));
        System.out.println(parenthesesCheck("(())((()())())"));
        System.out.println(reverseInteger(1234));
        System.out.println(reverseInteger(2468));
        System.out.println(encryptThis("Hello good day"));
        System.out.println(encryptThis("Ready set go"));
        System.out.println(decipherThis("72olle 103doo 100ya"));
        System.out.println(decipherThis("82yade 115te 103o"));
    }
    // 1.parenthesesCheck
    public static boolean parenthesesCheck(String str) {
        int openClosed = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                openClosed++;
            } else if (str.charAt(i) == ')') {
                openClosed--;
            }
            if (openClosed < 0) {
                return false;
            }
        }
        return openClosed == 0;
    }
    // 2. reverseInteger
    public static String reverseInteger(int num) {
        String number = Integer.toString(num);
        String reversed = "";

        for (int i = number.length() - 1; i >= 0; i--) {
            reversed += number.charAt(i);
        }
        return reversed;
    }
    //3. encryptThis
    public static String encryptThis(String text) {
        String[] words = text.split(" ");
        String encrypted = "";

        for (String word : words) {
            if (word.length() > 0) {
                String encryptedWord = (int) word.charAt(0) + "";
                if (word.length() > 1) {
                    encryptedWord += word.charAt(word.length() - 1);
                    if (word.length() > 2) {
                        encryptedWord += word.substring(2, word.length() - 1);
                    }
                    encryptedWord += word.charAt(1);
                }

                encrypted += encryptedWord + " ";
            }
        }

        return encrypted.trim();
    }
    //4. decipherThis
    public static String decipherThis(String text) {
        String[] words = text.split(" ");
        StringBuilder deciphered = new StringBuilder();

        for (String word : words) {
            StringBuilder decipheredWord = new StringBuilder();
            StringBuilder code = new StringBuilder();
            int i = 0;

            while (i < word.length() && Character.isDigit(word.charAt(i))) {
                code.append(word.charAt(i));
                i++;
            }

            int firstCharCode = Integer.parseInt(code.toString());
            char firstChar = (char) firstCharCode;
            decipheredWord.append(firstChar);

            if (i < word.length()) {
                char secondChar = word.charAt(i);
                char lastChar = word.charAt(word.length() - 1);
                decipheredWord.append(lastChar);

                if (i + 1 < word.length() - 1) {
                    decipheredWord.append(word, i + 1, word.length() - 1);
                }
                decipheredWord.append(secondChar);
            }
            deciphered.append(decipheredWord).append(" ");
        }
        return deciphered.toString().trim();
    }
}
