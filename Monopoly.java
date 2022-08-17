/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.*;

public class Monopoly {

    //use board 1 instatnce instead of the create object 
    // define variables of the system
    static Bank bank = new Bank();

    static int choice;
    static ArrayList<IPlayer> players = new ArrayList<IPlayer>();
    static String text;

    static int playerIndex; // Index of current player

    public static void main(String[] args) {

        System.out.println("--------------------------------------------");
        System.out.println("--------- Welcome to MONOPLY GAME ---------");
        System.out.println("--------------------------------------------");
        System.out.println("In this game only two players can play");

        GameMenu(); // start the game with menu

    }

    // get the dice total to play
    static int getRollDices() {

        int dice1, dice2;
        dice1 = (int) (Math.random() * 6) + 1;

        System.out.println("First dice = " + dice1);

        dice2 = (int) (Math.random() * 6) + 1;
        System.out.println("Second dice = " + dice2);

        int total = dice1 + dice2;
        System.out.println("Total of two dice:" + total);

        return total;
    }

    //validate the text of the player
    public static String cheakNameLength(String pName, Scanner input) {
        String regex = "^[A-Za-z]{2,8}[0-9]?$";
        while (!pName.matches(regex)) {
            System.out.println("Invalid name, Enter the name again between 1 and 8 letters");
            pName = input.next();
        }
        return pName;
    }

    //show to the user the munue to start the game
    static void GameMenu() {

        Scanner input = new Scanner(System.in);

        System.out.println("\nChoose from one of the options below to proceed");
        System.out.println("1: Start the game to play.");
        System.out.println("2: Print the Board");
        System.out.println("3: End the Game.");

        while (true) {
            try { // validate the input

                System.out.print("\n Enter your choice: ");
                choice = input.nextInt();

                // validate the choice
                while (choice < 1 || choice > 3) {
                    System.out.println();
                    System.out.println("Select correct option: ");
                    choice = input.nextInt();
                }
                break;
            } catch (Exception e) {
                System.out.println(" wrong input, trye again");
                input = new Scanner(System.in);
            }
        }

        if (choice == 1) {

            System.out.println("--------------------------------------------");

            // To input names of players
            for (int i = 0; i < 2; i++) {
                System.out.print("Enter name of player " + (i + 1) + ": ");
                String pName = input.next();
                text = cheakNameLength(pName, input);

                PlayerProxy pr = new PlayerProxy(i, text); // create playproxy object
                System.out.print("Enter " + text + " age: ");
                int age = input.nextInt();

                if (!pr.play(age)) { //check if the proxy allow the player to play
                    System.exit(0);
                }

                IPlayer player = new FinishedPlayerDecorator(pr.getPlayer());
                players.add(player);

                System.out.println("*********************\n");
            }
            PlayerMenu(input);

        } else if (choice == 2) { // print the board
            Board.getInstatnce().displayBoard();
            GameMenu(); // call the menue again
        } else if (choice == 3) {

            System.out.println("\nare you sure you want to close the program? (Yes/No)");
            text = input.next();
            if (text.equalsIgnoreCase("yes")) {
                quitGame();
            } else {
                GameMenu();

            }
        }

    }

    //show to the player menue to select and play
    static void PlayerMenu(Scanner input) {

        System.out.println();
        System.out.println("\nChoose from one of the options below to proceed");
        System.out.println("1: Select a player to play.");
        System.out.println("2: Print the Board");
        System.out.println("3: End the Game.");

        while (true) {
            try {//vaildate the input

                System.out.print("\n Enter your choice: ");
                choice = input.nextInt();

                // check the choice to be correct
                while (choice < 1 || choice > 3) {
                    System.out.println();
                    System.out.println("wrong input, trye again");
                    choice = input.nextInt();
                }
                break;
            } catch (Exception e) {
                System.out.println(" wrong input, trye again");
                input = new Scanner(System.in);
            }
        }

        if (choice == 1) {
            // Display select player menu
            selectPlayerMenu(input);
        } else if (choice == 2) {
            // Display board of monopoly
            Board.getInstatnce().displayBoard();
            PlayerMenu(input);
        } else if (choice == 3) {

            //print the game information
            //and end the game
            System.out.println("\nare you sure you want to close the program? (Yes/No)");
            String result = input.next();
            if (result.equalsIgnoreCase("yes")) {
                quitGame();
            } else {
                PlayerMenu(input);
            }

        }
    }

