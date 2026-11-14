package benakka2;

import benakka2.service.IMetier;
import benakka2.service.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"benakka2.service", "benakka2.aspects"})
// Quand on lance [ new AnnotationConfigApplicationContext(Application.class) ] Spring scanne les packages benakka2.service et benakka2.aspects.
// Dans le package benakka2.service, il y a une classe annotée (@Component ou @Service) qui implémente l'interface IMetier
// Spring détecte cette classe, l'instancie, et l'enregistre dans son conteneur (ApplicationContext) sous la forme d'un bean.
public class Application {
    public static void main(String[] args) {
        try {
            SecurityContext.authenticate("root","1234", new String[]{"ADMIN"});
            ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Application.class);
            IMetier metier=applicationContext.getBean(IMetier.class); // cherche  moi dans ton context un objet qui implement cette interface
            System.out.println("***********************");
            System.out.println(metier.getClass().getName());
            System.out.println("***********************");
            metier.process();
            System.out.println(metier.compute());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
