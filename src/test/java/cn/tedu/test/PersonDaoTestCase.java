package cn.tedu.test;

import cn.tedu.note.dao.PersonDao;
import cn.tedu.note.entity.Person;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by TM on 2017-4-19.
 */
public class PersonDaoTestCase extends BaseTestCase {

    PersonDao dao;

    @Before
    public void initDao() {
        dao = ctx.getBean("personDao", PersonDao.class);
    }

    @Test
    public void testAddPerson() {
        Person person = new Person("李洪鹤", 30);
        System.out.println(person);//添加之前id=null
        //myBatis在添加对象时候，自动的读取自增类型的ID值，填充到person的id属性
        int n = dao.addPerson(person);//id=1
        System.out.println("person的值是：" + person);
        System.out.println("n的值是：" + n);
    }
}
