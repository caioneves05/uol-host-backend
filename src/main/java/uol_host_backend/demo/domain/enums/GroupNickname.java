package uol_host_backend.demo.domain.enums;

public enum GroupNickname {
    AVENGERS("Avengers", "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json"),
    JUSTICE_LEAGUE("Justice League", "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml");

    GroupNickname(String name, String uri) {
        this.name = name;
        this.uri = uri;
    }

    private final String name;
    private final String uri;

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }
}