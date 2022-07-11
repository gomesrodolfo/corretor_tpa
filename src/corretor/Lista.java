/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corretor;

/**
 *
 * @author rebeca
 */
public class Lista {

    No inicio;
    int tamanho;

    public void inserir(Palavra info) {
        No no = new No();
        no.info = info;
        no.proximo = inicio;

        inicio = no;
        tamanho = tamanho + 1;
    }

    public Palavra buscar(int codigo) {
        No no = inicio;

        while (no != null) {
            if (no.info.codigo == codigo) {
                return no.info;
            }
            no = no.proximo;
        }
        return null;
    }

    public String toString() {
        String out = "";
        No no = inicio;

        while (no != null) {
            out = out + no.info + " ";
            no = no.proximo;
        }
        return out ;
    }
    
}
