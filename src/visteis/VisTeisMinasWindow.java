/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visteis;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * Nesta clase engadiremos as propiedades "game" (de clase Game, que fará
 * referencia ao obxecto xogo que mantén a partida) e "cellButtons" (que será un
 * array bidimensional de JToogleButton, e que usaremos para almacenar as
 * referencias aos obxectos JToogleButton que forman o panel do xogo)
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public class VisTeisMinasWindow extends javax.swing.JFrame {

    private Game game;
    private JPanel panel = new JPanel();
    private JToggleButton[][] cellsBTN;

    /**
     * Imos implementar unha interface gráfica para o xogo. A base da interface
     * será unha ventá cunha barra de menú e un panel onde se colocarán un
     * conxunto de botóns de tipo JToogleButton para representar as celas.
     *
     * No comezo dunha partida, pedirase ao usuario indicar o nivel de
     * dificultade que desexe escollendo entre:
     *
     * Baixo: Matriz de 6*6 celas, con 8 minas. Medio: Matriz de 8*8 celas, con
     * 20 minas. Alto: Matriz de 10*10 celas, con 40 minas.
     */
    /**
     * Mostra ao usuario un diálogo para que seleccione o nivel de xogo, crea un
     * novo obxecto Game e rexenera o panel do xogo co unha nova matriz de
     * JToogleButtons. Para que os botóns se mostren nunha rexilla que se adapte
     * ao tamaño da ventá, o máis cómodo é establecer para o panel do xogo un
     * layout de tipo GridLayout co número de filas e columas que ten a matriz
     * de celas do xogo. Recoméndase tamén poñer a cada botón un nome do tipo
     * "cell-i-j", poñendo en i e j as coordenadas da cela; desta maneira cando
     * se faga clic no botón poderemos saber polo nome con que cela está
     * relacionada ese botón. Engadiremos a cada botón listeners para capturar
     * os eventos de premer e facer clic co botón dereito sobre o botón. Por
     * último, engadiremos tamén os botóns na posición i,j do array
     * bidimensional "cellButtons", para logo poder acceder facilmente ao botón
     * que se corresponde cunha cela do xogo.
     *
     */
    public void startNewGame() {
        /**
         * int option es un numerador que necesitamos para poder controlar los 3
         * botones segun la accion del usuario para elegir una opcion.
         */
        String[] selectGameMode = {"Dificil", "Medio", "Facil"};
        int option = JOptionPane.showOptionDialog(this, "Selecciona una opcion", "Menu de opciones", WIDTH, HEIGHT, null, (Object[]) selectGameMode, EXIT_ON_CLOSE);

        /**
         * Si option se cumple, empezaremos a jugar con un switch para crear un
         * objeto game que asignará la creacion del tablero del juego en funcion
         * del nivel de dificultad elegido.
         */
        switch (option) {
            case 0:
                game = new Game(6, 6, 8);//EASY MODE
                break;
            case 1:
                game = new Game(8, 8, 20);//MEDIUM MODE
                break;
            case 2:
                game = new Game(10, 10, 40);//HARD MODE
                break;
        }
        panel.removeAll();
        panel.setLayout(new GridLayout(game.getRaws(), game.getColumns()));
        cellsBTN = new JToggleButton[game.getRaws()][game.getColumns()];

        for (int i = 0; i < game.getRaws(); i++) {
            for (int j = 0; j < game.getColumns(); j++) {
                JToggleButton cellButton = new JToggleButton();
                cellButton.setName("cell-" + i + "-" + j);
                cellButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        VisTeisMinasWindow.this.cellButtonActionPerformed(evt);
                    }
                });
                cellButton.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent evt) {
                        VisTeisMinasWindow.this.cellButtonMouseClicked(evt);
                    }
                });
                panel.add(cellButton);
                cellsBTN[i][j] = cellButton;
            }
        }
        pack();
    }

    /**
     * Actualiza no panel do xogo os JToogleButtons das celas que están
     * destapadas e mostra neles unha mina (unha imaxe que se almacena na mesma
     * carpeta que as clases), ou o número de minas adxacentes.
     */
    private void updatePanel() {
        for (int i = 0; i < game.getRaws(); i++) {
            for (int j = 0; j < game.getColumns(); j++) {
                Cell cell = game.getCell(i, j);
                JToggleButton cellButton = cellsBTN[i][j];

                if (cell.getState() != 3) {
                    cellButton.setEnabled(false);
                    //Si esta minada, indicamos que hay una bomba, para eso
                    //cambiaremos el boton y setearemos un icon
                    if (cell.isMined()) {
                        cellButton.setIcon(new ImageIcon("src/images/bomba.jpg"));
                    } else {
                        cellButton.setText(String.valueOf(this.game.getAdjacentMines(cell)));
                    }
                }
            }
        }
    }

    /**
     * Finaliza a partida, mostrando unha mensaxe ao usuario e dando a opción de
     * xogar outra partida ou pechar a aplicación.
     *
     * @param message
     */
    private void finishGame(String message) {
    }

    /**
     * Abre unha cela. Se a a cela ten unha mina, destapa todas as minas e
     * finaliza a partida (chamando ao método anterior). Se non, se chama ao
     * xogo para abrir a cela (o que pode supoñer abrir celas adxacentes de a
     * cela tivese cero minas adxacentes), actualízase o panel do xogo e se non
     * quedan celas sen minas que destapar se remata a partida (de novo chamando
     * ao método anterior, pero agora indicando ao usuario que gañou a partida).
     *
     * @param cell
     */
    private void openCell(Cell cell) {
    }

    /**
     * Método que captura o clic sobre un JToogleButton do panel do xogo,
     * abrindo a cela que se corresponde con este botón. Para saber con que cela
     * se corresponde o botón que causou o evento obteremos o "source" do evento
     * (convertíndoo a un JToogleButton), e no atributo "name" poderemos atopar
     * as coordenadas i e j da cela.
     *
     * @param evt
     */
    private void cellButtonActionPerformed(java.awt.event.ActionEvent evt) {
    }

    /**
     * Método que captura o clic co botón dereito (o botón do evento non debe
     * ser o botón 1) sobre un JToogleButton do panel do xogo, marcando ou
     * desmarcando o botón (o que supón poñer ou quitar no botón a icona de
     * aviso), e modificando o estado da cela correspondente (obtendo a cela
     * como no método anterior). No método "main" da clase "VisTeisMinas", se se
     * recibe o parámetro "text" na liña de comandos se creará un obxecto da
     * clase "VisteisMinasMenu" e se chamará ao método "startNewGame()" para que
     * mostre a interface en modo texto, e se non se recibe, mostrarase a ventá
     * "VisTeisMinasWindow".
     *
     * @param evt
     */
    private void cellButtonMouseClicked(java.awt.event.MouseEvent evt) {
    }

    /**
     * Creates new form VisTeisMinasWindow
     */
    public VisTeisMinasWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VisTeisMinasWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VisTeisMinasWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VisTeisMinasWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VisTeisMinasWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VisTeisMinasWindow().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
