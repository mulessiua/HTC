/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import factory.*;


/**
 *
 * @author Simone Mura
 * @version 1.0
 */
public abstract class Factory {

    public abstract Object newElement();
    public abstract Object read(Object primaryKey);
    public abstract Object insert(Object o);
    public abstract int update(Object o);
    public abstract int delete(Object o);
    public abstract java.util.List selectAll();
}
