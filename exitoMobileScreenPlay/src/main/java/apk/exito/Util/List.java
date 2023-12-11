package apk.exito.Util;

import io.cucumber.datatable.DataTable;

import java.util.Map;

public class List {
    public static Map<String, String> IterateData(DataTable tabla) {
        Map<String, String> valores = null;
        java.util.List<Map<String, String>> rows = tabla.asMaps(String.class, String.class);
        for (Map<String, String> columnas : rows) {
            valores = columnas;
        }
        return valores;
    }
}
