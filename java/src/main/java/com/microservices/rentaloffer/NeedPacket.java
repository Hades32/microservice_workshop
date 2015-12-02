package com.microservices.rentaloffer.need;

import java.lang.reflect.Type;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class NeedPacket {

    private final static Gson gson = new Gson();

    private Map<String, Object> msg;

    public NeedPacket(Map<String, Object> msg) {
        this.msg = msg;
    }

    public NeedPacket() {
        msg = new HashMap<>();
        msg.put("need","car_rental_offer");
        msg.put("json_class", NeedPacket.class.getSimpleName());
    }

    public static NeedPacket fromJSON(String json){
        Type mapType = new TypeToken<Map<String,Object>>() {}.getType();
        Map<String,Object> packet = gson.fromJson(json, mapType);
        return new NeedPacket(packet);
    }

    public String toJson() {
        return gson.toJson(this.msg);
    }

    public void setUser(String user) {
        msg.put("user", user);
    }

    public Collection<Object> getSolutions() {
        if (!msg.containsKey("solutions"))
            return null;
        else 
            return (Collection)msg.get("solutions");
    }
}
