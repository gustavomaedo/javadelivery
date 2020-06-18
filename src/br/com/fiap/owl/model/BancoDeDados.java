package br.com.fiap.owl.model;

public class BancoDeDados {
    private Usuario[] usuarios;
    private int totalUsuarios = 0;

    public BancoDeDados() {
        this.usuarios = new Usuario[100];
    }

    public BancoDeDados(int maximoUsuarios) {
        this.usuarios = new Usuario[maximoUsuarios];
    }

    public Usuario adicionaUsuario(Usuario usuario) {
        if(this.totalUsuarios < this.usuarios.length) {
            for (int i = 0; i < this.usuarios.length; i++) {
                if(this.totalUsuarios > 0 && this.usuarios[i].getEmail().equals(usuario.getEmail())) {
                    System.err.println("Email ja cadastrado!");
                    break;
                } else if(this.usuarios[i] == null) {
                    this.usuarios[i] = usuario;
                    this.totalUsuarios += 1;
                    return usuario;
                }
            }
        } else {
            System.err.println("Não é possível adicionar mais usuarios!");
        }
        return null;
    }

    public Usuario consultaEmailSenha(String email, String senha) {
        for(int i = 0; i < this.totalUsuarios; i++) {
            if(this.usuarios[i] != null) {
                if(this.usuarios[i].getEmail().contains(email)) {
                    if(this.usuarios[i].confirmarSenha(senha)) {
                        System.out.println(this.usuarios[i].getNome());
                        System.out.println(this.usuarios[i].getEmail());
                        return usuarios[i];
                    }
                    break;
                }
            }
        }
        System.err.println("Usuario ou senha incorretos!");
        return null;
    }
}
