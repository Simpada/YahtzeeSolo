import java.util.Scanner;

public class GameManager {

    Player player1 = new Player();

    Player player2 = new Player();

    public void runGame() {
        System.out.println("Welcome To a Game of Yahtzee Bitches!\n");

        Scanner input = new Scanner(System.in);

        System.out.println("Player 1: Enter your name in the terminal!");

        CheckForName(input, player1);

        System.out.println("Player 2: Enter your name in the terminal!");

        CheckForName(input, player2);

        System.out.println("Welcome " + player1.getName() + " and " + player2.getName());
        System.out.println("Prepare yourself for a BATTLE OF THE AGES... in yahtzee");
        System.out.println("\nClick enter to Start!");
        input.nextLine();

        boolean gameRunning = true;

        Player currentPlayer = player1;

        while (gameRunning) {

            System.out.println(currentPlayer.getName() + " goes first!");

            currentPlayer.throwDice(5);
            StringBuilder diceRoll = new StringBuilder(" ");
            for (Die die : currentPlayer.getDice()) {
                diceRoll.append(die.getValue()).append(" ");
            }

            System.out.println("You got: [" + diceRoll + "]");


            gameRunning = false;
        }

    }

    private void CheckForName(Scanner input, Player player) {
        while (true) {
            String name = input.nextLine();

            if (name.length() > 20) {
                System.out.println("Name too long, enter a short name!");
            } else if (name.length() == 0) {
                System.out.println("Please enter a name");
            } else {
                player.setName(name);
                break;
            }
        }
    }


}
