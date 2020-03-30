package hibernate.example

import org.grails.testing.GrailsUnitTest
import spock.lang.Specification

@SuppressWarnings('MethodName')
class ProductControllerSpec extends HibernateSpec implements ControllerUnitTest<ProductController> {
    
    static doWithSpring = {
        jsonSmartViewResolver(JsonViewResolver)
    }

    ​void 'test the search action finds results'() {
        ​given:
       ​ controller.productService = Stub(ProductService) {
            findByNameLike(_, _) >> [new Product(name: 'Apple', price: 2.0)]
        ​}
       ​ when: 'A query is executed that finds results'
        ​controller.search('pp', 10)

       ​ then: 'The response is correct'
       ​ response.json.size() == 1
       ​ response.json[0].name == 'Apple'
    ​}

}