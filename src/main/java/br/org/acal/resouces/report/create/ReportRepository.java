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
public class ReportRepository implements ReportDataSource {
    private final Logger logger = LoggerFactory.getLogger(ReportRepository.class);
    private final String separator = File.separator;
    @Override
    public void create(ReportData data) throws JRException {
        var dirPath = System.getProperty("user.home") + separator + "acal" + separator + "reports";
        var mainReportPath = dirPath + separator + data.getPrintPaths().getPath().replace("/", separator);

        String invoiceParamPath = dirPath + separator +"invoiceParam.jrxml";
        JasperReport reportParam = JasperCompileManager.compileReport(invoiceParamPath);

        String invoiceDetailPath = dirPath + separator +"invoiceDetail.jrxml";
        JasperReport reportDetail = JasperCompileManager.compileReport(invoiceDetailPath);

        if(data.getParam() == null){
            data.setParam(new HashMap<>());
        }
        data.getParam().put("SUBREPORT", reportParam);
        data.getParam().put("SUBREPORT_DETAIL", reportDetail);

        try {
            JasperReport mainReport = JasperCompileManager.compileReport(mainReportPath);

            var jasperPrint = JasperFillManager.fillReport(
                    mainReport,
                    data.getParam(),
                    data.getDataSource()
            );

            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            logger.error("Error generating report: ", e);
            showMessageDialog(null, "An error occurred while generating the report: " + e.getMessage(), "Error", INFORMATION_MESSAGE);
        }
    }


}
