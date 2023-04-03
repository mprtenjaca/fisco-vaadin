package com.mcode.fisco.ui;

import com.mcode.fisco.ui.views.CustomersView;
import com.mcode.fisco.ui.views.InputInvoicesView;
import com.mcode.fisco.ui.views.OffersView;
import com.mcode.fisco.ui.views.OutputInvoicesView;
import com.mcode.fisco.ui.views.ProfileView;
import com.mcode.fisco.ui.views.ServicesView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H2 title = new H2("FISCO");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), title);
        header.setWidth("100%");
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        addToNavbar(header);
    }

    private void createDrawer() {
        RouterLink profileLink = new RouterLink(ProfileView.class);
        Tab profil = new Tab(VaadinIcon.USER.create(), new Span("Profil"));
        profileLink.add(profil);

        RouterLink customersLink = new RouterLink( CustomersView.class);
        customersLink.add(new Tab(VaadinIcon.USERS.create(), new Span("Kupci")));

        RouterLink servicesLink = new RouterLink(ServicesView.class);
        servicesLink.add(new Tab(VaadinIcon.TOOLBOX.create(), new Span("Usluge")));

        RouterLink outputInvoiceLink = new RouterLink(OutputInvoicesView.class);
        outputInvoiceLink.add(new Tab(VaadinIcon.COPY_O.create(), new Span("Izlazni računi")));

        RouterLink inputInvoiceLink = new RouterLink(InputInvoicesView.class);
        inputInvoiceLink.add(new Tab(VaadinIcon.COPY.create(), new Span("Ulazni računi")));

        RouterLink offersLink = new RouterLink(OffersView.class);
        offersLink.add(new Tab(VaadinIcon.BULLSEYE.create(), new Span("Ponude")));

        profileLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(
                profileLink,
                customersLink,
                servicesLink,
                outputInvoiceLink,
                inputInvoiceLink,
                offersLink
        ));
    }
}
