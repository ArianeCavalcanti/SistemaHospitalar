package visao;

import dao.ConvenioDAO;
import dao.PacienteDAO;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Convenio;
import modelo.Paciente;
import servicos.ConvenioServicos;
import servicos.ServicosFactory;

public class GuiCadPaciente extends javax.swing.JInternalFrame {

    /**
     * Creates new form GuiCadPaciente
     */
    public GuiCadPaciente() {
        initComponents();
        preencherCombo();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jlNome = new javax.swing.JLabel();
        jlCpf = new javax.swing.JLabel();
        jlEndereco = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        jtCpf = new javax.swing.JTextField();
        jtEndereco = new javax.swing.JTextField();
        jlEspecialidade = new javax.swing.JLabel();
        jlDataNasc = new javax.swing.JLabel();
        jtDataNasc = new javax.swing.JTextField();
        jtTelefone = new javax.swing.JTextField();
        jlTelefone = new javax.swing.JLabel();
        jlEmail1 = new javax.swing.JLabel();
        jtEmail = new javax.swing.JTextField();
        jlRG = new javax.swing.JLabel();
        jtRG = new javax.swing.JTextField();
        jcConvenio = new javax.swing.JComboBox<>();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jbLimpar = new javax.swing.JButton();
        jbCadastrar1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("CADASTRO PACIENTE");

        jLayeredPane1.setBackground(new java.awt.Color(204, 255, 255));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLayeredPane1.setOpaque(true);

        jlNome.setText("Nome");
        jLayeredPane1.add(jlNome);
        jlNome.setBounds(40, 20, 60, 30);

        jlCpf.setText("CPF");
        jLayeredPane1.add(jlCpf);
        jlCpf.setBounds(40, 60, 90, 30);

        jlEndereco.setText("Endereço");
        jLayeredPane1.add(jlEndereco);
        jlEndereco.setBounds(40, 140, 60, 30);
        jLayeredPane1.add(jtNome);
        jtNome.setBounds(140, 20, 210, 30);
        jLayeredPane1.add(jtCpf);
        jtCpf.setBounds(140, 60, 110, 30);
        jLayeredPane1.add(jtEndereco);
        jtEndereco.setBounds(140, 140, 210, 30);

        jlEspecialidade.setText("Convênio");
        jLayeredPane1.add(jlEspecialidade);
        jlEspecialidade.setBounds(40, 300, 100, 30);

        jlDataNasc.setText("Data Nascimento");
        jLayeredPane1.add(jlDataNasc);
        jlDataNasc.setBounds(40, 260, 100, 30);

        jtDataNasc.setToolTipText("(dd/mm/aaaa)");
        jLayeredPane1.add(jtDataNasc);
        jtDataNasc.setBounds(140, 260, 210, 30);

        jtTelefone.setToolTipText("(xx) xxxx-xxxx");
        jLayeredPane1.add(jtTelefone);
        jtTelefone.setBounds(140, 180, 130, 30);

        jlTelefone.setText("Telefone");
        jLayeredPane1.add(jlTelefone);
        jlTelefone.setBounds(40, 180, 50, 30);

        jlEmail1.setText("E-mail(Opcional)");
        jLayeredPane1.add(jlEmail1);
        jlEmail1.setBounds(40, 220, 90, 30);
        jLayeredPane1.add(jtEmail);
        jtEmail.setBounds(140, 220, 210, 30);

        jlRG.setText("RG");
        jLayeredPane1.add(jlRG);
        jlRG.setBounds(40, 100, 90, 30);
        jLayeredPane1.add(jtRG);
        jtRG.setBounds(140, 100, 210, 30);

        jLayeredPane1.add(jcConvenio);
        jcConvenio.setBounds(140, 300, 150, 30);

        jLayeredPane2.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLayeredPane2.setOpaque(true);

        jbLimpar.setText("limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });
        jLayeredPane2.add(jbLimpar);
        jbLimpar.setBounds(290, 20, 140, 40);

        jbCadastrar1.setText("cadastrar");
        jbCadastrar1.setMinimumSize(new java.awt.Dimension(78, 20));
        jbCadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrar1ActionPerformed(evt);
            }
        });
        jLayeredPane2.add(jbCadastrar1);
        jbCadastrar1.setBounds(80, 20, 140, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                    .addComponent(jLayeredPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean emptyFields() {
        boolean empty = true;

        if (jtNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "ATENÇÃO! Nome não pode ser vazio.");
        } else if (jtCpf.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "ATENÇÃO! CPF não pode ser vazio.");
        } else if (jtEndereco.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "ATENÇÃO! Endereço não pode ser vazio.");
        } else if (jtTelefone.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "ATENÇÃO! Telefone não pode ser vazio.");
        } else if (jtDataNasc.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "ATENÇÃO! Data de Nascimento não pode ser vazio.");
        } else if (jcConvenio.getSelectedIndex() == 0 || jcConvenio.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "ATENÇÃO! Convênio não pode ser vazio.");
        } else {
            empty = false;
        }

        return empty;
    }

    private void cadastrar() {
        try {
            // Obtendo os valores dos campos
            String cpf = jtCpf.getText().trim();
            String telefone = jtTelefone.getText().trim();
            String rg = jtRG.getText().trim();
            String dataNasc = jtDataNasc.getText().trim();

            // Validações
            if (!validarCPF(cpf)) {
                return;
            }

            if (!validarRG(rg)) {
                return;
            }

            if (!validarTelefone(telefone)) {
                return;
            }

            if (!ValidarDataNascimento(dataNasc)) {
                return;
            }

            // Criando o objeto Paciente
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Paciente pac = new Paciente();
            pac.setNome(jtNome.getText());
            pac.setEndereco(jtEndereco.getText());
            pac.setDataNascimento(sdf.parse(dataNasc));
            pac.setTelefone(telefone);
            pac.setCpf(cpf);
            pac.setRg(rg);
            pac.setEmail(jtEmail.getText());

            // Verificando o convênio
            if (jcConvenio.getSelectedIndex() != 0) {
                String convenioSelecionado = jcConvenio.getSelectedItem().toString();
                ConvenioDAO convDAO = new ConvenioDAO();
                Convenio convenio = convDAO.buscarConvenioFiltro(convenioSelecionado);
                pac.setConvenio(convenio.getIdConvenio());
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um convênio válido.");
                return;
            }

            // Verifica se o CPF já está cadastrado
            PacienteDAO pacDAO = new PacienteDAO();
            if (!pacDAO.isCpfUnique(cpf)) {
                JOptionPane.showMessageDialog(this, "Este CPF já está cadastrado.");
                return;
            }

            // Salvando o paciente no banco
            pacDAO.cadastrarPaciente(pac);
            JOptionPane.showMessageDialog(this, "Paciente cadastrado com sucesso!");

        } catch (HeadlessException | SQLException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + e.getMessage());
        }
    }

    private boolean validarCPF(String cpf) {
        if (cpf.length() > 14) {
            JOptionPane.showMessageDialog(this, "O CPF excedeu o limite de caracteres. Use o formato XXX.XXX.XXX-XX.");
            return false;
        }
        if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Por favor, insira o CPF no formato XXX.XXX.XXX-XX.");
            return false;
        }
        return true;
    }

    private boolean validarRG(String rg) {
        if (rg.trim().isEmpty()) {
            // Se o RG estiver vazio, não faz validação.
            return true;
        }
        // Se o RG não estiver vazio, realiza a validação do formato
        if (rg.length() > 12) {
            JOptionPane.showMessageDialog(this, "O RG excedeu o limite de caracteres. Use o formato XX.XXX.XXX-X.");
            return false;
        }
        if (!rg.matches("\\d{2}\\.\\d{3}\\.\\d{3}-\\d{1}")) {
            JOptionPane.showMessageDialog(this, "Por favor, insira o RG no formato XX.XXX.XXX-X.");
            return false;
        }
        return true;
    }

    private boolean validarTelefone(String telefone) {
        if (telefone.length() > 14) {
            JOptionPane.showMessageDialog(this, "O telefone excedeu o limite de caracteres. Use os formatos (XX)XXXX-XXXX ou (XX)XXXXX-XXXX.");
            return false;
        }
        if (!telefone.matches("\\(\\d{2}\\)\\d{4}-\\d{4}") && !telefone.matches("\\(\\d{2}\\)\\d{5}-\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Por favor, insira o telefone nos formatos (XX)XXXX-XXXX ou (XX)XXXXX-XXXX.");
            return false;
        }
        return true;
    }

    private boolean ValidarDataNascimento(String dataNasc) {
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";

        if (dataNasc.length() > 10) {
            JOptionPane.showMessageDialog(this, "A data de nascimento excedeu o limite de caracteres. Use o formato DD/MM/AAAA.");
            return false;
        }
        if (!dataNasc.matches(regex)) {
            JOptionPane.showMessageDialog(this, "Por favor, insira a data de nascimento no formato DD/MM/AAAA.");
            return false;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(dataNasc);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Data de nascimento inválida. Por favor, insira uma data válida no formato DD/MM/AAAA.");
            return false;
        }

        return true;
    }

