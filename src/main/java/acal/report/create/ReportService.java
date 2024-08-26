package acal.report.create;

import acal.report.model.ReportData;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

public class ReportService {
    public void create(ReportData data) throws JRException {

        JasperViewer.viewReport(
                JasperFillManager.fillReport(
                        getClass().getResourceAsStream(data.getReport().getPath()),
                        data.getParam(),
                        data.getDataSource()), false);
    }
}
