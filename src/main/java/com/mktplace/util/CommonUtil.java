package com.mktplace.util;

import java.util.UUID;

public class CommonUtil {
    public static String generateNewUserId() {
        return "user-" + UUID.randomUUID().toString();
    }
}
