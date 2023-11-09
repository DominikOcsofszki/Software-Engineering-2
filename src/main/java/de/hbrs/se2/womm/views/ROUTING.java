package de.hbrs.se2.womm.views;

public enum ROUTING {
    CHATVIEW("ChatView"),
    APPLICATIONSVIEW("ApplicationsView"),
    ABOSTUDENTVIEW("AboStudentView"),
    STELLEANZEIGERSTELLENVIEW("StelleAnzeigeErstellenView");

    private final String name;

    ROUTING(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
