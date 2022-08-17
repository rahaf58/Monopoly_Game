/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

public class PlayerProxy {

    private Player p;

    public PlayerProxy(int numberOfPlayer, String name) {
        Player p = new Player(numberOfPlayer, name);

        this.p = p;
    }

    public boolean play(int age) {
        if (age < 10) {
            System.out.println("\nSorry, this game is desiged for 10+ ");
            System.out.println("See you later!\n");
            return false;
        } else {
            p.play(age);
            return true;
        }
    }

    public Player getPlayer() {
        return p;
    }

}