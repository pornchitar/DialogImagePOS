/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.werapan.databaseproject.ui;

import com.werapan.databaseproject.model.Product;
import com.werapan.databaseproject.model.Reciept;
import com.werapan.databaseproject.model.RecieptDetail;
import com.werapan.databaseproject.service.ProductService;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class PosPanel extends javax.swing.JPanel {
    ArrayList<Product> products;
    ProductService productService = new ProductService();
    Reciept reciept;
    /**
     * Creates new form PosPanel
     */
    public PosPanel() {
        initComponents();
        initProductTable();
        reciept = new Reciept();
        tblRecieptDetail.setModel(new AbstractTableModel(){
            String[] headers = {"Name", "Price", "Qty", "Total"};
            @Override
            public String getColumnName(int column) {
                return headers[column];
            }
            
            @Override
            public int getRowCount() {
                return reciept.getRecieptDetails().size();
            }

            @Override
            public int getColumnCount() {
                return 4;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                ArrayList<RecieptDetail> recieptDetails = reciept.getRecieptDetails();
                RecieptDetail recieptDetail = recieptDetails.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return recieptDetail.getProductName();
                    case 1:
                        return recieptDetail.getProductPrice();
                    case 2:
                        return recieptDetail.getQty();
                    case 3:
                        return recieptDetail.getTotalPrice();
                    default:
                        return "";
                }
            }
        
        });
    }

    private void initProductTable() {
        products = productService.getProductsOrderByname();
        tblProduct.getTableHeader().setFont(new Font("TH Sarabun New", Font.PLAIN, 24));
        tblProduct.setRowHeight(100);
        tblProduct.setModel(new AbstractTableModel() {
            String[] headers = {"Image", "ID", "Name", "Price"};
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return ImageIcon.class;
                    default:
                        return String.class;
                }
            }

            @Override
            public String getColumnName(int column) {
                return headers[column];
            }
            
            @Override
            public int getRowCount() {
                return products.size();
            }

            @Override
            public int getColumnCount() {
                return 4;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Product product = products.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        ImageIcon icon = new ImageIcon("./product"+product.getId()+".png");
                        Image image = icon.getImage();
                        int width = image.getWidth(null);
                        int height = image.getHeight(null);
                        Image newImage = image.getScaledInstance((int)((100.0*width)/height), 100, Image.SCALE_SMOOTH);
                        icon.setImage(newImage);
                        return icon;
                    case 1:
                        return product.getId();
                    case 2:
                        return product.getName();
                    case 3:
                        return product.getPrice();
                    default:
                        return "";
                }
            }
        });
        tblProduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblProduct.rowAtPoint(e.getPoint());
                int col = tblProduct.columnAtPoint(e.getPoint());
                System.out.println(products.get(row));
                Product product = products.get(row);
                
                reciept.addRecieptDetail(product, 1);
                refreshReciept();
            }
            
        });
        
    }

    private void refreshReciept() {
        tblRecieptDetail.revalidate();
        tblRecieptDetail.repaint();
        lblTotal.setText("Total: " + reciept.getTotal());
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
        tblProduct = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRecieptDetail = new javax.swing.JTable();
        lblUserName = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        tblProduct.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblProduct);

        tblRecieptDetail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblRecieptDetail.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblRecieptDetail);

        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUserName.setText("User Name");

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("Total: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotal)
                        .addGap(78, 78, 78))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTable tblRecieptDetail;
    // End of variables declaration//GEN-END:variables
}
