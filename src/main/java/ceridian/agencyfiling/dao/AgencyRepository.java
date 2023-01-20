package ceridian.agencyfiling.dao;

import ceridian.agencyfiling.entity.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface AgencyRepository extends JpaRepository<Agency, Integer> {

}

