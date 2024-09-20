package br.org.acal.resouces.report.create;

import br.org.acal.domain.datasource.ReportDataSource;
import br.org.acal.domain.entity.ReportData;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.swing.JOptionPane;
import java.io.InputStream;
import java.util.HashMap;

import static javax.swing.JOptionPane.showMessageDialog;

@Repository
@Profile("prod")
public class ProdReportRepository implements ReportDataSource {
    private final Logger logger = LoggerFactory.getLogger(ProdReportRepository.class);

    @Override
    public void create(ReportData data) throws JRException {
        String reportPath = data.getPrintPaths().getPath();
        logger.info("Tentando carregar o relatório a partir do caminho: {}", reportPath);

        try {
            InputStream masterReportStream = getClass().getResourceAsStream(reportPath);
            InputStream masterDetailStream = getClass().getResourceAsStream("/print/acal/test.jasper");

            JasperReport masterReport = (JasperReport) JRLoader.loadObject(masterReportStream);
            JasperReport detailReport = (JasperReport) JRLoader.loadObject(masterDetailStream);

            if (data.getParam() == null) {
                data.setParam(new HashMap<>());
            }

            data.getParam().put("SUBREPORT_DETAIL", detailReport);

            JasperPrint jasperPrint = JasperFillManager.fillReport(
                masterReport,
                data.getParam(),
                data.getDataSource()
            );

            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            logger.error("Erro ao gerar o relatório", e);
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
