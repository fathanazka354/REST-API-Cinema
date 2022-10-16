package com.binar.cinema.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "showtime")
public class ShowTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long showtimeId;

    @Column(name = "showtime_code")
    private String showtimeCode;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_showtime")
    private LocalDate dateShowtime;

    @ManyToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    @JsonIgnore
    @OneToMany(mappedBy = "showTimes",cascade = CascadeType.ALL)
    private Set<Order> order;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+7")
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
