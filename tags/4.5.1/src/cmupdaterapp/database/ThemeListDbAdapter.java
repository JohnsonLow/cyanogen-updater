package cmupdaterapp.database;

import java.net.URI;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import cmupdaterapp.customTypes.FullThemeList;
import cmupdaterapp.customTypes.ThemeList;
import cmupdaterapp.misc.Log;

public class ThemeListDbAdapter
{
	private static final String TAG = "ThemeListDbAdapter";
	
	private static final String DATABASE_NAME = "cmupdater";
	private static final String DATABASE_TABLE = "ThemeList";
	private static final int DATABASE_VERSION = 2;
	public static final String KEY_ID = "id";
	public static final int KEY_ID_COLUMN = 0;
	public static final String KEY_NAME = "name";
	public static final int KEY_NAME_COLUMN = 1;
	public static final String KEY_URI = "uri";
	public static final int KEY_URI_COLUMN = 2;
	public static final String KEY_ENABLED = "enabled";
	public static final int KEY_ENABLED_COLUMN = 3;
	public static final String KEY_FEATURED = "featured";
	public static final int KEY_FEATURED_COLUMN = 4;
	private SQLiteDatabase db;
	private final Context context;
	private ThemeListDbOpenHelper dbHelper;
	
	public ThemeListDbAdapter(Context _context)
	{
		this.context = _context;
		dbHelper = new ThemeListDbOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	public void close()
	{
		db.close();
	}
	
	public void open() throws SQLiteException
	{
		try
		{
			db = dbHelper.getWritableDatabase();
		}
		catch (SQLiteException ex)
		{
			db = dbHelper.getReadableDatabase();
		}
	}
	
	// Insert a new task
	public long insertTheme(ThemeList _theme)
	{
		ContentValues newValues = new ContentValues();
		newValues.put(KEY_NAME, _theme.name);
		newValues.put(KEY_URI, _theme.url.toString());
		if(_theme.enabled) newValues.put(KEY_ENABLED, 1);
		else newValues.put(KEY_ENABLED, 0);
		if(_theme.featured) newValues.put(KEY_FEATURED, 1);
		else newValues.put(KEY_FEATURED, 0);
		return db.insert(DATABASE_TABLE, null, newValues);
	}
	
	// Remove a theme based on its index
	public boolean removeTheme(long _rowIndex)
	{
		return db.delete(DATABASE_TABLE, KEY_ID + "=" + _rowIndex, null) > 0;
	}
	
	// Update a Theme
	public boolean updateTheme(long _rowIndex, ThemeList _theme)
	{
		ContentValues newValue = new ContentValues();
		newValue.put(KEY_NAME, _theme.name);
		newValue.put(KEY_URI, _theme.url.toString());
		if(_theme.enabled) newValue.put(KEY_ENABLED, 1);
		else newValue.put(KEY_ENABLED, 0);
		if(_theme.featured) newValue.put(KEY_FEATURED, 1);
		else newValue.put(KEY_FEATURED, 0);
		return db.update(DATABASE_TABLE, newValue, KEY_ID + "=" + _rowIndex, null) > 0;
	}
	
	public Cursor getAllThemesCursor()
	{
		return db.query(DATABASE_TABLE, new String[] { KEY_ID, KEY_NAME, KEY_URI, KEY_ENABLED, KEY_FEATURED }, null, null, null, null, KEY_NAME);
	}

	public Cursor setCursorToThemeItem(long _rowIndex) throws SQLException
	{
		Cursor result = db.query(true, DATABASE_TABLE, new String[] { KEY_ID, KEY_NAME, KEY_URI, KEY_ENABLED, KEY_FEATURED }, KEY_ID + "=" + _rowIndex, null, null, null, null, null);
		if ((result.getCount() == 0) || !result.moveToFirst())
		{
			throw new SQLException("No Theme items found for row: " + _rowIndex);
		}
		return result;
	}

	public ThemeList getThemeItem(long _rowIndex) throws SQLException
	{
		Cursor cursor = db.query(true, DATABASE_TABLE, new String[] { KEY_ID, KEY_NAME, KEY_URI, KEY_ENABLED, KEY_FEATURED }, KEY_ID + "=" + _rowIndex, null, null, null, null, null);
		if ((cursor.getCount() == 0) || !cursor.moveToFirst())
		{
			throw new SQLException("No Theme item found for row: " + _rowIndex);
		}
		String name = cursor.getString(KEY_NAME_COLUMN);
		String uri = cursor.getString(KEY_URI_COLUMN);
		int enabled = cursor.getInt(KEY_ENABLED_COLUMN);
		int featured = cursor.getInt(KEY_FEATURED_COLUMN);
		int Key = cursor.getInt(KEY_ID_COLUMN);
		ThemeList result = new ThemeList();
		result.name = name;
		result.url = URI.create(uri);
		result.PrimaryKey = Key;
		if(enabled == 1) result.enabled = true;
		else result.enabled = false;
		if(featured == 1) result.featured = true;
		else result.featured = false;
		return result;
	}
	
	public void UpdateFeaturedThemes(FullThemeList t)
	{
		FullThemeList retValue = new FullThemeList();
		//Get the enabled state of the current Featured Themes
		for (ThemeList tl : t.returnFullThemeList())
		{
			Cursor result = db.query(true, DATABASE_TABLE, new String[] { KEY_ID, KEY_NAME, KEY_URI, KEY_ENABLED, KEY_FEATURED }, KEY_NAME + "='" + tl.name + "' and " + KEY_FEATURED + "=1" , null, null, null, null, null);
			if ((result.getCount() == 0) || !result.moveToFirst())
			{
				Log.d(TAG, "Theme " + tl.name + " not found in your List");
				retValue.addThemeToList(tl);
				continue;
			}
			tl.enabled = result.getInt(KEY_ENABLED_COLUMN) != 0;
			retValue.addThemeToList(tl);
		}
		//Delete all featured Themes
		db.delete(DATABASE_TABLE, KEY_FEATURED + "=1", null);
		Log.d(TAG, "Deleted all old Featured Theme Servers");
		//Add all Featured Themes again
		for (ThemeList tl2 : retValue.returnFullThemeList())
		{
			insertTheme(tl2);
		}
		Log.d(TAG, "Updated Featured Theme Servers");
	}

	private static class ThemeListDbOpenHelper extends SQLiteOpenHelper
	{
		public ThemeListDbOpenHelper(Context context, String name, CursorFactory factory, int version)
		{
			super(context, name, factory, version);
		}
		// SQL Statement to create a new database.
		private static final String DATABASE_CREATE = "create table " +
		DATABASE_TABLE + " (" + KEY_ID + " integer primary key autoincrement, " + KEY_NAME + " text not null, "
		+ KEY_URI + " text not null, " + KEY_ENABLED + " integer default 0" + ", " + KEY_FEATURED + " integer default 0);";
		
		@Override
		public void onCreate(SQLiteDatabase _db)
		{
			Log.d(TAG, "Create Database");
			_db.execSQL(DATABASE_CREATE);
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion)
		{
			Log.d(TAG, "Upgrading from version " + _oldVersion + " to " + _newVersion + ", which will destroy all old data");
			//Drop the old table.
			_db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			// Create a new one.
			onCreate(_db);
		}
	}
}