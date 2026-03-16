import java.util.Scanner; // Importerar Scanner för inmatning.

public class TicTacToe{ // Huvudklass för Tic Tac Toe spelet.

    public static void printaBrädan(char[][] Bräda) { // Metod som skriver ut spelbrädet.
        for (int vertikal = 0; vertikal < 3; vertikal++) { // går igenom y-led.
            for (int horisontell = 0; horisontell < 3; horisontell++) // går igenom x-led.
                System.out.print(Bräda[vertikal][horisontell] + " "); // printar varje plats
            System.out.println(); // ny rad. 
        }
    }

    public static boolean KollaVinnaren(char [][] Bräda, char currentPlayer) { // Metod som kollar om den aktuella spelaren har vunnit.
        for (int i = 0; i < 3; i++) // loopar igenom varje rad och kollar om det finns tre i rad horisontellt.
            if (Bräda[i][0] == currentPlayer && Bräda[i][1] == currentPlayer && Bräda[i][2] == currentPlayer) // checkar om tre i rad horisontellt.
                return true; // om det finns tre i rad, returnerar true.

        for (int j = 0; j < 3; j++) // vertikal loop som kollar om det finns tre i rad vertikalt.
            if (Bräda[0][j] == currentPlayer && Bräda[1][j] == currentPlayer && Bräda[2][j] == currentPlayer) // checkar om tre i rad vertikalt.
                return true; // om det finns tre i rad, returnerar true.

        if (Bräda[0][0] == currentPlayer && Bräda[1][1] == currentPlayer && Bräda[2][2] == currentPlayer) // checkar diagonal \
            return true; // om det finns tre i rad, returnerar true.

        if (Bräda[0][2] == currentPlayer && Bräda[1][1] == currentPlayer && Bräda[2][0] == currentPlayer) // checkar diagonal /
            return true; // om det finns tre i rad, returnerar true.

        return false; // om ingen vinnare, returnerar false.
    }

