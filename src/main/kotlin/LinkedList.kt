class LinkedList<T>(data: T? = null) {

    var head: Node<T>? = null
        private set

    var size: Int = 0
        private set

    init {
        if (data != null) {
            head = Node(data)
            size++
        }
    }

    fun isEmpty() = size == 0

    fun addToHead(data: T) {
        val currentHead = head
        head = Node(data)
        size++
        if (currentHead != null) {
            head?.next = currentHead
        }
    }

    fun addToTail(data: T) {
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

    fun removeHead(): T? {
        val removedHead = head ?: return null
        head = removedHead.next
        size--
        return removedHead.value
    }
}
