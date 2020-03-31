package com.assure.movie.common.enums;
/**
 * @author Israel Yasis
 */
public enum StatusRental {
    RENTED {
        public String toString() {
            return "RENTED";
        }
    },
    RETURNED {
        public String toString() {
            return "RETURNED";
        }
    }

}
