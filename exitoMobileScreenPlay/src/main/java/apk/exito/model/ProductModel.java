package apk.exito.model;

import java.util.List;

public class ProductModel {

    private String productCategory;

    public ProductModel(List<String> logData) {
        this.productCategory = logData.get(0);
    }

    public String getProductCategory() {
        return productCategory;
    }
}


