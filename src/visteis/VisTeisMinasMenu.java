package visteis;

import java.util.Scanner;

/**
 * Esta clase es el menu del juego, donde se podrá ver toda la interfaz de texto
 * que implementaremos.
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
                String msgCell;
                Cell cell = game.getCell(t, m);

                switch (cell.getState()) {

                    case 1:
                        msgCell = " ";
                        break;
                    case 2:
                        msgCell = "!";
                        break;
                    default:
                        if (cell.isMined() ) {
                            msgCell = "*";
                            break;
                        }
                        msgCell = Integer.toString(game.getAdjacentMines(cell));
                        break;
                }

                System.out.print(msgCell + "|");
            }
            System.out.println();
        }
        System.out.print("  -");
        for (int i = 0; i < 6; i++) {
            System.out.print("--");
        }
        System.out.println();
    }

    /**
     * Este método crea una nueva partida, se utilizará para la primera partida
     * (trás iniciar el programa) y para cuando se diga que si a la opcion de
     * "deseas jugar otra vez?"
     */
    public void startNewGame() {
        Scanner sc = new Scanner(System.in);
        boolean restart;

        do {
            boolean isGameOver = false;
            Game game = new Game(6, 6, 8); 
            do {
                int raw, column;
                Cell cell;
                showPanel(game);
                System.out.println("Utiliza una de los opciones a seguir: \n> a (Abrir unha celda)\n> m (Marcar una celda)\n> d (Desmarcar celda)\n> s (Salir)");

                char option = sc.nextLine().charAt(0);

                switch (option) {
                    case 's':
                        isGameOver = true;
                        System.exit(0);
                        break;

                    case 'a':
                    case 'd':
                    case 'm':
                        do {
                            System.out.println("Introduce la fila la celda:");
                            raw = sc.nextInt();
                            System.out.println("Introduce la columna de la celda:");
                            column = sc.nextInt();
                            sc.nextLine();
                            if (raw >= 0 || raw < 6 || column >= 0 || column < 6) {
                                continue;
                            }
                            System.out.println("La fila y/o columnas indicas no son validas");

                        } while (raw < 0 && raw >= 6 && column < 0 && column >= 6);

                        cell = game.getCell(raw, column);

                        if (cell.getState() != 3) {
                            switch (option) {
                                case 'm':
                                    cell.setState(2);
                                    break;
                                case 'd':
                                    cell.setState(1);
                                    break; 
                            }

                            if (cell.isMined() && cell.getState() != 3) {
                                game.openAllMines();
                                showPanel(game);
                                System.out.println("Perdiste. La partida se acabó.");
                                isGameOver = true;
                            }
                            if (option == 'a') {
                                game.openCell(cell);
                            }
                            
//                            game.openCell(cell);
                            if (!game.checkCellsToOpen()) {
                                showPanel(game);
                                System.out.println("Enhorabuena, ganaste la partida.");
                            }
                        }
                        break;

                    default:
                        System.out.println("Esta accion no está permitida.");
                        break;
                }
            } while (!isGameOver);

            System.out.println("Jugar otra vez? (s / n)");
            restart = (sc.nextLine().charAt(0) == 's');
        } while (restart);
    }
}
