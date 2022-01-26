package peaksoft.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;

public class Hibernate {
    private static final SessionFactory session=sessionBuilder();
    private static SessionFactory sessionBuilder(){
        try {
            return new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
        }catch (Throwable ex){
            System.out.println("Himernette kata bar  "+ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSession(){
        return session;
    }
    public static void shupDown(){
        session.close();
    }
    public static void printInformation(){
        System.out.println("Таблица тузуу учун 1ди басыныз");
        System.out.println("Айди мн табуу учун 2 ни басыныз");
        System.out.println("Таблицадагы маанилерди жаныртуу учун 3ту басыныз");
        System.out.println("Таблицадагы баардык маалыматты коруу учун 4ту басыныз");
        System.out.println("Аты Аза жана жашы 20дан чон болгон баардык жумушчуларды алыгыныз келсе 5ти басыныз");
        System.out.println("Аты Аза болгон жумушчулардын жашын 18ге озгорткунуз келсе 6ны басыныз");
        System.out.println("Аты Аза болгон жумушчуларды очуруну кааласыныз 7ни басыныз");


    }
}
