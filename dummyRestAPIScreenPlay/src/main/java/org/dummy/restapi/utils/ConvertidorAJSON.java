package org.dummy.restapi.utils;

import com.google.gson.Gson;

public class ConvertidorAJSON {
    public static <T> String convertir(T model) {
        Gson gson = new Gson();
        return gson.toJson(model);
    }
}

