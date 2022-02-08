package bankmanagmentsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="account")
@Getter @Setter @NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //AUTO: JPA provider will use any strategy it wants to generate the identifiers
    private Integer accId;
    @Column(name="accNumber", length=10, nullable=false, unique=true)
    private String accNumber;
    @Column
    private String accHolderName;
    @Column
    private Integer accBalance;
    @Column
    private Date accOpenDate;
    /*@Column //make enum
    private String accType; */ //saving or current or demat

}
