import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Arif on 15.03.2017.
 */
public class SingleLLWithDeletedNode<E> {
    // Data Fields
    private ArrayList<Node<E>> removedList = new ArrayList<Node<E>>();
    /** A reference to the head of the list. */
    private Node< E > head = null;

    /** The size of the list. */
    private int size = 0;

    //Methods
    /**** BEGIN EXERCISE ****/
    /** Insert an object at the beginning of the list.
     @param item - the item to be added
     */
    public void addFirst(E item) {
        if (removedList.size() > 0 ){
            removedList.get(removedList.size()-1).data = item;
            head = removedList.remove(removedList.size()-1);
            ++size;
            return;
        }
        head = new Node<E>(item,head);
        ++size;
    }

    /**
     * Add a node after a given node
     * @param node node The preceding the new item
     * @param item item The item to insert
     */
    private void addAfter(Node<E> node, E item){
        if (removedList.size() > 0 ){
            removedList.get(removedList.size()-1).data = item;
            head.next = removedList.remove(removedList.size()-1);
            return;
        }
        node.next = new Node<E>(item, node.next);
        ++size;
    }

    /**
     * Remove the node after a given node
     * @param node the node before the one to be removed
     * @return the data from the removed node, or null
     *         if there is no node to remove
     */
    private E removeAfter(Node<E> node){
        Node<E> temp = node.next;
        if(temp != null){
            removedList.add(temp);
            node.next = temp.next;
            --size;
            return temp.data;
        }else{
            return null;
        }
    }

    /**
     * remove the first node from the list
     * @return the removed node's data or null if the list is empty
     */
    public E removeFirst(){
        Node<E> temp = head;
        if(head != null){
            head = head.next;
        }
        if (temp != null){
            removedList.add(head);
            --size;
            return temp.data;
        }else{
            return null;
        }
    }

    /**
     * Find the node at a specified position
     * @param index the position of the node sought
     * @return the node at index or null if it does not exist
     */
    private Node<E> getNode(int index){
        SingleLLWithDeletedNode.Node<E> node = head;
        for(int i=0; i< index && node != null; ++i){
            node = node.next;
        }
        return node;
    }

    /**
     * return linkedlist size
     * @return size
     */
    public int getSize(){
        return size;
    }
    /** Insert an object at the end of the list.
     @param item - the item to be added
     */
    public void addLast(E item) {
        add(size, item);
    }

    /** Get the first element in the list.
     @return The first element in the list.
     */
    public E getFirst() {
        return head.data;
    }


    /** Add an item at the specified index.
     @param index The index at which the object is to be
     inserted
     @param item The object to be inserted
     @throws IndexOutOfBoundsException if the index is out
     of range (i < 0 || i > size())
     */
    public void add(int index, E item){

        if(index < 0 || index > size){

            throw new IndexOutOfBoundsException(Integer.toString(index));

        }
        if(index == 0){
            addFirst(item);
        }else{
            Node<E> node = getNode(index-1);
            addAfter(node,item);
        }
    }

    /**
     * Append item to the end of the list
     * @param item the item to be appended
     * @return true (as specified by the Collection interface)
     */
    public boolean add(E item){
        add(size,item);
        return true;
    }
    /** Get the element at position index.
     @param index Position of item to be retrieved
     @return The item at index
     */
    public E get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }
    /**
     * Set the data value at index
     * @param index the position of the item to change
     * @param newValue the new value
     * @return the data value priviously at index
     * @throws IndexOutOfBoundsException if index is out of range
     */
    public E set(int index, E newValue){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }
    // Inner Classes

    /** A Node is the building block for a double-linked list. */
    private static class Node < E > {
        /** The data value. */
        private E data;

        /** The link to the next node. */
        private Node < E > next = null;

        /** Construct a node with the given data value.
         @param dataItem The data value
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }
        /**
         * Creates a new node that references another node.
         * @param dataItem The data stored
         * @param nodeRef The node referenced by new node
         * */
        private Node(E dataItem,Node<E> nodeRef){
            data = dataItem;
            next = nodeRef;
        }
    } //end class Node

    /**
     * Create an iterator
     * @return Iterator
     */
    public Iterator<E> Iterator() {
        KWListIter SingleLLWithDeletedNode = new KWListIter();
        return SingleLLWithDeletedNode;
    }

    /** Inner class to implement the Iterator interface. */
    private class KWListIter implements Iterator < E > {
        /** A reference to the next item. */
        private Node< E > nextItem;

        public KWListIter() {
            nextItem = head;
        }

        /** Indicate whether movement forward is defined.
         @return true if call to next will not throw an exception
         */
        public boolean hasNext() {
            return nextItem != null;
        }

        /** Move the iterator forward and return the next item.
         @return The next item in the list
         @throws NoSuchElementException if there is no such object
         */
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E tempData = nextItem.data;
            nextItem = nextItem.next;
            return tempData;
        }
    }//end class KWListIter
}
