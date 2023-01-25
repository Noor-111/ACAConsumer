package ceridian.agencyfiling.dao;

public interface HelperDBRepository {
    String getLiquidTemplateString(int agencyId);
    void addNewMessage(String message);
}
