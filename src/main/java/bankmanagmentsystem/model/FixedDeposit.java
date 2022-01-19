package bankmanagmentsystem.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Date;

public class FixedDeposit {
    @Id
    @Column
    private int fd_id;
    @Column
    private int fd_amount;
    @Column
    private int fd_period;   // only in years for now  i.e. 1,2,3,n
    @Column
    private int fd_acc_num;
    @Column
    private Date fd_start_date;

    public FixedDeposit(int fd_id, int fd_amount, int fd_period, int fd_acc_num, Date fd_start_date) {
        this.fd_id = fd_id;
        this.fd_amount = fd_amount;
        this.fd_period = fd_period;
        this.fd_acc_num = fd_acc_num;
        this.fd_start_date = fd_start_date;
    }

    public int getFd_id() {
        return fd_id;
    }

    public void setFd_id(int fd_id) {
        this.fd_id = fd_id;
    }

    public int getFd_amount() {
        return fd_amount;
    }

    public void setFd_amount(int fd_amount) {
        this.fd_amount = fd_amount;
    }

    public int getFd_period() {
        return fd_period;
    }

    public void setFd_period(int fd_period) {
        this.fd_period = fd_period;
    }

    public int getFd_acc_num() {
        return fd_acc_num;
    }

    public void setFd_acc_num(int fd_acc_num) {
        this.fd_acc_num = fd_acc_num;
    }

    public Date getFd_start_date() {
        return fd_start_date;
    }

    public void setFd_start_date(Date fd_start_date) {
        this.fd_start_date = fd_start_date;
    }

    @Override
    public String toString() {
        return "FixedDeposit{" +
                "fd_id=" + fd_id +
                ", fd_amount=" + fd_amount +
                ", fd_period=" + fd_period +
                ", fd_acc_num=" + fd_acc_num +
                ", fd_start_date=" + fd_start_date +
                '}';
    }
}
