package com.infskills.data.entities;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jondann on 3/25/16.
 */

@Entity
@Table(name = "finances_user")
@Access(value = AccessType.PROPERTY)
public class User {

    private Long userId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String emailAddress;
    private Date lastUpdateDate;
    private String lastUpdateBy;
    private Date createdDate;
    private String createdBy;
    private boolean valid;

    private int age;

    @Transient //will not be auto imported into database
    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generate a value, database provides the value // FOR ORACLE: GenerationType.Sequence and @SequenceGenerator(name = "user_seq", sequenceName = "USER_ID_SEQ")
    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //@Basic - can provide same functionality as nullable
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE", nullable = false)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "EMAIL_ADDRESS")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_UPDATED_DATE")
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Column(name = "LAST_UPDATED_BY")
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    @Temporal(TemporalType.DATE)    //tell hibernate how we want to store and retrieve date/time
    @Column(name = "CREATED_DATE", updatable = false) //updatable = false doesn't include in any secondary queries
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "CREATED_BY", updatable = false)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Formula("lower(datediff(curdate(), birth_date)/365)") //sql formuala - run select first to refresh persistence context
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
