package lavsam.gb.libs.mylesson1

class MainPresenter(private val view: IMainView) {

    private val model = CountersModel()

    fun counterClick(type: CounterType) {
        when (type) {
            CounterType.COUNTER_OF_DAYS -> view.setButtonOneText(model.next(0).toString())
            CounterType.COUNTER_OF_YEARS -> view.setButtonTwoText(model.next(1).toString())
            CounterType.COUNTER_OF_PAYLOAD -> view.setButtonThreeText(model.next(2).toString())
        }
    }
}

enum class CounterType {
    COUNTER_OF_DAYS,
    COUNTER_OF_YEARS,
    COUNTER_OF_PAYLOAD
}