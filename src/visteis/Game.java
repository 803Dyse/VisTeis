/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visteis;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class Game {

    private Cell[][] cells;
    private int raws;
    private int columns;

    /**
     * Devolve a cela que está nunha fila e columna determinadas.
     *
     * @param raw
     * @param column
     * @return
     */
    public Cell getCell(int raw, int column) {
        return this.cells[raw][column];
    }

    /**
     * Crea unha nova partida.Inicializará a matriz de celas e usará o método
     * anterior para repartir as minas.
     *
     * @param raws
     * @param columns
     * @param mines
     */
    public Game(int raws, int columns, int mines) {
        
    }

    /**
     * Obtén a lista de celas adxacentes da cela que se recibe como parámetro.
     *
     */
    public ArrayList<Cell> getAdjacentCells(Cell cell) {
        ArrayList<Cell> adjacentCells = new ArrayList<>();
        for (Cell adjacentCell : adjacentCells) {
            
        }
        return adjacentCells;
    }

    /**
     * Obtén a suma das minas das celas adxacentes á cela que se recibe como
     * parámetro. Fará uso do método anterior.
     *
     * @param cell
     * @return
     */
    public int getAdjacentMines(Cell cell) {
        //CAMBIA EL NOMBRE DE ESTA VAR DESPUES                          !!!!!!!!
        int minaCell = 0;
        for (Cell adjacent : getAdjacentCells(cell)) {
            if (adjacent.isMined()) {
                minaCell++;
            }
        }
        return minaCell;
    }

    /**
     * Destapa unha cela, e no caso de que o número de minas adxacentes sexa
     * cero, destapa todas as celas adxacentes que non estean destapadas. Tamén
     * fará uso do método getAdjacentCells() e é importante destacar que, pola
     * súa propia definición, é un método recursivo, xa que se chama a si mesmo
     * no seu código.T
     *
     * @param cell
     */
    public void openCell(Cell cell) {
        //3 es el estado para cuando está destapada, seteamos esto como abierto
        cell.setState(3);
        if (getAdjacentMines(cell) == 0) {
            for (Cell adjacentCells : getAdjacentCells(cell)) {
                //Si no esta destapada...
                if (adjacentCells.getState() != 3) {
                    // PUES QUE SE ABRA COÑO JAJAJAJAJAJA
                    openCell(adjacentCells);
                }
            }
        }
    }

    /**
     * Destapa todas as celas que teñan minas. Usarémolo cando o xogador perda
     * para mostrarlle en que celas estaban as minas.
     */
    public void openAllMines() {
        for (int i = 0; i < raws; i++) {
            for (int j = 0; j < columns; j++) {
                Cell cell = getCell(i, j);
                if (cell.isMined()) {
                    cell.setState(3);
                }
            }
        }
    }

    /**
     * Comproba se quedan celas sen minas por destapar. Usarémolo para saber se
     * o xogador gañou a partida.
     *
     * @return
     */
    public boolean checkCellsToOpen() {
        //tuve que crear al final este boolean porque me di cuenta de que no 
        //sirve con returnear false, ya que todo eso se tiene que guarda para
        //que el booleano te indique que cojones es verdadero o falso, pues
        //aqui lo que hice fue crear un booleano que se retorna al final 
        //despues de recorrer todo el mapa del juego para decir las celdas que 
        //faltan por abrir, fumada de porros total, pero funciona, amen.
        boolean mined = false;
        for (int i = 0; i < raws; i++) {
            for (int j = 0; j < columns; j++) {
                Cell cell = getCell(i, j);
                if (!cell.isMined() && cell.getState() != 3) {
                    mined = true;
                }

            }
        }
        return mined; //PD: No sabéis la puta locura que fué llegar a esto JAJA
    }

    /**
     * Coloca no array de celas o número de minas indicado, repartíndoas de
     * forma aleatoria.
     *
     */
    private void fillMines(int mines) {
        int minesThrow = 0;
        while (minesThrow < mines) {
            int cellRandom = (new Random()).nextInt(raws * columns);
            Cell cell = cells[cellRandom / columns][cellRandom % columns];
            //si la celda NO esta minada...
            if (!cell.isMined()) {
                //decimos que ahora si, para crear el efecto encadenado de abrir
                //las celdas
                cell.setMined(true);
                minesThrow++;
            }
        }
    }
}
