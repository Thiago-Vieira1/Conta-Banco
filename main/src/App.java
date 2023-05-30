import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc=new Scanner(System.in);
        acoesConta c1=new acoesConta();
        int opt=0,cod=0;
       
        do{
            //menu incial
            menu.menuInicial();
            opt=sc.nextInt();
            
            switch(opt){
                case 1:
                    c1.verContas();
                    break;

                case 2:
                    System.out.print("Selecione o codigo da sua conta: ");
                    cod=sc.nextInt();
                    c1.setCodConta(cod);
                    c1.setCod(cod);

                    do{
                        //menu para selecionar a conta
                        menu.menuSelec();
                        opt=sc.nextInt();
                        
                        switch(opt){

                            case 1:
                                c1.consultConta();
                                break;
                                
                            case 2:
                                c1.depositarSaldo();
                                break;

                            case 3:
                                c1.retirarSaldo();
                                break;

                            case 4:
                                c1.altInfor();
                                break;
                            }
                        }while(opt<5);
                    break;

                case 3:
                    c1.criarConta();
                    break;

                case 4:
                    c1.excluirConta();
                    break;

            }
        }while(opt<5);

        System.out.println("Obrigado por utilizar meu programa!!");
        sc.close();
    }
}
