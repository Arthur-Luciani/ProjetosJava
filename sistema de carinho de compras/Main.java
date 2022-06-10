public class Main {

	public static void main(String[] args) {

		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		
		carrinho.imprimirCarrinho();

		Item item1 = new Item(5, "Leite");
		Item item2 = new Item(9.5, "Café");
		Item item3 = new Item(7, "Queijo");
		Item item4 = new Item(6.5, "Presunto");

		
		carrinho.addItem(item1);
		carrinho.addItem(item2);
		carrinho.addItem(item3);
		carrinho.addItem(item4);
		
		System.out.println("Valor da Compra R$ "+ carrinho.valorTotal());
		
		carrinho.removeItem(10);
		carrinho.removeItem(2);
		
		carrinho.imprimirCarrinho();
		System.out.println("Valor da Compra R$ "+ carrinho.valorTotal());

	}

}
//SAIDA ESPERADA
//Carrinho Vazio!
//Item 1: Leite R$: 5.0
//Item 2: Café R$: 9.5
//Item 3: Queijo R$: 7.0
//Item 4: Presunto R$: 6.5
//Valor da Compra R$ 28.0
//Posição Inválida!
//Item Removido: Café
//Item 1: Leite R$: 5.0
//Item 2: Queijo R$: 7.0
//Item 3: Presunto R$: 6.5
//Valor da Compra R$ 18.5
