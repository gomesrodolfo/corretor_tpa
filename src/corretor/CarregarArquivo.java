/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corretor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CarregarArquivo {

	public static void main(String[] args) throws Exception {

		// abertura do arquivo
		BufferedReader myBuffer = new BufferedReader(new InputStreamReader(new FileInputStream("dict/pt2.txt"), "UTF-8"));
                OutputStreamWriter bufferOut = new OutputStreamWriter(new FileOutputStream("C:\\Users\\rodol\\OneDrive\\Área de Trabalho\\IFES\\TPA\\Corretor\\dict\\acentos.txt"),"UTF-8");

		// loop que lê e imprime todas as linhas do arquivo
		String linha = myBuffer.readLine();
                
                System.out.println(System.getProperty("myBuffer.encoding"));
                
		while (linha != null) {
			System.out.println(linha);
			linha = myBuffer.readLine();
                        bufferOut.write(linha);
		}

                myBuffer.close();
                bufferOut.close();

	}

}