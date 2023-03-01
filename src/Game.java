
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public class Game {

    private Cell cells;

    /**
     * Devolve a cela que está nunha fila e columna determinadas.
     */
    public Cell getCell(int raw, int column) {
        return null;
    }

    /**
     * Obtén a lista de celas adxacentes da cela que se recibe como parámetro.
     *
     */
    private ArrayList<Cell> getAdjacentCells(Cell cell) {

        return null;
    }

    /**
     * Obtén a suma das minas das celas adxacentes á cela que se recibe como
     * parámetro. Fará uso do método anterior.
     *
     * @param cell
     * @return
     */
    public int getAdjacentMines(Cell cell) {

        return 0;
    }

    /**
     * Destapa unha cela, e no caso de que o número de minas adxacentes sexa
     * cero, destapa todas as celas adxacentes que non estean destapadas. Tamén
     * fará uso do método getAdjacentCells() e é importante destacar que, pola
     * súa propia definición, é un método recursivo, xa que se chama a si mesmo
     * no seu código.
     */
    public void openCell(Cell cell) {

    }

    /**
     * Destapa todas as celas que teñan minas. Usarémolo cando o xogador perda
     * para mostrarlle en que celas estaban as minas.
     */
    public void openAllMines() {

    }

    /**
     * Comproba se quedan celas sen minas por destapar. Usarémolo para saber se
     * o xogador gañou a partida.
     *
     * @return
     */
    public boolean checkCellsToOpen() {
        return false;
    }

    /**
     * Coloca no array de celas o número de minas indicado, repartíndoas de
     * forma aleatoria.
     *
     */
    private void fillMines(int mines) {

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
}
