import java.util.ArrayList;
//import java.util.List;

public class CarrinhoDeCompras {
	double valorTotalV=0;

	ArrayList<Item> itemCarrinho = new ArrayList<Item>();
	public void addItem(Item item){
		// Adiciona um item no carrinho
		itemCarrinho.add(item);
	}


	public void removeItem(int pos){
		// Remove um item no carrinho	
		if (pos<itemCarrinho.size()){
			System.out.println("Item Removido: "+itemCarrinho.get(pos-1).nome);
			itemCarrinho.remove(pos-1);
		}
		else{
			System.out.println("Posição Inválida!");
		}
		
	}

	public double valorTotal(){
		// Retorna o valor de todos os itens do carrinho	
		valorTotalV=0;
		for(int i=0; i<itemCarrinho.size(); i++){
			valorTotalV=valorTotalV+itemCarrinho.get(i).valor;
		}	
		return valorTotalV;
	}

	public void imprimirCarrinho(){
		// Imprime todos os itens do carrinho	
		if (itemCarrinho.size()<=0){
			System.out.println("Carrinho vazio!");
		}
		else{
			for(int i=0; i < itemCarrinho.size(); i++){
				System.out.println("Item "+i+": "+itemCarrinho.get(i).nome+" R$: "+ itemCarrinho.get(i).valor);
			}
		}
	
	}

	
}
