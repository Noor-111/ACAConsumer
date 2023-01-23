package ceridian.agencyfiling.service;

import ceridian.agencyfiling.dao.HelperDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LiquidTemplateServiceImpl implements LiquidTemplateService{
    @Autowired
    private HelperDBRepository helperDBRepository;
    @Override
    public String getLiquidTemplate(int agencyId) {
        String liqTemplate = helperDBRepository.getLiquidTemplateString(agencyId);
        return liqTemplate;
    }
}
