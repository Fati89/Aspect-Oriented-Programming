package benakka.aspects;

public aspect FirstAspect {

    pointcut pc1():execution(* benakka.test.Application.main(..));

    before():pc1(){
        System.out.println("-------------------------------------------");
        System.out.println("Before main from Aspect with AspectJ syntax");
        System.out.println("-------------------------------------------");
    }
    after():pc1(){
        System.out.println("-------------------------------------------");
        System.out.println("After main from Aspect with AspectJ syntax");
        System.out.println("-------------------------------------------");
    }
}
