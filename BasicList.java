/**
 * BasicList<E> interface
 * @author Alexandra Gata
 * @version CPE 102 - 01
 * @version December 7, 2016
 */

import java.lang.Iterable;
public interface BasicList<E> extends Iterable<E>{
   void add(E element );
   void add(int index, E element);
   BasicListIterator<E> basicListIterator();
   void clear();
   boolean contains(E element);
   E get(int index);
   int indexOf(E element);
   java.util.Iterator<E> iterator();
   E remove(int index);
   E set(int index, E element);
   int size();
}
