package skyshop.model.basket;

public class Node<E> {
    E item;
    skyshop.model.basket.Node<E> next;
    skyshop.model.basket.Node<E> prev;

    public Node(E item) {
        this.item = item;
    }
}
