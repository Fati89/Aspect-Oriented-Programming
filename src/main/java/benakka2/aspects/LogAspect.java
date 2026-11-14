package benakka2.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
// Le @Component sur la classe LogAspect est indispensable, car :Spring doit connaître l'existence de l'aspect
// En Spring, tout ce qui doit être géré par le conteneur (ApplicationContext) doit être un bean
@Aspect
@EnableAspectJAutoProxy
//  Active le mécanisme de proxy automatique pour AOP
// Ce substitut est créé dynamiquement au moment de l'exécution via le JDK Dynamic Proxy (car MetierImpl implémente une interface).
public class LogAspect {
    // on a pas créer un pointcut comme avant, pourquoi ?
    // en effet, Les deux produisent exactement le même résultat à l'exécution. Spring lit l'expression, crée le proxy, et exécute l'advice avant process().
    // Un PointCut nommé est utile quand la même expression est utilisée plusieurs fois, pour eviter la répitition de "execution(public void process())" et faciliter la tache si on veut modifier

    Logger logger=Logger.getLogger(LogAspect.class.getName());
    @Around("execution(* benakka2.service..*(..))") // OU BEIN: ("execution(public void process())")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long t1=System.currentTimeMillis();
        logger.info("From Logging Aspects ... Before "+proceedingJoinPoint.getSignature());
        Object result=proceedingJoinPoint.proceed();
        logger.info("From Logging Aspects ... After "+proceedingJoinPoint.getSignature());
        long t2=System.currentTimeMillis();
        logger.info("Duration :"+(t2-t1));
        return result;
    }
}
