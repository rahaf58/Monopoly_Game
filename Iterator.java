/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

public interface Iterator {
    public boolean hasNextRow();
    public boolean hasNextCol();
    public boolean hasNext();
    public Cell next();
}