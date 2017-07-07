/**
 * BasicListIterator<E> interface
 * @author Alexandra Gata
 * @version CPE 102 - 01
 * @version December 7, 2016
 */

import java.util.Iterator;
public interface BasicListIterator<E> extends Iterator<E> {
   boolean hasPrevious();
   E previous();
}
