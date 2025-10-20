package co.edu.uco.aurora.business.assembler.entity;

import java.util.List;

public interface EntityAssembler<E, D> {

    E toEntity(D domain);

    D toDomain(E entity);

    List<E> toDTO(List<D> domainList);
}
