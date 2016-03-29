package com.infskills.data.entities;

import javax.persistence.*;

/**
 * Created by jdann on 3/29/2016.
 */

@Entity
@Table(name="credential")
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "credential_id")
    public Long credentialId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public Long getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Long credentialId) {
        this.credentialId = credentialId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
