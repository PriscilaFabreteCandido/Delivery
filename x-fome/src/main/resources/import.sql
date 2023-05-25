insert into categoria(nome) values ('Sobremesa'), ('Bebidas'), ('Hamburguers');

insert into status(nome) values ('Pendente'), ('Aceito'), ('Retirada na loja'), ('Pedido rejeitado'), ('Entregue'), ('A caminho'), ('Em processamento');
insert into produto(ingredientes, nomeProduto, preco, idCategoria) 
values ('Pão, Bifé, Bacon', 'X-Bacon', 15, 3), 
	   ('Pão, Bifé, Ovo', 'X-Ovo', 13, 3),
       (null, 'Coca Cola', 5, 2),
       ('Leite em pó, Açaí, Leite Condesado', 'Açaí 500ml', 15, 1),
       ('Leite em pó, Açaí, Leite Condesado', 'Açaí 1LS', 15, 1);
-- insert into usuario(cep, cidade, cpf, email, endereco, isCliente, nomeUsuario, senha) values ('27000-00', 'Colatina', '111.222.333-89', 'funcionario@gmail.com', 'Rua tal', 0, 'Fulano', '123');