package LojaGomes;

import java.util.HashMap;
import java.util.Map;

public class Vendedor {
	private int matricula;
	  private String nome;
	  private HashMap <Produto, Integer> vendas = new HashMap<>();

	  //CONSTRUCTOR
	  public Vendedor(int matricula, String nome){
	    this.matricula = matricula;
	    this.nome = nome;
	  }
	  
	  //GETTERS
	  public int getMatricula() {
	   return this.matricula;
	}

	  public String getNome(){
	    return this.nome;
	  }

	  public HashMap<Produto, Integer> getVendas(){
	    return vendas;
	  }

	  //SETTERS
	  public void setMatricula(int matricula){
	    this.matricula = matricula;
	  }

	  public void setNome(String nome){
	    this.nome = nome;
	  }

	  // MÉTODOS ADICIONAIS
	  public void mostrarRelatorio(){
	    float valorTotal = 0;
	    int qtdTotalVendido = 0; 
	    
	    System.out.println("------------------------------------");
	    System.out.println("Nome do vendedor: " + this.nome);
	    System.out.println("Matrícula: " + this.matricula);
	    
	    for (Map.Entry<Produto, Integer> entry : vendas.entrySet()){
	      qtdTotalVendido += entry.getValue();
	      valorTotal += entry.getKey().getValor() * entry.getValue();

	      String nomeProduto = entry.getKey().getNome().toString();
	      String descricao = entry.getKey().getDescricao().toString();
	      int quantidade = entry.getValue();
	      
	        System.out.println("\n|Produto: " + nomeProduto);
	        System.out.println("|Descricao: " + descricao);
	        System.out.println("|Quantidade: " + quantidade);

	    }

	    System.out.println("\nQuantidade total de produtos vendidos por " + this.nome+": " + qtdTotalVendido);
	    System.out.println("Valor total vendido por " + this.nome+": " + valorTotal +"\n");
	  }

	  public float getValorTotalVendido(){
	    float valorTotal = 0.0F;
	    for (Map.Entry<Produto, Integer> entry : vendas.entrySet()){
	      valorTotal += entry.getKey().getValor() * entry.getValue();
	    }
	    return valorTotal;
	  }

	  public int getQuantidadeTotalVendida(){
	    int qtdTotalVendida = 0;
	    for (int quantidade : vendas.values()){
	      qtdTotalVendida += quantidade;
	    }
	    return qtdTotalVendida;
	  }
}
