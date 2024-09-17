package br.org.acal.resouces.report.create;

import br.org.acal.domain.datasource.ReportDataSource;
import br.org.acal.domain.entity.ReportData;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

@Repository
@Profile("dev")
public class ReportRepository implements ReportDataSource {
    private final Logger logger = LoggerFactory.getLogger(ReportRepository.class);

    @Override
    public void create(ReportData data) throws JRException {

        var absolutePath = getClass().getResourceAsStream(data.getPrint().getPath());
        var pathReport = getClass().getResource(data.getPrint().getPath()).getPath();

        if(data.getParam() == null){
            Map<String, Object> map = new HashMap<>();
            data.setParam(map);
        }

        data.getParam().put("SUBREPORT_DIR", getAbsolutePath(pathReport));

        try {
            JasperReport masterReport = (JasperReport) JRLoader.loadObject(absolutePath);
            JasperViewer.viewReport(
                    JasperFillManager.fillReport(
                            masterReport,
                            data.getParam(),
                            data.getDataSource()
                    ), false);

        } catch (Exception e){
            logger.error("Error ",e);
            showMessageDialog(null, e, "Error", INFORMATION_MESSAGE);
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
            logger.error("Erro ao capturar o caminho do relatorio",e);
            throw new RuntimeException("Caminho invalido", e);
        }
    }

}
