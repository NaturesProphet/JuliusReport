/*
 * Copyright (C) 2018 mgarcia.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package VIEW.Cadastros;

import CONTROLE.DAO.AbastecimentoDAO;
import CONTROLE.DAO.CombustivelDAO;
import CONTROLE.DAO.PostoDAO;
import CONTROLE.DAO.RendimentoDAO;
import CONTROLE.DAO.TrajetoDAO;
import CONTROLE.ManipuladorData;
import ENTIDADES.Abastecimento;
import ENTIDADES.Posto;
import ENTIDADES.Rendimento;
import ENTIDADES.Trajeto;
import ENTIDADES.Usuario;
import ENTIDADES.Veiculo;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mgarcia
 */
public class NovoAbastecimento extends javax.swing.JFrame {

    Usuario usuario;
    Veiculo veiculo;
    Abastecimento UltimoAbastecimento;

    /**
     * Creates new form NovoAbastecimento
     */
    public NovoAbastecimento(Usuario u, Veiculo v) {
        initComponents();
        usuario = u;
        veiculo = v;
        AbastecimentoDAO abastecimentodao = new AbastecimentoDAO();
        try {
            UltimoAbastecimento = abastecimentodao.getLast(v.getIdVeiculo());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro de entrada e saída "
                    + "ao buscar na base de Abastecimento\n" + ex);
            Logger.getLogger(NovoAbastecimento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar na base de "
                    + "Abastecimento\n" + ex);
            Logger.getLogger(NovoAbastecimento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public NovoAbastecimento() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        diabox = new javax.swing.JComboBox<>();
        mesbox = new javax.swing.JComboBox<>();
        anobox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ValorTotalF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CombF = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        ValorLitroF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        PostoF = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        ArCondF = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TrajetoF = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        radioSIM = new javax.swing.JRadioButton();
        radioNAO = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        KmF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Abastecimento");

        diabox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Dia","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}));
        diabox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaboxActionPerformed(evt);
            }
        });

        mesbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Mes","janeiro","fevereiro","março","abril","maio","junho","julho","agosto","setembro","outubro","novembro","dezembro"}));

        String[] anos = new String[100];
        Date d = new Date();
        int today = d.getYear() + 1900;
        int aux = 1;
        anos[0] = "Ano";
        while (aux < 99) {
            anos[aux] = "" + today;
            aux ++;
            today--;
        }
        anobox.setModel(new javax.swing.DefaultComboBoxModel<>(anos));

        jLabel1.setText("Data do abastecimento");

        jLabel2.setText("Valor Total");

        jLabel3.setText("R$");

        jLabel4.setText("Tipo de Combustivel");

        CombustivelDAO cdao = new CombustivelDAO();
        ArrayList<String> lista = new ArrayList();
        try {
            lista = cdao.getAll();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar a base de combustiveis\n"+e);
        }

        String[] c = new String[lista.size()+1];
        c[0] = "Selecione um Combustivel";
        for (int i = 0; i < lista.size(); i++) {
            c[i+1] = lista.get(i);
        }
        CombF.setModel(new javax.swing.DefaultComboBoxModel<>(c));

        jLabel5.setText("Preço do Litro");

        jLabel6.setText("R$");

        jLabel7.setText("Posto");

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        PostoDAO Pdao = new PostoDAO();
        ArrayList<Posto> listaPostos = new ArrayList();
        try {
            listaPostos = Pdao.getAll();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar a base de Postos\n"+e);
        }

        String[] ArrayPostos = new String[listaPostos.size()+1];
        ArrayPostos[0] = "Selecione um Posto";
        for (int i = 0; i < listaPostos.size(); i++) {
            ArrayPostos[i+1] = listaPostos.get(i).getNome();
        }
        PostoF.setModel(new javax.swing.DefaultComboBoxModel<>(ArrayPostos));

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        ArCondF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o status do Ar.","Desligado sempre", "Ligado sempre", "Uso moderado/econômico", "Pouco uso"}));

        jLabel8.setText("Considerando a situação em que você rodou com este veículo");

        jLabel9.setText("1 - Como foi o uso do Ar Condicionado ?");

        jLabel10.setText("desde a ultima vez em que o abasteceu, responda:");

        jLabel11.setText("2 - Qual tipo de trajeto o veículo percorreu?");

        TrajetoDAO Tdao = new TrajetoDAO();
        ArrayList<Trajeto> listaTrajeto = new ArrayList();
        try {
            listaTrajeto = Tdao.getAll();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar a base de Trajetos\n"+e);
        }

        String[] ArrayTrajeto = new String[listaTrajeto.size()+1];
        ArrayTrajeto[0] = "Selecione um tipo de trajeto";
        for (int i = 0; i < listaTrajeto.size(); i++) {
            ArrayTrajeto[i+1] = listaTrajeto.get(i).getNome();
        }
        TrajetoF.setModel(new javax.swing.DefaultComboBoxModel<>(ArrayTrajeto));

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel13.setText("Deseja registrar este consumo na base de dados ?");

        radioSIM.setText("Sim! Registre! :)");
        radioSIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSIMActionPerformed(evt);
            }
        });

        radioNAO.setText("Não. eu não pude completar o tanque :(");
        radioNAO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNAOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioSIM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioNAO)
                                .addGap(30, 30, 30))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TrajetoF, javax.swing.GroupLayout.Alignment.LEADING, 0, 420, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel11))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ArCondF, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ArCondF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TrajetoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioSIM)
                    .addComponent(radioNAO))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setText("Quilometragem atual");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                        .addComponent(jLabel6)))
                                .addComponent(jLabel7)
                                .addComponent(jLabel4)
                                .addComponent(jLabel12))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(diabox, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(mesbox, 0, 103, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(anobox, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(KmF)
                                        .addComponent(PostoF, 0, 258, Short.MAX_VALUE)
                                        .addComponent(ValorTotalF)
                                        .addComponent(ValorLitroF)
                                        .addComponent(CombF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diabox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CombF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ValorLitroF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ValorTotalF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(PostoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(KmF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void diaboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diaboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Boolean Validador = true;
        Boolean ValidarRendimento = true;
        if (diabox.getSelectedIndex() == 0 || mesbox.getSelectedIndex() == 0
                || anobox.getSelectedIndex() == 0) {
            Validador = false;
            JOptionPane.showMessageDialog(null, "Preencha uma data válida");
        }

        if (CombF.getSelectedIndex() == 0) {
            Validador = false;
            JOptionPane.showMessageDialog(null, "Selecione o Combustivel");
        }

        try {
            if (Double.parseDouble(ValorLitroF.getText()) < 0) {
                Validador = false;
                JOptionPane.showMessageDialog(null, "Digite corretamente o valor "
                        + "do Litro pago neste abastecimento");
            }
        } catch (Exception e) {
            Validador = false;
            JOptionPane.showMessageDialog(null, "Digite apenas valores "
                    + "Numéricos no campo Valor do Litro");
        }

        try {
            if (Double.parseDouble(ValorTotalF.getText()) < 0) {
                Validador = false;
                JOptionPane.showMessageDialog(null, "Digite corretamente o valor "
                        + "Total gasto neste abastecimento");
            }
        } catch (Exception e) {
            Validador = false;
            JOptionPane.showMessageDialog(null, "Digite apenas valores "
                    + "Numéricos no campo Valor Total");
        }

        if (PostoF.getSelectedIndex() == 0) {
            Validador = false;
            JOptionPane.showMessageDialog(null, "Escolha um Posto de Combustível");
        }

        try {
            if (Integer.parseInt(KmF.getText()) < 0) {
                Validador = false;
                JOptionPane.showMessageDialog(null, "Digite corretamente o valor "
                        + "da Quilometragem atual do veículo");
            }
        } catch (Exception e) {
            Validador = false;
            JOptionPane.showMessageDialog(null, "Digite apenas valores "
                    + "Numéricos no campo Quilometragem atual");
        }

        if (!radioSIM.isSelected() && !radioNAO.isSelected()) {
            Validador = false;
            JOptionPane.showMessageDialog(null, "Marque uma das opções abaixo para"
                    + "definir se os dados de consumo \ne rendimento serão gerados"
                    + "e armazenados na base de dados.");
        }

        if (radioSIM.isSelected()) {
            if (ArCondF.getSelectedIndex() == 0) {
                Validador = false;
                ValidarRendimento = false;
                JOptionPane.showMessageDialog(null, "Selecione o status "
                        + "do Ar Condicionado");
            }
            if (TrajetoF.getSelectedIndex() == 0) {
                Validador = false;
                ValidarRendimento = false;
                JOptionPane.showMessageDialog(null, "Selecione um tipo de trajeto");
            }

        }
        if (radioNAO.isSelected()) {
            ValidarRendimento = false;
        }

        if (Validador) {

            Abastecimento abastecimento = new Abastecimento();
            AbastecimentoDAO dao = new AbastecimentoDAO();

            String dd = diabox.getSelectedItem().toString();
            String MM = mesbox.getSelectedItem().toString();
            String yyyy = anobox.getSelectedItem().toString();

            switch (MM) {
                case "janeiro":
                    MM = "01";
                    break;
                case "fevereiro":
                    MM = "02";
                    break;
                case "março":
                    MM = "03";
                    break;
                case "abril":
                    MM = "05";
                    break;
                case "maio":
                    MM = "06";
                    break;
                case "junho":
                    MM = "06";
                    break;
                case "julho":
                    MM = "07";
                    break;
                case "agosto":
                    MM = "08";
                    break;
                case "setembro":
                    MM = "09";
                    break;
                case "outubro":
                    MM = "10";
                    break;
                case "novembro":
                    MM = "11";
                    break;
                case "dezembro":
                    MM = "12";
                    break;
            }
            String dataAb = dd + "/" + MM + "/" + yyyy;
            try {
                abastecimento.setData(ManipuladorData.getDate(dataAb));
            } catch (ParseException ex) {
                Logger.getLogger(NovoAbastecimento.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao gravar a data\n" + ex);
                return;
            }

            abastecimento.setPosto(PostoF.getSelectedIndex());

            int tc = CombF.getSelectedIndex();

            abastecimento.setTipoCombustivel(tc);
            abastecimento.setUsuario(usuario.getIdUsuario());
            abastecimento.setValorLitro(Double.parseDouble(ValorLitroF.getText()));
            abastecimento.setValorTotal(Double.parseDouble(ValorTotalF.getText()));
            abastecimento.setVeiculo(veiculo.getIdVeiculo());
            abastecimento.setkm(Integer.parseInt(KmF.getText()));

            int z = JOptionPane.showConfirmDialog(null, "Confirma este "
                    + "abastecimento para o Veículo " + veiculo.toString() + " ?");
            if (z == 0) {
                try {
                    dao.salvar(abastecimento);
                    JOptionPane.showMessageDialog(null, "Abastecimento Registrado com sucesso.");
                    if (ValidarRendimento == false) {
                        dispose();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(NovoAbastecimento.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro ao registrar Abastecimento\n" + ex);
                } catch (IOException ex) {
                    Logger.getLogger(NovoAbastecimento.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Erro ao registrar Abastecimento\n" + ex);
                }

                if (ValidarRendimento) {
                    Rendimento r = new Rendimento();
                    r.SetAbastecimento(UltimoAbastecimento.getIdAbastecimento());
                    r.setArCond(ArCondF.getSelectedItem().toString());
                    r.setTrajeto(TrajetoF.getSelectedIndex());
                    int kmrodados = Integer.parseInt(KmF.getText()) - UltimoAbastecimento.getkm();
                    Double Litros = Double.parseDouble(ValorTotalF.getText());
                    Litros /= Double.parseDouble(ValorLitroF.getText());
                    Double kmmedia = kmrodados / Litros;
                    r.setKmL(kmmedia);
                    RendimentoDAO ReDAO = new RendimentoDAO();
                    try {
                        ReDAO.salvar(r);
                        JOptionPane.showMessageDialog(null, "Rendimento registrado");
                        dispose();
                    } catch (SQLException ex) {
                        Logger.getLogger(NovoAbastecimento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Erro ao salvar o rendimento\n" + ex);
                    } catch (IOException ex) {
                        Logger.getLogger(NovoAbastecimento.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "Erro de entrada e saida "
                                + "ao salvar o rendimento\n" + ex);
                    }
                }

            } else if (z == 1) {
                JOptionPane.showMessageDialog(null, "Ação cancelada.");
                dispose();
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radioSIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSIMActionPerformed
        if (radioSIM.isSelected()) {
            radioNAO.setSelected(false);
        }
    }//GEN-LAST:event_radioSIMActionPerformed

    private void radioNAOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNAOActionPerformed
        if (radioNAO.isSelected()) {
            radioSIM.setSelected(false);
        }
    }//GEN-LAST:event_radioNAOActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NovoAbastecimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoAbastecimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoAbastecimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoAbastecimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoAbastecimento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ArCondF;
    private javax.swing.JComboBox<String> CombF;
    private javax.swing.JTextField KmF;
    private javax.swing.JComboBox<String> PostoF;
    private javax.swing.JComboBox<String> TrajetoF;
    private javax.swing.JTextField ValorLitroF;
    private javax.swing.JTextField ValorTotalF;
    private javax.swing.JComboBox<String> anobox;
    private javax.swing.JComboBox<String> diabox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> mesbox;
    private javax.swing.JRadioButton radioNAO;
    private javax.swing.JRadioButton radioSIM;
    // End of variables declaration//GEN-END:variables
}
