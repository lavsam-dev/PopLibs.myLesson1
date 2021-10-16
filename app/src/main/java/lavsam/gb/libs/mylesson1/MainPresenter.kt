package lavsam.gb.libs.mylesson1

import moxy.MvpPresenter

class MainPresenter(val model: CountersModel) : MvpPresenter<IMainView>() {

    fun counterOneClick() {
        viewState.setButtonOneText(model.next(0).toString())
    }

    fun counterTwoClick() {
        viewState.setButtonTwoText(model.next(1).toString())
    }

    fun counterThreeClick() {
        viewState.setButtonThreeText(model.next(2).toString())
    }
}
