package cn.tedu.note.service.impl;

import cn.tedu.note.dao.NotebookDao;
import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.Notebook;
import cn.tedu.note.entity.User;
import cn.tedu.note.service.NameException;
import cn.tedu.note.service.NotebookService;
import cn.tedu.note.service.UserNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("notebookService")
public class NotebookServiceImpl implements NotebookService {
    @Resource
    private NotebookDao notebookDao;
    @Resource
    private UserDao userDao;

    public List<Map<String, Object>> listNotebooks(String userId) throws UserNotFoundException {
        if (userId == null || userId.trim().isEmpty()) {
            throw new UserNotFoundException("User Id 空");
        }

        User user = userDao.findUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("ID错误");
        }
        return notebookDao.findNotebooksByUserId(userId);
    }

    public List<Map<String, Object>> addNotebook(String userId, String name) throws UserNotFoundException {
        if (name == null || name.trim().isEmpty()) {
            throw new NameException("笔记本名不能空！");
        }
        if (userId == null || userId.trim().isEmpty()) {
            throw new UserNotFoundException("userId不能空！");
        }
        User user = userDao.findUserById(userId);
        if (user == null) {
            throw new UserNotFoundException("ID错误");
        }
        String id = UUID.randomUUID().toString();
        /*String typeId="1";
		String desc="";
		Timestamp createTime=new Timestamp(
				System.currentTimeMillis());*/
        Notebook book = new Notebook(id, userId, name);
        notebookDao.saveNotebook(book);
        return notebookDao.findNotebooksByUserId(userId);
    }

}
