package com.mcode.fisco.ui.views;

import com.mcode.fisco.ui.MainLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "input-invoices", layout = MainLayout.class)
@PageTitle("Input invoices | FISCO")
public class InputInvoicesView extends HorizontalLayout {

    public InputInvoicesView() {
        add(new Span("I Invoices"));
    }
}
