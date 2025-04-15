/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tecnicas;

import com.mycompany.generics.Caixa;
import com.mycompany.generics.Produto;
import com.mycompany.lambda.Pessoa;
import com.mycompany.reflection.AtaqueVoador;
import com.mycompany.reflection.Personagem;
import java.io.File;
import java.lang.reflect.*;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author alunolages
 */
public class Main {
    public static void main(String[] args) {
        
//        Caixa caixa = new Caixa();
        
//        String bilhete = "aprender a hackear algo";
//        Produto produto = new Produto("escova", 5);
        
        //sem generics
//        caixa.setObjeto(bilhete);
//        Object generico = caixa.getObjeto();
//        System.out.println(generico);
//        
//        caixa.setObjeto(produto);
//        Produto prod = (Produto) caixa.getObjeto();
//        System.out.println(prod.getTitulo());
//        
//        Caixa<Produto> caixa2 = new Caixa();
//        caixa2.setObjeto(produto);
//        Produto prod2 = caixa2.getObjeto();
//        System.out.println(prod2.getTitulo());
//        
//        Caixa<String> caixaBilhetes = new Caixa();
        
        
        //reflection
//        Personagem batima = new Personagem("Batima", 10, 80);
//        
//        try {
//            //codigo para desenvolvimento
//            //classloader
//            //Class<?> classe = Class.forName("com.mycompany.reflection.AtaqueVoador");
//            
//            //para carregar classes extermas (fora do classpath)
//            File diretorioDLC = new File("DLC");
//            URL url = diretorioDLC.toURI().toURL();
//            URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
//            Class<?> classe = classLoader.loadClass("com.mycompany.reflection.AtaqueVoador");
//            
//            //acessando campos da classe via reflexao
//            Object objetoBonus = classe.getDeclaredConstructor().newInstance();
//            Field campoDesc = classe.getDeclaredField("descricao");
//            campoDesc.setAccessible(true); //agora acesso campo private
//            String tituloBonus = (String) campoDesc.get(objetoBonus);
//            System.out.println("Bonus: "+tituloBonus);
//            
//            //acessando metodos da classe via reflexao
//            Method metodo = classe.getMethod("fornecerBonus");
//            int bonusRecebido = (int) metodo.invoke(objetoBonus);
//            System.out.println("DLC carregada com sucesso");
//            batima.aumentarDano(bonusRecebido);
//            
//        
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Nao foi possivel achar a classe");
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NoSuchMethodException ex) {
//            System.out.println("Nao foi possivel carregar o metodo");
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SecurityException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException ex) {
//            System.out.println("Nao foi possivel instanciar ou acessar metodo");
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);        
//        } catch (InvocationTargetException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NoSuchFieldException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
////        AtaqueVoador bonus = new AtaqueVoador();
////        int bonusRecebido = bonus.fornecerBonus();
////        batima.aumentarDano(bonusRecebido);
//        
//        System.out.println(batima.getNome() + " atacando com ");
//        System.out.println(batima.atacar() + " pontos");
        Pessoa p1 = new Pessoa("Ana", "feminino");
        Pessoa p2 = new Pessoa("Bruno", "masculino");
        Pessoa p3 = new Pessoa("Carlos", "masculino");
        List<Pessoa> pessoas = List.of(p1,p2,p3);
        
        //imperativo, sem lambda
        for(Pessoa pessoa : pessoas){
            System.out.println("Nome: " + pessoa.getNome());
        }
        
        //com lambda:
        pessoas.forEach(
                pessoa -> System.out.println("Nome: " + pessoa.getNome())
        );
        
        //com streams
        List<Pessoa> masculinos = pessoas.stream()
                            .filter(o -> o.getGenero().equals("masculino"))
                            .collect(Collectors.toList());
        masculinos.forEach(p -> System.out.println("Nome: "+ p.getNome()));
        
        
        
    }
    
}
