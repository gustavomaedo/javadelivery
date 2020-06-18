package br.com.fiap.owl.model;

public class MinhaConta {
    private Usuario usuario;

    public MinhaConta(Usuario usuario) {
        this.usuario = usuario;
    }

    public void exibirNome() {
        if(usuario.isNome()) {
            System.out.println(" ");
            System.out.print("Nome: ");
            System.out.println(usuario.getNome());
        }
    }

    public void exibirEmail() {
        if(usuario.isEmail()) {
            System.out.println(" ");
            System.out.print("Email: ");
            System.out.println(usuario.getEmail());
        }
    }
}
