fun main(args: Array<String>) {
    val node1 = Node("Hello")
    val node2 = Node("World!")
    node1.next = node2
    println(node1)
}
