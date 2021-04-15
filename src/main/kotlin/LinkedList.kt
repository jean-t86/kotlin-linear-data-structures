class LinkedList<T>(data: T? = null) {

    var head: Node<T>? = null
        private set

    var tail: Node<T>? = null
        private set

    var size: Int = 0
        private set

    init {
        if (data != null) {
            prepend(data)
        }
    }

    fun isEmpty() = size == 0

    fun prepend(data: T) {
        head = Node(data, this.head)
        size++
        if (tail == null) {
            tail = head
        }
    }

    fun append(data: T) {
        val newNode = Node(data)

        if (head == null) {
            head = newNode
            tail = newNode
            return
        }

        tail?.next = newNode
        tail = newNode
        size++
    }

    fun find(data: T): T? {
        if (head?.data == data) {
            return data;
        } else if (tail?.data == data) {
            return data
        }

        var current = head
        var foundData: T? = null
        while (current?.next != null) {
            if (current.data == data) {
                foundData = data
                break
            }
            current = current.next
        }

        return foundData
    }

    fun deleteHead(): T? {
        val removedHead = head ?: return null
        head = removedHead.next
        size--
        return removedHead.data
    }

    fun delete(data: T): Boolean {
        if (head == null) return false

        if (head?.data == data) {
            head = head?.next
            size--
            return true
        }

        var current = head
        while (current?.next != null) {
            if (current.next?.data == data) {
                current.next = current.next?.next
                size--
                return true
            }
            current = current.next
        }
        return false
    }

    override fun toString(): String {
        var currentNode = head
        var output = "<head> "
        while (currentNode != null) {
            output += "${currentNode.data} "
            currentNode = currentNode.next
        }
        output += "<tail>"
        return output
    }
}
