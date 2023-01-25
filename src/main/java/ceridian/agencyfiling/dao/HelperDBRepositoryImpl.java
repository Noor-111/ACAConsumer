package ceridian.agencyfiling.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.Map;


@Repository
public class HelperDBRepositoryImpl implements HelperDBRepository {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public String getLiquidTemplateString(int agencyId){
        RowMapper<String> mapper = (rs, rowNum) -> rs.getString("LiquidMap");
        return jdbcTemplate.queryForObject("SELECT LiquidMap FROM Agencies WHERE AgencyID=?", mapper, agencyId);
    }

    public void addNewMessage(String message){
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
        simpleJdbcCall
                .withProcedureName("[dbo].[USP_AddNewMessage]")
                .declareParameters(
                        new SqlParameter("@MESSAGEJSON",Types.NVARCHAR, Integer.MAX_VALUE)
                );
        Map<String,Object> result = simpleJdbcCall.execute(message);
        System.out.println(result);

    }


}
