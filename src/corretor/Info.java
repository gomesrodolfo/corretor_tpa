package corretor;
public class Info implements Comparable<Info>{
	private String nomecompleto, telefone, cidade, pais;

	public Info(String nomecompleto, String telefone, String cidade, String pais){
		setNomeCompleto(nomecompleto);
		setTelefone(telefone);
		setCidade(cidade);
		setPais(pais);
	}

	public String getNomeCompleto(){
		return nomecompleto;
	}

	public void setNomeCompleto(String nomecompleto){
		this.nomecompleto=nomecompleto;
	}

	public String getTelefone(){
		return telefone;
	}

	public void setTelefone(String telefone){
		this.telefone=telefone;
	}

	public String getCidade(){
		return cidade;
	}

	public void setCidade(String cidade){
		this.cidade=cidade;
	}

	public String getPais(){
		return pais;
	}

	public void setPais(String pais){
		this.pais=pais;
	}

	public int compareTo(Info c){
    return this.getNomeCompleto().compareTo(c.getNomeCompleto());
  }

	public Info(String linhaArquivo){
    String[] atributos=linhaArquivo.split(",");
	setNomeCompleto(atributos[0]);
	setTelefone(atributos[1]);
	setCidade(atributos[2]);
	setPais(atributos[3]);
  }

	public String imprimir(){
		return getNomeCompleto() + "," + getTelefone() + "," + getCidade() + "," + getPais();
	}
}