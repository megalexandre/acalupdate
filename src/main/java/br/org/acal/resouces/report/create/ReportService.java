package br.org.acal.resouces.report.create;

import br.org.acal.domain.entity.ReportData;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ReportService {
    public void create(ReportData data) throws JRException {

        JasperReport masterReport = JasperCompileManager.compileReport(
                getClass().getResourceAsStream(data.getPrint().getPath())
        );

        JasperViewer.viewReport(
                JasperFillManager.fillReport(
                        masterReport,
                        data.getParam(),
                        data.getDataSource()
                ), true);
    }
}
