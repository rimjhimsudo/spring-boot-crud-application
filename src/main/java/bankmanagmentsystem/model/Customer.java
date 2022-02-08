package bankmanagmentsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="customer")
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    //annotation for FK to declare foreign key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cusId;
    @Column
    private String cusName;
    @Column
    private String cusAddress;
    @Column
    private String cusPhoneNumber;
    @Column
    @Enumerated(EnumType.STRING)
    private Gender cusGender;
    @CreationTimestamp
    public LocalDateTime createdAt;
    //https://stackoverflow.com/questions/49954812/how-can-you-make-a-created-at-column-generate-the-creation-date-time-automatical
    @UpdateTimestamp
    public LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "Customer{" +
                "cusId=" + cusId +
                ", cusName='" + cusName + '\'' +
                ", cusAddress='" + cusAddress + '\'' +
                ", cusPhoneNumber='" + cusPhoneNumber + '\'' +
                ", cusGender=" + cusGender +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    private enum Gender {
        MALE,
        FEMALE
    }
}

/*
    //default constructor is neccessary if creating more parametrised constructr else gives error
    //seter and getters are better way of initialising than do it in parametrised constructor
 */