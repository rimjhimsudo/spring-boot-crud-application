package bankmanagmentsystem.models;

import bankmanagmentsystem.enums.Gender;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employee")
@Setter @Getter @NoArgsConstructor @ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String dateOfBirth; //date of birth

    private String dateOfjoin; //date of joining

    private String role;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @CreationTimestamp
    public LocalDate createdAt;

    @UpdateTimestamp
    public LocalDate updatedAt;



}
