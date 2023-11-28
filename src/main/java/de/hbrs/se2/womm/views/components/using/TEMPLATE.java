package de.hbrs.se2.womm.views.components.using;

public class TEMPLATE {

    public static final String LIT_TEMPLATE_HTML = """
                <vaadin-button title="Go to ..."
                               @click="${clickHandler}"
                               theme="tertiary-inline small link">
                    ${item.id}
                </vaadin-button>""";
}
