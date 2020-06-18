package br.com.fiap.owl.model;

public class Cadastro {
    private BancoDeDados dados;
    private Usuario usuario;

    public Cadastro(BancoDeDados dados, Usuario usuario) {
        this.dados = dados;
        this.usuario = usuario;
    }

    public Usuario cadastrarNomeEmailSenha() {
        if(usuario.isNome() && usuario.isEmail() && usuario.isSenha()) {
            Usuario usuarioCadastrado = dados.adicionaUsuario(usuario);
            if(usuarioCadastrado != null) {
                System.out.println(" ");
                System.out.println(usuario.getEmail());
                System.out.println("Usuario cadastrado com sucesso!");
                return usuarioCadastrado;
            }
        }
        return null;
    }
}