    static void selectPlayerMenu(Scanner input) {
        Player player1 = ((PlayerDecorator) players.get(0)).decoratedPlayer;
        Player player2 = ((PlayerDecorator) players.get(1)).decoratedPlayer;
//        IPlayer player1 = players.get(0);
//        IPlayer player2 = players.get(1);

        System.out.println();
        System.out.println("\nSelect a player to play from below:");
        System.out.println("(1) Player :" + player1.getName());
        System.out.println("(2) Player :" + player2.getName());

        while (true) {
            try {
                System.out.print("\n enter player number: ");
                choice = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println(" wrong input, trye again");
                input = new Scanner(System.in);
            }
        }
        // validate the choice
        while (choice < 1 || choice > 2) {
            System.out.println();
            System.out.println("wrong choice, try again");
            choice = input.nextInt();
        }

        IPlayer player = null;

        //set the index of the player
        if (choice == 1) {
            playerIndex = 0;

        } else {
            playerIndex = 1;

        }

        player = players.get(playerIndex);
        player.toString();
        System.out.println("\n" + bank.toString());
        PlayerStartMenu(input);
    }

    static void PlayerStartMenu(Scanner input) {
        System.out.println();
        System.out.println("\nSelect from the below");
        System.out.println("1: Roll the Dice");
        System.out.println("2: Print the Board");
        System.out.println("3: End The Game");

        while (true) {
            try {//vaildate the input

                System.out.print("\n Enter your choice: ");
                choice = input.nextInt();

                // check the choice to be correct
                while (choice < 1 || choice > 3) {
                    System.out.println();
                    System.out.println("wrong input, trye again");
                    choice = input.nextInt();
                }
                break;
            } catch (Exception e) {
                System.out.println(" wrong input, trye again");
                input = new Scanner(System.in);
            }
        }

        switch (choice) {
            case 1: // start the player game

                Player player = ((PlayerDecorator) players.get(playerIndex)).decoratedPlayer;
                Player p = ((PlayerDecorator) players.get(1)).decoratedPlayer;

                if (!(player.getPlaysNumber() > 35 && p.getPlaysNumber() > 35)) { // still in the first round

                    if (player.isInJail(player)) {
                        player.setCurrentLocation(0, 0); // go to start

                        //pay to go out the jail
                        double result = player.getMoney() * 0.1;
                        if (player.checkBalance(player)) {
                            result *= -1;
                        }
                        double total = player.getMoney();
                        double bankBalance = bank.getMoney() + result;
                        player.setMoney(total - result);
                        bank.setMoney(bankBalance);
                    }

                    int roll = getRollDices(); // play

                    player.move(player, roll);
                    System.out.println("Move to: " + player.getCurrentLocation().getCellName() + "\n");

                    //check the move of the player
                    if (player.getCurrentLocation().getCellName().equals("Go to Jail")) {
                        player.setCurrentLocation(9, 0);
                    } else if (player.getCurrentLocation().getCellName().equals("Roll again")) {
                        if (playerIndex == 0) {
                            playerIndex++;
                        } else if (playerIndex == 1) {
                            playerIndex--;
                        }
                    } else if (player.getCurrentLocation().getCellName().equals("Income Tax")) {
                        //just pay to the bank
                        double result = player.getMoney() * 0.07;
                        if (player.checkBalance(player)) {
                            result *= -1;
                        }
                        double total = player.getMoney();

                        player.setMoney(total - result);
                        double bankBalance = bank.getMoney() + result;
                        bank.setMoney(bankBalance);

                    } else if (player.getCurrentLocation().getCellName().equals("Luxury tax")) {
                        //just pay to the bank
                        double result = player.getMoney() * 0.12;
                        if (player.checkBalance(player)) {
                            result *= -1;
                        }
                        double total = player.getMoney();

                        player.setMoney(total - result);
                        double bankBalance = bank.getMoney() + result;
                        bank.setMoney(bankBalance);

                    } else if (player.getCurrentLocation().getCellName().equals("Give half of your money")) {
                        //pay to the second player half of the money
                        double result = player.getMoney() / 2;

                        player.setMoney(player.getMoney() - result);
                        if (playerIndex == 0) {

                            Player temp = ((PlayerDecorator) players.get(1)).decoratedPlayer;
                            double player2Money = temp.getMoney() + result;
                            temp.setMoney(player2Money);
                        } else if (playerIndex == 1) {

                            Player temp = ((PlayerDecorator) players.get(0)).decoratedPlayer;
                            double player2Money = temp.getMoney() + result;
                            temp.setMoney(player2Money);

                        }

                    } else if (player.getCurrentLocation().getCellName().equals("Mosque")
                            || player.getCurrentLocation().getCellName().equals("Blue Mosque")) {

                        //just pay to the bank
                        double total = player.getMoney() - 5;
                        double bankBalance = bank.getMoney() + 5;
                        player.setMoney(total);
                        bank.setMoney(bankBalance);

                    } else if (player.getCurrentLocation().getCellName().equals("Swap")) {

                        //swap one of your properties with cheapest property
                        if (playerIndex == 0) {
                            Cell[][] boardCell = Board.getInstatnce().getCellBoard();
                            Cell[] result = player.getPropertisSecondPlayer(players);

                            System.out.println();
                            if (result[0] == null) {
                                System.out.println("Can't swap the player doesn't have any property");
                            } else {

                                System.out.println("");
                                System.out.print("Select an option to swap: ");
                                int index = input.nextInt();
                                Cell cell = result[index - 1];

                                System.out.println(player.getName() + " owns " + cell.getCellName());
                                player.getFirstPlayerCheapPropertis(players);

                                boardCell[cell.getCellNumberFirst()][cell.getCellNumberSecond()].setOwnerName(player.getName());
                            }
                        } else if (playerIndex == 1) {
                            Cell[][] boardCell = Board.getInstatnce().getCellBoard();
                            Cell[] result = player.getPropertisFirstPlayer(players);
                            System.out.println();

                            if (result[0] == null) {
                                System.out.println("Can't swap the player doesn't have any property");
                            } else {

                                System.out.println("");

                                System.out.print("Select an option to swap: ");
                                int index = input.nextInt();
                                Cell cell = result[index - 1];

                                System.out.println(player.getName() + " owns " + cell.getCellName());

                                player.getSecondPlayerCheapPropertis(players);
                                boardCell[cell.getCellNumberFirst()][cell.getCellNumberSecond()].setOwnerName(player.getName());

                            }
                        }
                    } else if (player.getCurrentLocation().getType().equals("property")) {
                        if (player.getCurrentLocation().getOwnerName() == null || player.getCurrentLocation().getOwnerName().equals("none")) {
                            //no one own this property
                            System.out.println("Would you Like to buy " + player.getCurrentLocation().getCellName() + " ?, Cost: 300$");
                            System.out.print("Enter your choice yes/no: ");
                            while (true) {
                                text = input.next();
                                if (text.equalsIgnoreCase("yes")) { // want to buy
                                    double total = player.getMoney();
                                    player.setMoney(total - 300); // pay the money
                                    double bankBalance = bank.getMoney();
                                    bank.setMoney(bankBalance + 300);
                                    String namePlayer = player.getName();
                                    //set the owner of the property
                                    player.getCurrentLocation().setOwnerName(namePlayer);
                                    break;
                                } else if (text.equalsIgnoreCase("no")) {
                                    break;
                                } else {
                                    System.out.println("Wrong entry");
                                    System.out.println("Enter a valid input(yes or no):");
                                }
                            }
                        } else if (!player.getCurrentLocation().getOwnerName().equals(player.getName())) {
                            //pay to the other play the rent of the property
                            if (playerIndex == 0) {
                                double total = player.getMoney();
                                player.setMoney(total - 200);
                                Player temp = ((PlayerDecorator) players.get(1)).decoratedPlayer;
                                double secondPlayer = temp.getMoney();
                                temp.setMoney(secondPlayer + 200);
                            } else if (playerIndex == 1) {
                                double total = player.getMoney();
                                player.setMoney(total - 200);
                                Player temp = ((PlayerDecorator) players.get(0)).decoratedPlayer;
                                double secondPlayer = temp.getMoney();
                                temp.setMoney(secondPlayer + 200);

                            }
                        } else if (player.getCurrentLocation().getOwnerName().equals(player.getName())) {
                            //you own the property
                            System.out.println(player.getCurrentLocation().getCellName() + " you own the cell. No action is needed");
                        }
                    } else if (player.getCurrentLocation().getType().equals("Utility")) {
                        if (player.getCurrentLocation().getOwnerName() == null || player.getCurrentLocation().getOwnerName().equals("none")) {
                            System.out.println("Would you Like to buy " + player.getCurrentLocation().getCellName() + " ? ,Cost: 100$");
                            System.out.print("Enter your choice yes/no: ");
                            while (true) {
                                text = input.next();
                                if (text.equalsIgnoreCase("yes")) {
                                    double total = player.getMoney();
                                    player.setMoney(total - 100);
                                    double bankBalance = bank.getMoney();
                                    bank.setMoney(bankBalance + 100);
                                    String namePlayer = player.getName();
                                    player.getCurrentLocation().setOwnerName(namePlayer);
                                    break;

                                } else if (text.equalsIgnoreCase("no")) {
                                    break;
                                } else {
                                    System.out.println("Wrong entry");
                                    System.out.println("Enter a valid input(yes or no):");
                                }

                            }
                        } else if (!player.getCurrentLocation().getOwnerName().equals(player.getName())) {
                            //pay to the other play the rent of the utility
                            if (playerIndex == 0) {
                                double total = player.getMoney();
                                player.setMoney(total - 50);

                                Player temp = ((PlayerDecorator) players.get(1)).decoratedPlayer;
                                double secondPlayer = temp.getMoney();

                                //double secondPlayer = players.get(1).getMoney();
                                bank.setMoney(secondPlayer + 50);
                            } else if (playerIndex == 1) {
                                double total = player.getMoney();
                                player.setMoney(total - 50);

                                Player temp = ((PlayerDecorator) players.get(0)).decoratedPlayer;
                                double secondPlayer = temp.getMoney();

                                bank.setMoney(secondPlayer + 50);
                            }
                        } else if (player.getCurrentLocation().getOwnerName().equals(player.getName())) {
                            //you own the utility
                            System.out.println(player.getCurrentLocation().getCellName() + " you own the cell. No action is needed");

                        }
                    } else if (player.getCurrentLocation().getType().equals("railroad")) {
                        if (player.getCurrentLocation().getOwnerName() == null) {
                            System.out.println("Would you Like to buy" + player.getCurrentLocation().getCellName() + "? ,Cost: 100$ ");
                            while (true) {
                                text = input.next();
                                if (text.equalsIgnoreCase("yes")) {
                                    double total = player.getMoney();
                                    player.setMoney(total - 100);
                                    double bankBalance = bank.getMoney();
                                    bank.setMoney(bankBalance + 100);
                                    String namePlayer = player.getName();
                                    player.getCurrentLocation().setOwnerName(namePlayer);
                                    break;

                                } else if (text.equalsIgnoreCase("no")) {
                                    break;
                                } else {
                                    System.out.println("Wrong entry");
                                    System.out.println("Enter a valid input(yes or no):");
                                }

                            }
                        } else if (!player.getCurrentLocation().getOwnerName().equals(player.getName())) {
                            if (playerIndex == 0) {
                                double total = player.getMoney();
                                player.setMoney(total - 50);

                                Player temp = ((PlayerDecorator) players.get(1)).decoratedPlayer;
                                double secondPlayer = temp.getMoney();

                                bank.setMoney(secondPlayer + 50);
                            } else if (playerIndex == 1) {
                                double total = player.getMoney();
                                player.setMoney(total - 50);

                                Player temp = ((PlayerDecorator) players.get(0)).decoratedPlayer;
                                double secondPlayer = temp.getMoney();

                                bank.setMoney(secondPlayer + 50);
                            } else if (player.getCurrentLocation().getOwnerName().equals(player.getName())) {
                                System.out.println(player.getCurrentLocation().getCellName() + " you own the cell. No action is needed");
                                System.out.println();

                            }
                        }
                    } else if (player.getCurrentLocation().getType().equals("Park")) {
                        if (player.checkBalance(player)) {
                            double total = player.getMoney();
                            player.setMoney(total - 20);
                            double bankBalance = bank.getMoney();
                            bank.setMoney(bankBalance + 20);
                            System.out.println("Rent cost is 20 $ " + player.getCurrentLocation().getCellName());
                        } else {
                            double total = player.getMoney();
                            player.setMoney(total - 20);
                            double bankBalance = bank.getMoney();
                            bank.setMoney(bankBalance + 20);
                            System.out.println("Rent cost is 20 $ " + player.getCurrentLocation().getCellName());
                        }
                    } else if (player.getCurrentLocation().getType().equals("Garden")) {
                        if (player.checkBalance(player)) {
                            double total = player.getMoney();
                            player.setMoney(total - 20);
                            double bankBalance = bank.getMoney();
                            bank.setMoney(bankBalance + 20);
                            System.out.println("Rent cost is 20 $ " + player.getCurrentLocation().getCellName());
                        } else {
                            double total = player.getMoney();
                            player.setMoney(total - 20);
                            double bankBalance = bank.getMoney();
                            bank.setMoney(bankBalance + 20);
                            System.out.println("Rent cost is 20 $ " + player.getCurrentLocation().getCellName());
                        }
                    }

                    //finish print the summery
                    printPlayersInfo(playerIndex);
                    System.out.println("\n" + bank.toString());

                    if (playerIndex == 0) {
                        playerIndex++;
                    } else if (playerIndex == 1) {
                        playerIndex--;
                    }
                    //printPlayersInfo(playerIndex);

                    Player playerTurn = ((PlayerDecorator) players.get(playerIndex)).decoratedPlayer;
                    System.out.println("\n************************************\nPlayer (" + (playerIndex + 1) + ") " + playerTurn.getName() + "'s turn:");

                    PlayerStartMenu(input);
                } else {

                    //finish one round stop the game
                    System.out.print("You complete one round");
                    printGameInfo();

                    Player temp1 = ((PlayerDecorator) players.get(0)).decoratedPlayer;
                    Player temp2 = ((PlayerDecorator) players.get(1)).decoratedPlayer;

                    if (temp1.getMoney() > temp2.getMoney()) {
                        players.get(0).setFinishStatus(true);
                    } else if (temp1.getMoney() < temp2.getMoney()) {
                        players.get(1).setFinishStatus(true);
                    } else {
                        System.out.println("No winner, " + temp1.getName() + " and " + temp2.getName() + " are equal.");
                    }

//                    if (players.get(0).getMoney() > players.get(1).getMoney()) {
//                        System.out.println("Player 1: " + players.get(0).getName() + " is the winner");
//                    } else {
//                        System.out.println("Player 2: " + players.get(1).getName() + " is the winner");
//                    }
                    System.exit(0);

                }

                printPlayersInfo(playerIndex);
                PlayerStartMenu(input);
                break;
            case 2:
                // If user selected option 2  print monoply board 
                Board.getInstatnce().displayBoard();
                PlayerStartMenu(input);
                break;

            case 3:
                //end the game
                System.out.println("\nare you sure you want to close the program");
                text = input.next();
                if (text.equalsIgnoreCase("yes")) {
                    quitGame();
                } else {
                    PlayerStartMenu(input);
                }
                break;
            default:
                break;
        }
    }

