import java.util.Scanner;

public class menu {
    Scanner sc=new Scanner(System.in);
    int opt=0;
    public static void menuInicial(){
        System.out.println("-Menu inicial-");
        System.out.println("1- Ver contas cadastradas");
        System.out.println("2- Selecionar uma conta");
        System.out.println("3- Cadastrar nova conta");
        System.out.println("4- Excluir conta");
        System.out.println("5- Sair");
    }

    public static void menuSelec(){
        System.out.println("--Menu--");
        System.out.println("1- Ver informações da conta");
        System.out.println("2- Depositar");
        System.out.println("3- Sacar");
        System.out.println("4- Alterar informação");
        System.out.println("5- Sair");
    }

    public static void menuAlt(){
        System.out.println("1- Codigo da Agência");
        System.out.println("2- Nome");
    }
}
