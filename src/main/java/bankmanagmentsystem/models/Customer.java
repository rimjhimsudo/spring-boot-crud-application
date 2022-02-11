package bankmanagmentsystem.models;

import bankmanagmentsystem.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name="customer")
@Getter @Setter @NoArgsConstructor @ToString
public class Customer {
    //annotation for FK to declare foreign key
    @Id
    @Column(nullable=false, unique=true)
    private Long id; //1,2,3,4,5(now for ease )
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String phoneNumber;
    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @CreationTimestamp
    public LocalDateTime createdAt;
    //https://stackoverflow.com/questions/49954812/how-can-you-make-a-created-at-column-generate-the-creation-date-time-automatical
    @UpdateTimestamp
    public LocalDateTime updatedAt;


    //@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
    /*
    when we use mappedBy then there is no extra column made in this(customer table) and the new column in account is created once but now mapped as bidirectional thing.
     */




}

/*
    //default constructor is neccessary if creating more parametrised constructr else gives error
    //seter and getters are better way of initialising than do it in parametrised constructor
 */