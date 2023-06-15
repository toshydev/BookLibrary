package click.snekhome.booklibrary.models;

public enum Type {
    SOFT("Soft-Cover"),
    HARD("Hard-Cover"),
    EBOOK("E-Book"),
    AUDIO("Audio-Book");

    private String type;
    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
