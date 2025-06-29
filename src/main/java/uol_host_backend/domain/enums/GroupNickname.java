package uol_host_backend.domain.enums;

public enum GroupNickname {
    AVENGERS("Avengers", "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json"),
    JUSTICE_LEAGUE("Justice League", "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml");

    private final String name;
    private final String uri;

    GroupNickname(String name, String uri) {
        this.name = name;
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }
}