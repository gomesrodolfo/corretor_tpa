/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corretor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.sql.DriverManager.println;

/**
 *
 * @author rebeca
 */
public class Arquivo {

    public static Hash Read(String caminho) throws IOException{
        String conteudo = "";
        Hash hash = new Hash(20971520);

        try {          
//            FileReader arq = new FileReader(caminho);
//            BufferedReader lerArq = new BufferedReader(arq);
            BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream(caminho), "UTF-8"));         
            String linha = "";
            
            try {
                linha = lerArq.readLine();
                
                int i = 0;
                while (linha != null) {
                    Palavra palavra = new Palavra(i, linha);
                    hash.inserir(palavra);
                    conteudo = conteudo + linha;
                    linha = lerArq.readLine();
//                    System.out.println("Palavra: " + linha);
                    i = i + 1;
//                    System.out.println(hash);
                }
                 
            } catch (IOException e) {
                conteudo = "Erro: Nao foi possivel ler o arquivo!";
            }
        } catch (FileNotFoundException e) {
            conteudo = "Erro: Arquivo nao encontrado!";
        }
        
//        if (conteudo.contains("Erro")) {
//            return "";
//        } else {
//            return conteudo;
//        }
        return hash;
    }
}
