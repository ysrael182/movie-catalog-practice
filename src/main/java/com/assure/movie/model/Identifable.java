package com.assure.movie.model;

import java.io.Serializable;
/**
 * @author Israel Yasis
 */
interface Identifiable<T> extends Serializable {

    void setId(T id);

    T getId();

}
