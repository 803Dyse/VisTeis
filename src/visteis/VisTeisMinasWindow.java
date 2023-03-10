/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visteis;

import javax.swing.JOptionPane;

/**
 * Nesta clase engadiremos as propiedades "game" (de clase Game, que fará
 * referencia ao obxecto xogo que mantén a partida) e "cellButtons" (que será un
 * array bidimensional de JToogleButton, e que usaremos para almacenar as
 * referencias aos obxectos JToogleButton que forman o panel do xogo)
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public class VisTeisMinasWindow extends javax.swing.JFrame {

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
        int option = JOptionPane.showOptionDialog(this, "Selecciona una opcion", "Menu de opciones", WIDTH, HEIGHT, null, selectGameMode, EXIT_ON_CLOSE);
        
    }

    /**
     * Actualiza no panel do xogo os JToogleButtons das celas que están
     * destapadas e mostra neles unha mina (unha imaxe que se almacena na mesma
     * carpeta que as clases), ou o número de minas adxacentes.
     */
    /**
     * Actualiza no panel do xogo os JToogleButtons das celas que están
     * destapadas e mostra neles unha mina (unha imaxe que se almacena na mesma
     * carpeta que as clases), ou o número de minas adxacentes.
     */
    private void updatePanel() {
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

        barraMenu = new javax.swing.JMenuBar();
        ficheiro = new javax.swing.JMenu();
        nuevaPartida = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        ficheiro.setText("Ficheiro");

        nuevaPartida.setText("Nueva Partida");
        ficheiro.add(nuevaPartida);

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        ficheiro.add(Salir);

        barraMenu.add(ficheiro);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalirActionPerformed

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
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenu ficheiro;
    private javax.swing.JMenuItem nuevaPartida;
    // End of variables declaration//GEN-END:variables
}
