package com.newton.holidaymaker.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id") private int customerId;
    @Column(name="phone_no")    private String phoneNumber;
    @Column(name="first_name")  private String firstname;
    @Column(name="last_name")   private String lastname;
    @Column(name="email")       private String email;
    @Column(name="username")    private String username;
    @Column(name="password")    private String password;
    @Column(name="roles")       private String roles = "USER";
    @Column(name="permissions") private String permissions = "USER_READ";

    // @OneToMany(mappedBy = "user")
    // private Set<Booking> usersBookings;

    public User() { }
    public User(String firstname, String lastname, String phoneNumber, String email, String username, String password, String roles, String permissions) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.permissions = permissions;
    }

    // Getters
    public int getCustomerId()      { return customerId;  }
    public String getPhoneNumber()     { return phoneNumber; }
    public String getFirstname()    { return firstname;   }
    public String getLastname()     { return lastname;    }
    public String getUsername()     { return username;    }
    public String getPassword()     { return password;    }
    public String getEmail()        { return email;       }
    public String getRoles()        { return roles;       }
    public String getPermissions()  { return permissions; }

    public List<String> getRoleList() {
        if(this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList() {
        if(this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

    // Setters
    public void setFirstname(String firstname)      { this.firstname    = firstname;   }
    public void setLastname(String lastname)        { this.lastname     = lastname;    }
    public void setUsername(String username)        { this.username     = username;    }
    public void setEmail(String email)              { this.email        = email;       }
    public void setPassword(String password)        { this.password     = password;    }
    public void setCustomerId(int id)               { this.customerId   = id;          }
    public void setRoles(String roles)              { this.roles        = roles;       }
    public void setPermissions(String permissions)  { this.permissions  = permissions; }

    public void setPhoneNumber(String phoneNumber)
    {

        this.phoneNumber  = phoneNumber;
    }
}
