import java.util.Scanner; // Importerar Scanner för inmatning.

public class TicTacToe{

    public static void printaBrädan(char[][] Bräda) { // Metod som skriver ut spelbrädet.

    for (int vertikal = 0; vertikal < 3; vertikal++) {
        for (int horisontell = 0; horisontell < 3; horisontell++)
            System.out.print(Bräda[vertikal][horisontell] + " ");
        System.out.println();
    }

}
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Skapar Scanner för att läsa från tangentbordet.
        boolean GameIsOn = true; // Spelet är på.
        char Sign = '-'; // Ett tecken som visar tom plats senare.
        char [][] Bräda = new char [3][3]; // Spelbrädan, 3x3.

        char X = 'X'; // Spelare X.
        char O = 'O'; // Spelare O.
        int Drag = 0; // Antal drag per runda.

        for (int vertikal = 0; vertikal < 3; vertikal++)
            for (int horisontell = 0; horisontell < 3; horisontell++)
                Bräda[vertikal][horisontell] = Sign; // Fyller alla rutor med '-', används för tom plats.

        System.out.println("Vem vill börja först? Ange X eller O"); // Terminal msg.
        char First = Character.toUpperCase(input.nextLine().charAt(0)); // Scannar input.

        System.out.println();
        if (First != 'X' && First != 'O'){ // if-sats.
            System.out.println();
            System.out.println("Ange endast X eller O");
            return;
        }
        else
            System.out.println("Spelare 1 är: " + First);

        char currentPlayer = First; // Variabel som håller reda på vilken spelare som är aktuell.

        while (GameIsOn) {
            int vertikal = 0;
            int horisontell = 0;

            while (GameIsOn) {
                while (GameIsOn) {
                    System.out.println("Spelare " + currentPlayer + ", ange position 0-2 för vertikal");
                    vertikal = input.nextInt();
                    input.nextLine();

                    if (vertikal < 0 || vertikal > 2){
                        System.out.println("Ange ett värde mellan (0-2)!");
                        continue;
                    }
                    break;
                }

                while (true) {
                    System.out.println("Spelare " + currentPlayer + ", ange position 0-2 för horisontell");
                    horisontell = input.nextInt();
                    input.nextLine();

                    if (horisontell < 0 || horisontell > 2){
                        System.out.println("Ange ett värde mellan (0-2)!");
                        continue;
                    }
                    break;
                }
                break;
            }

            if (Bräda[vertikal][horisontell] != '-') {
                System.out.println("Rutan är redan tagen.");
                continue;
            }
            else {
                Bräda[vertikal][horisontell] = currentPlayer; // Sätter den aktuella spelarens tecken på den valda positionen.
                Drag++; // Ökar antalet drag.
            }

            printaBrädan(Bräda); // Printar brädan.

            if (currentPlayer == 'X') //om det är X:s tur, byt till O.
                currentPlayer = 'O';
            else // Annars, byt till X.
                currentPlayer = 'X';
        }


    }

}