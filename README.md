# Projetolasa


Projeto desenvolvido na IDE Eclipse com o Maven e Springboot

Este projeto provê Webservices para simular a execução de um sistema web. Este sistema faz um CRUD baseado nos endpoints

## Instruções de uso:

- ### Back-end

Para executar o projeto standalone deverá ir na pasta do projeto e executar o comando: `mvn package`, ir na pasta target do projeto e executar o arquivo JAR gerado com o seguinte comando: `java -jar br.com.ulisses-1.0.0-SNAPSHOT.jar`.

O projeto faz persistência de dados no banco Mysql para baixá-lo: https://dev.mysql.com/downloads/mysql/ .
Instalar o Mysql com o login e senha **root**, caso já esteja com o MySql instalado, alterar o login e senha na classe localizada no pacote com.ulisses.persistence.Dao no método open.

Abaixo segue o comando SQL para execução do banco:

`create database produtos;`

`create table produto (codigo int primary key auto_increment,
                       nome varchar(50), 
                       preco numeric(12,2),
                       estado varchar(2),
                       foto longtext);`
                       

- ### Front-end

O Front-end foi desenvolvido usando o script create-react-app, pois já monta a estrutura do que é necessário para o projeto ReactJs funcionar. Nesse caso ele executará com o NodeJS, usando o comando `npm start` dentro da pasta do projeto.
O projeto front-end está compactado dentro da pasta chamada Frontend no projeto java, deverá ser copiado para uma pasta fora do projeto, por exemplo: para uma pasta na área de trabalho, depois deverá descompactar o arquivo.
No terminal ou CMD, ir no diretório do projeto e executar o comando `npm start` para subir o sistema.

Obs.:  Executar o projeto java spring e React na mesma máquina.

