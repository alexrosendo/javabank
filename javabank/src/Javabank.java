import java.util.Date;
import java.util.Scanner;

public class Javabank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int escolha;
        int opcao;
        int tipoConta = 0;
        String nomeCliente;

        Cliente c1;
        Cliente c2;
        Conta cc = null;
        Conta poupanca = null;

        System.out.println("Bem vindo ao JavaBank");
        System.out.println("Antes de tudo, qual o seu nome? ");
        String nome = scan.nextLine();
        System.out.println();
        System.out.println("Bem vindo ao JavaBank, "+nome);
        System.out.println();
        System.out.println("Qual operação você deseja realizar?");
        System.out.println("1 - Criar nova conta");
        System.out.println("2 - Consultar informações");
        escolha = scan.nextInt();
        System.out.println();

        if(escolha==1){
            System.out.println("Qual o tipo de conta que você deseja criar?");
            System.out.println("1 - Conta Corrente");
            System.out.println("2 - Conta Poupança");
            tipoConta = scan.nextInt();
            System.out.println();
            if (tipoConta==1){
                System.out.println("Qual o nome que sua conta devera ter?");
                nomeCliente = String.valueOf(scan.nextLine());

                c1 = new Cliente();
                c1.setNome(nomeCliente);

                cc = new ContaCorrente(c1);

                System.out.println("A conta de "+nomeCliente+" foi criada com sucesso");
            }if (tipoConta==2){
                System.out.println("Qual o nome que sua conta devera ter?");
                nomeCliente = scan.nextLine();

                c2 = new Cliente();
                c2.setNome(nomeCliente);

                poupanca = new ContaPoupanca(c2);

                System.out.println("A conta de "+nomeCliente+" foi criada com sucesso");
            }else{
                System.out.println("Entrada incorreta, por segurança reinicie o processo!");
            }
        }if (escolha==2){
            System.out.println();
            System.out.println("JavaBank - 2022");
            System.out.println("Todos os direitos reservados");
        }else{
            System.out.println("Entrada incorreta, por segurança reinicie o processo!");
        }

        System.out.println("Agora que você já criou sua conta, qual operação deseja realizar? ");
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Transferir");
        System.out.println("4 - Imprimir Extrato");
        opcao = scan.nextInt();
        System.out.println();

        if(opcao==1){
            System.out.println("Qual o valor que deseja depositar");
            double value = Double.parseDouble(scan.nextLine());
            if (tipoConta==1){
                cc.depositar(value);
                System.out.println();
                System.out.println("VALOR DEPOSITADO COM SUCESSO!");
            }if (tipoConta==2){
                poupanca.depositar(value);
                System.out.println();
                System.out.println("VALOR DEPOSITADO COM SUCESSO!");
            }
        }if(opcao==2){
            System.out.println("Qual o valor que deseja sacar");
            double value = Double.parseDouble(scan.nextLine());
            if (tipoConta==1){
                if (value<= cc.saldo){
                    cc.sacar(value);
                    System.out.println();
                    System.out.println("VALOR SACADO COM SUCESSO!");
                }else{
                    System.out.println("Você tentou sacar uma quantia inexistente nesta conta, por segurança reinicie o processo!");
                }

            }if (tipoConta==2){
                if (value<= poupanca.saldo){
                    poupanca.sacar(value);
                    System.out.println();
                    System.out.println("VALOR SACADO COM SUCESSO!");
                }else{
                    System.out.println("Você tentou sacar uma quantia inexistente nesta conta, por segurança reinicie o processo!");
                }
            }
        }if(opcao==3){
            System.out.println("Qual o valor que deseja transferir");
            double value = Double.parseDouble(scan.nextLine());
            System.out.println("para qual conta deseja transferir");
            Double acount = Double.parseDouble(scan.nextLine());
            if (tipoConta==1){
                if (value<= cc.saldo){
                    cc.transferir(value, poupanca);
                    System.out.println();
                    System.out.println("VALOR TRANSFERIDO COM SUCESSO!");
                }else{
                    System.out.println("Você tentou transferir uma quantia inexistente nesta conta, por segurança reinicie o processo!");
                }

            }if (tipoConta==2){
                if (value<= poupanca.saldo){
                    poupanca.transferir(value, cc);
                    System.out.println();
                    System.out.println("VALOR TRANSFERIDO COM SUCESSO!");
                }else{
                    System.out.println("Você tentou transferir uma quantia inexistente nesta conta, por segurança reinicie o processo!");
                }
            }
        }if(opcao==4){
            if (tipoConta==1){
                cc.imprimirExtrato();
                Date data = new Date();
                System.out.println("Data Transação: "+data);
            }if (tipoConta==2){
                poupanca.imprimirExtrato();
                Date data = new Date();
                System.out.println("Data Transação: "+data);
            }
        }

    }
}
