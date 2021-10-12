package lavsam.gb.libs.mylesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import lavsam.gb.libs.mylesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IMainView {

    private lateinit var mainBinding: ActivityMainBinding

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val listener = View.OnClickListener {
            val type = when (it.id) {
                R.id.btn_counter1 -> CounterType.COUNTER_OF_DAYS
                R.id.btn_counter2 -> CounterType.COUNTER_OF_YEARS
                R.id.btn_counter3 -> CounterType.COUNTER_OF_PAYLOAD
                else -> throw IllegalStateException(getString(R.string.noButton))
            }
            presenter.counterClick(type)
        }

        mainBinding.btnCounter1.setOnClickListener(listener)
        mainBinding.btnCounter2.setOnClickListener(listener)
        mainBinding.btnCounter3.setOnClickListener(listener)
    }

    override fun onStop() {
        super.onStop()
    }

    //Подсказка к ПЗ: поделить на 3 отдельные функции и избавиться от index
    override fun setButtonText(type: CounterType, text: String) {
        when (type) {
            CounterType.COUNTER_OF_DAYS -> mainBinding.btnCounter1.text = text
            CounterType.COUNTER_OF_YEARS -> mainBinding.btnCounter2.text = text
            CounterType.COUNTER_OF_PAYLOAD -> mainBinding.btnCounter3.text = text
        }
    }
}