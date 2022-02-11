package bankmanagmentsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="branch")
@Getter @Setter @NoArgsConstructor @ToString
public class Branch {
    @Id
    @Column(name="code", length=3, nullable=false, unique=true)
    private int code; //101 onwards
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
}
