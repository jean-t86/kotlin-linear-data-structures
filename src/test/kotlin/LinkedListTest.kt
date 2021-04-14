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
        val linkedList = LinkedList<Int>()

        assertEquals(0, linkedList.size)

        linkedList.addToHead(14)
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
        linkedList.addToTail(24)

        assertEquals(tail, linkedList.head)
    }

    @Test
    fun `setTail called with list having exactly 1 item, that is the list head`() {
        val linkedList = LinkedList('A')
        assertEquals(1, linkedList.size)

        linkedList.addToTail('Z')
        assertEquals(2, linkedList.size)
    }

    @Test
    fun `setTail with list having two items should have size 3`() {
        val linkedList = LinkedList('B')
        linkedList.addToHead('B')

        linkedList.addToTail('Z')

        assertEquals(3, linkedList.size)
    }

    @Test
    fun `removeHead on an empty LinkedList`() {
        val linkedList = LinkedList<Int>()

        val actual = linkedList.removeHead()

        assertEquals(null, actual)
        assertEquals(0, linkedList.size)
    }

    @Test
    fun `remove head from LinkedList with only one node`() {
        val linkedList = LinkedList('A')

        var head = linkedList.head
        assertEquals(head, Node('A'))
        assertEquals(1, linkedList.size)

        linkedList.removeHead()
        head = linkedList.head
        assertEquals(null, head)
        assertEquals(0, linkedList.size)
    }

    @Test
    fun `removeHead in a LinkedList with only one node should return proper size`() {
        val linkedList = LinkedList('A')

        assertEquals(1, linkedList.size)

        val actual = linkedList.removeHead()

        assertEquals('A', actual)
        assertEquals(0, linkedList.size)
    }

    @Test
    fun `removeHead in a LinkedList with only one node should have head null`() {
        val linkedList = LinkedList('A')

        val actual = linkedList.removeHead()

        assertEquals('A', actual)
        assertEquals(null, linkedList.head)
        assertEquals(0, linkedList.size)
    }

    @Test
    fun `removeHead in a LinkedList with two nodes should properly relink nodes`() {
        val linkedList = LinkedList('A')
        linkedList.addToHead('B')

        val actual = linkedList.removeHead()

        assertEquals('B',actual)
        assertEquals(1, linkedList.size)
    }

    @Test
    fun `getPrintableList returns head value tail header is 10`() {
        val linkedList = LinkedList(10)

        val actual = linkedList.toString()

        assertEquals("<head> 10 <tail>", actual)
    }

    @Test
    fun `getPrintableList returns correct string`() {
        val linkedList = LinkedList('C')
        linkedList.addToHead('B')
        linkedList.addToHead('A')

        val actual = linkedList.toString()

        assertEquals("<head> A B C <tail>", actual)
    }
}
