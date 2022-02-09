package bankmanagmentsystem.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name="employee")
@Setter @Getter @NoArgsConstructor @ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer empId;

    private String empName;

    private String empDob; //date of birth

    private String empDoj; //date of joining

    private String empRole;

    @Enumerated(EnumType.STRING)
    private Gender empGender;

    @CreationTimestamp
    public LocalDateTime createdAt;

    @UpdateTimestamp
    public LocalDateTime updatedAt;

    private enum Gender {
        MALE,
        FEMALE
    }


}
