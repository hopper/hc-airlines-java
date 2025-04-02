package com.hopper.cloud.airlines;

import java.util.List;

public class ListUtil {
    /**
     * Check if a given list is null or empty
     * @param list
     * @return true if the list is null or empty
     */
    public static boolean isEmpty(List<?> list) {
        return (list == null || list.isEmpty());
    }
}
