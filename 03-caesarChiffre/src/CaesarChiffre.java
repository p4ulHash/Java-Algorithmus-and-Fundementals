
public class CaesarChiffre {

    public static final String GERMAN_LANGUAGE_PATTERN = "Werden zwei Glasstaebe mit einem Wolltuch gerieben, dann kann man feststellen, dass sich die beiden Staebe gegenseitig abstossen. Wird das gleiche Experiment mit zwei Kunststoffstaeben wiederholt, dann bleibt das Ergebnis gleich, auch diese beiden Staebe stossen sich gegenseitig ab. Im Gegensatz dazu ziehen sich ein Glas und ein Kunststoffstab gegenseitig an. Diese mit den Gesetzen der Mechanik nicht zu erklaerende Erscheinung fuehrt man auf Ladungen zurueck. Da sowohl Anziehung als auch Abstossung auftritt, muessen zwei verschiedene Arten von Ladungen existieren. Man unterscheidet daher positive und negative Ladungen.";
    public static final String ENCRYPTED_MESSAGE = "ugjt iwv! fw jcuv fgp eqfg igmpcemv wpf fkt uq twjo wpf gjtg gtyqtdgp. ykg fw ukgjuv, kuv fkgugu xgtuejnwguugnwpiuxgthcjtgp ugjt ngkejv |w mpcemgp. mqornk|kgtvgtg xgthcjtgp ygtfgp kp cpfgtgp xgtcpuvcnvwpigp pcgjgt dgvtcejvgv.";
    public static final char SEPARATOR = ' ';

    public static int getIndexOfMaximumEntry(int[] values) {
        int maxIndex = 0;
        for (int i = 1; i < values.length; i++) {
            // vergleich auf groesser >
            if (values[i] > values[maxIndex]) {
                // speicher den index
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int[] getHistogram(String text) {
        int[] histogram = new int[256];
        String lowerCaseText = text.toLowerCase();
        for (int i = 0; i < lowerCaseText.length(); i++) {
            // aktuelles Zeichen holen
            char c = lowerCaseText.charAt(i);

            // KORREKTUR (-0,5P): Leerzeichen sollen beim Zaehlen ignoriert werden!
            if (c != SEPARATOR) {
                // Zaehler an der Position des ASCII-Wertes des Zeichens erhoehen
                histogram[c]++;
            }
        }
        return histogram;
    }

    public static char getSignificantLetter(String text) {
        int[] histogram = getHistogram(text);

        // Da Leerzeichen in getHistogram nun ohnehin ignoriert werden,
        // ist dieser Schritt zur Sicherheit da, aber hat keinen stoerenden Effekt mehr.
        histogram[SEPARATOR] = 0;

        // hoechsten Wert finden
        int maxIndex = getIndexOfMaximumEntry(histogram);
        // char umwandeln
        char significantLetter = (char) maxIndex;
        // Anzahl aus dem Histogramm lesen
        int quantity = histogram[maxIndex];

        int quota = (int) (((double) quantity / text.length()) * 100);

        // Meldung auf stdout ausgeben
        System.out.println("Most significant letter: " + significantLetter);
        System.out.println("  Quantity: " + quantity + " times (" + quota + " % of whole text).");
        return significantLetter;
    }

    public static int getShift(String encryptedText, String languagePattern) {
        //suche nach haeufigsten buchstaben
        System.out.println("\nAnalyzing language pattern...");
        char sigOfPattern = getSignificantLetter(languagePattern);
        System.out.println("\nAnalyzing encrypted text...");
        char sigOfChiffre = getSignificantLetter(encryptedText);
        //differenz berechnen
        int shift = sigOfChiffre - sigOfPattern;

        System.out.println("\n--- Intermediate Decoding Report ---");
        System.out.println("Most significant letter in the pattern text: " + sigOfPattern);
        System.out.println("Most significant letter in the encrypted text: " + sigOfChiffre);
        System.out.println("Resulting shift: " + shift);
        System.out.println("-------------------------------------\n");

        //shift zurueckgeben
        return shift;
    }

    public static String decode(String encryptedText, String languagePattern) {
        //shift abrufen
        int shift = getShift(encryptedText, languagePattern);

        // Text muss in Kleinbuchstaben umgewandelt werden,
        char[] lettersEncryptedText = encryptedText.toLowerCase().toCharArray();

        //verwendung stringbuilder fue encrypted text
        StringBuilder decoded = new StringBuilder();

        //iteriere und verschiebe zeichen
        for (char currentChar : lettersEncryptedText) {
            char decodedChar = currentChar;

            // Bei korrekter Pruefung auf Buchstaben ist diese unnoetig.
            if (currentChar >= 'a' && currentChar <= 'z') {
                //shift abziehen
                decodedChar = (char) (currentChar - shift);
                //"wrap around" wenn verschobener buchstabe auf a faellt
                if (decodedChar < 'a') {
                    decodedChar = (char) (decodedChar + 26);
                }
            }
            //anhang des entschluesselten zeichens
            decoded.append(decodedChar);
        }
        //rueckgabe als string
        return decoded.toString();
    }

    public static void main(String[] args) {
        String decodedText = decode(ENCRYPTED_MESSAGE, GERMAN_LANGUAGE_PATTERN);

        // KORREKTUR 5: Korrekte Zeilenumbrueche ('\n' statt 'n')
        System.out.println("\nUnreadable, encrypted input text:");
        System.out.println(ENCRYPTED_MESSAGE);
        System.out.println("\nReadable, decoded output text:");
        System.out.println(decodedText);

        /*
         * Entschluesselter Text:
         * sehr gut! du hast den code geknackt und dir so ruhm und ehre erworben.
         * wie du siehst, ist dieses verschluesselungsverfahren sehr leicht zu knacken. kompliziertere verfahren werden in anderen veranstaltungen naeher betrachtet.
         * Schluessel (Shift): 2
         */
    }
}