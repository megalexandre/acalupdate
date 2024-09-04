package br.org.acal.resouces.repository.impl;

import br.org.acal.domain.entity.WaterQuality;
import br.org.acal.domain.datasource.WaterQualityDataSource;
import br.org.acal.resouces.adapter.WaterQualityAdapter;
import br.org.acal.resouces.repository.interfaces.WaterQualityRepositoryJpa;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public class WaterQualityRepositoryImpl implements WaterQualityDataSource {
    private final WaterQualityRepositoryJpa waterQualityRepository;

    public WaterQualityRepositoryImpl(@Lazy WaterQualityRepositoryJpa waterQualityRepository){
        this.waterQualityRepository = waterQualityRepository;
    }

    public List<WaterQuality> find(List<LocalDate> duoDate) {
        return waterQualityRepository.findAll().stream().map(WaterQualityAdapter::map).toList();

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
