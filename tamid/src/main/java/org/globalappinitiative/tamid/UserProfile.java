package org.globalappinitiative.tamid;

/*
    Class for user profile.
 */

import java.util.HashMap;
import java.util.Map;

public class UserProfile {
    private String email;
    private String fullName;
    private String phoneNum;
    private String location;

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("email", email);
        result.put("fullName", fullName);
        result.put("phoneNum", phoneNum);
        result.put("location", location);
        return result;
    }

}
