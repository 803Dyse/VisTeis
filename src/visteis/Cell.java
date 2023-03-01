/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visteis;

/**
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class Cell {

    private boolean mined;
    private int state;
    private int raw;
    private int column;

    /**
     * Siempre que crees un objeto de cell, aqui tienes la grade para crear las
     * celulas, esto seria el atributo de game.
     *
     * @param raw
     * @param column
     */
    public Cell(int raw, int column) {
        this.raw = raw;
        this.column = column;
    }

    /**
     *
     * @return
     */
    public boolean isMined() {
        return mined;
    }

    /**
     *
     * @param mined
     */
    public void setMined(boolean mined) {
        this.mined = mined;
    }

    /**
     *
     * @return
     */
    public int getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     *
     * @return
     */
    public int getRaw() {
        return raw;
    }

    /**
     *
     * @param raw
     */
    public void setRaw(int raw) {
        this.raw = raw;
    }

    /**
     *
     * @return
     */
    public int getColumn() {
        return column;
    }

    /**
     *
     * @param column
     */
    public void setColumn(int column) {
        this.column = column;
    }

}
