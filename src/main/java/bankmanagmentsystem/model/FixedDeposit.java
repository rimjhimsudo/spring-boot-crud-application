package bankmanagmentsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="fixeddeposit")
public class FixedDeposit {
    @Id
    @Column
    @GeneratedValue
    private Long id;
    @Column
    private Integer principleAmount;
    @Column
    private Integer period;   // only in years for now  i.e. 1,2,3,n
    @Column
    private Date issueDate;
    @CreationTimestamp
    public LocalDateTime createdAt;
    @UpdateTimestamp
    public LocalDateTime updatedAt;

}
