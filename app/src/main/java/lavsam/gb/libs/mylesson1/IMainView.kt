package lavsam.gb.libs.mylesson1

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

//@AddToEndSingle() //- можно такой алиас
@StateStrategyType(AddToEndSingleStrategy::class)
interface IMainView : MvpView {
    fun setButtonOneText(text: String)
    fun setButtonTwoText(text: String)
    fun setButtonThreeText(text: String)
}