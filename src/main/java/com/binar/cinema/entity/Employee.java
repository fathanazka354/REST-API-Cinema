package com.binar.cinema.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long employeeId;

    @NotEmpty(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "telephone_number", nullable = false)
    private String telephoneNumber;

    @NotEmpty(message = "Address is required")
    @Column(name = "address", nullable = false)
    private String address;

    @NotEmpty(message = "Email is required")
    @Column(name = "email", nullable = false)
    private String email;

    @NotEmpty(message = "password is required")
    @Column(name = "password", nullable = false)
    private String password;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+7")
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
