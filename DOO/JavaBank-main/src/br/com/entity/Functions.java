package br.com.entity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.*;
import java.util.Random;

public class Functions {

    public static boolean isValidEmailAddress(String email) {
        boolean isEmailValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern ptt = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher mt = ptt.matcher(email);
            if (mt.matches()) {
                isEmailValid = true;
            }
        }
        return isEmailValid;
    }

    /**
     *
     * @param args
     */
    public Integer randomNumber() {
        Random aleatorio = new Random();
        int valor = aleatorio.nextInt(10000);
        valor = valor;
        System.out.println("Número gerado: " + valor);
        return valor;
  }
    
}
