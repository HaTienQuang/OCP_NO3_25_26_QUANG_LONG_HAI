/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlst.main;
import View.LoginGUI;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Tạo một thể hiện của lớp LoginGUI và hiển thị nó
                new LoginGUI().setVisible(true);
            }
        });
    }
}
