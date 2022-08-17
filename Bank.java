/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

public class Bank {

    private double Money;

    public Bank() {
        Money = 2000;
    }

    public void setMoney(double Money) {
        this.Money = Money;
    }

    public double getMoney() {
        return Money;
    }

    @Override
    public String toString() {
        return "Bank Money: " + Money;

    }
}