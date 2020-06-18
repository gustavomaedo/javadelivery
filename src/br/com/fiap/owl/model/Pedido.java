package br.com.fiap.owl.model;

public class Pedido {
    private Usuario usuario;
    private String codigoRastreio;
    private String conteudo;
    private String localRetirada;
    private String localEntrega;
    private double precoEntrega;
    private boolean statusPendente;

    public Pedido(
            Usuario usuario,
            String conteudo,
            String localRetirada,
            String localEntrega,
            double precoEntrega
    ) {
        this.usuario = usuario;
        this.conteudo = conteudo;
        this.localRetirada = localRetirada;
        this.localEntrega = localEntrega;
        this.precoEntrega = precoEntrega;
        this.statusPendente = true;
    }

    public String getCliente() {
        return usuario.getNome();
    }

    public String getCodigoRastreio() {
        return codigoRastreio;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getLocalRetirada() {
        return localRetirada;
    }

    public String getLocalEntrega() {
        return localEntrega;
    }

    public double getPrecoEntrega() {
        return precoEntrega;
    }

    public String getStatus() {
        if(statusPendente) {
            return "Pendente";
        } else {
            return "Entregue";
        }
    }

    public void adicionarCodigo(String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }

    public void entregue() {
        statusPendente = false;
    }
}
