package visteis;

import java.util.ArrayList;
import java.util.Random;

/**
 * Esta clase es la que inicia la partida utilizando los metodos y los objetos
 * de cell como atributos de clase, que generan la interfaz.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class Game {

    private Cell[][] cells;
    private int raws;
    private int columns;

    /**
     * Devuelve la celda seleccionada por coordenadas, que en este caso son raw
     * y column.
     *
     * @param raw
     * @param column
     * @return
     */
    public Cell getCell(int raw, int column) {
        return this.cells[raw][column];
    }

    /**
     * Este es el constructor de game, inicia una nueva partida y iniciliza el
     * array de celdas(cells).
     *
     * @param raws
     * @param columns
     * @param mines
     */
    public Game(int raws, int columns, int mines) {
        this.raws = raws;
        this.columns = columns;
        this.cells = new Cell[raws][columns];
        for (int i = 0; i < raws; i++) {
            for (int j = 0; j < columns; j++) {
                this.cells[i][j] = new Cell(false, 1, i, j);
            }
        }
        fillMines(mines);
    }

    /**
     * Este método recorre las celdas adyacentes de la cela que tenemos como
     * parametro, se utilizará como método auxiliar para otros métodos.
     *
     * @param cell Esta cell es la que se selecciona, las adyacentes apareceran
     * alrededor de esta celda.
     * @return
     */
    public ArrayList<Cell> getAdjacentCells(Cell cell) {
        ArrayList<Cell> adjacentCells = new ArrayList<>();

        int minI = (cell.getRaw() == 0) ? 0 : (cell.getRaw() - 1);

        int maxI = (cell.getRaw() == this.raws - 1) ? cell.getRaw() : (cell.getRaw() + 1);

        int minJ = (cell.getColumn() == 0) ? 0 : (cell.getColumn() - 1);

        int maxJ = (cell.getColumn() == this.columns - 1) ? cell.getColumn() : (cell.getColumn() + 1);

        for (int i = minI; i <= maxI; i++) {
            for (int j = minJ; j <= maxJ; j++) {
                adjacentCells.add(this.cells[i][j]);
            }
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
        int numMines = 0;
        for (Cell adjCell : getAdjacentCells(cell)) {
            if (adjCell.isMined()) {
                numMines++;
            }
        }
        return numMines;
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
            for (Cell adjacentCell : getAdjacentCells(cell)) {
                //Si no esta destapada...
                if (adjacentCell.getState() != 3) {
                    // PUES QUE SE ABRA COÑO JAJAJAJAJAJA
                    openCell(adjacentCell);
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
        //faltan por abrir, fumada de porros total.
        boolean mined = false;
        for (int i = 0; i < this.raws && !mined; i++) {
            for (int j = 0; j < this.columns && !mined; j++) {
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

    public int getRaws() {
        return raws;
    }

    public void setRaws(int raws) {
        this.raws = raws;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
    
}
