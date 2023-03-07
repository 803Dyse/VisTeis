/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visteis;

/**
 * Esta es la clase que hace la llamada al objeto menu.
 *
 * @author Alejandro Martínez Domínguez, Bilo Alejandro Martins González y Raúl
 * Parada de la Fuente
 */
public class VisTeisMinas {

    /**
     * Metodo main, que crea un objeto menu que por su vez inicia la partida y
     * saca el menu por pantalla.
     *
     * @param args
     */
    public static void main(String[] args) {
        VisTeisMinasMenu visTeisMinasMenu = new VisTeisMinasMenu();
        visTeisMinasMenu.startNewGame();
    }
}
