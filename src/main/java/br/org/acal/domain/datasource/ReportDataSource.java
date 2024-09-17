package br.org.acal.domain.datasource;

import br.org.acal.domain.entity.ReportData;
import net.sf.jasperreports.engine.JRException;

public interface ReportDataSource {
    void create(ReportData data) throws JRException;

}
