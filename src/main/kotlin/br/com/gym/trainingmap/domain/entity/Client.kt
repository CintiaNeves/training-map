package br.com.gym.trainingmap.domain.entity

import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "CLIENT")
data class Client(
        @Id
        @Column(name = "IDT_CLIENT")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(name = "NAM_CLIENT", nullable = false)
        var name: String,

        @Column(name = "DES_EMAIL", nullable = false)
        var email: String,

        @Column(name = "DAT_BIRTH", nullable = false)
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        var birthDate: LocalDate,

        @Column(name = "DAT_CREATION")
        @CreationTimestamp
        val dateCreation: LocalDateTime = LocalDateTime.now(),

        @Column(name = "DAT_UPDATE")
        @UpdateTimestamp
        var dateUpdate: LocalDateTime = LocalDateTime.now(),

        @Column(name = "DES_CHANGE_AGENT", nullable = false)
        var changeAgent : String,

        @OneToOne
        @JoinColumn(name = "IDT_USER")
        val user : User
)