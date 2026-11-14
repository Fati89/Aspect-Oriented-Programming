package benakka2.service;

import benakka2.aspects.Log;
import benakka2.aspects.SecuredByAsppect;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    @Override
    @Log
    @SecuredByAsppect(roles = {"USER","ADMIN"})
    public void process() {
        System.out.println("Buisness Process....");
    }

    @Override
    @Log
    @SecuredByAsppect(roles={"ADMIN"})
    public double compute() {
        double data=78;
        System.out.println("Buisness Computing and returning");
        return data;
    }
}
