package net.pside.android.example.mostpowerfulorminandroid;

import net.pside.android.example.mostpowerfulorminandroid.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table CHILD_ONE.
 */
public class ChildOne {

    private Long id;
    private Long ChildTwoId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ChildOneDao myDao;

    private ChildOne childOne;
    private Long childOne__resolvedKey;


    public ChildOne() {
    }

    public ChildOne(Long id) {
        this.id = id;
    }

    public ChildOne(Long id, Long ChildTwoId) {
        this.id = id;
        this.ChildTwoId = ChildTwoId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getChildOneDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChildTwoId() {
        return ChildTwoId;
    }

    public void setChildTwoId(Long ChildTwoId) {
        this.ChildTwoId = ChildTwoId;
    }

    /** To-one relationship, resolved on first access. */
    public ChildOne getChildOne() {
        Long __key = this.ChildTwoId;
        if (childOne__resolvedKey == null || !childOne__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ChildOneDao targetDao = daoSession.getChildOneDao();
            ChildOne childOneNew = targetDao.load(__key);
            synchronized (this) {
                childOne = childOneNew;
            	childOne__resolvedKey = __key;
            }
        }
        return childOne;
    }

    public void setChildOne(ChildOne childOne) {
        synchronized (this) {
            this.childOne = childOne;
            ChildTwoId = childOne == null ? null : childOne.getId();
            childOne__resolvedKey = ChildTwoId;
        }
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
