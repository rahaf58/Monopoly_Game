/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

public class Cell {

    public Cell(String cellName, int cellNumberFirst, int cellNumberSecond, String ownerName, String type, int price) {
        this.cellName = cellName;
        this.cellNumberFirst = cellNumberFirst;
        this.cellNumberSecond = cellNumberSecond;
        this.ownerName = ownerName;
        this.type = type;
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String cellName;
    public int cellNumberFirst;
    public int cellNumberSecond;
    private String ownerName;
    String type;
    int price;

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public void setCellNumberFirst(int cellNumberFirst) {
        this.cellNumberFirst = cellNumberFirst;
    }

    public void setCellNumberSecond(int cellNumberSecond) {
        this.cellNumberSecond = cellNumberSecond;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCellName() {
        return cellName;
    }

    public int getCellNumberFirst() {
        return cellNumberFirst;
    }

    public int getCellNumberSecond() {
        return cellNumberSecond;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getType() {
        return type;
    }

    public String setType() {
        return type;
    }
}