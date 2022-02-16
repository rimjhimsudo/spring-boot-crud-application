package bankmanagmentsystem.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="branch")
@Getter @Setter @NoArgsConstructor @ToString
public class Branch {
    @GeneratedValue
    @Id
    @Column(name="code", length=3, nullable=false, unique=true)
    private Long code; //101 onwards
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String phoneNumber; //numeric
    @Column
    private String ifscCode; //alphanumeric
    @CreationTimestamp
    public LocalDateTime createdAt;
    @UpdateTimestamp
    public LocalDateTime updatedAt;
    @OneToMany(mappedBy = "branch")
    private List<Account> lists;
}
