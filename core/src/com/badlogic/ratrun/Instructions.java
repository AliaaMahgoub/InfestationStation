package com.badlogic.ratrun;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

public class Instructions extends javax.swing.JFrame {

    private javax.swing.JLabel jLabel1;

    public Instructions() {initComponents();}

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setPreferredSize(new java.awt.Dimension(800, 480));
        setSize(new java.awt.Dimension(800, 480));
        getContentPane().setLayout(new java.awt.GridLayout());

        jLabel1 = new javax.swing.JLabel();
        jLabel1.setIcon(new javax.swing.ImageIcon("assets/instructions.png")); // NOI18N
        jLabel1.setText("jLabel1");

        getContentPane().add(jLabel1);
        pack();
    }
}
