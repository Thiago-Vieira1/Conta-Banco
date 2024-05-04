# Aplicação de Conta Bancária em Java
Esta é uma aplicação Java que simula o funcionamento de uma conta bancária, com a capacidade de armazenar informações de clientes e transações em um banco de dados MySQL.

# Funcionalidades Principais:
Cadastro de Clientes: Permite registrar novos clientes com informações como nome, número da conta e saldo inicial.
Depósitos e Saques: Os clientes podem realizar depósitos e saques em suas contas, atualizando automaticamente o saldo.
Consulta de Saldo: Os clientes podem verificar o saldo atual de suas contas.

# Tecnologias Utilizadas:
Java: A aplicação é desenvolvida em Java, garantindo portabilidade e facilidade de manutenção.
MySQL: O banco de dados MySQL é utilizado para armazenar informações de clientes e transações.
JDBC (Java Database Connectivity): O JDBC é usado para estabelecer a conexão entre a aplicação Java e o banco de dados MySQL.

# Como Usar:
Configuração do Banco de Dados: Antes de executar a aplicação, é necessário configurar um banco de dados MySQL. Você pode usar o script fornecido (script.sql) para criar a estrutura do banco de dados e tabelas necessárias.
Configuração da Conexão: Edite o arquivo de configuração (config.properties) para especificar as credenciais do banco de dados (URL, nome de usuário e senha).
Compilação e Execução: Compile o código-fonte Java e execute o programa. Certifique-se de incluir o conector JDBC do MySQL no classpath.
Interagindo com o Programa: Siga as instruções do programa para realizar operações como cadastro de clientes, depósitos, saques e consulta de saldo.
