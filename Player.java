/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import java.util.*;

public class Player implements IPlayer {

    private String name;
    private int numberOfPlayer;
    private Cell currentLocation;
    private double money;

    private boolean inJail;
    private int playsNumber;
    private boolean isWinner;

    public Player(int numberOfPlayer, String name) {
        this.numberOfPlayer = numberOfPlayer;
        this.name = name;
    }

    public boolean play(int age) {

        money = 1500;
        Cell[][] b = Board.getInstatnce().getCellBoard();

        currentLocation = b[0][0];
        inJail = false;
        playsNumber = 0;

        return true;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Cell getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(int firstNumber, int secondNumber) {
        Cell[][] b = Board.getInstatnce().getCellBoard();

        currentLocation = b[firstNumber][secondNumber];
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public boolean getInJail() {
        return inJail;
    }

    public void setInJail(Cell currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Cell[] getPropertisFirstPlayer(ArrayList<IPlayer> players) {
        Player player = ((PlayerDecorator) players.get(0)).decoratedPlayer;
        
        int counter = 1;
        int index = 0;
        Cell[] result = new Cell[35];
        Cell[][] b = Board.getInstatnce().getCellBoard();

        System.out.println("List of " + player.getName() + " Proeprties:\n");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (b[i][j] == null || b[i][j].getOwnerName() == null) {
                    continue;
                }
                if (b[i][j].getOwnerName().equals(player.getName())) {
                    System.out.println(counter + ": (" + b[i][j].getCellNumberFirst() + "," + b[i][j].getCellNumberSecond() + ") "
                            + b[i][j].getCellName());
                    counter++;
                    result[index] = b[i][j];
                    index++;
                }
            }
        }

        return result;
    }

    public void getFirstPlayerCheapPropertis(ArrayList<IPlayer> players) {
        Player player = ((PlayerDecorator) players.get(0)).decoratedPlayer;
        
        Cell[][] b = Board.getInstatnce().getCellBoard();
        Cell cheapCell = null;
        int price = 300;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (b[i][j] == null || b[i][j].getOwnerName() == null) {
                    continue;
                }
                if (b[i][j].getOwnerName().equals(player.getName())) {
                    if (b[i][j].getPrice() <= price) {
                        price = b[i][j].getPrice();
                        cheapCell = b[i][j];
                    }
                }
            }
        }
        
       String name = ((PlayerDecorator) players.get(1)).decoratedPlayer.getName();
        //String name = players.get(1).getName();
        if (cheapCell != null) {
            cheapCell.setOwnerName(name);
            System.out.println(name + " owns the cheapest property: " + cheapCell.getCellName());
        } else {
            System.out.println("The player " + player.getName() + " doesn't have cheap property to swap with it");
        }
    }

    public Cell[] getPropertisSecondPlayer(ArrayList<IPlayer> players) {
        Player player = ((PlayerDecorator) players.get(1)).decoratedPlayer;
        
        int counter = 1;
        int index = 0;
        Cell[] result = new Cell[35];
        Cell[][] b = Board.getInstatnce().getCellBoard();

        System.out.println("List of " + player.getName() + " Proeprties:\n");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (b[i][j] == null || b[i][j].getOwnerName() == null) {
                    continue;
                }
                if (b[i][j].getOwnerName().equals(player.getName())) {
                    System.out.println(counter + ": (" + b[i][j].getCellNumberFirst() + "," + b[i][j].getCellNumberSecond() + ") "
                            + b[i][j].getCellName());
                    counter++;
                    result[index] = b[i][j];
                    index++;
                }
            }
        }

        return result;
    }

    public void getSecondPlayerCheapPropertis(ArrayList<IPlayer> players) {
         Player player = ((PlayerDecorator) players.get(1)).decoratedPlayer;
        Cell[][] b = Board.getInstatnce().getCellBoard();

        Cell cheapCell = null;
        int price = 300;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                if (b[i][j] == null || b[i][j].getOwnerName() == null) {
                    continue;
                }
                if (b[i][j].getOwnerName().equals(player.getName())) {
                    if (b[i][j].getPrice() <= price) {
                        price = b[i][j].getPrice();
                        cheapCell = b[i][j];
                    }
                }
            }
        }
        String name = ((PlayerDecorator) players.get(0)).decoratedPlayer.getName();
       // String name = players.get(0).getName();

        if (cheapCell != null) {
            cheapCell.setOwnerName(name);
            System.out.println(name + " owns the cheapest property: " + cheapCell.getCellName());

        } else {
            System.out.println("The player " + player.getName() + " doesn't have cheap property to swap with it");
        }

    }

    public boolean isInJail(Player player) {
        if (player.getCurrentLocation().getCellName().equals("InJail")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkBalance(Player player) {
        if (player.getMoney() <= 0) {
            if (player.getMoney() == -200) {
                System.exit(0);
            }
            return true;
        } else {
            return false;
        }
    }

    public void move(Player player , int move) {
        int firstNumber = player.getCurrentLocation().getCellNumberFirst();
        int secondNumber = player.getCurrentLocation().getCellNumberSecond();
        for (int i = 1; i <= move; i++) {
            if (firstNumber == 0 && secondNumber <= 8) {
                secondNumber++;
            } else if (firstNumber <= 8 && secondNumber == 9) {
                firstNumber++;
            } else if (firstNumber == 9 && 0 != secondNumber && secondNumber <= 9) {
                secondNumber--;
            } else if (0 != firstNumber && firstNumber <= 9 && secondNumber == 0) {
                firstNumber--;
            }
        }
        int steps = player.getPlaysNumber();
        player.setPlaysNumber(steps + move);

        player.setCurrentLocation(firstNumber, secondNumber);

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    public void setPlaysNumber(int playsNumber) {
        this.playsNumber = playsNumber;
    }

    public int getPlaysNumber() {
        return playsNumber;
    }

    public void toString(int number) {
        System.out.println("\n************************************\nPlayer " + (number + 1) + ": " + getName()
                + "\nCurrent Location: " + getCurrentLocation().getCellName()
                + "\nCell number: (" + getCurrentLocation().getCellNumberFirst() + ","
                + getCurrentLocation().getCellNumberSecond() + ")"
                + " \nMoney: " + getMoney() + " $");

    }

    @Override
    public void setFinishStatus(boolean isWinner) {
        this.isWinner = isWinner;
    }

}