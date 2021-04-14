import org.junit.Test
import java.time.LocalDate
import kotlin.test.assertEquals

class LinkedListTest {
    @Test
    fun `list is empty if created without a head`() {
        val linkedList = LinkedList<Int>()

        assertEquals(true, linkedList.isEmpty())
    }

    @Test
    fun `size returns 1 if list created with head`() {
        val node = Node("Hello")
        val linkedList = LinkedList(node)

        val actual = linkedList.size

        assertEquals(1, actual)
    }

    @Test
    fun `can add head after instantiation without a head`() {
        val headNode = Node(14)
        val linkedList = LinkedList<Int>()

        assertEquals(0, linkedList.size)

        linkedList.head = headNode
        assertEquals(1, linkedList.size)
    }

    @Test
    fun `null head returns null`() {
        assertEquals(null, LinkedList<Int>().head)
    }

    @Test
    fun `getHead returns the head of the LinkedList`() {
        val node = Node(LocalDate.now())
        val linkedList = LinkedList<LocalDate>(LocalDate.now())

        val actual = linkedList.head

        assertEquals(node, actual)
    }

    @Test
    fun `setTail on an empty list sets the node to head`() {
        val tail = Node(24)
        val linkedList = LinkedList<Int>()

        assertEquals(null, linkedList.head)
        linkedList.setTail(24)

        assertEquals(tail, linkedList.head)
    }

    @Test
    fun `setTail called with list having exactly 1 item, that is the list head`() {
        val linkedList = LinkedList('A')
        assertEquals(1, linkedList.size)

        linkedList.setTail('Z')
        assertEquals(2, linkedList.size)
    }

    @Test
    fun `setTail with list having two items should have size 3`() {
        val linkedList = LinkedList('B')
        linkedList.head = Node('B')

        linkedList.setTail('Z')

        assertEquals(3, linkedList.size)
    }
}
