package br.com.fiap.owl.model;

public class BancoDeDados {
    private Usuario[] usuarios;
    private Pedido[] pedidos;
    private int totalUsuarios = 0;
    private int totalPedidos = 0;
    private int codigoContador = 1;

    public BancoDeDados() {
        this.usuarios = new Usuario[100];
        this.pedidos = new Pedido[100];
    }

    public BancoDeDados(int maximoUsuarios, int maximoPedidos) {
        this.usuarios = new Usuario[maximoUsuarios];
        this.pedidos = new Pedido[maximoPedidos];
    }

    public Usuario adicionaUsuario(Usuario usuario) {
        if(totalUsuarios < usuarios.length) {
            for (int i = 0; i < usuarios.length; i++) {
                if(totalUsuarios > i) {
                    if(usuario.getEmail().equals(usuarios[i].getEmail())) {
                        System.err.println("Email ja cadastrado!");
                        break;
                    }
                } else if(usuarios[i] == null) {
                    usuarios[i] = usuario;
                    totalUsuarios += 1;
                    return usuario;
                }
            }
        } else {
            System.err.println("Não é possível adicionar mais usuarios!");
        }
        return null;
    }

    public Pedido adicionaPedido(Pedido pedido) {
        if(totalPedidos < pedidos.length) {
            for (int i = 0; i < pedidos.length; i++) {
                if(pedidos[i] == null) {
                    pedido.adicionarCodigo("OWL"+String.format("%05d", codigoContador));
                    pedidos[i] = pedido;
                    totalPedidos += 1;
                    codigoContador += 1;
                    return pedido;
                }
            }
        } else {
            System.err.println("Não é possível adicionar mais pedidos!");
        }
        return null;
    }

    public Usuario consultaEmailSenha(String email, String senha) {
        for(int i = 0; i < totalUsuarios; i++) {
            if(usuarios[i] != null) {
                if(usuarios[i].getEmail().equals(email)) {
                    if(usuarios[i].confirmarSenha(senha)) {
                        return usuarios[i];
                    }
                    break;
                }
            }
        }
        System.err.println("Usuario ou senha incorretos!");
        return null;
    }

    public Pedido consultaPedido(String codigoRastreio) {
        for(int i = 0; i < totalPedidos; i++) {
            if(pedidos[i] != null) {
                if(pedidos[i].getCodigoRastreio().contains(codigoRastreio)) {
                    return pedidos[i];
                }
            }
        }
        System.err.println("O pedido nao foi encontrado");
        return null;
    }

    public Pedido finalizaPedido(String codigoRastreio) {
        for(int i = 0; i < totalPedidos; i++) {
            if(pedidos[i] != null) {
                if(pedidos[i].getCodigoRastreio().contains(codigoRastreio)) {
                    pedidos[i].entregue();
                    return pedidos[i];
                }
            }
        }
        System.err.println("O pedido nao foi encontrado");
        return null;
    }
}
