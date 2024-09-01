package br.org.acal.resouces.repository;

import br.org.acal.domain.model.WaterQuality;
import br.org.acal.resouces.adapter.WaterQualityAdapter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public class WaterQualityRepository {

    private final WaterQualityRepositoryInterface waterQualityRepositoryInterface;

    public WaterQualityRepository(WaterQualityRepositoryInterface waterQualityRepositoryInterface){
        this.waterQualityRepositoryInterface = waterQualityRepositoryInterface;
    }

    public List<WaterQuality> find(List<LocalDate> duoDate) {
        return waterQualityRepositoryInterface.findAll().stream().map(WaterQualityAdapter::map).toList();

        /*
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<WaterQualityModel> cq = cb.createQuery(WaterQualityModel.class);
            Root<WaterQualityModel> waterQuality = cq.from(WaterQualityModel.class);

            // Assuming 'date' is a LocalDate field in WaterQualityModel
            cq.where(waterQuality.get("date").in(duoDate));

            Query<WaterQualityModel> query = session.createQuery(cq);
            List<WaterQualityModel> resultList = query.getResultList();

            return resultList.stream().map(it ->
                    WaterQuality.builder()
                            .waterParam(WaterQualityParameter.fromNumber(it.getParam()))
                            .number(it.getNumber())
                            .required(it.getRequired())
                            .analyzed(it.getAnalyzed())
                            .accordance(it.getAccordance())
                            .date(it.getDate())
                            .build()
            ).toList();
        }
        */
    }

}
