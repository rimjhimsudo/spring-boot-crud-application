package bankmanagmentsystem.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity   //annotations to make table at backend
@Table(name="customer")
public class Customer {
    //annotation for FK to declare foreign key
    @Id
    @Column
    private Integer cusId;
    @Column
    private String cusName;
    @Column
    private String cusAddress;
    @Column
    private String cusPhoneNumber;
    @CreatedDate
    private Date createdAt;
    //https://stackoverflow.com/questions/49954812/how-can-you-make-a-created-at-column-generate-the-creation-date-time-automatical
    @LastModifiedDate
    private Date updatedAt;
    //default constructor is neccessary if creating more parametrised constructr else gives error
    public Customer() {
    }

    /* //not a good practice, use onl getters and setters to set and get values
    public Customer(Integer cus_id, String cus_name,String cus_phone_no) {
        this.cus_id = cus_id;
        this.cus_name = cus_name;
        this.cus_phone_no = cus_phone_no;
    }*/

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusPhoneNumber() {
        return cusPhoneNumber;
    }

    public void setCusPhoneNumber(String cusPhoneNumber) {
        this.cusPhoneNumber = cusPhoneNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusId=" + cusId +
                ", cusName='" + cusName + '\'' +
                ", cusAddress='" + cusAddress + '\'' +
                ", cusPhoneNumber='" + cusPhoneNumber + '\'' +
                '}';
    }
}
