package com.alibaba.nacos.consistency;

import com.google.protobuf.ByteString;

public class Utils {

    public static boolean isStringEmpty(final Object value) {
        if (value instanceof String) {
            return ((String) value).isEmpty();
        } else {
            return ((ByteString) value).isEmpty();
        }
    }
}
