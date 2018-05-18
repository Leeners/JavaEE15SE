package cn.edu.chzu.xxxy.se15.javaee.hibernate.po;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;
    @Before
    public void setUp() throws Exception
    {
        // ���������ļ�
        Configuration config = new Configuration().configure();
        // �����Ự��������
        sessionFactory = config.buildSessionFactory();
        // �����Ự����
        session = sessionFactory.openSession();
        // ��������
        transaction = session.beginTransaction();
    }
    @After
    public void tearDown() throws Exception
    {
        // �ύ����
        transaction.commit();
        // �رջỰ
        session.close();
        // �رջỰ����
        sessionFactory.close();
    }
    @Test
    public void testSaveCustomer()
    {
        //���ɹ˿Ͷ���
    	Customer cutomer = new Customer();
    	cutomer.setAccount("javase");
    	cutomer.setPassword("123456");
    	//...
        //�������������ݿ�
        session.save(cutomer);
    }
}
