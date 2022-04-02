package com.example.newsapp;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class News_DAO_Impl implements News_DAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<News> __insertionAdapterOfNews;

  public News_DAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNews = new EntityInsertionAdapter<News>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `news_table` (`id`,`title`,`imageURL`,`author`,`url`,`description`,`publishedAt`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, News value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getImageURL() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getImageURL());
        }
        if (value.getAuthor() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAuthor());
        }
        if (value.getUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUrl());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDescription());
        }
        if (value.getPublishedAt() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPublishedAt());
        }
      }
    };
  }

  @Override
  public void Insert(final News item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfNews.insert(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<News> getAllData() {
    final String _sql = "Select *  from news_table LIMIT 15";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfImageURL = CursorUtil.getColumnIndexOrThrow(_cursor, "imageURL");
      final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
      final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfPublishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "publishedAt");
      final List<News> _result = new ArrayList<News>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final News _item;
        _item = new News();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        _item.setTitle(_tmpTitle);
        final String _tmpImageURL;
        _tmpImageURL = _cursor.getString(_cursorIndexOfImageURL);
        _item.setImageURL(_tmpImageURL);
        final String _tmpAuthor;
        _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
        _item.setAuthor(_tmpAuthor);
        final String _tmpUrl;
        _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
        _item.setUrl(_tmpUrl);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _item.setDescription(_tmpDescription);
        final String _tmpPublishedAt;
        _tmpPublishedAt = _cursor.getString(_cursorIndexOfPublishedAt);
        _item.setPublishedAt(_tmpPublishedAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
