/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

public class PlayerDecorator implements IPlayer{

    Player decoratedPlayer;

    public PlayerDecorator(Player decoratedPlayer) {
        this.decoratedPlayer = decoratedPlayer;
    }
    
    
    @Override
    public void setFinishStatus(boolean isWinner) {
        decoratedPlayer.setFinishStatus(isWinner);
    }

    
    
}