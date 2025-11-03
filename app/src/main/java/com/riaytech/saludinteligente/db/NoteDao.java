package com.riaytech.saludinteligente.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    long insert(NoteEntity note);

    @Update
    int update(NoteEntity note);

    @Delete
    int delete(NoteEntity note);

    @Query("SELECT * FROM notes ORDER BY id DESC")
    List<NoteEntity> getAll();

    @Query("SELECT * FROM notes WHERE id = :id LIMIT 1")
    NoteEntity getById(long id);
}
