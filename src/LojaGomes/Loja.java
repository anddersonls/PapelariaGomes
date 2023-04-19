package LojaGomes;

import java.util.ArrayList;
import java.util.HashMap;

public class Loja {
	private String nome;
	  private ArrayList<Produto> produtos = new ArrayList<Produto>();
	  private ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();

	  //CONSTRUCTOR
	  public Loja(String nome){
	    this.nome = nome;
	  }
	  
	  //GETTERS
	  public String getNome() {
	    return this.nome;
	  } 
	  
	  public ArrayList<Produto> getProdutos() {
		    return this.produtos;
	  } 
	  
	  public ArrayList<Vendedor> getVendedores() {
		    return this.vendedores;
	  } 
	  
	  //SETTERS
	  public void setNome(String nome) {
			this.nome = nome;
		}
	  
	  //MÉTODOS ADICIONAIS
	  public void addProduto(Produto produto){
		    this.produtos.add(produto);
		  }

	  public void addVendedor(Vendedor vendedor){
		    this.vendedores.add(vendedor);
		  }

	  public void registrarVenda(Vendedor v, Produto p, int quantidade){
	    //checando se há a quantidade no estoque
	    if(quantidade<=p.getEstoque()){
	      p.setEstoque(p.getEstoque() - quantidade);
	      
	      //registro da venda do vendedor
	      HashMap <Produto, Integer> vendas = v.getVendas();
	      if(vendas.containsKey(p)){
	        int qtdAtual = vendas.get(p);
	        vendas.put(p, qtdAtual + quantidade);
	      }
	      else{
	        vendas.put(p, quantidade);
	      }
	    }
	    else{
	      System.out.println("\n" + v.getNome() + ", não é possível fazer a venda de " + quantidade + " " + 
	    		  				p.getNome()  + ", pois há "+ p.getEstoque() +" unidade(s) desse produto no estoque!\n");
	    }

	  }
	  
	  public void mostrarEstoque(){
			System.out.println("------------------------------------");
			System.out.println("Estoque dos Produtos da Loja Gomes\n");
			
		    for(Produto produto : produtos){
		      System.out.println("|Nome: " + produto.getNome());
		      System.out.println("|Valor: " + produto.getValor());
		      System.out.println("|Estoque: " + produto.getEstoque()+"\n");
		    }
		    System.out.println("------------------------------------");
	  }

	  public void mostrarRelatorioCompleto(){
		System.out.println("\n------------------------------------");
		System.out.println("Relatório Completo da Loja Gomes");
		
	    for(Vendedor vendedor : vendedores){
	      vendedor.mostrarRelatorio();
	    }
	    mostrarQuantidadeTotalVendida();
	    mostrarValorTotalVendido();
	  }

	 
	  public void mostrarQuantidadeTotalVendida(){
		    int qtdTotalVendida = 0;
		    System.out.println("-----------------------------------------------------");
		    
		    for(Vendedor vendedor : vendedores){
		      qtdTotalVendida += vendedor.getQuantidadeTotalVendida();
		    }
		    System.out.println("Quantidade total de produtos vendidos pela loja: " + qtdTotalVendida);
		  }
		  

	  public void mostrarValorTotalVendido(){
	    float valorTotal = 0.0F;
	    
	    for(Vendedor vendedor : vendedores){
	      valorTotal += vendedor.getValorTotalVendido();
	    }
	    System.out.println("Valor total vendido pelos vendodores: " + valorTotal);
	    System.out.println("-----------------------------------------------------");
	  }
}
