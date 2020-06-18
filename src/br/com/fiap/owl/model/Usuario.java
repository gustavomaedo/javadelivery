package br.com.fiap.owl.model;

public class Usuario {
    private String nome;
    private String email;
    private String senha;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario(String nome, String email, String senha) {
        this(email, senha);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isNome() {
        return !nome.isEmpty();
    }

    public boolean isEmail() {
        return !email.isEmpty();
    }

    public boolean isSenha() {
        return !senha.isEmpty();
    }

    public boolean confirmarSenha(String senha) {
        return this.senha.equals(senha);
    }
}
