package br.org.acal.resouces.repository;

import br.org.acal.domain.model.WaterParam;
import br.org.acal.infra.HibernateUtil;
import br.org.acal.domain.model.WaterQuality;
import br.org.acal.resouces.model.WaterQualityModel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;


public class WaterQualityRepository {
    public List<WaterQuality> find(List<LocalDate> duoDate) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<WaterQualityModel> cq = cb.createQuery(WaterQualityModel.class);
            Root<WaterQualityModel> waterQuality = cq.from(WaterQualityModel.class);
            cq.where(waterQuality.get("date").in(duoDate));
            Query<WaterQualityModel> query = session.createQuery(cq);

            return query.getResultList().stream().map(it ->
                    WaterQuality.builder()
                            .waterParam(WaterParam.builder().name("meu pau").build())
                            .number(it.getNumber())
                            .required(it.getRequired())
                            .analyzed(it.getAnalyzed())
                            .accordance(it.getAccordance())
                            .date(it.getDate())
                            .build()
            ).toList();
        }
    }

}
