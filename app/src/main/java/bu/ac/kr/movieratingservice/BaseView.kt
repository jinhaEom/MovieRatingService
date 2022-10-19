package bu.ac.kr.movieratingservice

interface BaseView<PresenterT : BasePresenter> {

    val presenter : PresenterT
}