package org.globalappinitiative.tamid;

/*
    Class for user profile.
 */

import java.util.HashMap;
import java.util.Map;

public class UserProfile {
    public String username;
    public String email;
    public String fullName;
    public String phoneNum;
    public String location;

    public UserProfile() {
        username = "";
        email = "";
        fullName = "";
        phoneNum = "";
        location = "";
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("username", username);
        result.put("email", email);
        result.put("fullName", fullName);
        result.put("phoneNum", phoneNum);
        result.put("location", location);
        return result;
    }

}
