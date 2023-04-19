package LojaGomes;

public class App {
	public static void main(String[] args) {
	    Loja loja = new Loja("Papelaria Gomes");
	    Produto caneta = new Produto("Caneta", "Azul", 3.00F, 25);
	    Produto caderno = new Produto("Caderno", "96 folhas", 25.00F, 20);
	    Produto lapis = new Produto("Lápis", "HB", 1.00F, 5);
	    Vendedor vendedor1 = new Vendedor(1, "Manoel Gomes");
	    Vendedor vendedor2 = new Vendedor(2, "João Gomes");
	    Vendedor vendedor3 = new Vendedor(3, "Ciro Gomes");
	    
	    
	    //adiciona o produto no ArrayList produtos de loja
	    loja.addProduto(caneta);
	    loja.addProduto(caderno);
	    loja.addProduto(lapis);
	    //adiciona o vendedor no ArrayList vendedores de loja
	    loja.addVendedor(vendedor1);
	    loja.addVendedor(vendedor2);
	    loja.addVendedor(vendedor3);
	    
	    loja.mostrarEstoque();
	    loja.registrarVenda(vendedor1, caneta, 5);
	    loja.registrarVenda(vendedor1, caderno, 2);
	    loja.registrarVenda(vendedor2, lapis, 3);
	    loja.registrarVenda(vendedor3, lapis, 2);
	    loja.registrarVenda(vendedor1, caneta, 10);
	    loja.registrarVenda(vendedor2, caderno, 9);
	    loja.registrarVenda(vendedor1, lapis, 1);
	    loja.registrarVenda(vendedor3, caderno, 2);
	    loja.registrarVenda(vendedor3, caneta, 2);

	    loja.mostrarEstoque();
	    loja.mostrarRelatorioCompleto();
	  }
}
