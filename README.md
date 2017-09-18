# Projetolasa


Projeto desenvolvido na IDE Eclipse com o Maven e Springboot

Este projeto provê Webservices para simular a execução de um sistema web. Este sistema faz um CRUD baseado nos endpoints

## Instruções de uso:

- ### Back-end

Importar o projeto no Eclipse como projeto Maven, se executar o projeto pelo eclipse, executar como um aplicação java, pois ele já possui um containter embutido.

Para executar o projeto standalone deverá ir na pasta raiz do projeto no terminal e executar o comando: `mvn package`, ir na pasta target do projeto e executar o arquivo JAR gerado com o seguinte comando: `java -jar br.com.ulisses-1.0.0-SNAPSHOT.jar`.

O projeto faz persistência de dados no banco Mysql para baixá-lo: https://dev.mysql.com/downloads/mysql/ .
Instalar o Mysql com o login e senha **root**, caso já esteja com o MySql instalado, alterar o login e senha na classe localizada no pacote com.ulisses.persistence.Dao no método open.

Abaixo segue o comando SQL para execução do banco:

- Criar o banco
`create database produtos;`

- Acessar o banco
`use produtos;`

- Criar a tabela do sistema
`create table produto (codigo int primary key auto_increment,
                       nome varchar(50), 
                       preco numeric(12,2),
                       estado varchar(2),
                       foto longtext);`
                       

