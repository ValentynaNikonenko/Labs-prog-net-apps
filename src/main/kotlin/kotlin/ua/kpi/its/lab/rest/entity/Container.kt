import ua.kpi.its.lab.rest.entity.Phone

interface Container<T> {
    fun add(element: T)

    fun remove(index: Int)

    fun update(index: Int, element: T)

    fun get(index: Int): T
    fun getAll(): List<T>
}

class TrainContainer : Container<Phone> {
    private val enterprises: MutableList<Phone> = mutableListOf()

    override fun add(element: Phone) {
        enterprises.add(element)
    }

    override fun remove(index: Int) {
        enterprises.removeAt(index)
    }

    override fun update(index: Int, element: Phone) {
        enterprises[index] = element
    }

    override fun get(index: Int): Phone {
        return enterprises[index]
    }

    override fun getAll(): List<Phone> {
        return enterprises
    }
}