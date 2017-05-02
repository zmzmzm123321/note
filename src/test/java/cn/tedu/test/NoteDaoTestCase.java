package cn.tedu.test;

import cn.tedu.note.dao.NoteDao;
import cn.tedu.note.entity.Note;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.Map.Entry;

public class NoteDaoTestCase extends BaseTestCase {

    NoteDao dao;

    @Before
    public void initDao() {
        dao = ctx.getBean("noteDao", NoteDao.class);
    }

    @Test
    public void testFindNotesByNotebookId() {
        String notebookId = "d0b0727f-a233-4a1f-8600-f49fc1f25bc9";
        List<Map<String, Object>> list = dao.findNotesByNotebookId(notebookId);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }

    @Test
    public void testFindNoteByNoteId() {
        String noteId = "09f60aeb-a573-4fcf-b39f-903e1536e762";
        Map<String, Object> myMap = dao.findNoteByNoteId(noteId);
        Iterator<Entry<String, Object>> it = myMap.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Object> entry = it.next();
            System.out.println("key:" + entry.getKey());
            System.out.println("val" + entry.getValue());
        }
    }

    @Test
    public void testUpdateNote() {
        String noteId = "b4f82f9f-bc0f-480a-b8f2-335164d69945";
        //String title = "我又变了";
        String body = "我现在是值改变主体的内容，不改变标题";
        long now = System.currentTimeMillis();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", noteId);
        //map.put("title", title);
        map.put("body", body);
        map.put("lastModifyTime", now);
        int n = dao.updateNote(map);
        System.out.println(n);
        Map<String, Object> note = dao.findNoteByNoteId(noteId);
        System.out.println(note);
    }

    @Test
    public void testSaveNote() {
        String id = "668354a9-c7b4-46a0-9a6d-b138soodew941";
        String notebookId = "0cd94778-4d52-486d-a35d-263d6tfe6de9";
        String userId = "39295a3d-cc9b-42b4-b206-a2e7fab7e77c";
        Integer statusId = 1;
        Integer typeId = 2;
        String title = "zzzzzzz";
        String body = "<p>aaaazzzzzzz</p>";
        Note note = new Note(id, notebookId, userId, statusId, typeId, title, body);
        int n = dao.saveNote(note);
        System.out.println(n);
        System.out.println(note);
        dao.findNoteByNoteId(id);
    }

    @Test
    public void testDeleteNotesByParams() {
        //组织参数
        Map<String, Object> map = new HashMap<String, Object>();
        //添加参数
        map.put("statusId", "1");
        //添加id列表
        List<String> list = new ArrayList<String>();
        list.add("003ec2a1-f975-4322-8e4d-dfd206d6ac0c");
        list.add("019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0");
        map.put("idList", list);
        //
        int n = dao.deleteNotesByParams(map);
        System.out.println("数据： " + n);
    }

    @Test
    public void testFindNotesByParams() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("statusId", "1");
        map.put("key", "Java");
//        map.put("name","zhoujia");
        List<Map<String, Object>> list = dao.findNoteByParams(map);
        for (Map<String, Object> obj : list) {
            System.out.println("obj:" + obj);
        }
    }

    @Test
    public void testFindNotesByNotebookIdPaged() {
        String notebookId = "20b4cbec-bd55-4c21-9c41-3a11ada2b803";
        int start = 0;
        int size = 6;

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("notebookId", notebookId);
        map.put("start", start);
        map.put("size", size);
        List<Map<String, Object>> list = dao.findNotesByNotebookIdPaged(map);
        for (Map<String, Object> m : list) {
            System.out.println(m);
        }
    }
}
