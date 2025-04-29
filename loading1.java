/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author PMYLS
 */
import javax.swing.*;
import java.awt.*;
public class loading1 extends javax.swing.JFrame {

    /**
     * Creates new form loading1
     */
    public loading1() {
        initComponents();
        setImage();
       Thread obj = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(1000); // 1 second wait karega
                  new loading().setVisible(true);
//                System.out.println("Thread Completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
       
       obj.start();
    }
public void openNewFrame(JFrame currentFrame, JFrame newFrame) {
    currentFrame.dispose();  // Purani frame close
    newFrame.setVisible(true);  // Nayi frame show
}
    private void setImage() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/carshowbg2.jpg"));
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        jLabel1.setIcon(new ImageIcon(newImg)); // JLabel me scaled image lagayi
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loading1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
