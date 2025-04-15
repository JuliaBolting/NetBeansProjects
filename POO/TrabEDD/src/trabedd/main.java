/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabedd;

import frame.gui.Supermercado;
import frame.gui.TelaLogin;

/**
 *
 * @author Julia
 */
public class main {
    public static void main(String[] args) {
        Supermercado s = new Supermercado();
        TelaLogin login = new TelaLogin(s);
        login.show();
    }
}

