create database conta;

use conta;

 create table conta (codConta INT PRIMARY KEY AUTO_INCREMENT NOT NULL, codAgenc INT NOT NULL, nome varchar(50) NOT NULL, saldo DECIMAL(10,2));