// Ação do botão "Limpar"
    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {
        limparCampos();  // Chama o método de limpeza
    }

// Ação do botão "Cadastrar"
    private void jbCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (!emptyFields()) {  // Verifica se os campos não estão vazios
            cadastrar();  // Chama o método de cadastro
        }
    }

    private void limparCampos() {

        jtNome.setText("");
        jtEndereco.setText("");
        jtDataNasc.setText("");
        jtTelefone.setText("");
        jtCpf.setText("");
        jtRG.setText("");
        jtEmail.setText("");
        jcConvenio.setSelectedIndex(0);

        jtNome.requestFocus();
    }

    // metodo para preencher o combo box com os produtos cadastrados no banco de dados
    private void preencherCombo() {
        try {
            ConvenioServicos ps = ServicosFactory.getConvenioServicos();
            ArrayList<Convenio> convenios = ps.buscarConvenio();

            jcConvenio.addItem("-Selecione-");
            for (Convenio convenio : convenios) {
                jcConvenio.addItem(convenio.getNomeConvenio());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao preencher combo: " + e.getMessage());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JButton jbCadastrar1;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JComboBox<String> jcConvenio;
    private javax.swing.JLabel jlCpf;
    private javax.swing.JLabel jlDataNasc;
    private javax.swing.JLabel jlEmail1;
    private javax.swing.JLabel jlEndereco;
    private javax.swing.JLabel jlEspecialidade;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlRG;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JTextField jtCpf;
    private javax.swing.JTextField jtDataNasc;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtEndereco;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtRG;
    private javax.swing.JTextField jtTelefone;
    // End of variables declaration//GEN-END:variables
}