    public static void main(String[] args) { // Huvudmetod där spelet körs.
        Scanner input = new Scanner(System.in); // Skapar en Scanner för att läsa inmatning från användaren.
        boolean GameIsOn = true; // Spelet är på.
        char Sign = '-'; // Ett tecken som representerar en tom plats på brädan.
        char [][] Bräda = new char [3][3]; // Spelbrädan, 3x3.
        int Drag = 0; // Antal drag som har gjorts.

        for (int vertikal = 0; vertikal < 3; vertikal++) // Loopar igenom y-led.
            for (int horisontell = 0; horisontell < 3; horisontell++) // Loopar igenom x-led.
                Bräda[vertikal][horisontell] = Sign; // Fyller brädan med tecknet '-' för att representera tomma platser.

        System.out.println("Vem vill börja först? Ange X eller O"); // Frågar användaren vem som vill börja först.
        char First = Character.toUpperCase(input.nextLine().charAt(0)); // Scannar input.

        System.out.println(); // Tom rad för bättre läsbarhet.
        if (First != 'X' && First != 'O'){ // Kollar om användaren har angett en giltig spelare (X eller O).
            System.out.println(); // Tom rad för bättre läsbarhet.
            System.out.println("Ange endast X eller O"); // Om användaren inte har angett en giltig spelare, skriv ut ett felmeddelande.
            return; // returnerar till main-metoden, vilket avslutar programmet.
        }

        else // Om användaren har angett en giltig spelare. 
            System.out.println("Spelare 1 är: " + First); // Skriv ut vilken spelare som är spelare 1.

        char currentPlayer = First; // Variabel som håller reda på vilken spelare som är aktuell.

        printaBrädan(Bräda); // Printar brädan.

        while (GameIsOn) { // Huvudloop som kör spelet så länge det är på.
            int vertikal = 0; // Variabel som håller reda på den vertikala positionen som spelaren väljer.
            int horisontell = 0; // Variabel som håller reda på den horisontella positionen som spelaren väljer.

            while (true) { // Loop som fortsätter tills spelaren anger en giltig position.
                while (true) { // Loop som fortsätter tills spelaren anger en giltig vertikal position.
                    System.out.println("Spelare " + currentPlayer + ", ange position 1-3 för vertikal"); // Frågar spelaren att ange en vertikal position mellan 1 och 3.
                    vertikal = input.nextInt(); // Scannar in den vertikala positionen.
                    input.nextLine(); // läser in den nya raden som skapas efter att spelaren har angett en siffra.

                    if (vertikal < 1 || vertikal > 3){ // Kollar om den vertikala positionen är giltig (mellan 1 och 3).
                        System.out.println("Ange ett värde mellan (1-3)!"); // Om den vertikala positionen inte är giltig, skriv ut ett felmeddelande.
                        continue; // Fortsätter till nästa iteration av loopen, vilket gör att spelaren får en ny chans att ange en giltig vertikal position.
                    }
                    break; // Om den vertikala positionen är giltig, bryt ut ur loopen och fortsätt till nästa steg.
                }

                while (true) { // Loop som fortsätter tills spelaren anger en giltig horisontell position.
                    System.out.println("Spelare " + currentPlayer + ", ange position 1-3 för horisontell"); // Frågar spelaren att ange en horisontell position mellan 1 och 3.
                    horisontell = input.nextInt(); // Scannar in den horisontella positionen.
                    input.nextLine(); // läser in den nya raden som skapas efter att spelaren har angett en siffra.

                    if (horisontell < 1 || horisontell > 3){ // Kollar om den horisontella positionen är giltig (mellan 1 och 3).
                        System.out.println("Ange ett värde mellan (1-3)!"); // Om den horisontella positionen inte är giltig, skriv ut ett felmeddelande.
                        continue; // Fortsätter till nästa iteration av loopen, vilket gör att spelaren får en ny chans att ange en giltig horisontell position.
                    }
                    break; // Om den horisontella positionen är giltig, bryt ut ur loopen och fortsätt till nästa steg.
                }
                break; // Bryt ut ur den yttre loopen när både vertikal och horisontell position är giltiga.
            }

            if (Bräda[vertikal-1][horisontell-1] != '-') { // Kollar om den valda positionen på brädan redan är upptagen av en spelare (inte lika med '-').
                System.out.println("Rutan är redan tagen."); // Skriv ut ett meddelande om att rutan är upptagen.
                continue; // Fortsätter till nästa iteration av huvudloopen, vilket gör att spelaren får en ny chans att välja en position.
            }
            else { // Om den valda positionen är tom (lika med '-').
                Bräda[vertikal-1][horisontell-1] = currentPlayer; // Sätter den aktuella spelarens tecken på den valda positionen.
                Drag++; // Ökar antalet drag.
            }

            printaBrädan(Bräda); // Printar brädan.

            if (KollaVinnaren(Bräda, currentPlayer)) { // Kollar om den aktuella spelaren har vunnit.
                System.out.println("Grattis! Spelare " + currentPlayer + " har vunnit!"); // Om den aktuella spelaren har vunnit, skriv ut ett gratulationsmeddelande.
                GameIsOn = false; // Spelet är slut.
                break; // Bryt ut ur loopen.
            }

            if (Drag == 9) { // Kollar om antalet drag är 9 (alla rutor är upptagna).
                System.out.println("Oavgjort!"); // Om antalet drag är 9 och ingen spelare har vunnit, skriv ut ett oavgjort-meddelande.
                GameIsOn = false; // Spelet är slut.
                break; // Bryt ut ur loopen.
            }

            if (currentPlayer == 'X') //om det är X:s tur, byt till O.
                currentPlayer = 'O'; // Byter till O.
            else // Annars, byt till X.
                currentPlayer = 'X'; // Byter till X.
        }
        input.close(); // stänger scanner.
    }
}