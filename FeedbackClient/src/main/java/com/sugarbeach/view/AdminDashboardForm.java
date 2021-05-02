/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sugarbeach.view;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.sugarbeach.resource.AnswerResource;
import com.sugarbeach.resource.FeedbackReportResource;
import com.sugarbeach.resource.QuestionnaireAdminResource;
import com.sugarbeach.resource.QuestionnaireResource;
import com.sugarbeach.service.FeedbackClientService;
import com.sugarbeach.service.QuestionnaireClientService;
import com.sugarbeach.service.QuickChartClientService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lakitha
 */
public class AdminDashboardForm extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashboardForm
     */
    public AdminDashboardForm(String username) throws RemoteException {
        initComponents();
        btnReportGenerate.setEnabled(false);
        lblUsername.setText(username);
        initTableData();
        txtQuestionId.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        lblAnswer1 = new javax.swing.JLabel();
        txtAnswer2 = new javax.swing.JTextField();
        lblAnswer2 = new javax.swing.JLabel();
        txtAnswer1 = new javax.swing.JTextField();
        lblAnswer3 = new javax.swing.JLabel();
        txtAnswer3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestion = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        lblQuestion1 = new javax.swing.JLabel();
        txtQuestionId = new javax.swing.JTextField();
        lblUsername = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReportGenerate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblQuestionnaire = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin Dashboard");

        lblQuestion.setText("Question");

        lblAnswer1.setText("Answer 1");

        txtAnswer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnswer2ActionPerformed(evt);
            }
        });

        lblAnswer2.setText("Answer 2");

        lblAnswer3.setText("Answer 3");

        txtAnswer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnswer3ActionPerformed(evt);
            }
        });

        txtQuestion.setColumns(20);
        txtQuestion.setRows(5);
        jScrollPane1.setViewportView(txtQuestion);

        btnSave.setBackground(new java.awt.Color(1, 168, 42));
        btnSave.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnSave.setForeground(new java.awt.Color(254, 254, 254));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnSaveActionPerformed(evt);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        lblQuestion1.setText("Question Id");

        lblUsername.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblUsername.setText("Username");

        btnUpdate.setBackground(new java.awt.Color(26, 138, 233));
        btnUpdate.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(254, 254, 254));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnUpdateActionPerformed(evt);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        btnDelete.setBackground(new java.awt.Color(206, 42, 31));
        btnDelete.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(254, 254, 254));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnDeleteActionPerformed(evt);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        btnReportGenerate.setBackground(new java.awt.Color(26, 138, 233));
        btnReportGenerate.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnReportGenerate.setForeground(new java.awt.Color(254, 254, 254));
        btnReportGenerate.setText("Generate Report");
        btnReportGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportGenerateActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(69, 69, 69));
        btnReset.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnReset.setForeground(new java.awt.Color(254, 254, 254));
        btnReset.setText("Reset Fields");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblQuestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtQuestionId, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                        .addGap(574, 574, 574))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1)
                                        .addGap(52, 52, 52))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblAnswer1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtAnswer1)
                                .addGap(3, 3, 3)
                                .addComponent(lblAnswer2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAnswer2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAnswer3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAnswer3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnReportGenerate, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(386, 386, 386))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuestion1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(txtQuestionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAnswer2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(txtAnswer1)
                            .addComponent(lblAnswer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAnswer3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAnswer2)
                            .addComponent(txtAnswer3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReportGenerate))
                .addGap(18, 18, 18)
                .addComponent(btnReset)
                .addGap(11, 11, 11))
        );

        tblQuestionnaire.setBackground(new java.awt.Color(254, 254, 254));
        tblQuestionnaire.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Question", "Answer 1", "Answer 2", "Answer 3", "Question Id"
            }
        ));
        tblQuestionnaire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuestionnaireMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblQuestionnaire);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException {//GEN-FIRST:event_btnDeleteActionPerformed
        if (!txtQuestionId.getText().isEmpty()) {
            QuestionnaireAdminResource adminResource = getQuestionnaireAdminResource();
            adminResource.setQuestionId(Integer.parseInt(txtQuestionId.getText()));
            QuestionnaireClientService questionnaireClientService = new QuestionnaireClientService();
            if (questionnaireClientService.delete(adminResource)) {
                initTableData();
                JOptionPane optionPane = new JOptionPane("Successfully deleted.", JOptionPane.OK_OPTION);
                JDialog dialog = optionPane.createDialog(jPanel1, "Success");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            } else {
                JOptionPane optionPane = new JOptionPane("Something went wrong with data deleting", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog(jPanel1, "Failed");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private QuestionnaireAdminResource getQuestionnaireAdminResource() {
        QuestionnaireAdminResource adminResource = new QuestionnaireAdminResource();
        adminResource.setQuestion(txtQuestion.getText());
        List<String> answerList = new ArrayList<>();
        answerList.add(txtAnswer1.getText());
        answerList.add(txtAnswer2.getText());
        answerList.add(txtAnswer3.getText());
        adminResource.setAnswerList(answerList);
        return adminResource;
    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException {//GEN-FIRST:event_btnUpdateActionPerformed
        if (!txtQuestionId.getText().isEmpty()) {
            QuestionnaireAdminResource adminResource = getQuestionnaireAdminResource();
            adminResource.setQuestionId(Integer.parseInt(txtQuestionId.getText()));
            QuestionnaireClientService questionnaireClientService = new QuestionnaireClientService();
            if (questionnaireClientService.update(adminResource)) {
                initTableData();
                JOptionPane optionPane = new JOptionPane("Successfully updated.", JOptionPane.OK_OPTION);
                JDialog dialog = optionPane.createDialog(jPanel1,"Success");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            } else {
                JOptionPane optionPane = new JOptionPane("Something went wrong with data updating", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog(jPanel1,"Failed");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            }

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtAnswer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnswer2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnswer2ActionPerformed

    private void txtAnswer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnswer3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnswer3ActionPerformed

    private void tblQuestionnaireMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuestionnaireMouseClicked
        btnReportGenerate.setEnabled(true);
        int row = tblQuestionnaire.getSelectedRow();
        String question = tblQuestionnaire.getModel().getValueAt(row, 0).toString();
        String answer1 = tblQuestionnaire.getModel().getValueAt(row, 1).toString();
        String answer2 = tblQuestionnaire.getModel().getValueAt(row, 2).toString();
        String answer3 = tblQuestionnaire.getModel().getValueAt(row, 3).toString();
        String answerId = tblQuestionnaire.getModel().getValueAt(row, 4).toString();

        txtQuestion.setText(question);
        txtAnswer1.setText(answer1);
        txtAnswer2.setText(answer2);
        txtAnswer3.setText(answer3);
        txtQuestionId.setText(answerId);

    }//GEN-LAST:event_tblQuestionnaireMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException {//GEN-FIRST:event_btnSaveActionPerformed
        QuestionnaireAdminResource adminResource = getQuestionnaireAdminResource();
        QuestionnaireClientService questionnaireClientService = new QuestionnaireClientService();

        if (questionnaireClientService.save(adminResource)) {
            initTableData();
            JOptionPane optionPane = new JOptionPane("Successfully saved.", JOptionPane.OK_OPTION);
            JDialog dialog = optionPane.createDialog(jPanel1,"Success");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        } else {
            JOptionPane optionPane = new JOptionPane("Something went wrong with data saving", JOptionPane.ERROR_MESSAGE);
            JDialog dialog = optionPane.createDialog(jPanel1,"Failed");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnReportGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportGenerateActionPerformed
        try {
            QuickChartClientService chartClientService = new QuickChartClientService();
            FeedbackClientService feedbackClientService = new FeedbackClientService();
            FeedbackReportResource feedbackReportData = feedbackClientService.getFeedbackReportData(Integer.parseInt(txtQuestionId.getText()));
            if (feedbackReportData == null || feedbackReportData.getAnswerReportResources().isEmpty()) {
                JOptionPane optionPane = new JOptionPane("No enough data found to generate a report.", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog(jPanel1,"Failed");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
            } else {
                chartClientService.bindData(feedbackReportData);
            }
        } catch (IOException | UnirestException ex) {
            Logger.getLogger(AdminDashboardForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReportGenerateActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtQuestionId.setText("");
        txtQuestion.setText("");
        txtAnswer1.setText("");
        txtAnswer2.setText("");
        txtAnswer3.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AdminDashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AdminDashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AdminDashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AdminDashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new AdminDashboardForm("").setVisible(true);
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReportGenerate;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblAnswer1;
    private javax.swing.JLabel lblAnswer2;
    private javax.swing.JLabel lblAnswer3;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblQuestion1;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTable tblQuestionnaire;
    private javax.swing.JTextField txtAnswer1;
    private javax.swing.JTextField txtAnswer2;
    private javax.swing.JTextField txtAnswer3;
    private javax.swing.JTextArea txtQuestion;
    private javax.swing.JTextField txtQuestionId;
    // End of variables declaration//GEN-END:variables

    private void initTableData() throws RemoteException {
        DefaultTableModel model = (DefaultTableModel) tblQuestionnaire.getModel();
        model.setRowCount(0);
        QuestionnaireClientService questionnaireClientService = new QuestionnaireClientService();
        List<QuestionnaireResource> questionnaire = questionnaireClientService.getAllQuestionWithAnswers();
        for (int i = 0, questionnaireSize = questionnaire.size(); i < questionnaireSize; i++) {
            List<String> tableData = new ArrayList<>();
            QuestionnaireResource questionnaireResource = questionnaire.get(i);
            tableData.add(questionnaireResource.getQuestion());
            int questionId = 0;
            for (int j = 0; j < questionnaireResource.getAnswerResourceList().size(); j++) {
                AnswerResource answerResource = questionnaireResource.getAnswerResourceList().get(j);
                questionId = answerResource.getQuestionId();
                tableData.add(answerResource.getAnswer());
            }
            tableData.add(Integer.toString(questionId));
            model.addRow(tableData.toArray());
        }
    }
}
