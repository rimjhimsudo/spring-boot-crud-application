package bankmanagmentsystem.model;

import bankmanagmentsystem.encryption.StringAttributeConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="debitcard")
@Getter @Setter @NoArgsConstructor @ToString
public class DebitCard {
    @Id
    @Column(name="num", length=10, nullable=false, unique=true)
    private String num;
    @Column
    @Convert(converter = StringAttributeConverter.class)
    private String cvv;   //must be encypted
    @Column
    private String holderName;
    /*@Column //fk
    private String debitAccountNumber;*/   //debit card associated to
    @CreationTimestamp
    public LocalDateTime createdAt;

    @UpdateTimestamp
    public LocalDateTime updatedAt;
}
