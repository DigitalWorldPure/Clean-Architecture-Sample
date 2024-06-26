package dimaarts.ru.data.repository.database

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class Pokemon (
    @PrimaryKey
    val id: Long,
    val name: String?,
    val height: Int?,
    val backDefault: String?,
    val backFemale: String?,
    val backShiny: String?,
    val backShinyFemale: String?,
    val frontDefault: String?,
    val frontFemale: String?,
    val frontShiny: String?,
    val frontShinyFemale: String?,
    val loadingError: String?,
    val haveDetailInfo: Boolean=false
)