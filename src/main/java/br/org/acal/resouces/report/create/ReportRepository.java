package br.org.acal.resouces.report.create;

import br.org.acal.commons.util.DefaultLocale;
import br.org.acal.domain.datasource.ReportDataSource;
import br.org.acal.domain.entity.ReportData;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.HashMap;

@Repository
public class ReportRepository implements ReportDataSource {

    private static final String SEPARATOR = File.separator;
    @Override
    public void create(ReportData data) throws JRException {
        var dirPath = System.getProperty("user.home") + SEPARATOR + "acal" + SEPARATOR + "reports";
        var mainReportPath = dirPath + SEPARATOR + data.getPrintPaths().getPath().replace("/", SEPARATOR);

        String invoiceParamPath = dirPath + SEPARATOR +"invoiceParam.jrxml";
        JasperReport reportParam = JasperCompileManager.compileReport(invoiceParamPath);

        String invoiceDetailPath = dirPath + SEPARATOR +"invoiceDetail.jrxml";
        JasperReport reportDetail = JasperCompileManager.compileReport(invoiceDetailPath);

        if(data.getParam() == null){
            data.setParam(new HashMap<>());
        }
        data.getParam().put("SUBREPORT", reportParam);
        data.getParam().put("SUBREPORT_DETAIL", reportDetail);

        JasperReport mainReport = JasperCompileManager.compileReport(mainReportPath);

        var jasperPrint = JasperFillManager.fillReport(
                mainReport,
                data.getParam(),
                data.getDataSource()
        );

        JasperViewer.viewReport(jasperPrint, false);

    }

    @Override
    public void createRegister(ReportData data) throws JRException {
        var dirPath = System.getProperty("user.home") + SEPARATOR + "acal" + SEPARATOR + "reports";
        var mainReportPath = dirPath + SEPARATOR + data.getPrintPaths().getPath().replace("/", SEPARATOR);

        if(data.getParam() == null){
            data.setParam(new HashMap<>());
        }

        data.getParam().put(JRParameter.REPORT_LOCALE, DefaultLocale.ptBR());
        JasperReport mainReport = JasperCompileManager.compileReport(mainReportPath);

        var jasperPrint = JasperFillManager.fillReport(
                mainReport,
                data.getParam(),
                data.getDataSource()
        );

        JasperViewer.viewReport(jasperPrint, false);

    }
}
