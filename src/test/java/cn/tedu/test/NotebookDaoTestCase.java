package cn.tedu.test;

import cn.tedu.note.dao.NotebookDao;
import cn.tedu.note.entity.Notebook;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by TM on 2017-4-13.
 */
public class NotebookDaoTestCase extends BaseTestCase {
	NotebookDao dao;

	@Before
	public void initDao() {
		dao = ctx.getBean("notebookDao", NotebookDao.class);
	}

	@Test
	public void testFindNotebooksByUserId() {
		String userId = "52f9b276-38ee-447f-a3aa-0d54e7a736e4";
		List<Map<String, Object>> list = dao.findNotebooksByUserId(userId);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}

	@Test
	public void testSaveNotebook() {
		Notebook book = new Notebook();
		book.setId("1238888888888888888888888888888888");
		book.setUserId("39295a3d-cc9b-42b4-b206-a2e7fab7e77c");
		book.setName("tmTest");
		int i = dao.saveNotebook(book);
		System.out.println(i);
	}
}
