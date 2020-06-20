package com.meb.projectmanagement.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_accounts_seq")
    @SequenceGenerator(name = "user_accounts_seq", sequenceName = "user_accounts_seq", allocationSize = 1)
    @Column(name = "user_id")
    private long userId;

    @NotBlank(message = "Field doesn't accept empty spaces.")
    @Column(name = "username")
    private String userName;

    @NotBlank(message = "Field doesn't accept empty spaces.")
    @Column(name = "email_address")
    @Email(message = "Must provide a valid email.")
    private String emailAddress;

    @NotBlank(message = "Field doesn't accept empty spaces.")
    private String password;

    private final boolean enabled = true;

    public UserAccount() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
