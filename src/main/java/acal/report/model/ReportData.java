package acal.report.model;

import acal.commons.Report;
import lombok.Builder;
import lombok.Data;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.Map;

@Data
@Builder
public class ReportData {

    private Report report;
    private JRBeanCollectionDataSource dataSource;

    private Map<String, Object> param;

}
