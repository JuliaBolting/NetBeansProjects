/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frame.util;

/**
 *
 * @author Julia
 */
public class CodeException extends Exception {

    public CodeException(String mensagem, Exception e) {
        super(mensagem, e);
    }

    public CodeException(String mensagem) {
        super(mensagem);
    }

    public static void print(Exception e, String mensagem) {
        System.out.println("==============Exception===============");
        System.out.println(mensagem);
        System.out.println("PrintStackTrace: ");
        e.printStackTrace();
        System.out.println("============End Exception=============");
    }

    public void print() {
        System.out.println("==============Exception===============");
        System.out.println(getMessage());
        System.out.println("PrintStackTrace: ");
        getCause().printStackTrace();
        System.out.println("============End Exception=============");
    }
}
