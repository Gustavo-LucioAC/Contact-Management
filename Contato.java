import java.util.HashSet;

public class Contato {

    private String nome;
    private HashSet<String> telefones;
    private String email;

    public Contato(String nome, String email) {
        if (!validarNome(nome)) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        if (!validarEmail(email)) {
            throw new IllegalArgumentException("Email inválido.");
        }
        this.nome = nome;
        this.email = email;
        this.telefones = new HashSet<>();
    }

    public boolean adicionarTelefone(String telefone) {
        if (telefone == null || telefone.isEmpty()) {
            System.out.println("Telefone inválido.");
            return false;
        }
        return telefones.add(telefone);
    }

    private boolean validarNome(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }

    private boolean validarEmail(String email) {
        return email != null && email.contains("@");
    }

    public String getNome() {
        return nome;
    }

    public HashSet<String> getTelefones() {
        return telefones;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefones: " + telefones + ", Email: " + email;
    }
}