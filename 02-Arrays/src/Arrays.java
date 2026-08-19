public class Arrays {

    public static void printArray(int[] array) { // methode print array
        // initialisieren
        System.out.print("[");
        for (int i = 0; i < array.length; i++) { //ueber alle elemente des
            // arrays iterieren
            if (i == array.length - 1) {
                System.out.print(array[i]);//ausgabe des elements
            } else
                System.out.print(array[i] + ", ");
        }
        System.out.print("]");//ausgabe wird mit "]" abgeschlossen
        System.out.println();
    }

    public static int sum(int[] array) { //methode sum initialisieren
        int sum = 0;
        for (int i = 0; i < array.length; i++) { //alle elementwerte zur
            // gesamtsumme addieren
            sum += array[i];
        }
        return sum; //summe wird zurueckgegeben
    }

    public static double mean(int[] array) { //methode mean initialisieren
        double mean = (double) sum(array) / array.length;//mit zugriff auf
        // sum den mittelwert errechen
        return mean;//mean wird zurueckgegeben
    }

    public static int[] sumArrays(int[] array1, int[] array2) {
        int minLength = (array1.length < array2.length) ? array1.length : array2.length;
        //neue arraylaenge betraegt das minimum der anderen arraylaengen

        int array3[] = new int[minLength]; //array 3 anlegen
        for (int i = 0; i < minLength; i++) {
            array3[i] = array1[i] + array2[i];//addieren der elemente bis
            // minlength
        }
        return array3;//array3 zurueckgeben
    }

    public static int maximum(int[] array) { // methode maximum initialisieren
        int max = array[0];
        for (int i = 1; i < array.length; i++) {//arraylaenge ermitteln
            if (array[i] > max) {//vergleich des aktuellen elements mit
                // bisherigem maximum
                max = array[i];//maximum speichern
            }
        }
        return max;//finalen wert von maximum zurueckgeben
    }

    public static int[] tail(int[] array) { // methode tail initialisieren
        if (array.length == 0) {//pruefen, ist laenge = 0
            return new int[0];//leeres array zurueckgeben, wenn array leer ist
        }
        int tailArray[] = new int[array.length - 1];//neues array mit laenge
        // -1 erstellen
        for (int i = 0; i < tailArray.length; i++) {
            tailArray[i] = array[i + 1];
        }
        return tailArray;//zurueckgeben von arraytail
    }

    public static boolean checkSorting(int[] array) { //methode checkSorting
        // initialisieren
        for (int i = 0; i < array.length -1; i++) {//arraylaenge ermitteln
            if (array[i] > array[i + 1]) {//pruefen auf aufsteigende reihenfolge
                return false;//reihenfolge stimmt nicht: rueckgabe false
            }
        }
        return true;//reihenfolge passt; rueckgabe true
    }

    public static boolean[] evenNumbers(int[] array) {//methode even numbers
        // initialisieren
        boolean evenArray[] = new boolean[array.length];//boolean fuer abgabe
        // anlegen
        for (int i = 0; i < array.length; i++) {//aufzaehlung elemente der
            // arrays
            evenArray[i] = (array[i] % 2 == 0);//pruefung auf gerade zahl
        }
        return evenArray;//rueckgabe von evenarray
    }

    public static void printBooleanArray(boolean[] array) {//methode
        // printBooleanArray initialisieren
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {//aufzaehlung array elemente
            if (i == array.length - 1) {
                System.out.print(array[i]);//pruefung ob array endet
            } else
                System.out.print(array[i] + ", ");
        }
        System.out.print("]");
        System.out.println();//absatz
    }


    public static void main(String[] args) { // main Methode initialisieren
        int[] array1 = {0, 5, 12, 17, 21, 42}; //array 1 index festlegen
        int[] array2 = {23, 18, 3, 16, 41, 7, 9};// array 2 index festlegen
        printArray(array1);
        printArray(array2);//jeweilige array ausgeben
        System.out.println("array1: sum = " + sum(array1) + ", mean = " +
                mean(array1));// ausgabe sum und mean fuer array1
        int[] array3 = sumArrays(array1, array2);
        printArray(array3);
        System.out.println("maximum in array1 is " + maximum(array1));
        // maximum array 1 ausgeben
        System.out.print("array1: tail = "); // ausgabe beider array tails
        printArray(tail(array1));
        System.out.print("array2: tail = ");
        printArray(tail(array2));
        System.out.println("array1: sorted = " + checkSorting(array1));
        System.out.println("array2: sorted = " + checkSorting(array2));
        System.out.print("array1: ");// ausgabe  ob jeweilige zahlen der
        // arrays gerade sind
        printBooleanArray(evenNumbers(array1));//ausgabe eines arrays mit true
        // oder false fuer jeweils un-/gerade array elemente
        System.out.print("array2: ");
        printBooleanArray(evenNumbers(array2));
    }
}