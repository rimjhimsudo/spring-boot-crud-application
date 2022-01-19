package bankmanagmentsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="branch")
public class Branch {
    @Id
    @Column
    private int branch_code;
    @Column
    private String branch_name;
    @Column
    private String branch_address;
    @Column
    private long branch_phone_no;
    @Column
    private long branch_ifsc_code;

    public Branch(int branch_code, String branch_name, String branch_address, long branch_phone_no, long branch_ifsc_code) {
        this.branch_code = branch_code;
        this.branch_name = branch_name;
        this.branch_address = branch_address;
        this.branch_phone_no = branch_phone_no;
        this.branch_ifsc_code = branch_ifsc_code;
    }

    public int getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(int branch_code) {
        this.branch_code = branch_code;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getBranch_address() {
        return branch_address;
    }

    public void setBranch_address(String branch_address) {
        this.branch_address = branch_address;
    }

    public long getBranch_phone_no() {
        return branch_phone_no;
    }

    public void setBranch_phone_no(long branch_phone_no) {
        this.branch_phone_no = branch_phone_no;
    }

    public long getBranch_ifsc_code() {
        return branch_ifsc_code;
    }

    public void setBranch_ifsc_code(long branch_ifsc_code) {
        this.branch_ifsc_code = branch_ifsc_code;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branch_code=" + branch_code +
                ", branch_name='" + branch_name + '\'' +
                ", branch_address='" + branch_address + '\'' +
                ", branch_phone_no=" + branch_phone_no +
                ", branch_ifsc_code=" + branch_ifsc_code +
                '}';
    }
}
