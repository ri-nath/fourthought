public class Constants {
    public static enum VALUES {
        NONE("None"),
        RED("Red"),
        BLUE("Blue");

        private final String textRepresentation;

        private VALUES(String textRepresentation) {
            this.textRepresentation = textRepresentation;
        }

        @Override public String toString() {
            return textRepresentation;
        }
    }
}
