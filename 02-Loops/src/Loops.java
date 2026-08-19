public class Loops { //Klasse Loops anlegen
    public static void main(String[] args) { // main Methode initialisieren
        for (int a = 0; a < 11; a++) { // 0-10 mit < Aufgabe 2
            System.out.print( a + " " );
        }
        System.out.println(); // nach jeder Schleife frei Zeile
        for (int b = 0; b <= 10; b++){ // 0-10 mit <=
            System.out.print( b + " " );
        }
        System.out.println();
        for (int c = 6; c <= 42; c += 6){ // 6-42 in 6er Schritten
            System.out.print( c + " " );
        }
        System.out.println();
        for (int d = 23; d >= 11; d -= 2){ // 23-11 (ungerade, negativ -2)
            System.out.print( d + " " );
        }
        System.out.println();
        for (int e = 8; e < 17; e += 2){ // 8-16 (gerade Schritte +2)
            System.out.print( e + " " );
        }
        System.out.println();
        for (int e = 16; e <= 711; e *= 2) { // 16-711 (* 2 weil 2^2 Anfang)
            System.out.print( e + " " );
        }
        System.out.println(); // Umwandlung in while Aufgabe 3
        int m = 7;
        int i = 0;
        while (m >= i){ // Bedingung
            System.out.print( i + " " );
            i++; //Aenderung der Zaehlvariable
        }
        System.out.println();
        i = 42; // Variable auf 42 zur weiterverwendung setzen
        while ( 2 * i > m) {
            System.out.print( i + " ");
            i -= 6; // Aenderung der Zaehlvariable
        }
        System.out.println();
        while (true){ //umwandlung while (True) Aufgabe 4
            System.out.print( i + " " );
            i++; //Aenderung der Zaehl Variable
            if (m < i) {
                break; //if Schleife erfuellt wird -> break (Ende der Schleife)
            }
        }
        System.out.println();
        i = 42; //Variable auf 42 zur weiterverwendung setzen
        while (true) {
            System.out.print( i + " ");
            i -= 6; // Aenderung der Zaehl Variable
            if ( 2 * i <= m){
                break;
            }
        }
        System.out.println();
        byte nMax = 5; //festlegen Variablen, byte weil <128
        double x = 2; // wird in der Rechnung verwendet deswegen Gleitkomma zahl
        byte a = 2; // < 128
        for (int n = 0; n <= nMax; n++){
            x = 0.5 * (x + a / x); //Formel
            System.out.println("Approximation at step (" + n + "): " + x);
        }
    }
}