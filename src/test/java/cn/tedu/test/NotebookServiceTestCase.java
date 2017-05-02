package cn.tedu.test;

import cn.tedu.note.service.NotebookService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class NotebookServiceTestCase extends BaseTestCase {
	NotebookService service;

	@Before
	public void initService() {
		this.service = ctx.getBean("notebookService", NotebookService.class);
	}

	@Test
	public void testListNotebooks() {
		String userId = "52f9b276-38ee-447f-a3aa-0d54e7a736e4";
		List<Map<String, Object>> list = service.listNotebooks(userId);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
	@Test
	public void testAddNotebook() {
		String userId = "39295a3d-cc9b-42b4-b206-a2e7fab7e77c";
		String name = "赵明SD";
		List<Map<String, Object>> list = service.addNotebook(userId, name);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}


}
