package de.hbrs.se2.womm.views.unternehmen;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = ROUTING.UNTERNEHMEN.UApplicantView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
@PageTitle("ApplicantView")
public class UApplicantView extends AViewWomm implements HasUrlParameter<Long> {
    long studentId;

    // ToDo: finish this view
    @Override
    public void setParameter(BeforeEvent beforeEvent, Long aLong) {
        if (aLong != null) {
            this.studentId = aLong;
        } else {
            setup404Page();
        }
    }

    private void setup404Page() {
        add(new H1("404 Not Found! :("));
    }
}
