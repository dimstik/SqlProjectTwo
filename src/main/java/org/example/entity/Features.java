package org.example.entity;

import static java.util.Objects.isNull;

public enum Features {
    Trailers("Trailers"),
    Commentaries("Commentaries"),
    Deleted_Scenes("Deleted Scenes"),
    Behind_the_Scenes("Behind the Scenes");
    private final String value;

    Features(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static  Features getFeaturesByValue(String value) {
        if (isNull(value) || value.isEmpty()) {
            return null;
        }
        Features[] features = Features.values();
        for (Features feature : features) {
            if (feature.value.equals(value)) {
                return feature;
            }
        }
        return null;
    }
}
