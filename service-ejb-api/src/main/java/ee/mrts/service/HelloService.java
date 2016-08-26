package ee.mrts.service;

import javax.ejb.Local;

@Local
public interface HelloService {

    String sayHello();

}
