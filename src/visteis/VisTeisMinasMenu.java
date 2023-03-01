package visteis;

/**
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public class VisTeisMinasMenu {

    public static final int RAWS = 6;
    public static final int COLUMNS = 6;
    public static final int MINES = 8;

    /**
     * Saca por pantalla el panel de las minas.
     */
    private void showPanel(Game game) {

        System.out.println("[ *** Estás xogando ao VisTeis Minas *** ]");
        System.out.println("         --- Estado do panel --- ");
        System.out.println("");

        
        //Y = VERTICAL
        //X = HORIZONTAL
        for (int y = 0; y < 6; y++) {
            System.out.println(y + "");
            System.out.println("-");
            System.out.println(y+ "");
        }
        System.out.println();
    }

    /**
     * Que inicia unha partida, creando un obxecto da clase Game, mostrará o
     * panel (chamando o método anterior) e pedirá ao usuario e executará a
     * acción a realizar. Volverase a mostrar o panel e pedir unha nova acción
     * de forma repetitiva mentres non remate a partida, ben porque o usuario
     * destapa unha cela minada ou ben porque destapa todas as celas que non
     * teñen minas. Cando se remate a partida, este método preguntará ao xogador
     * se quere xogar outra partida, repetindo todo o proceso se responde
     * afirmativamente.
     */
    public void startNewGame() {
        Game game = new Game(RAWS, COLUMNS, MINES);
        showPanel(game);
    }

}
