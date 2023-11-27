package de.hbrs.se2.womm.config;

//public class ErrorRedirect {
//}

import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.NotFoundException;
import com.vaadin.flow.router.RouteNotFoundError;
import de.hbrs.se2.womm.views.layouts.ErrorView;
import jakarta.servlet.http.HttpServletResponse;

public class ErrorRedirect extends RouteNotFoundError {

    @Override
    public int setErrorParameter(final BeforeEnterEvent event, final ErrorParameter<NotFoundException> parameter) {
        event.forwardTo(ErrorView.class);
        return HttpServletResponse.SC_NOT_FOUND;
    }
}