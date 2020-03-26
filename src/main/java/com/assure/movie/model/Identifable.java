package com.assure.movie.model;
/**
 * @author Israel Yasis
 */
interface Identifiable<T extends Number> {

    void setId(T id);

    T getId();

}
