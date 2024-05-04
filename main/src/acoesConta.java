import java.util.Scanner;

public class acoesConta extends conta {
    Scanner sc=new Scanner(System.in);
    contaBDD c=new contaBDD();
    CriarBDD criar=new CriarBDD();
    
    //Variaveis
    private int cod=0;
    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
        this.cod = cod;
    }
    private double deposito;
    public double getDeposito() {
        return deposito;
    }
    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }
    private int opt;

    public void exibirSaldo(){
        System.out.println("Seu Saldo é: "+getSaldo());
    }

    //método para depositar o dinheiro
    public void depositarSaldo(){
        conta c=new conta();
        contaBDD.consultSaldo(cod);
        c.setCodConta(cod);
        System.out.print("Quanto você deseja depositar: ");
        deposito=sc.nextInt();
        c.setSaldo(deposito);
        contaBDD.somarSaldo(c);
    }

    //método para sacar o dinheiro
    public void retirarSaldo(){
        conta c=new conta();
        contaBDD.consultSaldo(cod);
        c.setCodConta(cod);
        System.out.print("Quanto você deseja sacar: ");
        deposito=sc.nextInt();
        c.setSaldo(deposito);
        contaBDD.diminuirSaldo(c);
    }

    //método para ver todas as contas no banco de dados
    public void verContas(){
        for(conta co:c.verContas()){
            System.out.println(co);
        }
    }

    //método para ver uma conta no banco de dados
    public void consultConta(){
        conta c=contaBDD.consultConta(cod);
        System.out.println(c);
    }

    //método para criar uma nova conta no banco de dados
    public void criarConta(){
        conta c=new conta();
        System.out.print("Qual o nome: ");
        nome=sc.nextLine();
        c.setNome(nome);
        System.out.print("Qual o codigo da agência: ");
        codAgenc=sc.nextInt();
        c.setCodAgenc(codAgenc);
        c.setSaldo(0);
        contaBDD.inserirConta(c);
    }

    //método para alterar informação da conta no banco de dados
    public void altInfor(){
        conta c=new conta();
        menu.menuAlt();
        c.setCodConta(cod);
        System.out.print("O que você deseja mudar: ");
        opt=sc.nextInt();
        switch(opt){
            case 1:
                System.out.print("Qual o novo número da agência: ");
                codAgenc=sc.nextInt();
                c.setCodAgenc(codAgenc);
                contaBDD.alterarAgencia(c);
                break;
            case 2:
                System.out.print("Qual o novo nome: ");
                sc.nextLine(); // Consumir a nova linha pendente
                nome=sc.nextLine();
                c.setNome(nome);
                contaBDD.alterarNome(c);
                break;
        }
    }

    //método para excluir conta
    public void excluirConta(){
        System.out.print("Qual codigo da conta que você deseja excluir: ");   
        cod=sc.nextInt();
        System.out.println("Você tem certeza que seja excluir a conta do codigo: "+cod+" (1-SIM) (2-NÂO)");
        opt=sc.nextInt();
        if (opt==1){
            contaBDD.excluirConta(cod);
        } else {
            System.out.println("Conta não excluida!!");
        }
    }
    
    //método para criar a tabela no banco de dados
    public void criarTabela(){
        System.out.println("Criando tabela!!");
        criar.criarTabela();
    }
}
