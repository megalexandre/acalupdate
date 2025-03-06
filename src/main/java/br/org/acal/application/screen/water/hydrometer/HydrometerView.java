package br.org.acal.application.screen.water.hydrometer;

import br.org.acal.application.screen.render.WaterQualityTableCellRenderer;
import br.org.acal.application.screen.water.hydrometer.create.WaterQualityCreateView;
import br.org.acal.application.screen.water.hydrometer.model.WaterQualityTable;
import br.org.acal.application.screen.water.hydrometer.model.WaterQualityTableModel;
import br.org.acal.domain.usecase.waterQuality.WaterQualityDeleteAllUseCase;
import br.org.acal.domain.usecase.waterQuality.WaterQualityFindAllUseCase;
import br.org.acal.domain.usecase.waterQuality.WaterQualitySaveAllUseCase;
import lombok.val;
import org.jdesktop.swingx.HorizontalLayout;
import org.springframework.stereotype.Component;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static javax.swing.SwingUtilities.getWindowAncestor;

@Component
public class HydrometerView extends JPanel {

    private final WaterQualityFindAllUseCase find;
    private final WaterQualityDeleteAllUseCase delete;
    private final WaterQualitySaveAllUseCase save;

    public HydrometerView(
            WaterQualityFindAllUseCase find,
            WaterQualitySaveAllUseCase save,
            WaterQualityDeleteAllUseCase delete
        ) {
        initComponents();
        this.find = find;
        this.save = save;
        this.delete = delete;
        setContextMenu();
    }

    private void setContextMenu(){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }

            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
                    int row = table.rowAtPoint(e.getPoint());
                    int column = table.columnAtPoint(e.getPoint());

                    if (!table.isRowSelected(row)) {
                        table.setRowSelectionInterval(row, row);
                    }
                    if (!table.isColumnSelected(column)) {
                        table.setColumnSelectionInterval(column, column);
                    }

                    contextMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

    private void deleteAction() {
        int selectedRow = table.getSelectedRow();
        val model = (WaterQualityTableModel) table.getModel();
        val item = model.getItem(selectedRow);
        delete.execute(item.getDate());
        search();
    }

    private void searchEvent(ActionEvent e) {
        search();
    }

    private void search(){
        val waterQualities = find.execute();
        val tableModel = new WaterQualityTableModel(waterQualities.stream().map(WaterQualityTable::of).toList());
        table.setModel(tableModel);

        val render = new WaterQualityTableCellRenderer();
        table.setDefaultRenderer(Object.class, render);
    }

    private void addAction(ActionEvent e) {
        var dialog = new WaterQualityCreateView(getWindowAncestor(this), items -> {
            save.execute(items);
            search();
        });
        dialog.setVisible(true);

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        panel1 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        buttonAdd = new JButton();
        buttonSearch = new JButton();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        contextMenu = new JPopupMenu();
        menuItemDelete = new JMenuItem();

        //======== this ========
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new BorderLayout());

            //======== panel4 ========
            {
                panel4.setLayout(new BorderLayout());

                //======== panel5 ========
                {
                    panel5.setLayout(new HorizontalLayout());

                    //---- buttonAdd ----
                    buttonAdd.setText("Adicionar");
                    buttonAdd.addActionListener(e -> addAction(e));
                    panel5.add(buttonAdd);

                    //---- buttonSearch ----
                    buttonSearch.setText("Consultar");
                    buttonSearch.addActionListener(e -> searchEvent(e));
                    panel5.add(buttonSearch);
                }
                panel4.add(panel5, BorderLayout.EAST);
            }
            panel1.add(panel4, BorderLayout.NORTH);
        }
        add(panel1, BorderLayout.SOUTH);

        //======== panel2 ========
        {
            panel2.setLayout(new BorderLayout());

            //======== scrollPane1 ========
            {

                //---- table ----
                table.setBorder(new EmptyBorder(5, 5, 5, 5));
                table.setCellSelectionEnabled(true);
                table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                scrollPane1.setViewportView(table);
            }
            panel2.add(scrollPane1, BorderLayout.CENTER);
        }
        add(panel2, BorderLayout.CENTER);

        //======== contextMenu ========
        {

            //---- menuItemDelete ----
            menuItemDelete.setText("Deletar");
            menuItemDelete.addActionListener(e -> deleteAction());
            contextMenu.add(menuItemDelete);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JPanel panel1;
    private JPanel panel4;
    private JPanel panel5;
    private JButton buttonAdd;
    private JButton buttonSearch;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JTable table;
    private JPopupMenu contextMenu;
    private JMenuItem menuItemDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
