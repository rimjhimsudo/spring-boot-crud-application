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
    @Column(name="branchCode", length=3, nullable=false, unique=true)
    private int branchCode; //101 onwards
    @Column
    private String branchName;
    @Column
    private String branchAddress;
    @Column
    private String branchPhoneNumber; //numeric
    @Column
    private String branchIfscCode; //alphanumeric

    @CreationTimestamp
    public LocalDateTime createdAt;

    @UpdateTimestamp
    public LocalDateTime updatedAt;
}
