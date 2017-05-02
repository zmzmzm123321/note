package cn.tedu.note.dao;

import cn.tedu.note.entity.Notebook;

import java.util.List;
import java.util.Map;

/**
 * Created by TM on 2017-4-13.
 */
public interface NotebookDao {
    List<Map<String,Object>> findNotebooksByUserId(String userId);
    
    int saveNotebook(Notebook book);

    Notebook findNotebookById(String notebookId);
}
