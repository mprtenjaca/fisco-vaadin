package com.mcode.fisco.ui.views;

import com.mcode.fisco.ui.MainLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "outpu-invoices", layout = MainLayout.class)
@PageTitle("Output invoices | FISCO")
public class OutputInvoicesView extends HorizontalLayout {


    public OutputInvoicesView() {
        add(new Span("O Invoices"));
    }
}
