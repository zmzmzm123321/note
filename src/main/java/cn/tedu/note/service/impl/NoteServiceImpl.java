package cn.tedu.note.service.impl;

import cn.tedu.note.dao.NoteDao;
import cn.tedu.note.dao.NotebookDao;
import cn.tedu.note.entity.Notebook;
import cn.tedu.note.service.NoteNotFoundException;
import cn.tedu.note.service.NoteService;
import cn.tedu.note.service.NotebookNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("noteService")
//@Transactional //可以直接加到类上，这样所有方法都成了事务
public class NoteServiceImpl implements NoteService {

    @Resource
    private NoteDao noteDao;

    @Resource
    private NotebookDao notebookDao;

    public List<Map<String, Object>> listNotes(String notebookId) throws NotebookNotFoundException {
        if (notebookId == null || notebookId.trim().isEmpty()) {
            throw new NotebookNotFoundException("notebookId不能空");
        }
        Notebook book = notebookDao.findNotebookById(notebookId);
        if (book == null) {
            throw new NotebookNotFoundException("notebookId不存在");
        }

        return noteDao.findNotesByNotebookId(notebookId);
    }

    @Transactional(readOnly = true)
    public Map<String, Object> loadNote(String noteId) throws NoteNotFoundException {
        if (noteId == null || noteId.trim().isEmpty()) {
            throw new NoteNotFoundException("noteId不能为空");
        }
        Map<String, Object> map = noteDao.findNoteByNoteId(noteId);
        if (map == null) {
            throw new NoteNotFoundException("noteId不存在");
        }
        return noteDao.findNoteByNoteId(noteId);
    }


    //老师写的代码
    public boolean updateNote(String noteId, String title, String body) throws NoteNotFoundException {
        if (noteId == null || noteId.trim().isEmpty()) {
            throw new NoteNotFoundException("ID不能为空");
        }
        Map<String, Object> myMap = noteDao.findNoteByNoteId(noteId);

        if (myMap == null) {
            throw new NoteNotFoundException("ID错");
        }
        //创建MAP封装更新参数
        //如title是null则不更新title
        Map<String, Object> params = new HashMap<String, Object>();
        if (title != null && !title.trim().isEmpty()) {
            params.put("title", title.trim());
        }
        //笔记为空的时候，不更新笔记内容
        if (body != null) {
            if (!body.equals(myMap.get(body)))
                params.put("body", body.trim());
        }
        //如果title和body都无需更新？
        if (params.isEmpty()) {
//            throw new RuntimeException("无需更新");
            return false;
        }
        //添加必须参数
        params.put("id", noteId);
        params.put("lastModifyTime", System.currentTimeMillis());
        //更新数据
        //int n;
        int n = noteDao.updateNote(params);

        return n == 1;
        /*if (n == 1) {
            return true;
        }
        return false;*/
    }

    @Transactional
    public int deleteNotes(String... ids) {
        //String... 就是String[]
        for (String id :ids) {
            int n = noteDao.deleteNote(id);
            if(n!=1){
                throw new NoteNotFoundException(id);
            }
        }
        System.out.println("删除多少数据：---" + ids.length);
        return ids.length;
    }

    @Transactional(readOnly=true)
    public List<Map<String, Object>>
    listNotes(String notebookId, int page)
            throws NotebookNotFoundException {

        if(notebookId==null || notebookId.trim().isEmpty()){
            throw new NotebookNotFoundException("ID NULL");
        }
        Notebook book=notebookDao.findNotebookById(notebookId);
        if(book==null){
            throw new NotebookNotFoundException("ID错误");
        }
        //计算分页参数
        int size = 6;
        int start = page * size;
        //检查start是否有效
        if(start < 0){
            start = 0;
        }
        int max =
                noteDao.countNotes(notebookId);
        if(start>=max){
            return new
                    ArrayList<Map<String,Object>>();
        }
        //拼凑参数
        Map<String, Object> map=
                new HashMap<String, Object>();
        map.put("notebookId", notebookId);
        map.put("start", start);
        map.put("size", size);
        //分页查询
        return noteDao.findNotesByNotebookIdPaged(map);
    }

}
