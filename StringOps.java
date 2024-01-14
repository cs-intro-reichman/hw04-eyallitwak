public class StringOps {
    ////////////////////////////////////////////////////////////
    ////// ///////
    ////// Reminder: ///////
    ////// allowed methods ///////
    ////// ///////
    ////// 1.charAt(int index) ///////
    ////// 2.length() ///////
    ////// 3.substring(int start) ///////
    ////// 4.substring(int start,int ends) ///////
    ////// 5.indexOf(String str) ///////
    ////// ///////
    ////// The rest are not allowed ! ///////
    ////// if you want to use a different ///////
    ////// method, and you can implement ///////
    ////// it using material from the course ///////
    ////// you need to implement a version of ///////
    ////// the function by yourself. ///////
    ////// ///////
    ////// see example for substring ///////
    ////// in Recitation 3 question 5 ///////
    ////// ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        int[] array = allIndexOf("MMMM", 'M');
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /*
     * gets a string, returns the string with each vowel in uppercase & each
     * consonant in lowercase
     */
    public static String capVowelsLowRest(String string) {
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            /* checks each char in string, changes it as necessary */
            if (isVowel(currentChar) && currentChar <= 'Z') {
                result += (char) currentChar;
            } else {
                if (isVowel(currentChar)) {
                    result += (char) (currentChar - 32);
                } else {
                    if (currentChar <= 'Z' && currentChar > 32) {
                        result += (char) (currentChar + 32);
                    } else {
                        result += currentChar;
                    }
                }
            }
        }

        return result;
    }

    /* returns whether the given character is an English vowel */
    public static boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
        }
        return false;
    }

    /* returns whether the given character is a latin-alphabet letter */
    public static boolean isLetter(char c) {
        return (c >= 'A') && (c <= 'z');
    }

    public static char toUpperCase(char c) {
        return (char) (c - 32);
    }

    public static char toLowerCase(char c) {
        return (char) (c + 32);
    }

    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static String camelCase(String string) {
        String result = "";
        boolean isNextUpper = false;

        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (currentChar == ' ') {
                isNextUpper = true;
            } else {
                if (result.length() == 0) {
                    result += isLowerCase(currentChar) ? currentChar : toLowerCase(currentChar);
                    isNextUpper = false;
                } else {

                    if (isNextUpper) {
                        result += isUpperCase(currentChar) ? currentChar : toUpperCase(currentChar);
                        isNextUpper = false;
                    } else {
                        result += isLowerCase(currentChar) ? currentChar : toLowerCase(currentChar);
                    }
                }
            }
        }
        return result;
    }

    /*
     * gets a string and a char, returns an array with all indexes in which the
     * given char appears in the string
     */
    public static int[] allIndexOf(String string, char chr) {
        int count = 0;

        // determines length of the returned array
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                count++;
            }
        }
        int[] indexArray = new int[count];
        int index = 0;

        // populates returned array with all indexes of given character
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                indexArray[index] = i;
                index++;
            }
        }

        return indexArray;
    }
}
