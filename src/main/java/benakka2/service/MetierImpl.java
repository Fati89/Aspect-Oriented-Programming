package benakka2.service;

import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {
    @Override
    public void process() {
        System.out.println("Buisness Process....");
    }

    @Override
    public double compute() {
        double data=78;
        System.out.println("Buisness Computing and returning");
        return data;
    }
}
