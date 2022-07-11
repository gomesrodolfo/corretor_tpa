/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corretor;

/**
 *
 * @author rebeca
 * Tratamento das colisões resolvido com Encadeamento Exterior
 * Manter m listas encadeadas, uma para cada possível endereço base
 * A tabela base não possui nenhum registro, apenas os ponteiros para as listas encadeadas
 */
public class Hash {

    int operador;
    Lista[] vetor;

    public Hash(int operador) {
        this.operador = operador;
        vetor = new Lista[operador];

        for (int i = 0; i < operador; i++) {
            vetor[i] = new Lista();
        }
    }

    public void inserir(Palavra palavra) {
        int chave = palavra.codigo % operador;

        vetor[chave].inserir(palavra);
    }

    public Palavra buscar(int codigo) {
        return vetor[codigo % operador].buscar(codigo);
    }

    public String toString() {
        String out = "";

        for (int i = 0; i < operador; i++) {
            out += "" + i + ": ";
            out += vetor[i % operador] + "\n";
        }
        return out;
    }
}
