/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corretor;

/**
 *
 * @author rebeca
 */
public class Palavra {

    public int codigo;         //chave
    public String palavra;

    public Palavra(int codigo, String palavra) {
        this.codigo = codigo;
        this.palavra = palavra;
    }

    public String toString() {
        return "(" + getCodigo() + ", " + getPalavra() + ")";
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the palavra
     */
    public String getPalavra() {
        return palavra;
    }

    /**
     * @param palavra the palavra to set
     */
    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }
}
