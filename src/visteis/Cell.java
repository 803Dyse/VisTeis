package visteis;

/**
 * Esta clase genera las celdas de la interfaz gráfica, con esta clase
 * conseguiremos implementar metodos que sacan la interfaz del juego (modo
 * texto) por pantalla. Toda la malla del juego se crea a partir de aquí.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class Cell {

    private boolean mined; //Este booleano indicará si la celda está tapada o no.
    private int state; // Esta variable almacena el status del juego utilizando las constantes que declaramos abajo.
    private int raw; // estas son las filas que utilizaremos en el bucle for para crear la malla del juego.
    private int column; //y estas son las columnas, que se utiliza igual que las filas.

    /**
     * Este es la constante que define el estado de la celda como tapada
     */
    public static final int STATE_HIDDEN = 1;

    /**
     * Este es la constante que define el estado de la celda como marcada
     */
    public static final int STATE_CHECKED = 2;

    /**
     * Este es la constante que define el estado de la celda como destapada
     */
    public static final int STATE_SHOWN = 3;

    /**
     * Siempre que crees un objeto de cell, aqui tienes la grade para crear las
     * celdas, esto seria el atributo de game.
     *
     * @param mined
     * @param raw
     * @param state
     * @param column
     */
    public Cell(boolean mined, int state, int raw, int column) {
        this.mined = mined;
        this.state = state;
        this.raw = raw;
        this.column = column;
    }

    public boolean isMined() {
        return mined;
    }

    public void setMined(boolean mined) {
        this.mined = mined;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getRaw() {
        return raw;
    }

    public void setRaw(int raw) {
        this.raw = raw;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    

}
