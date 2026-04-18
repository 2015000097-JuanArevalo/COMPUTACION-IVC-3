/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author LABORATORIO
 */
public class jfrmCalc extends javax.swing.JFrame {

    /**
     * Creates new form jfrmCalc
     */
    //Variables restringidas - Privada
    private String entrada = "0";
    private double num1 = 0;
    private String operador = "";
    private boolean nuevaEntrada = true;

    
    public jfrmCalc() {
        initComponents();
        jtxtCantidad.setText("0");
    }
    
    private String formatearNumero(double valor) {
        if (Double.isNaN(valor) || Double.isInfinite(valor)) {
            return "Error";
        }

        if (valor == (long) valor) {
            return String.valueOf((long) valor);
        } else {
            return String.valueOf(valor);
        }
    }
    
    private double obtenerValorActual() {
        if (entrada == null || entrada.isEmpty() || entrada.equals("Error")) {
            return 0;
        }
        return Double.parseDouble(entrada);
    }
    
    private void agregarNumero(String numero) {
        if (entrada.equals("Error")) {
            entrada = "0";
        }
        if (nuevaEntrada || entrada.equals("0")) {
            entrada = numero;
        } else {
            entrada = entrada + numero;
        }

        nuevaEntrada = false;
        jtxtCantidad.setText(entrada);
    }

    private void agregarPunto() {
        if (entrada.equals("Error")) {
            entrada = "0";
        }
        if (nuevaEntrada) {
            entrada = "0.";
            nuevaEntrada = false;
        } else if (!entrada.contains(".")) {
            entrada = entrada + ".";
        }
        jtxtCantidad.setText(entrada);
    }
    
    private double realizarOperacion(double valor1, double valor2, String op) {
        switch (op) {
            case "+":
                return valor1 + valor2;
            case "-":
                return valor1 - valor2;
            case "*":
                return valor1 * valor2;
            case "/":
                if (valor2 == 0) {
                    throw new ArithmeticException("No se puede dividir entre cero");
                }
                return valor1 / valor2;
            default:
                return valor2;
        }
    }

    private void procesarOperador(String nuevoOperador) {
        try {
            double valorActual = obtenerValorActual();

            if (!operador.isEmpty() && !nuevaEntrada) {
                num1 = realizarOperacion(num1, valorActual, operador);
                entrada = formatearNumero(num1);
                jtxtCantidad.setText(entrada);
            } else if (operador.isEmpty()) {
                num1 = valorActual;
            }

            operador = nuevoOperador;
            nuevaEntrada = true;
        } catch (ArithmeticException e) {
            entrada = "Error";
            operador = "";
            num1 = 0;
            nuevaEntrada = true;
            jtxtCantidad.setText(entrada);
        }
    }

    private void calcularResultado() {
        try {
            if (operador.isEmpty()) {
                jtxtCantidad.setText(entrada);
                return;
            }

            double valorActual = obtenerValorActual();
            double resultado = realizarOperacion(num1, valorActual, operador);

            entrada = formatearNumero(resultado);
            jtxtCantidad.setText(entrada);
            num1 = resultado;
            operador = "";
            nuevaEntrada = true;
        } catch (ArithmeticException e) {
            entrada = "Error";
            operador = "";
            num1 = 0;
            nuevaEntrada = true;
            jtxtCantidad.setText(entrada);
        }
    }
    
    private void limpiarTodo() {
        entrada = "0";
        num1 = 0;
        operador = "";
        nuevaEntrada = true;
        jtxtCantidad.setText(entrada);
    }

    private void borrarUltimo() {
        if (entrada.equals("Error")) {
            limpiarTodo();
            return;
        }

        if (nuevaEntrada) {
            entrada = "0";
            nuevaEntrada = false;
            jtxtCantidad.setText(entrada);
            return;
        }

        if (entrada.length() > 1) {
            entrada = entrada.substring(0, entrada.length() - 1);
            if (entrada.equals("-") || entrada.equals("")) {
                entrada = "0";
            }
        } else {
            entrada = "0";
        }

        jtxtCantidad.setText(entrada);
    }
    
    private void calcularPorcentaje() {
        double valor = obtenerValorActual();
        valor = valor / 100.0;
        entrada = formatearNumero(valor);
        jtxtCantidad.setText(entrada);
        nuevaEntrada = true;
    }

