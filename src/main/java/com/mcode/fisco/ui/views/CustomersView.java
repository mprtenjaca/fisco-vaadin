package com.mcode.fisco.ui.views;

import com.mcode.fisco.ui.MainLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "customers", layout = MainLayout.class)
@PageTitle("Customers | FISCO")
public class CustomersView extends HorizontalLayout {

    public CustomersView() {
        add(new Span("Customers"));
    }
}
