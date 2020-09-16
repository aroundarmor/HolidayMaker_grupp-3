package com.newton.holidaymaker.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id") private int customerId;
    @Column(name="phone_no")    private int phoneNumber;
    @Column(name="first_name")  private String firstname;
    @Column(name="last_name")   private String lastname;
    @Column(name="email")       private String email;
    @Column(name="username")    private String username;
    @Column(name="password")    private String password;

    public User() { }
    public User(String firstname, String lastname, int phoneNumber, String email, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    // Getters
    public int getCustomerId()   { return customerId;  }
    public int getPhoneNumber()  { return phoneNumber; }
    public String getFirstname() { return firstname;   }
    public String getLastname()  { return lastname;    }
    public String getUsername()  { return username;    }
    public String getPassword()  { return password;    }
    public String getEmail()     { return email;       }

    // Setters
    public void setFirstname(String firstname)  { this.firstname    = firstname;   }
    public void setLastname(String lastname)    { this.lastname     = lastname;    }
    public void setUsername(String username)    { this.username     = username;    }
    public void setEmail(String email)          { this.email        = email;       }
    public void setPhoneNumber(int phoneNumber) { this.phoneNumber  = phoneNumber; }
    public void setPassword(String password)    { this.password     = password;    }
    public void setCustomerId(int customerId)   { this.customerId   = customerId;  }
}
