package br.com.fiap.owl;
import br.com.fiap.owl.model.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        Usuario usuarioLogado = null;

        Scanner input = new Scanner(System.in).useDelimiter("\n");

        do {
            System.out.println(" ");
            System.out.println("Bem vindo ao The Owl!");
            System.out.println(" ");

            System.out.println("Ola, voce ja possui um cadastro?");
            System.out.println(" ");
            System.out.println("1 - sim");
            System.out.println("2 - nao");
            int a = numero(input.next());
            if (a == 1) {
                System.out.println(" ");
                System.out.println("Digite o seu email:");
                String email = input.next();
                System.out.println(" ");
                System.out.println("Digite a sua senha:");
                String senha = input.next();
                Usuario usuario = new Usuario(email, senha);
                Login login = new Login(bancoDeDados, usuario);
                usuarioLogado = login.logarEmailSenha();
            } else if (a == 2) {
                System.out.println(" ");
                System.out.println("Siga os passos abaixo para cadastrar!");
                System.out.println(" ");
                System.out.println("Digite o seu nome:");
                String nome = input.next();
                System.out.println(" ");
                System.out.println("Digite o seu email:");
                String email = input.next();
                System.out.println(" ");
                System.out.println("Digite a sua senha:");
                String senha = input.next();
                Usuario usuario = new Usuario(nome, email, senha);
                Cadastro cadastro = new Cadastro(bancoDeDados, usuario);
                usuarioLogado = cadastro.cadastrarNomeEmailSenha();
            }

            while (usuarioLogado != null) {
                System.out.println(" ");
                System.out.println("O que deseja fazer?");
                System.out.println("1 - fazer um pedido");
                System.out.println("2 - consultar um pedido");
                System.out.println("3 - finalizar a entrega");
                System.out.println("4 - minha conta");
                System.out.println("5 - sair");
                System.out.println(" ");
                switch (numero(input.next())) {
                    case 1:
                        System.out.println(" ");
                        System.out.println("Siga os passos abaixo para cadastrar o pedido!");
                        System.out.println(" ");
                        System.out.println("Digite o produto, o conteudo a ser entregue:");
                        String conteudo = input.next();
                        System.out.println(" ");
                        System.out.println("Digite o o endereco de retirada:");
                        String localRetirada = input.next();
                        System.out.println(" ");
                        System.out.println("Digite o destino da entrega:");
                        String localEntrega = input.next();
                        System.out.println(" ");
                        System.out.println("Digite o valor do frete:");
                        double precoEntrega = numeroDouble(input.next());
                        Pedido pedidoNovo = new Pedido(usuarioLogado, conteudo, localRetirada, localEntrega, precoEntrega);
                        Pedido pedidoAdiciona = bancoDeDados.adicionaPedido(pedidoNovo);
                        if(pedidoAdiciona != null) {
                            System.out.println(" ");
                            System.out.println("O pedido foi cadastrado com sucesso!");
                            System.out.println("O numero de rastreio é:");
                            System.out.println(pedidoAdiciona.getCodigoRastreio());
                        }
                        break;
                    case 2:
                        System.out.println(" ");
                        System.out.println("Digite o codigo de rastreio:");
                        String codigoConsulta = input.next();
                        Pedido pedidoConsulta = bancoDeDados.consultaPedido(codigoConsulta);
                        if(pedidoConsulta != null) {
                            System.out.println(" ");
                            System.out.print("Informacoes do pedido ");
                            System.out.print(pedidoConsulta.getCodigoRastreio());
                            System.out.println(":");
                            System.out.println(" ");
                            System.out.print("Cliente: ");
                            System.out.println(pedidoConsulta.getCliente());
                            System.out.print("Conteudo: ");
                            System.out.println(pedidoConsulta.getConteudo());
                            System.out.print("Remetente: ");
                            System.out.println(pedidoConsulta.getLocalRetirada());
                            System.out.print("Destinatario: ");
                            System.out.println(pedidoConsulta.getLocalEntrega());
                            System.out.print("Frete: ");
                            System.out.println(pedidoConsulta.getPrecoEntrega());
                            System.out.print("Status: ");
                            System.out.println(pedidoConsulta.getStatus());
                        }
                        break;
                    case 3:
                        System.out.println(" ");
                        System.out.println("Digite o codigo de rastreio:");
                        String codigoEntregue = input.next();
                        Pedido pedidoEntregue = bancoDeDados.finalizaPedido(codigoEntregue);
                        if(pedidoEntregue != null) {
                            System.out.println(" ");
                            System.out.print("O pedido ");
                            System.out.print(pedidoEntregue.getCodigoRastreio());
                            System.out.println(" foi entregue!");
                        }
                        break;
                    case 4:
                        MinhaConta minhaConta = new MinhaConta(usuarioLogado);
                        minhaConta.exibirEmail();
                        minhaConta.exibirNome();
                        break;
                    default:
                        usuarioLogado = null;
                        break;
                }
            }

            System.out.println(" ");
            System.out.println("Pressione uma tecla para continuar...");
            input.next();
            System.out.println(" ");

        } while (true);
}

    public static int numero(String str) {
        try {
            return Integer.parseInt(str);
        } catch(NumberFormatException e){
            return 0;
        }
    }

    public static double numeroDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch(NumberFormatException e){
            return 0.0;
        }
    }
}
