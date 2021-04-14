class LinkedList<T>(private var head: Node<T>? = null) {

    var size: Int = 0
        private set

    init {
        if (head != null) {
            size++
        }
    }

    fun isEmpty() = size == 0

    fun setHead(node: Node<T>) {
        val currentHead = head
        head = node
        size++
        if (currentHead != null) {
            head?.let { it.next = currentHead }
        }
    }

    fun getHead() = head
}
