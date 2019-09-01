public class Constants {
    public static enum VALUES {
        NONE("None") {
            public VALUES next() {
                return VALUES.NONE;
            }
        },
        RED("Red") {
            public VALUES next() {
                return VALUES.BLUE;
            }
        },
        BLUE("Blue"){
            public VALUES next() {
                return VALUES.RED;
            }
        };

        private final String textRepresentation;

        public abstract VALUES next();

        private VALUES(String textRepresentation) {
            this.textRepresentation = textRepresentation;
        }

        @Override public String toString() {
            return textRepresentation;
        }
    }
}
