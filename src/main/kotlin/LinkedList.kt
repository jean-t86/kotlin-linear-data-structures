class LinkedList<T>(data: T? = null) {

    var head: Node<T>? = null
        set(value) {
            val currentHead = field
            field = value
            if (currentHead != null) {
                field?.let { it.next = currentHead }
            }
            size++
        }

    var size: Int = 0
        private set

    init {
        if (data != null) {
            head = Node(data)
        }
    }

    fun isEmpty() = size == 0

    fun setTail(data: T) {
        var tail = head
        if (tail == null) {
            head = Node(data)
        } else {
            while (tail?.next != null) {
                tail = tail.next
            }
            tail?.next = Node(data)
        }
        size++
    }
}
