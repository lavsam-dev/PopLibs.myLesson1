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
                R.id.btn_counter1 -> CounterType.FIRST
                R.id.btn_counter2 -> CounterType.SECOND
                R.id.btn_counter3 -> CounterType.THIRD
                else -> throw IllegalStateException("такой кнопки нет")
            }
            presenter.counterClick(type)
//            type?.run { presenter.counterClick(this) }
        }

        mainBinding.btnCounter1.setOnClickListener(listener)
        mainBinding.btnCounter2.setOnClickListener(listener)
        mainBinding.btnCounter3.setOnClickListener(listener)
    }

    override fun onStop() {
        super.onStop()
    }

    //Подсказка к ПЗ: поделить на 3 отдельные функции и избавиться от index
    override fun setButtonText(index: Int, text: String) {
        when (index) {
            0 -> mainBinding.btnCounter1.text = text
            1 -> mainBinding.btnCounter2.text = text
            2 -> mainBinding.btnCounter3.text = text
        }
    }
}