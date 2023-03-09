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
                        if (cell.isMined()) {
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
        boolean isGameOver = false;
        Game game = new Game(6, 6, 8);
        do {
            /**
             * esto que se vé abajo, se creó posteriormente cuando fué necesario
             * un nivel de visibilidad externo dentro de las condicionales. Así
             * que no os rayéis mirando esto a principio y pensando: Que cojones
             * hizo bilo? Dejo con una exclamacion para indicar a que me refiero
             */
            int raw, column; //!
            Cell cell; //!  
            showPanel(game);
            System.out.println("Utiliza una de los opciones a seguir: \n> a (Abrir unha celda)\n> m (Marcar una celda)\n> d (Desmarcar celda)\n> s (Salir)");

            char option = sc.nextLine().charAt(0); //!

            switch (option) {
                //Este código funciona, está un poco guarro, se puede optimizar,
                //pero como es perceptible su complejidad, seria demasiado lío
                //lograr hacerlo de la mejor manera, que de hecho fue la unica 
                //posible, pero esto futuramente se cambiará a un código más
                //limpio.
                case 's':
                    isGameOver = true;
                    System.exit(0);
                    break;
                /**
                 * Lo primero de todo, aqui dejamos los cases a, d y m así,
                 * porque directamente el switch los lleva al proximo, y, como
                 * el case m ya sirve de utilidad tanto para a como para d y
                 * para m, hacemos todo el codigo dentro de m, por eso está
                 * guarro, y de hecho esto se cambiará mas tarde, pero está
                 * totalmente funcional.
                 */
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
                    /**
                     * Me preguntaréis como cojones esto está asi, pues,
                     * resumidamente: El codio que véis arriba, es lo que tiene
                     * en comun las 3 opciones, marcar, desmarcar y abrir
                     * celdas. Y lo que tienen en comun son los siguientes
                     * aspectos: (1)- Pedir dato de fila y de columna (2)- Una
                     * condicional para que esas requisicion no exceda la malla
                     * de la interfaz grafica, para que esté entre la fila 0 y
                     * 6, y lo mismo con la columna. (3)-Avisar que és invalido
                     * si esa condicional no se cumple.
                     */
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
                        if (cell.isMined() && cell.getState() != 2) {
                            game.openAllMines();
                            showPanel(game);
                            System.out.println("Perdiste. La partida se acabó.");
                            isGameOver = true;
                        }
                        if (option == 'a') {
                            game.openCell(cell);
                        }
                        if (!game.checkCellsToOpen()) {
                            game.openAllMines();
                            showPanel(game);
                            System.out.println("Enhorabuena, ganaste la partida.");
                        }
                    }
                    break;
                default:
                    System.out.println("Esta accion no está permitida.");
                    break;
            }
            if (isGameOver) {
                game.checkCellsToOpen();
                game.openAllMines();
                showPanel(game);
                System.out.println("Has perdido");
                System.out.println("Jugar otra vez? (s / n)");
                char restartr = sc.nextLine().charAt(0);
                if (restartr == 's') {
                    startNewGame();
                } else if (restartr == 'n') {
                    System.exit(0);
                }
            }
            if (!game.checkCellsToOpen()) {
                game.openAllMines();
                showPanel(game);
                System.out.println("Has ganado");
                System.out.println("Jugar otra vez? (s / n)");
                char restartr = sc.nextLine().charAt(0);
                if (restartr == 's') {
                    startNewGame();
                } else if (restartr == 'n') {
                    System.exit(0);
                }
            }
        } while (!game.checkCellsToOpen() || !isGameOver);
    }
}
