package excecoes;

// Classes de exceção
public class RedeSocialException extends Exception {
    public RedeSocialException(String mensagem) {
        super(mensagem);
    }
}

class AutenticacaoException extends RuntimeException {
    public AutenticacaoException(String mensagem) {
        super(mensagem);
    }
}