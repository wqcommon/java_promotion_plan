package core.proxy.dynamic.cglib;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @author: wenqiang
 * @date: 2019-05-09 17:48
 */
public class CglibMain {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/wenqiang/partproject/java_promotion_plan/proxy");
        BookService bookService = new BookService();
        CglibProxy cglibProxy = new CglibProxy();
        BookService service = cglibProxy.getInstance(bookService);
        service.addBook();
    }
}
