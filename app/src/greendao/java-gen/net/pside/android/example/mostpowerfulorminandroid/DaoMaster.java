package net.pside.android.example.mostpowerfulorminandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

import net.pside.android.example.mostpowerfulorminandroid.SimpleDao;
import net.pside.android.example.mostpowerfulorminandroid.ChildOneDao;
import net.pside.android.example.mostpowerfulorminandroid.ChildTwoDao;
import net.pside.android.example.mostpowerfulorminandroid.ChildThreeDao;
import net.pside.android.example.mostpowerfulorminandroid.ChildFourDao;
import net.pside.android.example.mostpowerfulorminandroid.ChildFiveDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * Master of DAO (schema version 1): knows all DAOs.
*/
public class DaoMaster extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 1;

    /** Creates underlying database table using DAOs. */
    public static void createAllTables(SQLiteDatabase db, boolean ifNotExists) {
        SimpleDao.createTable(db, ifNotExists);
        ChildOneDao.createTable(db, ifNotExists);
        ChildTwoDao.createTable(db, ifNotExists);
        ChildThreeDao.createTable(db, ifNotExists);
        ChildFourDao.createTable(db, ifNotExists);
        ChildFiveDao.createTable(db, ifNotExists);
    }
    
    /** Drops underlying database table using DAOs. */
    public static void dropAllTables(SQLiteDatabase db, boolean ifExists) {
        SimpleDao.dropTable(db, ifExists);
        ChildOneDao.dropTable(db, ifExists);
        ChildTwoDao.dropTable(db, ifExists);
        ChildThreeDao.dropTable(db, ifExists);
        ChildFourDao.dropTable(db, ifExists);
        ChildFiveDao.dropTable(db, ifExists);
    }
    
    public static abstract class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory, SCHEMA_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
            createAllTables(db, false);
        }
    }
    
    /** WARNING: Drops all table on Upgrade! Use only during development. */
    public static class DevOpenHelper extends OpenHelper {
        public DevOpenHelper(Context context, String name, CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
            dropAllTables(db, true);
            onCreate(db);
        }
    }

    public DaoMaster(SQLiteDatabase db) {
        super(db, SCHEMA_VERSION);
        registerDaoClass(SimpleDao.class);
        registerDaoClass(ChildOneDao.class);
        registerDaoClass(ChildTwoDao.class);
        registerDaoClass(ChildThreeDao.class);
        registerDaoClass(ChildFourDao.class);
        registerDaoClass(ChildFiveDao.class);
    }
    
    public DaoSession newSession() {
        return new DaoSession(db, IdentityScopeType.Session, daoConfigMap);
    }
    
    public DaoSession newSession(IdentityScopeType type) {
        return new DaoSession(db, type, daoConfigMap);
    }
    
}
