import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

public class Principal extends JFrame {

    private JEditorPane editorPagina;
    private JTextField enderecoTxt;

    public Principal() {
        super("Editor de Página");

        editorPagina = new JEditorPane();
        editorPagina.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(editorPagina);

        enderecoTxt = new JTextField(30);

        JButton abrirBtn = new JButton("Abrir");
        abrirBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    editorPagina.setPage(new URL(enderecoTxt.getText()));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(Principal.this, "Erro ao carregar página: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton fecharBtn = new JButton("Fechar");
        fecharBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(enderecoTxt);
        panel.add(abrirBtn);
        panel.add(fecharBtn);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panel, BorderLayout.NORTH);

        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Principal();
    }
}
