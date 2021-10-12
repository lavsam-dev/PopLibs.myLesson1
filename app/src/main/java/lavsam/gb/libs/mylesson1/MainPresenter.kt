package lavsam.gb.libs.mylesson1

class MainPresenter(private val view: IMainView) {

    private val model = CountersModel()

    //Архитектурная ошибка. В качестве практического задания -- исправить
    fun counterClick(type: CounterType) {
        val nextValue = when (type) {
            CounterType.COUNTER_OF_DAYS -> model.next(0)
            CounterType.COUNTER_OF_YEARS -> model.next(1)
            CounterType.COUNTER_OF_PAYLOAD -> model.next(2)
        }
        view.setButtonText(type, nextValue.toString())
    }
}

enum class CounterType {
    COUNTER_OF_DAYS,
    COUNTER_OF_YEARS,
    COUNTER_OF_PAYLOAD
}