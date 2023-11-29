package de.hbrs.se2.womm.views.components.using;

public class TEMPLATE {

    public static final String LIT_TEMPLATE_HTML = """
            <vaadin-button title="Go to ..."
                           @click="${clickHandler}"
                           theme="tertiary-inline small link">
                ${item.id}
            </vaadin-button>""";

    public static final String LIT_TEMPLATE_HTML_BUTTON = """
            <button title="Go to ..."
                                         @click="${clickHandler}"
                                         theme="tertiary-inline small link">
                              ${item.stelle}
                              ${item.student}
                              
                          </button>""";
    //            <button @click="${e => }">Do something</button>
    //                        """;
//            <vaadin-button title="Go to ..."
//                           @click="${clickHandler}"
//                           theme="tertiary-inline small link">
//                ${item.id}
//            </vaadin-button>""";
}
