package ua.kpi.its.lab.rest.entity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name="file")
data class StorageFile(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val name: String,
    val extension: String,
    val size: Double, // in kb
    val creationDate: LocalDate,
    val isPhoto: Boolean,
    @ManyToOne
    @JoinColumn(name = "phone_id")
    val phone: Phone,
) : Comparable<StorageFile> {
    override fun compareTo(storageFile: StorageFile): Int {
        if (name.compareTo(storageFile.name) != 0)
            return -1
        if (creationDate.compareTo(storageFile.creationDate) != 0)
            return -1
        if (extension.compareTo(storageFile.extension) != 0)
            return -1
        if (size.compareTo(storageFile.size) != 0)
            return -1
        return 0
    }
}

