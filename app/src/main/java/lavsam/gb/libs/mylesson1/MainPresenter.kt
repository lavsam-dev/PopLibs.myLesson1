package lavsam.gb.libs.mylesson1

class MainPresenter(private val view: IMainView) {

    private val model = CountersModel()

    //Архитектурная ошибка. В качестве практического задания -- исправить
    fun counterClick(type: CounterType) {
        when (type) {
            CounterType.FIRST -> {
                val nextValue = model.next(0)
                view.setButtonText(0, "привет $nextValue")
            }
            CounterType.SECOND -> {
                val nextValue = model.next(1)
                view.setButtonText(1, nextValue.toString())
            }
            CounterType.THIRD -> {
                val nextValue = model.next(2)
                view.setButtonText(2, nextValue.toString())
            }
        }
    }
}

enum class CounterType {
    FIRST,
    SECOND,
    THIRD
}