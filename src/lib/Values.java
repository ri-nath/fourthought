package lib;

import java.awt.*;

public enum Values {
    NONE("None", Color.LIGHT_GRAY) {
        public Values next() {
            return Values.NONE;
        }
    },
    RED("Red", Color.RED) {
        public Values next() {
            return Values.BLUE;
        }
    },
    BLUE("Blue", Color.BLUE) {
        public Values next() {
            return Values.RED;
        }
    };

    private final String textRepresentation;
    private final Color color;

    public abstract Values next();

    private Values(String textRepresentation, Color color) {
        this.textRepresentation = textRepresentation;
        this.color = color;
    }

    @Override
    public String toString() {
        return textRepresentation;
    }

    public Color getColor() {
        return color;
    }
}

