package br.org.acal.resouces.report.create;

import br.org.acal.domain.entity.ReportData;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

@Repository
public class ReportRepository {

    public void create(ReportData data) throws JRException {

        var absolutePath = getClass().getResourceAsStream(data.getPrint().getPath());
        var pathReport = getClass().getResource(data.getPrint().getPath()).getPath();

        if(data.getParam() == null){
            Map<String, Object> map = new HashMap<>();
            data.setParam(map);
        }

        data.getParam().put("SUBREPORT_DIR", getAbsolutePath(pathReport));

        try {
            JasperReport masterReport = JasperCompileManager.compileReport(absolutePath);

            JasperViewer.viewReport(
                    JasperFillManager.fillReport(
                            masterReport,
                            data.getParam(),
                            data.getDataSource()
                    ), false);

        } catch (Exception e){
            showMessageDialog(null, e.getMessage(), "Error", INFORMATION_MESSAGE);
        }

    }

    private String getAbsolutePath(String data){

        try {

            String resourcePath = data + File.separator;

            if (resourcePath.startsWith("/")) {
                resourcePath = resourcePath.substring(1);
            }
            Path filePath = Paths.get(resourcePath);
            Path directoryPath = filePath.getParent();

            return directoryPath.toAbsolutePath() + File.separator;

        } catch (Exception e) {
            throw new RuntimeException("Caminho invalido");
        }
    }

}
