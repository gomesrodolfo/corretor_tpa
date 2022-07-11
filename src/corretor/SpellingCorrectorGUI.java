
import corretor.Palavra;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SpellingCorrectorGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JTextField jtfPalavra = null;
    private JButton jbtCorregir = null;
    private JButton jbtLimpar = null;
    private JLabel jlbTitulo = null;
    private JButton jbtSair = null;
    private JLabel jlbExemplo = null;

    private JTextField getJtfPalavra() {
        if (jtfPalavra == null) {
            jtfPalavra = new JTextField();
            jtfPalavra.setBounds(new Rectangle(23, 122, 312, 27));
        }
        return jtfPalavra;
    }

    private JButton getJbtCorregir() {
        if (jbtCorregir == null) {
            jbtCorregir = new JButton();
            jbtCorregir.setBounds(new Rectangle(339, 122, 142, 27));
            jbtCorregir.setText("Corrigir");
            jbtCorregir.setToolTipText("Corretor");
            jbtCorregir.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jbtCorregir.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {

                    String caminhoDicionario = "dict/pt2.txt";

                    Spelling spelling = null;
//                    Palavra palavra = null;
                    try {
                        spelling = new Spelling(caminhoDicionario);
                    } catch (IOException e1) {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "ERROR: "
                                + e1, "Spelling Corrector",
                                JOptionPane.ERROR_MESSAGE);
                        e1.printStackTrace();
                    }

                    String word = "";

                    while ((word = jtfPalavra.getText().trim()) != null) {
                        System.out.println(word);
//                        palavra = new Palavra(palavra.getCodigo(), word);
                        String[] correct = spelling.correct(word);

                        if (correct == null) {
                            Toolkit.getDefaultToolkit().beep();
                            JOptionPane
                                    .showMessageDialog(
                                            null,
                                            "Sem sugestões e/ou palavra correta.",
                                            "Spelling Corrector",
                                            JOptionPane.INFORMATION_MESSAGE);
                            break;

                        } else {
                            JOptionPane.showMessageDialog(null,
                                    correct, "Você quis dizer: ",
                                    JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }
                }
            });
        }
        return jbtCorregir;
    }

    private JButton getjbtLimpar() {
        if (jbtLimpar == null) {
            jbtLimpar = new JButton();
            jbtLimpar.setBounds(new Rectangle(485, 122, 74, 27));
            jbtLimpar.setText("Limpar");
            jbtLimpar.setToolTipText("Limpar");
            jbtLimpar.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jbtLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent e) {

                    jtfPalavra.setText("");
                }
            });
        }
        return jbtLimpar;
    }

    private JButton getJbtSair() {
        if (jbtSair == null) {
            jbtSair = new JButton("<html><font color='RED'>X</font></html>");
            jbtSair.setBounds(new Rectangle(523, 4, 43, 26));
            jbtSair.setToolTipText("Sair");
            jbtSair.setContentAreaFilled(false);
            jbtSair.setFocusPainted(false);
            jbtSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jbtSair.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent e) {

                    System.exit(0);
                }
            });
        }
        return jbtSair;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SpellingCorrectorGUI thisClass = new SpellingCorrectorGUI();
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setVisible(true);
            }
        });
    }

    public SpellingCorrectorGUI() {
        super();
        initialize();
    }

    private void initialize() {
        this.setSize(585, 219);
        this.setContentPane(getJContentPane());
        this.setTitle("Corretor");
        // Tamanho fixo do programa, sem alteção
        // this.setResizable(false);
        // Deixa o programa no meio da tela, centralizado
        this.setLocationRelativeTo(null);
        // Tira a borda da Janela
        this.setUndecorated(true);
    }

    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jlbExemplo = new JLabel();
            jlbExemplo.setBounds(new Rectangle(23, 97, 314, 23));
            jlbExemplo.setForeground(Color.WHITE);
            jlbExemplo.setText(" Exemplo: ameendooim");

            jlbTitulo = new JLabel();
            jlbTitulo.setBounds(new Rectangle(88, 4, 409, 38));
            jlbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
            jlbTitulo.setFont(new Font("Arial", Font.BOLD, 28));
            jlbTitulo.setForeground(Color.WHITE);
            jlbTitulo.setText("Corrigir");

            jContentPane = new JPanel();
            jContentPane.setLayout(null);

            // Aplica a cor preta no formulário
            jContentPane.setBackground(new Color(0, 0, 0));
            jContentPane.add(getJtfPalavra(), null);
            jContentPane.add(getJbtCorregir(), null);
            jContentPane.add(getjbtLimpar(), null);
            jContentPane.add(jlbTitulo, null);
            jContentPane.add(getJbtSair(), null);
            jContentPane.add(jlbExemplo, null);
        }
        return jContentPane;
    }
}
