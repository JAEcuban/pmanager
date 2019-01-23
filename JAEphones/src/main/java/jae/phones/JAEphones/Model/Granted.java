package jae.phones.JAEphones.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "granted")
@EntityListeners(AuditingEntityListener.class)
public class Granted implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotBlank
    private Date granteDate;

    @Column(nullable = true)
    private String phone;

    private Boolean isCharge;

    @NotNull
    private Person person;

    @NotNull
    private Sim sim;

    public Granted() {
        this.isCharge = false;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGranteDate() {
        return this.granteDate;
    }

    public void setGranteDate(Date granteDate) {
        this.granteDate = granteDate;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsCharge() {
        return this.isCharge;
    }

    public void setIsCharge(Boolean isCharge) {
        this.isCharge = isCharge;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Sim getSim() {
        return this.sim;
    }

    public void setSim(Sim sim) {
        this.sim = sim;
    }
}