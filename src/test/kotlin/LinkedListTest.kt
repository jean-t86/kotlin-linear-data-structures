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
        val node = Node(14)
        val linkedList = LinkedList<Int>()

        assertEquals(0, linkedList.size)

        linkedList.setHead(node)
        assertEquals(1, linkedList.size)
    }

    @Test
    fun `null head returns null`() {
        assertEquals(null, LinkedList<Int>().getHead())
    }

    @Test
    fun `getHead returns the head of the LinkedList`() {
        val node = Node(LocalDate.now())
        val linkedList = LinkedList<LocalDate>(node)

        val actual = linkedList.getHead()

        assertEquals(node, actual)
    }
}
