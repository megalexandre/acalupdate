package br.org.acal.domain.entity;

import br.org.acal.commons.PrintPaths;
import lombok.Builder;
import lombok.Data;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.Map;

@Data
@Builder
public class ReportData {

    private PrintPaths printPaths;
    private JRBeanCollectionDataSource dataSource;

    private Map<String, Object> param;

}
