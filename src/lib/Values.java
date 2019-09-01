public enum Values {
    NONE("None") {
        public Values next() {
            return Values.NONE;
        }
    },
    RED("Red") {
        public Values next() {
            return Values.BLUE;
        }
    },
    BLUE("Blue") {
        public Values next() {
            return Values.RED;
        }
    };

    private final String textRepresentation;

    public abstract Values next();

    private Values(String textRepresentation) {
        this.textRepresentation = textRepresentation;
    }

    @Override
    public String toString() {
        return textRepresentation;
    }
}

