package ceridian.agencyfiling.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Agencies")
public class Agency {

    @Id
    @Column(name="AgencyID")
    private int agencyId;

    @Column(name="SourceSystemID")
    private int sourceSystemId;

    @Column(name="AgencyTaxCode")
    private String agencyTaxCode;

    @Column(name="AgencyTaxState")
    private String agencyTaxState;

    @Column(name="AgencyDescription")
    private String agencyDescription;

    @Column(name="OutputFormat")
    private String outputFormat;

    @Column(name="LiquidMap", columnDefinition="ntext")
    private String liquidMap;

    @Column(name="KafkaTopicToListen")
    private String kafkaTopicToListen;

    @Column(name="SchemaName")
    private String schemaName;

    @Column(name = "AddedOn")
    private LocalDateTime addedOn;

    //getters and setters
}
