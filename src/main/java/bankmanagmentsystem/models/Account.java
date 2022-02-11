package bankmanagmentsystem.models;

import bankmanagmentsystem.enums.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="account")
@Getter @Setter @NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO: JPA provider will use any strategy it wants to generate the identifiers
    private Long id;
    @Column(name="accNumber", length=4, nullable=false, unique=true)
    private String number;
    @Column
    private String holderName; //redundant?
    @Column
    private Integer balance;
    @Column
    @CreatedDate
    private Date openDate;
    @Column
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "cusId", referencedColumnName = "cusId") //here name is your choice whatever you want to name foreign key here and referncename is actual key which is in customer table and must be present in customer
    private Customer customer;

    public Customer getCustomer(){
        return customer;
    }
    public void setCustomer(Customer customer){
        this.customer=customer;
    }


}
