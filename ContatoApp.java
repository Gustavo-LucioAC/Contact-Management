import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import javax.swing.*;

public class ContatoApp extends JFrame {

    private GerenciadorContatos gerenciador;
    private JTextField nomeField;
    private JTextField emailField;
    private JTextField telefoneField;
    private JTextArea outputArea;

    public ContatoApp() {
        setTitle("Gerenciador de Contatos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gerenciador = new GerenciadorContatos(Comparator.comparing(Contato::getNome));

        // Painel para entrada de dados
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        inputPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        inputPanel.add(nomeField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        inputPanel.add(new JLabel("Telefone:"));
        telefoneField = new JTextField();
        inputPanel.add(telefoneField);

        // Painel para botões
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 5, 5));

        JButton addButton = new JButton("Adicionar Contato");
        addButton.addActionListener(new AdicionarContatoAction());
        buttonPanel.add(addButton);

        JButton removeButton = new JButton("Remover Contato");
        removeButton.addActionListener(new RemoverContatoAction());
        buttonPanel.add(removeButton);

        JButton searchButton = new JButton("Buscar por Telefone");
        searchButton.addActionListener(new BuscarContatoAction());
        buttonPanel.add(searchButton);

        JButton listButton = new JButton("Listar Contatos");
        listButton.addActionListener(new ListarContatosAction());
        buttonPanel.add(listButton);

        // Área de saída para mostrar os resultados
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        // Layout principal
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);
    }

    // Ação para adicionar contato
    private class AdicionarContatoAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = nomeField.getText();
            String email = emailField.getText();
            String telefone = telefoneField.getText();

            try {
                Contato contato = new Contato(nome, email);
                contato.adicionarTelefone(telefone);
                gerenciador.adicionarContato(contato);
                outputArea.append("Contato adicionado: " + contato + "\n");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(ContatoApp.this, "Erro: " + ex.getMessage());
            }
        }
    }

    // Ação para remover contato
    private class RemoverContatoAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = nomeField.getText();
            gerenciador.removerContato(nome);
            outputArea.append("Tentativa de remoção do contato com nome: " + nome + "\n");
        }
    }

    // Ação para buscar contato por telefone
    private class BuscarContatoAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String telefone = telefoneField.getText();
            Contato contato = gerenciador.buscarPorTelefone(telefone);
            if (contato != null) {
                outputArea.append("Contato encontrado: " + contato + "\n");
            } else {
                outputArea.append("Nenhum contato encontrado com o telefone: " + telefone + "\n");
            }
        }
    }

    // Ação para listar todos os contatos
    private class ListarContatosAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            outputArea.setText("Contatos em ordem de inserção:\n");
            gerenciador.listarContatosPorIndice();
            outputArea.append("Contatos listados.\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ContatoApp app = new ContatoApp();
            app.setVisible(true);
        });
    }
}