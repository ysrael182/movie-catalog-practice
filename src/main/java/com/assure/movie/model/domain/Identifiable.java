package com.assure.movie.model.domain;

import java.io.Serializable;
/**
 * @author Israel Yasis
 */
public interface Identifiable<T> extends Serializable {

    void setId(T id);

    T getId();

}
