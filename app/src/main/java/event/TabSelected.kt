package event

class TabSelected {
    private var selected : Int = 0

    constructor(selected: Int){
        this.selected = selected
    }

    fun getSelected(): Int {
        return selected
    }
}