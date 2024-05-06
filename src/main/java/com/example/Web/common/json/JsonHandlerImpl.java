package com.example.Web.common.json;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public abstract class JsonHandlerImpl<T> implements JsonHandler<T> {

    protected Gson gson;
    private JsonObject json;

    public JsonHandlerImpl() {
        gson = new Gson();
        json = new JsonObject();
    }

    protected JsonObject ObjectToJson(String mode, T entity) {
        json.addProperty("entity", getEntityType());
        json.addProperty("mode", mode);
        json.add(getEntityType(), gson.toJsonTree(entity));
        return json;
    }

    protected abstract T parseToObject(String result);

    protected abstract String getEntityType();
}
