package lavsam.gb.libs.mylesson1

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

//@AddToEndSingle() //- можно такой алиас
@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersView: MvpView {
    fun init()
    fun updateList()
}