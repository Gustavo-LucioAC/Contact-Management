import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

public class GerenciadorContatos {

    private ArrayList<Contato> listaContatos;
    private TreeMap<Contato, Contato> contatosOrdenados;

    // Construtor com comparador personalizado
    public GerenciadorContatos(Comparator<Contato> comparator) {
        this.listaContatos = new ArrayList<>();
        this.contatosOrdenados = new TreeMap<>(comparator);
    }

    public void adicionarContato(Contato contato) {
        try {
            if (contato == null || contatosOrdenados.containsKey(contato)) {
                throw new IllegalArgumentException("Contato inválido ou já existente.");
            }
            listaContatos.add(contato);
            contatosOrdenados.put(contato, contato);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar contato: " + e.getMessage());
        }
    }

    public void removerContato(String nome) {
        try {
            Contato contato = new BuscarPorNome().buscar(nome);
            if (contato != null) {
                listaContatos.remove(contato);
                contatosOrdenados.remove(contato);
                System.out.println("Contato " + nome + " removido com sucesso.");
            } else {
                throw new Exception("Contato com o nome " + nome + " não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao remover contato: " + e.getMessage());
        }
    }

    public void listarContatosPorIndice() {
        if (listaContatos.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
        } else {
            listaContatos.forEach(System.out::println);
        }
    }

    public void listarContatosOrdenados() {
        if (contatosOrdenados.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
        } else {
            contatosOrdenados.values().forEach(System.out::println);
        }
    }

    // Classe interna para busca por nome
    private class BuscarPorNome {
        public Contato buscar(String nome) {
            return contatosOrdenados.values().stream()
                    .filter(contato -> contato.getNome().equalsIgnoreCase(nome))
                    .findFirst()
                    .orElse(null);
        }
    }

    // Classe interna para busca por telefone
    private class BuscarPorTelefone {
        public Contato buscar(String telefone) {
            return listaContatos.stream()
                    .filter(contato -> contato.getTelefones().contains(telefone))
                    .findFirst()
                    .orElse(null);
        }
    }

    public Contato buscarPorTelefone(String telefone) {
        try {
            Contato contato = new BuscarPorTelefone().buscar(telefone);
            if (contato != null) {
                System.out.println("Contato encontrado: " + contato);
            } else {
                throw new Exception("Nenhum contato encontrado com o telefone " + telefone);
            }
            return contato;
        } catch (Exception e) {
            System.out.println("Erro na busca por telefone: " + e.getMessage());
            return null;
        }
    }
}