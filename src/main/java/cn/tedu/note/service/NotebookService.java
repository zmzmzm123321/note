package cn.tedu.note.service;

import java.util.List;
import java.util.Map;

/**
 * Created by TM on 2017-4-13.
 */
public interface NotebookService {
	List<Map<String, Object>> listNotebooks(String userId) throws UserNotFoundException;

	List<Map<String, Object>> addNotebook(String userId, String name) throws UserNotFoundException;
}
