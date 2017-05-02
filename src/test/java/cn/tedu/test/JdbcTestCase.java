package cn.tedu.test;

import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;


public class JdbcTestCase extends BaseTestCase {

    // 初始化Spring容器
    /*@Before
    public void init() {
		ctx = new ClassPathXmlApplicationContext("conf/spring-web.xml", "conf/spring-mybatis.xml");
}*/

    @Test
    public void testDataSource() throws SQLException {
        DataSource ds = ctx.getBean("dataSource", DataSource.class);
        Connection conn = ds.getConnection();
        System.out.println(conn);
        DatabaseMetaData md = conn.getMetaData();
        String n = md.getDatabaseProductName();
        String v = md.getDatabaseProductVersion();
        System.out.println(n + v);
        conn.close();
    }


}
