package bankmanagmentsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
public class FixedDeposit {
    @Id
    @Column
    @GeneratedValue
    private Integer fdId;
    @Column
    private Integer fdAmount;
    @Column
    private Integer fdPeriod;   // only in years for now  i.e. 1,2,3,n
    @Column
    private String fdAccountnumber;
    @Column
    private Date fdStartdate;

}
