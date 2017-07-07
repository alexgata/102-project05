/**
 * BasicLinkedList<E> class
 * @author Alexandra Gata
 * @version CPE 102 - 01
 * @version December 7, 2016
 */

import java.lang.Object;
import java.util.*;
 
public class BasicLinkedList<E> implements BasicList<E> {
   private Node first;
   private Node last;
   private int size = 0;

   public void add(E element) {
      Node newNode = new Node(element);
      if (last == null) {
         first = newNode;
         last = newNode;
         size ++;
      }
      else {
         last.next = newNode;
         newNode.previous = last;
         last = newNode;
         size ++;
      }
   }

   public void add(int index, E element) {
     if (index < 0 || index >= size + 1) {
        throw new IndexOutOfBoundsException();
     }

      Node newNode = new Node(element);
     if (size == 0) {
         first = newNode;
         last = newNode;
         newNode.previous = null;
         newNode.next = null;
     }
     
     if (index == 0) {
        newNode.next = first;
        first = newNode;
     }

     if (index == size) {
        last.next = newNode;
        newNode.previous = last;
        last = newNode;
     }

     else {
        Node p = getNode(index-1);
        newNode.next = p.next;
        newNode.previous = p;
        p.next.previous = newNode;
        p.next = newNode; 
        
     }

     size ++;
   }

   public void clear() {
      first = null;
      last = null;
      size = 0;
   }

   public boolean contains(E element) {
      Node temp = first;
      while (temp != null) {
         if (temp.element == null && element == null) {
            return true;
         }
         
         if (temp.element != null && temp.element.equals(element)) {  
            return true;
         }
         temp = temp.next;    
      }

      return false;
   }

   public E get(int index) {
      if (index < 0 || index >= size) {
         throw new IndexOutOfBoundsException();
      }
      
      Node p = getNode(index);

      if (p != null) {
         return p.element;
      }

      else {
         throw new NoSuchElementException();
      }
   }

   public int indexOf(E element) {
      Node temp = first;
      for (int i = 0; i < size; i ++) {
         if (temp.element == null && element == null || temp.element != null && temp.element.equals(element)) {
            return i;
         }
         temp = temp.next;
      }
      throw new NoSuchElementException();
   }

   public E remove(int index) {
      if (index < 0 || index >= size) {
         throw new IndexOutOfBoundsException();
      }
      if (size == 1) {
         E e = first.element;
         first = null;
         last = null;
         size --;
         return e;

      }
      
      if (index == 0) {
         E e = first.element;
         first = first.next;
         first.previous = null;
         size --;
         return e;
      }

      if (index == size -1) {
         E e = last.element;
         last = last.previous;
         last.next = null;
         size --;
         return e;
      }

      else {
         Node p = getNode(index);
         p.previous.next = p.next;
         p.next.previous = p.previous;
         size --;
         return p.element;
      }
   }

   public E set(int index, E element) {
      E newSet = null;
      Node current = getNode(index);
      if (index < 0 || index >= size) {
         throw new IndexOutOfBoundsException();
      }
      
      newSet = current.element;
      current.element = element;
      return newSet;
   }

   public int size() {
      return size;
   }

   private class Node {
      public E element;
      public Node next;
      public Node previous;

      public Node(E element) {
         this.element = element;
         this.next = null;
         this.previous = null;
      }

      public Node() {
      }
   }

   private Node getNode(int i) {
      Node p = first;
      int pos = 0;
      while (pos != i) {
         p = p.next;
         pos ++;
      }
      return p;
   }

   public BasicListIterator<E>basicListIterator() {
      return new InternalIterator();
   }

   public Iterator<E> iterator() {
      return new InternalIterator();
   }

   private class InternalIterator implements BasicListIterator<E> {
      private Node node = null;
      public boolean hasNext() {
         return false;
      }

      public E next() {
         return null;
      }

      public boolean hasPrevious(){
         return false;
      }

      public E previous() {
         return null;
      }

      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
}
