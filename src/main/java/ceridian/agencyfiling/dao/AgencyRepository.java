package ceridian.agencyfiling.dao;

import ceridian.agencyfiling.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Integer> {

    @Query(value = "spAgencyGetLiquidMapByAgencyId(:AgencyID);", nativeQuery = true)
    List<Agency> getLiquidMapForAgency(@Param("AgencyID") Integer AgencyID);
//    @Procedure("spAgencyGetLiquidMapByAgencyId")
//    String getLiquidMapForAgency(@Param("AgencyID") Integer agencyId);
}

