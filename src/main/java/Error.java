import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: wenqiang
 * @date: 2020-08-06 15:08
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Info
public @interface Error {

    String msg() default "";
}
