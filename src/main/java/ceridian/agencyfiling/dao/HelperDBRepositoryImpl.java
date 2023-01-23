package ceridian.agencyfiling.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class HelperDBRepositoryImpl implements HelperDBRepository {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public String getLiquidTemplateString(int agencyId){
        return jdbcTemplate.queryForObject("SELECT LiquidMap FROM Agencies WHERE AgencyID=?", liqTemplateStringMapper, agencyId);
    }

    private static final RowMapper<String> liqTemplateStringMapper = (rs, rowNum) -> rs.getString("LiquidMap");

}
