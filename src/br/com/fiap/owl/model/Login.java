package br.com.fiap.owl.model;

public class Login {
    private BancoDeDados dados;
    private Usuario usuario;

    public Login(BancoDeDados dados, Usuario usuario) {
        this.dados = dados;
        this.usuario = usuario;
    }

    public Usuario logarEmailSenha() {
        if(usuario.isEmail() && usuario.isSenha()) {
            Usuario usuarioLogado = dados.consultaEmailSenha(usuario.getEmail(), usuario.getSenha());
            if(usuarioLogado != null) {
                System.out.println(" ");
                System.out.println(usuario.getEmail());
                System.out.println("Login autorizado!");
                return usuarioLogado;
            }
        }
        return null;
    }
}
