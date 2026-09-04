
import javax.swing.JTable;
import javax.swing.table.TableColumn;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author USUARIO
 */
public class jfrmPrestamoBancario extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(jfrmPrestamoBancario.class.getName());

    /**
     * Creates new form jfrmPrestamoBancario
     */
    private double credito;
    private int periodoMax, periodoMin;
    private double interesMin, interesMax;
    private double incremento;
    private double pagoMensual;
    private boolean tablaPagos = false;
    private JTable jtablaPrestamo;
    private JTable jtablaCabsFilas;
    private void initTable (final int filasTabla, final int colsTabla)
    {
        class CModeloTablaPrestamo extends javax.swing.table.AbstractTableModel
        {
            Object dato[][] = new Object[filasTabla][colsTabla];
            String cabecera[] = new String[colsTabla];
            boolean editColumn[] = new boolean[colsTabla];
            
            CModeloTablaPrestamo()
            {
                for (int c = 0; c < colsTabla; ++c)
                {
                    cabecera[c] = "Columna" + c;
                    if (c != 0) editColumn[c] = true;
                }
            }
            @Override
            public String getColumnName(int col)
            {
                return cabecera[col];
            }
            @Override
            public Object getValueAt(int fila, int col) {
                return dato[fila][col];
            }
            @Override
            public void setValueAt(Object obj, int fila, int col)
            {
                dato[fila][col] = obj;
            }
            @Override
            public boolean isCellEditable(int indFila, int indColumn)
            {
                return editColumn[indColumn];
            }
            @Override
            public int getRowCount()
            {
                return dato.length;
            }
            @Override
            public int getColumnCount()
            {
                return cabecera.length;
            }
        };
        
        javax.swing.table.TableColumnModel modeloColums =
                new javax.swing.table.DefaultTableColumnModel()
        {
            boolean primeraCol = true;
            public void addColumn(javax.swing.table.TableColumn col)
            {
                if (primeraCol) { primeraCol = false; return; }
                col.setMinWidth(110);
                super.addColumn(col);
            }
        };
        javax.swing.table.TableColumnModel modeloCabsFilas =
                new javax.swing.table.DefaultTableColumnModel()
        {
            boolean primeraCol = true;
            public void addColumn(javax.swing.table.TableColumn col)
            {
                if (primeraCol)
                {
                    col.setMaxWidth(70);
                    super.addColumn(col);
                    primeraCol = false;
                }
            }
        };
        javax.swing.table.TableModel modeloTabla = new CModeloTablaPrestamo();
        jtablaPrestamo = new javax.swing.JTable(modeloTabla, modeloColums);
        jtablaCabsFilas = new javax.swing.JTable(modeloTabla, modeloCabsFilas);
        jtablaPrestamo.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jtablaPrestamoMouseClicked(evt);
            }
        });
        jtablaPrestamo.createDefaultColumnsFromModel();
        jtablaCabsFilas.createDefaultColumnsFromModel();
        jtablaPrestamo.setSelectionModel(jtablaCabsFilas.getSelectionModel());
        jtablaCabsFilas.setBackground(java.awt.Color.lightGray);
        jtablaCabsFilas.setSelectionBackground(java.awt.Color.lightGray);
        jtablaPrestamo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtablaCabsFilas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtablaPrestamo.setFont(new java.awt.Font("Courier New", 0, 12));
        jtablaCabsFilas.setFont(new java.awt.Font("Courier New", 0, 12));
        jScrollPane1.setViewportView(jtablaPrestamo);
        javax.swing.JViewport jv = new javax.swing.JViewport();
        jv.setView(jtablaCabsFilas);
        jv.setPreferredSize(jtablaCabsFilas.getMaximumSize());
        jScrollPane1.setRowHeader(jv);
    }
    public jfrmPrestamoBancario() {
        initComponents();
        this.setTitle("Préstamo Bancario");
        this.setSize(485, 425);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        int tiposIntrs = 18;
        int añosMeses = 4;
        jmItemAños.setEnabled(false);
        jPanel1.setBorder(
            new javax.swing.border.TitledBorder("Años del Préstamo"));
        jtfCredito.setText("6000");
        jtfPeriodoMax.setText("1");
        jtfPeriodoMin.setText("1");
        jtfInteresMax.setText("10.00");
        jtfInteresMin.setText("0.00");
        jcbIncremento.setSelectedIndex(2);
        initTable(tiposIntrs, añosMeses + 1);
        jmItemInstruc.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jmItemInstrucActionPerformed(evt);
            }
        });
        jmItemAños.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jmItemAñosMesesActionPerfomed(evt);
            }
        });
        jmItemMeses.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jmItemAñosMesesActionPerfomed(evt);
            }
        });
        jbtCalculoPagos.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jbtCalculoPagosActionPerformed(evt);
            }
        });
        jbtCalculoAmort.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jbtCalculoAmortActionPerformed(evt);
            }
        });
        jmItemAcercaDe.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jmItemAcercaDeActionPerformed(evt);
            }
        });
        jmItemSalir.addActionListener(new java.awt.event.ActionListener()
{
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jmItemSalirActionPerformed(evt);
            }
        });
    }
    private void jmItemInstrucActionPerformed(java.awt.event.ActionEvent evt)
    {
        String mensaje;
        mensaje = "Introduzca el crédito, la duración del préstamo y el tipo\n";
        mensaje += "de interés. Pulse el botón [Pagos] para visualizar\n";
        mensaje += "los pagos mensuales en la rejilla.\n\n";
        mensaje += "Elija un pago mensual y pulse el botón [Amortización]\n";
        mensaje += "para visualizar el plan de amortización para el interés\n";
        mensaje += "y períodos correspondientes al pago elegido.\n\n";
        mensaje += "Para copiar datos en el portapapeles, seleccione las celdas\n";
        mensaje += "que desee y pulse las teclas Ctrl+c.\n";
        javax.swing.JOptionPane.showMessageDialog(
            null, mensaje, "Instrucciones",
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    private void jmItemSalirActionPerformed(java.awt.event.ActionEvent evt)
    {
        int opcion = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro de que desea salir?",
            "Confirmar salida",
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE
        );

        if (opcion == javax.swing.JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
    private void jmItemAcercaDeActionPerformed(java.awt.event.ActionEvent evt)
    {
        String mensaje;
        mensaje = "Aplicación de Préstamo. Versión 1.0\n";
        mensaje += "Copyright(c)\n\n";
        mensaje += "Nombre: Juan Ignacio Arévalo Toc\n";
        mensaje += "Grado: IV Bachillerato en Ciencias y Letras con Orientación en Computación\n";
        mensaje += "Sección: C\n";
        mensaje += "Clave: 3\n";
        javax.swing.JOptionPane.showMessageDialog(
            null, mensaje, "Acerca de Préstamo",
            javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    private void jmItemAñosMesesActionPerfomed(java.awt.event.ActionEvent evt)
    {
        Object item = evt.getSource();
        String tituloMarco = "";
        if (item == jmItemAños)
        {
            jmItemAños.setEnabled(false);
            jmItemMeses.setEnabled(true);
            tituloMarco = "Años del Préstamo";
        }
        else if (item == jmItemMeses)
        {
            jmItemAños.setEnabled(true);
            jmItemMeses.setEnabled(false);
            tituloMarco = "Meses del Préstamo";
        }
        jPanel1.setBorder(
            new javax.swing.border.TitledBorder(tituloMarco));
    }
    private void jbtCalculoPagosActionPerformed(java.awt.event.ActionEvent evt)
    {
        try
        {
            credito = Double.parseDouble(jtfCredito.getText());
            periodoMin = Integer.parseInt(jtfPeriodoMin.getText());
            periodoMax = Integer.parseInt(jtfPeriodoMax.getText());
            interesMin = Double.parseDouble(jtfInteresMin.getText());
            interesMax = Double.parseDouble(jtfInteresMax.getText());
            incremento = Double.parseDouble((String)jcbIncremento.getSelectedItem());
            if (credito <= 0 ||
                    periodoMin <= 0 || periodoMax <= 0 || periodoMax < periodoMin ||
                    interesMin < 0 || interesMax < 0 || interesMax < interesMin ||
                    incremento < 0)
                throw new NumberFormatException();
        }
        catch(NumberFormatException e)
        {
            javax.swing.JOptionPane.showMessageDialog(
                null, "Datos no válidos.",
                "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        int tiposIntrs = (int)((interesMax - interesMin) / incremento) + 1;
        int añosMeses = (periodoMax - periodoMin) + 1;
        int filas = tiposIntrs, cols = añosMeses;
        if (tiposIntrs < 18) filas = 18;
        if (añosMeses < 4) cols  = 4;
        initTable(filas, cols + 1);
        jtablaCabsFilas.setValueAt(AlinDer("##0.00", interesMin) + "%", 0, 0);
        for (int fila = 1; fila < tiposIntrs; ++fila)
            jtablaCabsFilas.setValueAt(AlinDer("##0.00",
                interesMin + incremento * fila) + "%", fila, 0);
        javax.swing.table.TableColumn column = null;
        String per = " años";
        if (jmItemAños.isEnabled()) per = " meses";
        for (int columna = 0; columna < añosMeses; ++ columna)
        {
            column = jtablaPrestamo.getColumnModel().getColumn(columna);
            column.setHeaderValue((periodoMin + columna) + per);
        }
        int P = 0;
        if (!jmItemAños.isEnabled())
            P = 12;
        else
            P = 1;
        double interes = 0.0;
        pagoMensual = 0.0;
        int meses;
        for (int fila = 0; fila < tiposIntrs; ++fila)
        {
            String sinteres = jtablaCabsFilas.getValueAt(fila, 0).toString();
            sinteres = sinteres.substring(0, sinteres.indexOf('%'));
            sinteres = sinteres.replace(',', '.');
            interes = Double.parseDouble(sinteres) / 100 / 12;
            for (int columna = 0; columna < añosMeses; ++columna)
            {
                TableColumn colum = jtablaPrestamo.getColumnModel().getColumn(columna);
                String smeses = (String)colum.getHeaderValue();
                smeses = smeses.substring(0, smeses.indexOf(' '));
                meses = Integer.parseInt(smeses) * P;
                if (interes == 0.0)
                    pagoMensual = credito / meses;
                else
                    pagoMensual = credito * (interes / (1 - (1 /
                            (Math.pow(1.0 + interes, (double)meses)))));
                jtablaPrestamo.setValueAt(AlinDer("###,###,##0.00",
                        pagoMensual), fila, columna);
            }
        }
        tablaPagos = true;
    }
    private StringBuffer AlinDer(String patrón, double dato)
    {
        java.text.FieldPosition fp =
                new java.text.FieldPosition(java.text.NumberFormat.FRACTION_FIELD);
        java.text.DecimalFormat formato = new java.text.DecimalFormat(patrón);
        StringBuffer salida = new StringBuffer();
        formato.format(dato, salida, fp);
        for (int i = 0; i < (patrón.length() - fp.getEndIndex()); i++)
            salida.insert(0, ' ');
       return salida;
    }
    private void jtablaPrestamoMouseClicked(java.awt.event.MouseEvent evt)
    {
        Object datoCelda = jtablaPrestamo.getValueAt(
            jtablaPrestamo.getSelectedRow(),
            jtablaPrestamo.getSelectedColumn());
        if (datoCelda != null && tablaPagos)
        {
            try
            {
                java.text.DecimalFormat formato =
                        new java.text.DecimalFormat("###,###,##0.00");
                    Number numero = formato.parse(datoCelda.toString().trim());
                pagoMensual = numero.doubleValue();
                jbtCalculoAmort.setEnabled(true);
            }
            catch (java.text.ParseException e)
            {
                jbtCalculoAmort.setEnabled(false);
            }
        }
    }
    private void jbtCalculoAmortActionPerformed(java.awt.event.ActionEvent evt)
    {
        int fila = jtablaPrestamo.getSelectedRow();
        int columna = jtablaPrestamo.getSelectedColumn();
        String sinteres = (String)jtablaCabsFilas.getValueAt(fila, 0);
        sinteres = sinteres.substring(0, sinteres.indexOf('%'));
        sinteres = sinteres.replace(',', '.');
        double interes = Double.parseDouble(sinteres) / 100 / 12;
        int P = 0;
        if (!jmItemAños.isEnabled())
            P = 12;
        else
           P = 1;
        javax.swing.table.TableColumn colum = null;
        colum = jtablaPrestamo.getColumnModel().getColumn(columna);
        String smeses = (String)colum.getHeaderValue();
        smeses = smeses.substring(0, smeses.indexOf(' '));
        int meses = Integer.parseInt(smeses) * P;
        int filas = meses, cols = 5;
        if (filas < 18) filas = 18;
        initTable(filas, cols);
        for (int mes = 0; mes < meses; ++mes)
            jtablaCabsFilas.setValueAt(AlinDer("#####", mes + 1), mes, 0);
        String cab[] = {"Capital", "Intereses", "Capital Pendiente", "Total Intereses"};
        for (columna = 0; columna < 4; ++columna)
        {
            colum = jtablaPrestamo.getColumnModel().getColumn(columna);
            colum.setHeaderValue(cab[columna]);
        }
        double interesesMensuales = 0, creditoPendiente = credito;
        double capitalMensualAmort = 0, totalIntereses = 0;
        String formato = "###,###,##0.00";
        for (int mes = 0; mes < meses; ++mes)
        {
            interesesMensuales = creditoPendiente * interes;
            capitalMensualAmort = pagoMensual - interesesMensuales;
            creditoPendiente -= pagoMensual - interesesMensuales;
            totalIntereses += interesesMensuales;
            jtablaPrestamo.setValueAt(AlinDer(formato, capitalMensualAmort), mes, 0);
            jtablaPrestamo.setValueAt(AlinDer(formato, interesesMensuales), mes, 1);
            jtablaPrestamo.setValueAt(AlinDer(formato, creditoPendiente), mes, 2);
            jtablaPrestamo.setValueAt(AlinDer(formato, totalIntereses), mes, 3);
        }
        jbtCalculoAmort.setEnabled(false);
        tablaPagos = false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPrestamo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtfCredito = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfPeriodoMax = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfPeriodoMin = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jtfInteresMax = new javax.swing.JTextField();
        jtfInteresMin = new javax.swing.JTextField();
        jcbIncremento = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbtCalculoPagos = new javax.swing.JButton();
        jbtCalculoAmort = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmnuOpciones = new javax.swing.JMenu();
        jmItemInstruc = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmItemSalir = new javax.swing.JMenuItem();
        jmnuPrestamoEn = new javax.swing.JMenu();
        jmItemAños = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmItemMeses = new javax.swing.JMenuItem();
        jmnuAyuda = new javax.swing.JMenu();
        jmItemAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaPrestamo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaPrestamo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaPrestamo.setMaximumSize(new java.awt.Dimension(180, 345));
        tablaPrestamo.setMinimumSize(new java.awt.Dimension(180, 345));
        tablaPrestamo.setPreferredSize(new java.awt.Dimension(180, 345));
        jScrollPane1.setViewportView(tablaPrestamo);

        jLabel1.setText("Crédito:");

        jtfCredito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Duración del Préstamo"));

        jLabel2.setText("Máximo:");

        jtfPeriodoMax.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setText("Mínimo:");

        jtfPeriodoMin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfPeriodoMax)
                    .addComponent(jtfPeriodoMin))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPeriodoMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPeriodoMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Interés"));

        jtfInteresMax.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jtfInteresMin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jcbIncremento.setEditable(true);
        jcbIncremento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0.10", "0.25", "0.50", "1.00" }));

        jLabel4.setText("% máximo:");

        jLabel5.setText("% mínimo:");

        jLabel6.setText("Incremento:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfInteresMax)
                    .addComponent(jtfInteresMin)
                    .addComponent(jcbIncremento, 0, 110, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfInteresMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfInteresMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbIncremento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)))
        );

        jbtCalculoPagos.setText("Pagos");

        jbtCalculoAmort.setText("Amortización");
        jbtCalculoAmort.setEnabled(false);

        jmnuOpciones.setMnemonic('O');
        jmnuOpciones.setText("Opciones");

        jmItemInstruc.setMnemonic('I');
        jmItemInstruc.setText("Instrucciones...");
        jmnuOpciones.add(jmItemInstruc);
        jmnuOpciones.add(jSeparator1);

        jmItemSalir.setMnemonic('S');
        jmItemSalir.setText("Salir");
        jmnuOpciones.add(jmItemSalir);

        jMenuBar1.add(jmnuOpciones);

        jmnuPrestamoEn.setMnemonic('P');
        jmnuPrestamoEn.setText("Préstamo en...");

        jmItemAños.setMnemonic('A');
        jmItemAños.setText("Años");
        jmnuPrestamoEn.add(jmItemAños);
        jmnuPrestamoEn.add(jSeparator2);

        jmItemMeses.setMnemonic('M');
        jmItemMeses.setText("Meses");
        jmnuPrestamoEn.add(jmItemMeses);

        jMenuBar1.add(jmnuPrestamoEn);

        jmnuAyuda.setMnemonic('A');
        jmnuAyuda.setText("Ayuda");

        jmItemAcercaDe.setMnemonic('A');
        jmItemAcercaDe.setText("Acerca de Préstamo...");
        jmnuAyuda.add(jmItemAcercaDe);

        jMenuBar1.add(jmnuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtCalculoPagos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCredito))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtCalculoAmort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtCalculoPagos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtCalculoAmort)
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new jfrmPrestamoBancario().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JButton jbtCalculoAmort;
    private javax.swing.JButton jbtCalculoPagos;
    private javax.swing.JComboBox<String> jcbIncremento;
    private javax.swing.JMenuItem jmItemAcercaDe;
    private javax.swing.JMenuItem jmItemAños;
    private javax.swing.JMenuItem jmItemInstruc;
    private javax.swing.JMenuItem jmItemMeses;
    private javax.swing.JMenuItem jmItemSalir;
    private javax.swing.JMenu jmnuAyuda;
    private javax.swing.JMenu jmnuOpciones;
    private javax.swing.JMenu jmnuPrestamoEn;
    private javax.swing.JTextField jtfCredito;
    private javax.swing.JTextField jtfInteresMax;
    private javax.swing.JTextField jtfInteresMin;
    private javax.swing.JTextField jtfPeriodoMax;
    private javax.swing.JTextField jtfPeriodoMin;
    private javax.swing.JTable tablaPrestamo;
    // End of variables declaration//GEN-END:variables
}
