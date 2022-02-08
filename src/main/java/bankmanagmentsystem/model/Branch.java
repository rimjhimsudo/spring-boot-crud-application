package bankmanagmentsystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="branch")
@Getter @Setter @NoArgsConstructor
public class Branch {
    @Id
    @Column
    private int branchCode;
    @Column
    private String branchName;
    @Column
    private String branchAddress;
    @Column
    private long branchPhoneNumber;
    @Column
    private long branchIfscCode;


}
