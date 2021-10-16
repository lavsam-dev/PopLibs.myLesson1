package lavsam.gb.libs.mylesson1

import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun settings() = Unit
}
