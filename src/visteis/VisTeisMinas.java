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
         /**
         * Dejaré aqui comentado lo que pide el enunciado del proyecto porque lo
         * que vereis a seguir es lo que entiendo que hay que hacer, de todos
         * modos esta documentacion és crucial para que os situeis bien y si
         * luego hay un error, que ya sabeis que aqui puede ser donde está. Aun
         * que de momento entiendo que esto es lo que pide.
         */
        //Dejo el enunciado abajo de ESTE comentario.
        /**
         * No método "main" da clase "VisTeisMinas", se se recibe o parámetro
         * "text" na liña de comandos se creará un obxecto da clase
         * "VisteisMinasMenu" e se chamará ao método "startNewGame()" para que
         * mostre a interface en modo texto, e se non se recibe, mostrarase a
         * ventá "VisTeisMinasWindow".
         */
//        if (args.length == 1 && args[0].equals("text")) {
//            (new VisTeisMinasMenu()).startNewGame();
//        } else {
//            (new VisTeisMinasMenu()).startNewGame();
//        }
        VisTeisMinasMenu visTeisMinasMenu = new VisTeisMinasMenu();
        visTeisMinasMenu.startNewGame();
    }
}
