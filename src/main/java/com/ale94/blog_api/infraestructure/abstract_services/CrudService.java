package com.ale94.blog_api.infraestructure.abstract_services;

public interface CrudService<RS, RQ, ID> {

    RS create(RQ request);

    RS read(ID id);

    RS update(RQ request, ID id);

    void delete(ID id);


}
