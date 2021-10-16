package lavsam.gb.libs.mylesson1

import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEndSingle

//@AddToEndSingle() //- можно такой алиас
@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : MvpView {
    fun setButtonOneText(text: String)
    fun setButtonTwoText(text: String)
    fun setButtonThreeText(text: String)
}

@AddToEndSingle
interface ListUsersView : MvpView {
    fun init()
    fun updateList()
}

class ScreenListUsersPresenter(val usersRepo: GithubUsersRepo): MvpPresenter<ListUsersView>(){

    class UserslistPresenter : IUserListPresenter {

        val users = mutableListOf<GithubUser>()

        override var itemClickListener: ((IUserItemView) -> Unit)? = null

        override fun bindView(view: IUserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }

        override fun getCount() = users.size
    }

    val userslistPresenter = UserslistPresenter()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        userslistPresenter.itemClickListener = {
            itemView ->
            // переход на экран с информацией о пользователе
        }
    }

    fun loadData() {
        // типа сходили на сервер
        val users = usersRepo.getUsers()
        // добавляем данные в наш список
        userslistPresenter.users.addAll(users)
        viewState.updateList()
    }
}