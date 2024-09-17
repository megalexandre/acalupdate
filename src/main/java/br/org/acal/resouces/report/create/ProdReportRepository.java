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
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

@Repository
@Profile("prod")
public class ProdReportRepository implements ReportDataSource {
    private final Logger logger = LoggerFactory.getLogger(ProdReportRepository.class);
    @Override
    public void create(ReportData data) throws JRException {

        String reportPath = data.getPrint().getPath();
        logger.info("Tentando carregar o relatório a partir do caminho: {}", reportPath);

        try {
            InputStream reportStream = getClass().getResourceAsStream(reportPath);

            if (reportStream == null) {
                throw new RuntimeException("Recurso não encontrado: " + reportPath);
            }

            if (data.getParam() == null) {
                Map<String, Object> map = new HashMap<>();
                data.setParam(map);
            }

            URL baseUrl = getClass().getResource("/");
            String subReportDir = baseUrl != null ? baseUrl.getPath() : "/";
            subReportDir = subReportDir.replace("\\", "/");
            if (!subReportDir.endsWith("/")) {
                subReportDir += "/";
            }
            data.getParam().put("SUBREPORT_DIR", subReportDir.replaceFirst("/",""));

            JasperReport masterReport = (JasperReport) JRLoader.loadObject(reportStream);
            JasperViewer.viewReport(
                    JasperFillManager.fillReport(
                            masterReport,
                            data.getParam(),
                            data.getDataSource()
                    ), false);

        } catch (Exception e) {
            logger.error("Erro ao gerar o relatório", e);
            showMessageDialog(null, e.getMessage(), "Erro", INFORMATION_MESSAGE);
        }
    }
}
