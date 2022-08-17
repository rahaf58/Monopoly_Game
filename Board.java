/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

public class Board implements CellIterator{

    private static Board instance = null;
            
    private Board() {
    }

    public static Board getInstatnce(){
        if(instance == null){
            instance = new Board();
        }
        return instance;
    }
 
    Cell[][] cellBoard = {
        {new Cell("Go", 0, 0, "none", "", 0), 
            new Cell("White House", 0, 1, "none", "property", 300),
            new Cell("Chica go avenue", 0, 2, "none", "property", 300),
            new Cell("Texas Avenue", 0, 3, "none", "property", 300), 
            new Cell("Utility", 0, 4, "none", "Utility", 100),
            new Cell("College Avenue", 0, 5, "none", "property", 300), 
            new Cell("Burger King", 0, 6, "none", "property", 300),
            new Cell("Nothing", 0, 7, "none", "", 0),
            new Cell("Holiday inn Hotile", 0, 8, "none", "property", 300), 
            new Cell("Go to Jail", 0, 9, "none", "", 0)},
        {
            new Cell("Mall of Arabia", 1, 0, "none", "property", 300), null, null, null, null, null, null, null, null, 
            new Cell("Roll again", 1, 9, "none", "", 0)
        },
        {
            new Cell("Roll again", 2, 0, "none", "", 0),
            null, null, null, null, null, null, null, null, 
            new Cell("Blue Mosque", 2, 9, "none", "", 0)
        }, {
            new Cell("Washington Avenue", 3, 0, "none", "property", 300), null, null, null, null, null, null, null, null,
            new Cell("Railroads", 3, 9, "none", "Railroads", 100)},
        {
            new Cell("Yellow House", 4, 0, "none", "Property", 300),
            null, null, null, null, null, null, null, null, 
            new Cell("Luxury tax", 4, 9, "none", "", 0)
        },
        {
            new Cell("Sheraton Hotel", 5, 0, "none", "property", 300),
            null, null, null, null, null, null, null, null, 
            new Cell("City Park", 5, 9, "none", "Park", 20)
        },
        {
            new Cell("Nothing", 6, 0, "none", "", 0),
            null, null, null, null, null, null, null, null, 
            new Cell("Nothing", 6, 9, "none", "", 0)
        },
        {
            new Cell("Swap", 7, 0, "none", "", 0),
            null, null, null, null, null, null, null, null, 
            new Cell("Give half of your money", 7, 9, "none", "", 0)
        },
        {
            new Cell("Mosque", 8, 0, "none", "", 0),
            null, null, null, null, null, null, null, null, 
            new Cell("Mosque", 8, 9, "none", "", 0)
        },
        {
            new Cell("InJail", 9, 0, "none", "", 0),
            new Cell("Hilton hotel", 9, 1, "none", "property", 300),
            new Cell("Blue house", 9, 2, "none", "property", 300),
            new Cell("Red house", 9, 3, "none", "property", 300),
            new Cell("Nothing", 9, 4, "none", "", 0),
            new Cell("Marvin Garden", 9, 5, "none", "Garden", 20),
            new Cell("Income Tax", 9, 6, "none", "", 0),
            new Cell("Colorado Avenue", 9, 7, "none", "property", 300),
            new Cell("New York Avenue", 9, 8, "none", "property", 300),
            new Cell("Free Parking", 9, 9, "none", "", 300)
        }};

    public String getCellName(int firstNumber, int secondNumber) {
        String location = "";
        
        for (Iterator iterator = this.getIterator(); iterator.hasNext(); ) {
           
                Cell cell =  iterator.next();
                if (cell.cellNumberFirst == firstNumber && cell.cellNumberSecond == secondNumber){
                    location = cell.getCellName();
                    break;
                }
               
        }
        
        
        return location;
    }

    public Cell[][] getCellBoard() {
        return cellBoard;
    }

    public void displayBoard() {
        System.out.println("________________________________________________________________________________________________");
        System.out.println("|        |         |         |        |        |        |        |        | Holiday |    Go    |");
        System.out.println("|   GO   |  White  | Chicago | Texas  |Utility |College | Burger |Nothing |   Inn   |    To    |");
        System.out.println("|        |  House  | Avenue  | Avenue |        | Avenue | King   |        |  Hotel  |   Jail   |");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("|Mall Of |                                                                          | Roll     |");
        System.out.println("| Arabia |                                                                          | Again    |");
        System.out.println("----------                                                                          ------------");
        System.out.println("| Roll   |                                                                          | Blue     |");
        System.out.println("| Again  |                                                                          | Mosque   |");
        System.out.println("----------                                                                          ------------");
        System.out.println("|Washing-|                                                                          |          |");
        System.out.println("|ton     |                                                                          | Railroads|");
        System.out.println("| Avenue |                                                                          |          |");
        System.out.println("----------                                                                          ------------");
        System.out.println("| Yellow |                                                                          | Luxury   |");
        System.out.println("|  House |                                                                          | Tax      |");
        System.out.println("----------                                                                          ------------");
        System.out.println("|Sheraton|                                                                          | City     |");
        System.out.println("|Hotel   |                                                                          | Park     |");
        System.out.println("----------                                                                          ------------");
        System.out.println("|Nothing |                                                                          | Nothing  |");
        System.out.println("----------                                                                          ------------");
        System.out.println("|        |                                                                          | Give Half|");
        System.out.println("|  Swap  |                                                                          | Of Your  |");
        System.out.println("|        |                                                                          | Money    |");
        System.out.println("----------                                                                          ------------");
        System.out.println("| Mosque |                                                                          | Mosque   |");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("|        |         |         |        |        |        |        |        |   New   |          |");
        System.out.println("| In Jail|  Hilton | Blue    | Red    |Nothing | Marvin | Income |Colorado|   York  |   Free   |");
        System.out.println("|        |  Hotel  | House   | House  |        | Garden | Tax    |Avenue  |  Avenue |  Parking |");
        System.out.println("------------------------------------------------------------------------------------------------");

    }

@Override
    public Iterator getIterator() {
        return new BoardIterator();
    }

    private class BoardIterator implements Iterator {

        int indexRow;
        int indexCol;

        @Override
        public boolean hasNextRow() {
            if (indexRow < cellBoard.length) {
                return true;
            }
            return false;
        }

        @Override
        public boolean hasNextCol() {
            if (indexRow < cellBoard.length && indexCol < cellBoard[indexRow].length) {
                return true;
            } else {
                indexRow++;
                return false;
            }

        }

        @Override
        public boolean hasNext() {
            if (hasNextRow() || hasNextCol()) {
                return true;
            }

            return false;
        }

        @Override
        public Cell next() {

            Cell result = null;
            if (this.hasNextCol()) {

                result = cellBoard[indexRow][indexCol];
                indexCol++;
            } else if (this.hasNextRow()) {

                indexCol = 0;
                result =  cellBoard[indexRow][indexCol];
                indexCol++;
            }else{
                result = null;
            }

            return result;
        }

    }

}