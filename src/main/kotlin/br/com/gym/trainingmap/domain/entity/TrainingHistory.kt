package br.com.gym.trainingmap.domain.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "TRAINING_HISTORY")
data class TrainingHistory(
        @Id
        @Column(name = "IDT_TRAINING_HISTORY")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        @Column(name = "DAT_CREATION")
        @CreationTimestamp
        val dateCreation: LocalDateTime = LocalDateTime.now(),

        @Column(name = "DAT_UPDATE")
        @UpdateTimestamp
        var dateUpdate: LocalDateTime = LocalDateTime.now(),

        @Column(name = "DES_CHANGE_AGENT", nullable = false)
        var changeAgent : String,

        @ManyToOne()
        @JoinColumn(name = "IDT_GYM_STUDENT")
        val gymStudent: GymStudent,

        @ManyToOne()
        @JoinColumn(name = "IDT_TRAINING")
        val training: Training,
){

}