package org.microService.storage.service.Mapper;

import org.microService.storage.service.EntityMicroService;


public interface Mapper<E extends EntityMicroService, D extends EntityMicroService> {

    D toDto(E entity);
}
