package lavsam.gb.libs.mylesson1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser (
    val login: String
) : Parcelable

