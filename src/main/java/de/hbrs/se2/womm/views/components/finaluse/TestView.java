package de.hbrs.se2.womm.views.components.finaluse;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.controller.StelleController;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.views.components.refactoring.AbstractViewDTOgetPrimaryFromSecurityServiceLast;
import de.hbrs.se2.womm.views.layouts.StudentLayout;

@AnonymousAllowed
@Route(value = "test", layout = StudentLayout.class)
public class TestView extends AbstractViewDTOgetPrimaryFromSecurityService<StelleController, StelleDTO> {
    @Override
    String setPrimaryKey() {
        System.out.println(getPrimaryKeyAsFromSecurityServiceWhenStartupString());
        return getPrimaryKeyAsFromSecurityServiceWhenStartupString();
    }

    protected TestView(StelleController stelleController, SecurityService securityService) {
        super(stelleController, securityService);
//        add(new FilterGridStelle(stelleController));
    }

}
