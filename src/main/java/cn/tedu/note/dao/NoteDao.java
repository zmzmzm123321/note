package cn.tedu.note.dao;

import cn.tedu.note.entity.Note;

import java.util.List;
import java.util.Map;

public interface NoteDao {
    List<Map<String, Object>> findNotesByNotebookId(String notebookId);

    Map<String, Object> findNoteByNoteId(String noteId);

    int updateNote(Map<String, Object> map);

    int saveNote(Note note);

    int deleteNote(String noteId);

    int deleteNotes(List<String> list);

    int deleteNotesByParams(Map<String, Object> param);

    List<Map<String, Object>> findNoteByParams(Map<String, Object> param);

    //分页查询参数：{notebookId:id,start:n,size:m}
    List<Map<String, Object>> findNotesByNotebookIdPaged(Map<String, Object> param);

    //NoteDao 接口
    int countNotes(String notebookId);
}