    static void printGameInfo() {
        for (int i = 0; i < players.size(); i++) {
            Player player = ((PlayerDecorator) players.get(i)).decoratedPlayer;

            System.out.println("\n************************************\nPlayer " + (i + 1) + ": " + player.getName()
                    + "\nCurrent Location: " + player.getCurrentLocation().getCellName()
                    + "\nCell number: (" + player.getCurrentLocation().getCellNumberFirst() + ","
                    + player.getCurrentLocation().getCellNumberSecond() + ")"
                    + " \nMoney: " + player.getMoney() + " $");

        }

        System.out.println("\n" + bank.toString());
    }

    static void printPlayersInfo(int number) {

        Player player = ((PlayerDecorator) players.get(number)).decoratedPlayer;
        System.out.println("\n************************************\nPlayer " + (number + 1) + ": " + player.getName()
                + "\nCurrent Location: " + player.getCurrentLocation().getCellName()
                + "\nCell number: (" + player.getCurrentLocation().getCellNumberFirst() + ","
                + player.getCurrentLocation().getCellNumberSecond() + ")"
                + "\nCell owner name: " + player.getCurrentLocation().getOwnerName()
                + " \nMoney: " + player.getMoney() + " $\n");

    }

    //end the game
    public static void quitGame() {

        //display information
        //end the game and exit
        printGameInfo();
        System.out.println("\n************************************\n");

        //show the winner
        Player temp1 = ((PlayerDecorator) players.get(0)).decoratedPlayer;
        Player temp2 = ((PlayerDecorator) players.get(1)).decoratedPlayer;

        if (temp1.getMoney() > temp2.getMoney()) {
            players.get(0).setFinishStatus(true);
        } else if (temp1.getMoney() < temp2.getMoney()) {
            players.get(1).setFinishStatus(true);
        } else {
            System.out.println("No winner, " + temp1.getName() + " and " + temp2.getName() + " are equal.");
        }
        System.out.println("");
        System.exit(0);

    }

}