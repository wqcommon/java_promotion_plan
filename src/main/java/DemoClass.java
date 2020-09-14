import java.lang.annotation.Annotation;

/**
 * @author: wenqiang
 * @date: 2020-08-06 15:10
 */
@Error(msg = "msg")
public class DemoClass {

    public static void main(String[] args) {

        Error error = DemoClass.class.getAnnotation(Error.class);
        System.out.println("error:" + error.msg());

        Annotation[] annotations = DemoClass.class.getAnnotations();
        if (error != null){
            Info info = error.annotationType().getAnnotation(Info.class);
            System.out.println("info:" + info);
        }
    }
}