    private void calcularRaiz() {
        double valor = obtenerValorActual();

        if (valor < 0) {
            entrada = "Error";
            jtxtCantidad.setText(entrada);
            operador = "";
            num1 = 0;
            nuevaEntrada = true;
            return;
        }

        double resultado = Math.sqrt(valor);
        entrada = formatearNumero(resultado);
        jtxtCantidad.setText(entrada);
        nuevaEntrada = true;
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtxtCantidad = new javax.swing.JTextField();
        jbtn7 = new javax.swing.JButton();
        jbtn8 = new javax.swing.JButton();
        jbtn9 = new javax.swing.JButton();
        jbtn4 = new javax.swing.JButton();
        jbtn5 = new javax.swing.JButton();
        jbtn6 = new javax.swing.JButton();
        jbtn1 = new javax.swing.JButton();
        jbtn2 = new javax.swing.JButton();
        jbtn3 = new javax.swing.JButton();
        jbtnDivi = new javax.swing.JButton();
        jbtnResta = new javax.swing.JButton();
        jbtnMulti = new javax.swing.JButton();
        jbtn0 = new javax.swing.JButton();
        jbtnIgual = new javax.swing.JButton();
        jbtnSuma = new javax.swing.JButton();
        jbtnAC = new javax.swing.JButton();
        jbtnPunto = new javax.swing.JButton();
        jbtnRaiz = new javax.swing.JButton();
        jbtnPorcentaje = new javax.swing.JButton();
        jbtnC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtxtCantidad.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jtxtCantidad.setText("0");
        jtxtCantidad.setEnabled(false);

        jbtn7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtn7.setText("7");
        jbtn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn7ActionPerformed(evt);
            }
        });

        jbtn8.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtn8.setText("8");
        jbtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn8ActionPerformed(evt);
            }
        });

        jbtn9.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtn9.setText("9");
        jbtn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn9ActionPerformed(evt);
            }
        });

        jbtn4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtn4.setText("4");
        jbtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn4ActionPerformed(evt);
            }
        });

        jbtn5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtn5.setText("5");
        jbtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn5ActionPerformed(evt);
            }
        });

        jbtn6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtn6.setText("6");
        jbtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn6ActionPerformed(evt);
            }
        });

        jbtn1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtn1.setText("1");
        jbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn1ActionPerformed(evt);
            }
        });

        jbtn2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtn2.setText("2");
        jbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn2ActionPerformed(evt);
            }
        });

        jbtn3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtn3.setText("3");
        jbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn3ActionPerformed(evt);
            }
        });

        jbtnDivi.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtnDivi.setText("/");
        jbtnDivi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDiviActionPerformed(evt);
            }
        });

        jbtnResta.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtnResta.setText("-");
        jbtnResta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRestaActionPerformed(evt);
            }
        });

        jbtnMulti.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtnMulti.setText("*");
        jbtnMulti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMultiActionPerformed(evt);
            }
        });

        jbtn0.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtn0.setText("0");
        jbtn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn0ActionPerformed(evt);
            }
        });

        jbtnIgual.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtnIgual.setText("=");
        jbtnIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIgualActionPerformed(evt);
            }
        });

        jbtnSuma.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtnSuma.setText("+");
        jbtnSuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSumaActionPerformed(evt);
            }
        });

        jbtnAC.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtnAC.setText("AC");
        jbtnAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnACActionPerformed(evt);
            }
        });

        jbtnPunto.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtnPunto.setText(".");
        jbtnPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPuntoActionPerformed(evt);
            }
        });

        jbtnRaiz.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtnRaiz.setText("√");
        jbtnRaiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRaizActionPerformed(evt);
            }
        });

        jbtnPorcentaje.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtnPorcentaje.setText("%");
        jbtnPorcentaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPorcentajeActionPerformed(evt);
            }
        });

        jbtnC.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbtnC.setText("C");
        jbtnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnAC, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnC))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtxtCantidad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jbtn7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbtn4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbtn0, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtn8)
                                    .addComponent(jbtn5)
                                    .addComponent(jbtn2)
                                    .addComponent(jbtnPunto))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtn9)
                                    .addComponent(jbtn3)
                                    .addComponent(jbtn6)
                                    .addComponent(jbtnIgual))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtnDivi)
                                    .addComponent(jbtnMulti)
                                    .addComponent(jbtnResta)
                                    .addComponent(jbtnSuma))
                                .addGap(6, 6, 6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnPorcentaje)
                            .addComponent(jbtnRaiz))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn7)
                    .addComponent(jbtn8)
                    .addComponent(jbtn9)
                    .addComponent(jbtnDivi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn4)
                    .addComponent(jbtn5)
                    .addComponent(jbtn6)
                    .addComponent(jbtnResta)
                    .addComponent(jbtnPorcentaje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn1)
                    .addComponent(jbtn3)
                    .addComponent(jbtn2)
                    .addComponent(jbtnMulti)
                    .addComponent(jbtnRaiz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn0)
                    .addComponent(jbtnIgual)
                    .addComponent(jbtnSuma)
                    .addComponent(jbtnPunto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAC)
                    .addComponent(jbtnC))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn7ActionPerformed
        // TODO add your handling code here:
        agregarNumero("7");
    }//GEN-LAST:event_jbtn7ActionPerformed

    private void jbtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn8ActionPerformed
        // TODO add your handling code here:
        agregarNumero("8");
    }//GEN-LAST:event_jbtn8ActionPerformed

    private void jbtn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn9ActionPerformed
        // TODO add your handling code here:
        agregarNumero("9");
    }//GEN-LAST:event_jbtn9ActionPerformed

    private void jbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn4ActionPerformed
        // TODO add your handling code here:
        agregarNumero("4");
    }//GEN-LAST:event_jbtn4ActionPerformed

    private void jbtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn5ActionPerformed
        // TODO add your handling code here:
        agregarNumero("5");
    }//GEN-LAST:event_jbtn5ActionPerformed

    private void jbtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn6ActionPerformed
        // TODO add your handling code here:
        agregarNumero("6");
    }//GEN-LAST:event_jbtn6ActionPerformed

    private void jbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn1ActionPerformed
        // TODO add your handling code here:
        agregarNumero("1");
    }//GEN-LAST:event_jbtn1ActionPerformed

    private void jbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn2ActionPerformed
        // TODO add your handling code here:
        agregarNumero("2");
    }//GEN-LAST:event_jbtn2ActionPerformed

    private void jbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn3ActionPerformed
        // TODO add your handling code here:
        agregarNumero("3");
    }//GEN-LAST:event_jbtn3ActionPerformed

    private void jbtn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn0ActionPerformed
        // TODO add your handling code here:
        agregarNumero("0");
    }//GEN-LAST:event_jbtn0ActionPerformed

    private void jbtnSumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSumaActionPerformed
        // TODO add your handling code here:
        procesarOperador("+");
    }//GEN-LAST:event_jbtnSumaActionPerformed

    private void jbtnMultiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMultiActionPerformed
        // TODO add your handling code here:
        procesarOperador("*");
    }//GEN-LAST:event_jbtnMultiActionPerformed

    private void jbtnRestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRestaActionPerformed
        // TODO add your handling code here:
        procesarOperador("-");
    }//GEN-LAST:event_jbtnRestaActionPerformed

    private void jbtnDiviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDiviActionPerformed
        // TODO add your handling code here:
        procesarOperador("/");
    }//GEN-LAST:event_jbtnDiviActionPerformed

    private void jbtnIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIgualActionPerformed
        // TODO add your handling code here:
        calcularResultado();
    }//GEN-LAST:event_jbtnIgualActionPerformed

    private void jbtnACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnACActionPerformed
        // TODO add your handling code here:
        limpiarTodo();
    }//GEN-LAST:event_jbtnACActionPerformed

    private void jbtnPuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPuntoActionPerformed
        // TODO add your handling code here:
        agregarPunto();
    }//GEN-LAST:event_jbtnPuntoActionPerformed

    private void jbtnRaizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRaizActionPerformed
        // TODO add your handling code here:
        calcularRaiz();
    }//GEN-LAST:event_jbtnRaizActionPerformed

    private void jbtnPorcentajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPorcentajeActionPerformed
        // TODO add your handling code here:
        calcularPorcentaje();
    }//GEN-LAST:event_jbtnPorcentajeActionPerformed

    private void jbtnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCActionPerformed
        // TODO add your handling code here:
        borrarUltimo();
    }//GEN-LAST:event_jbtnCActionPerformed

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
            java.util.logging.Logger.getLogger(jfrmCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrmCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrmCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrmCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrmCalc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtn0;
    private javax.swing.JButton jbtn1;
    private javax.swing.JButton jbtn2;
    private javax.swing.JButton jbtn3;
    private javax.swing.JButton jbtn4;
    private javax.swing.JButton jbtn5;
    private javax.swing.JButton jbtn6;
    private javax.swing.JButton jbtn7;
    private javax.swing.JButton jbtn8;
    private javax.swing.JButton jbtn9;
    private javax.swing.JButton jbtnAC;
    private javax.swing.JButton jbtnC;
    private javax.swing.JButton jbtnDivi;
    private javax.swing.JButton jbtnIgual;
    private javax.swing.JButton jbtnMulti;
    private javax.swing.JButton jbtnPorcentaje;
    private javax.swing.JButton jbtnPunto;
    private javax.swing.JButton jbtnRaiz;
    private javax.swing.JButton jbtnResta;
    private javax.swing.JButton jbtnSuma;
    private javax.swing.JTextField jtxtCantidad;
    // End of variables declaration//GEN-END:variables
}
