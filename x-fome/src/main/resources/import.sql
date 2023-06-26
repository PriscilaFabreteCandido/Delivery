insert into categoria(nome) values ('Sobremesa'), ('Bebidas'), ('Hamburguers');

insert into status(nome) values ('Pendente'), ('Aceito'), ('Retirada na loja'), ('Pedido rejeitado'), ('Entregue'), ('A caminho'), ('Em processamento'), ('Pedido Cancelado');

-- insert into usuario(cep, cidade, cpf, email, endereco, isCliente, nomeUsuario, senha) values ('27000-00', 'Colatina', '111.222.333-89', 'funcionario@gmail.com', 'Rua tal', 0, 'Fulano', '123');



insert into  `x-fome-2`.categoria(nome) values ('Sobremesa'), ('Bebidas'), ('Hamburguers');

insert into  `x-fome-2`.status(nome) values ('Pendente'), ('Aceito'), ('Retirada na loja'), ('Pedido rejeitado'), ('Entregue'), ('A caminho'), ('Em processamento'), ('Pedido Cancelado');

insert into  `x-fome-2`.usuario(cep, cidade, cpf, email, endereco, isCliente, nomeUsuario, senha) 
values ('27000-00', 'Colatina', '111.222.333-89', 'funcionario', 'Rua tal', 0, 'Fulano', '123');
insert into  `x-fome-2`.usuario(cep, cidade, cpf, email, endereco, isCliente, nomeUsuario, senha)
 values ('27000-00', 'Colatina', '111.222.333-89', 'pri', 'Rua tal', 1, 'Priscila', '123');
insert into  `x-fome-2`.usuario(cep, cidade, cpf, email, endereco, isCliente, nomeUsuario, senha) 
values ('27000-00', 'Colatina', '111.222.333-89', 'lays', 'Rua tal', 1, 'Lays', '123');

INSERT INTO  `x-fome-2`.Produto (categoria_idCategoria, nomeProduto, ingredientes, preco)
VALUES (1, 'Sorvete de Morango', 'Morangos, açúcar, creme de leite, leite condensado', 8.00 ),
 (1, 'Pudim de Leite', 'Leite, ovos, açúcar, essência de baunilha', 10.00 );


INSERT INTO  `x-fome-2`.Produto (categoria_idCategoria, nomeProduto, ingredientes, preco)
VALUES (2, 'Coca Cola 500ml', null, 8.00 ),
 (2, 'Guaraná 1L', null, 15.00 );
 
INSERT INTO  `x-fome-2`.Produto (categoria_idCategoria, nomeProduto, ingredientes, preco)
VALUES (3, 'Hamburguer de Frango', 'Peito de frango moído, pão de hambúrguer, queijo, alface, tomate',  18.00 ),
 (3, 'Hamburguer Tradicional', 'Carne moída, pão de hambúrguer, queijo, alface, tomate, cebola', 20.00 );