package br.com.gym.trainingmap.domain.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "TRAINING_ITEM")
data class TrainingItem(
        @Id
        @Column(name = "IDT_TRAINING_ITEM")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        @Column(name = "NUM_SERIES", nullable = false)
        val seriesNumber: Int,

        @Column(name = "NUM_REPETITIONS", nullable = false)
        var repetitionsNumber: Int,

        @Column(name = "DAT_CREATION")
        @CreationTimestamp
        val dateCreation: LocalDateTime = LocalDateTime.now(),

        @Column(name = "DAT_UPDATE")
        @UpdateTimestamp
        var dateUpdate: LocalDateTime = LocalDateTime.now(),

        @Column(name = "DES_CHANGE_AGENT", nullable = false)
        var changeAgent : String,

        @OneToOne
        @JoinColumn(name = "IDT_EXERCISE")
        val exercise: Exercise,

        @ManyToOne
        @JoinColumn(name = "IDT_TRAINING")
        val training: Training
){
    override fun toString(): String {
        return super.toString()
    }
}