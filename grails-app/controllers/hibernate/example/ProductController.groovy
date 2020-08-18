package hibernate.example

import groovy.transform.CompileStatic

import grails.rest.*
import grails.converters.*

@CompileStatic
class ProductController extends RestfulController {
    static responseFormats = ['json', 'xml']

    ProductService productService

    ProductController() {
        super(Product)
    }

    def search(String name, Integer max) { 
        if (name) {
            respond productService.findByNameLike("%${name}%".toString(), [max: Math.min( max ?: 10, 100)])
        } else {
            respond([]) 
        }
    }
}
