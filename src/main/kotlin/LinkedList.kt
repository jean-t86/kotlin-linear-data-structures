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
        if (currentHead != null) {
            head?.let { it.next = currentHead }
        }
        size++
    }

    fun getHead() = head

    fun setTail(node: Node<T>) {
        var tail = head
        if (tail == null) {
            head = node
        } else {
            while (tail?.next != null) {
                tail = tail.next
            }
            tail?.next = node
        }
        size++
    }
}
