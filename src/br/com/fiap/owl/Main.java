package br.com.fiap.owl;
import br.com.fiap.owl.model.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BancoDeDados bancoDeDados = new BancoDeDados();
        Usuario usuarioLogado = null;

        Scanner input = new Scanner(System.in).useDelimiter("\n");

        while(true) {
            System.out.println(" ");
            System.out.println("Bem vindo ao The Owl!");
            System.out.println(" ");

            System.out.println("Ola, voce ja possui um cadastro?");
            System.out.println(" ");
            System.out.println("1 - sim");
            System.out.println("2 - nao");
            int a = input.nextInt();
            if(a == 1) {
                System.out.println(" ");
                System.out.println("Digite o seu email:");
                String email = input.next();
                System.out.println(" ");
                System.out.println("Digite a sua senha:");
                String senha = input.next();
                Usuario usuario = new Usuario(email, senha);
                Login login = new Login(bancoDeDados, usuario);
                usuarioLogado = login.logarEmailSenha();
            } else if(a == 2) {
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
                System.out.println("O que deseja fazer?");
                System.out.println("1 - fazer um pedido");
                System.out.println("2 - consultar um pedido");
                System.out.println("3 - consultar um pedido");
                System.out.println("4 - minha conta");
                System.out.println("5 - sair");
                System.out.println(" ");
                switch (input.nextInt()) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
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

    }
}
}
