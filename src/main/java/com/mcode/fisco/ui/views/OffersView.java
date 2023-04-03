package com.mcode.fisco.ui.views;

import com.mcode.fisco.ui.MainLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "offers", layout = MainLayout.class)
@PageTitle("Offers | FISCO")
public class OffersView extends HorizontalLayout {

    public OffersView() {
        add(new Span("Offers"));
    }
}
