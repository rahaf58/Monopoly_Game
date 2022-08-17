/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

public class FinishedPlayerDecorator extends PlayerDecorator {

    public static final String ANSI_RED_START = "\033[31m";    
    public static final String ANSI_RED_END = "\033[0m ";

    public FinishedPlayerDecorator(Player decoratedPlayer) {
        super(decoratedPlayer);
    }

    @Override
    public void setFinishStatus(boolean isWinner) {
        decoratedPlayer.setFinishStatus(isWinner);
        System.out.println("Congratulations  " + ANSI_RED_START + "(" + decoratedPlayer.getName().toUpperCase() + ")" + ANSI_RED_END + " you are the WINNER\n");

    }

    public String toString() {
        return decoratedPlayer.toString();
    }

}

