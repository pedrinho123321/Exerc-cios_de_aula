package redesocial;

import java.util.HashSet;
import java.util.Set;
import excecoes.RedeSocialException;
// Classe Usuario que utiliza as redes sociais
class Usuario {
    private String nome;
    private String email;
    private Set<RedeSocial> redesSociais;

    // Construtor com parâmetros
    public Usuario(String nome, String email, RedeSocial... redes) {
        this.nome = nome;
        this.email = email;
        this.redesSociais = new HashSet<>();
        for (RedeSocial rede : redes) {
            this.redesSociais.add(rede);
        }
    }

    // Métodos para interagir com as redes sociais
    public void usarRedesSociais() throws RedeSocialException {
        for (RedeSocial rede : redesSociais) {
            rede.postarFoto();
            rede.postarVideo();
        }
    }

}