
package dao;

import java.util.List;

/**
 *
 * @author eniof
 */
public abstract class DAO_Abstract {
    /**
     *
     * @param object
     */
    public abstract void insert(Object object);

    /**
     *
     * @param object
     */
    public abstract void update(Object object);

    /**
     *
     * @param object
     */
    public abstract void delete(Object object);

    /**
     *
     * @param id
     * @return
     */
    public abstract Object list(int id);

    /**
     *
     * @return
     */
    public abstract List listAll();
   
}
