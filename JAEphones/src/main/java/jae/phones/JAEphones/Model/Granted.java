package jae.phones.JAEphones.Model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "granted")
@EntityListeners(AuditingEntityListener.class)
public class Granted extends DateAudit {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private Instant granteDate;

    @Column(nullable = true)
    private String phone;

    private Boolean isCharge;

    private Boolean active;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Person person;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sim_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Sim sim;

    public Granted() {
        this.isCharge = false;
        this.active = true;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getGranteDate() {
        return this.granteDate;
    }

    public void setGranteDate(Instant granteDate) {
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

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}