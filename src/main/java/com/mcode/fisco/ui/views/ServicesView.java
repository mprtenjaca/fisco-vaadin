package com.mcode.fisco.ui.views;

import com.mcode.fisco.ui.MainLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "services", layout = MainLayout.class)
@PageTitle("Services | FISCO")
public class ServicesView extends HorizontalLayout {

    public ServicesView() {
        add(new Span("Services"));
    }
}
