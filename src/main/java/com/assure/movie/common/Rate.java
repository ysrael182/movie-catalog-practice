package com.assure.movie.common;
/**
 * @author Israel Yasis
 */
public enum Rate {
    G,
    PG,
    PG13 {
        public String toString() {
            return "PG-13";
        }
    },
    R,
    NG17{
        public String toString() {
            return "PG-17";
        }
    }
}
