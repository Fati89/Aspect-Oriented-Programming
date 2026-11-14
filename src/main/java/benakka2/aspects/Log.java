package benakka2.aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // cette annotation sera interpréter au mement de l'execution
@Target(ElementType.METHOD) // utilisé par les méthodes
public @interface Log {
}
