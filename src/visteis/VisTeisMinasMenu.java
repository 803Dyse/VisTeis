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
        System.out.println();
        System.out.println("[ *** Estás xogando ao VisTeis Minas *** ]");
        System.out.println("         --- Estado do panel --- ");
        System.out.println();

        System.out.print("   ");
        for (int i = 0; i < 6; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int t = 0; t < 6; t++) {

            System.out.print("  -");
            for (int m = 0; m < 6; m++) {
                System.out.print("--");
            }
            System.out.println();

            System.out.print(t + " |");
            for (int m = 0; m < 6; m++) {
                System.out.print(" |");
                String msgCell;
                Cell cell = game.getCell(t, m);
                
                switch(cell.getState()){
                    case 1:
                        msgCell = " ";
                        break;
                        
                    case 2:
                        msgCell = "!";
                        break;
                }
            }
            System.out.println("");
            if (t == 5) {
                System.out.print("  -");
                for (int i = 0; i < 1; i++) {
                    for (int j = 0; j < 6; j++) {
                        System.out.print("--");
                    }
                }
            }

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
