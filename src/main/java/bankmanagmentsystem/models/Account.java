package bankmanagmentsystem.models;

import bankmanagmentsystem.enums.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="account")
@Getter @Setter @NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //AUTO: JPA provider will use any strategy it wants to generate the identifiers
    private Long id;
    @Column(name="accNumber", length=4,unique=true)
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
    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private List<FixedDeposit> lists;
    @ManyToOne(cascade = CascadeType.ALL)
    private Branch branch;
    @OneToOne(cascade = CascadeType.ALL)
    private DebitCard debitCard;
    public Customer getCustomer(){
        return customer;
    }
    public void setCustomer(Customer customer){
        this.customer=customer;
    }


}
