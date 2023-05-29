package ua.kpi.its.lab.rest.entity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "phone")
data class Phone(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val brand: String,
    val manufacturer: String,
    val model: String,
    val rom: Int,
    val price: Int,
    val releaseDate: LocalDate,
    val doubleSIMSupport: Boolean,
    @OneToMany(mappedBy = "phone", cascade = [CascadeType.ALL], orphanRemoval = true)
    val files: List<com.example.StorageFile>
) : Comparable<Phone> {
    override fun compareTo(phone: Phone): Int {
        val compare = model.compareTo(phone.model)
        if (compare != 0) {
            if (brand.compareTo(phone.brand) != 0)
                return -1
            if (manufacturer.compareTo(phone.manufacturer) != 0)
                return -1
            if (releaseDate.compareTo(phone.releaseDate) != 0)
                return -1
        }
        return 0
    }
}